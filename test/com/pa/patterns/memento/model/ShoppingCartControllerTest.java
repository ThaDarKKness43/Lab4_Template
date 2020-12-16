package com.pa.patterns.memento.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ShoppingCartControllerTest {
    private ShoppingCartController ctrl;

    @BeforeEach
    void setUp() {
        ctrl = new ShoppingCartController();
    }

    @Test
    void addProduct() {
        assertEquals(0, ctrl.getProducts().size());
        ctrl.addProduct("Test product", 42.0);
        assertEquals(1, ctrl.getProducts().size());
    }

    @Test
    void reset() {
        ctrl.addProduct("Test product1", 42.0);
        ctrl.addProduct("Test product2", 44.0);
        ctrl.addProduct("Test product3", 48.0);
        assertEquals(3, ctrl.getProducts().size());
        ctrl.reset();
        assertEquals(0, ctrl.getProducts().size());
    }

    @Test
    void removeProduct() {
        ctrl.addProduct("Test product1", 42.0);
        ctrl.addProduct("Test product2", 44.0);
        ctrl.addProduct("Test product3", 48.0);
        assertEquals(3, ctrl.getProducts().size());
        ctrl.removeProduct("Test product3");
        assertEquals(2, ctrl.getProducts().size());
    }

    /*@Test
    void undo() throws NoMementoException, ParseException {
        ctrl.addProduct("Test product1", 42.0);
        ctrl.addProduct("Test product2", 44.0);
        assertEquals(2, ctrl.getProducts().size());
        ctrl.undo();
        assertEquals(1, ctrl.getProducts().size());
    }*/

    @Test
    void getProducts() {
        ctrl.addProduct("Test product1", 42.0);
        ctrl.addProduct("Test product2", 44.0);
        ctrl.addProduct("Test product3", 48.0);
        assertEquals(3, ctrl.getProducts().size());
    }

    @Test
    void showAll() {
        ctrl.addProduct("Test product1", 42.0);
        ctrl.addProduct("Test product2", 44.0);
        assertEquals("[Test product1 (42.0), Test product2 (44.0)]" + "\nTotal price:" + 86.0, ctrl.showAll());
    }
}