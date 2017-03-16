package com.epam.mp.composite.impl;

import com.epam.mp.composite.CompositeFormation;
import com.epam.mp.composite.Formation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Battalion implements CompositeFormation {

    private List<Regiment> regiments = new ArrayList<>();

    @Override
    public void addFormations(long number) {
        for (long i = 0; i < number; i++)
            regiments.add(new Regiment());
    }

    @Override
    public void cryHooray() {
         regiments.forEach(Regiment::cryHooray);
    }

    @Override
    public Formation getElement(int index) {
        return regiments.get(index);
    }

    @Override
    public void addFormation(Formation formation) {
        regiments.add((Regiment)formation);
    }

    @Override
    public long getSize() {
        return regiments.size();
    }

    @Override
    public List<Formation> getFormations() {
        return regiments.stream().collect(Collectors.toList());
    }
}
