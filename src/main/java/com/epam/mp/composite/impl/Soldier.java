package com.epam.mp.composite.impl;

import com.epam.mp.composite.Formation;
import com.epam.mp.composite.LeafFormation;

import java.util.List;
import java.util.UUID;

public class Soldier implements LeafFormation {

    private UUID id;

    public Soldier() {
        id = UUID.randomUUID();
    }

    @Override
    public void cryHooray() {
        System.out.println("Soldier " + id + " cry Hooooraaay!!");
    }

    @Override
    public Formation getElement(int index) {
        return this;
    }

    @Override
    public void addFormations(long number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Formation> getFormations() {
        throw new UnsupportedOperationException();
    }
}
