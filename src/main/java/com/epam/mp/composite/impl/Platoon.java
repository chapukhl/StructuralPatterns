package com.epam.mp.composite.impl;

import com.epam.mp.composite.CompositeFormation;
import com.epam.mp.composite.Formation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Platoon implements CompositeFormation {

    private List<Squad> squads = new ArrayList<>();

    @Override
    public void addFormations(long number) {
        for (long i = 0; i < number; i++)
            squads.add(new Squad());
    }

    @Override
    public void cryHooray() {
        squads.forEach(Squad::cryHooray);
    }

    @Override
    public Formation getElement(int index) {
        return squads.get(index);
    }

    @Override
    public void addFormation(Formation formation) {
        squads.add((Squad) formation);
    }

    @Override
    public long getSize() {
        return squads.size();
    }

    @Override
    public List<Formation> getFormations() {
        return squads.stream().collect(Collectors.toList());
    }
}
