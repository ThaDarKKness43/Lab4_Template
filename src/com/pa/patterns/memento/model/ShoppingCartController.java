package com.pa.patterns.memento.model;

import java.util.Collection;
import java.util.Date;

/**
 * @author André Sabino
 */
public class ShoppingCartController {
    private ShoppingCart cart;
    private Caretaker caretaker;

    public ShoppingCartController() {
        cart = new ShoppingCart();
        caretaker = new Caretaker(cart);
    }

    public void addProduct(String name, double cost) {
        caretaker.saveState();
        Product p = new Product(name, cost);
        cart.addProduct(p);
    }

    public void reset() {
        caretaker.saveState();
        cart.reset();
    }

    public void removeProduct(String name) {
        caretaker.saveState();
        for (Product p : cart.getProducts())
            if (p.getName().equals(name)) {
                cart.removeProduct(p);
                return;
            }
        return;
    }

    public void undo(Date date) throws NoMementoException {
        caretaker.restoreState(date);
    }

    public Collection<Product> getProducts() {
        return cart.getProducts();
    }

    public Collection<Date> getDate() {
        return caretaker.getDates();
    }

    public String showAll() {
        String str = cart.toString() + "\nTotal price:" + cart.getTotal();
        return str;
    }
}
