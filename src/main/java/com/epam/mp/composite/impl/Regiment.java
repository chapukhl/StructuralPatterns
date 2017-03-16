package com.epam.mp.composite.impl;

import com.epam.mp.composite.CompositeFormation;
import com.epam.mp.composite.Formation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Regiment implements CompositeFormation {

    private List<Platoon> platoons = new ArrayList<>();

    @Override
    public void addFormations(long number) {
        for (long i = 0; i < number; i++)
            platoons.add(new Platoon());
    }

    @Override
    public void cryHooray() {
        platoons.forEach(Platoon::cryHooray);
    }

    @Override
    public Formation getElement(int index) {
        return platoons.get(index);
    }

    @Override
    public void addFormation(Formation formation) {
        platoons.add((Platoon) formation);
    }

    @Override
    public long getSize() {
        return platoons.size();
    }

    @Override
    public List<Formation> getFormations() {
        return platoons.stream().collect(Collectors.toList());
    }
}
