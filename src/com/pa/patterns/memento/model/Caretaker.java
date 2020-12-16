package com.pa.patterns.memento.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Caretaker {

    //private Memento memento;
    private Originator sc;
    Map<Date, Memento> mementos; // Multi-undo

    //Multi-undo
    public Caretaker(Originator sc) {
        this.sc = sc;
        mementos = new HashMap<>();
    }

    public void saveState() {
        //this.memento = sc.createMemento();

        Date date = new Date();
        Memento memento = sc.createMemento();
        mementos.put(date, memento);
    }

    public void restoreState(Date date) throws NoMementoException {
        /*if(memento.getState().isEmpty()) {
            throw new NoMementoException("There is no saved memento");
        } else {
            sc.setMemento(this.memento);
        }*/

        if(mementos.isEmpty()) {
            throw new NoMementoException("There is no saved memento");
        }
        Memento memento = mementos.get(date);
        sc.setMemento(memento);
    }

    public Collection<Date> getDates() {
        return mementos.keySet();
    }
}
