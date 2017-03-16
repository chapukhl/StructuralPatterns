package com.epam.mp.composite.impl;

import com.epam.mp.composite.CompositeFormation;
import com.epam.mp.composite.Formation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Division implements CompositeFormation {

    private List<Battalion> battalions = new ArrayList<>();

    @Override
    public void addFormations(long number) {
        for (long i = 0; i < number; i++)
            battalions.add(new Battalion());
    }


    @Override
    public void cryHooray() {
        battalions.forEach(Battalion::cryHooray);
    }

    @Override
    public Formation getElement(int index) {
        return battalions.get(index);
    }

    @Override
    public void addFormation(Formation formation) {
        battalions.add((Battalion) formation);
    }

    @Override
    public long getSize() {
        return battalions.size();
    }

    @Override
    public List<Formation> getFormations() {
        return battalions.stream().collect(Collectors.toList());
    }

//    public static class DivisionBuilder {
//
//        private Division division;
//
//        public DivisionBuilder() {
//            division = new Division();
//        }
//
//        public Division.DivisionBuilder divisions(int divisionNumber) {
//            for (int i = divisionNumber; i != 0; i--) {
//                army.addFormation(new Division().);
//            }
//            return this;
//        }
//    }
    }
