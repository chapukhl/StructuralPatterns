package com.epam.mp.composite.impl;

import com.epam.mp.composite.CompositeFormation;
import com.epam.mp.composite.Formation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Squad implements CompositeFormation {

    private List<Soldier> soldiers = new ArrayList<>();

    @Override
    public void cryHooray() {
        soldiers.forEach(Soldier::cryHooray);
    }

    @Override
    public Formation getElement(int index) {
        return soldiers.get(index);
    }

    @Override
    public void addFormation(Formation formation) {
        soldiers.add((Soldier) formation);
    }

    @Override
    public void addFormations(long number) {
        for (long i = 0; i < number; i++)
            soldiers.add(new Soldier());
    }

    @Override
    public long getSize() {
        return soldiers.size();
    }

    @Override
    public List<Formation> getFormations() {
        return soldiers.stream().collect(Collectors.toList());
    }
}
