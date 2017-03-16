package com.epam.mp.composite.impl;

import com.epam.mp.composite.CompositeFormation;
import com.epam.mp.composite.Formation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Army implements CompositeFormation {

    private List<Division> divisions = new ArrayList<>();

    @Override
    public void addFormations(long number) {
        for (long i = 0; i < number; i++)
            divisions.add(new Division());
    }

    @Override
    public void cryHooray() {
        divisions.forEach(Division::cryHooray);
    }

    @Override
    public Formation getElement(int index) {
        return divisions.get(index);
    }

    @Override
    public void addFormation(Formation formation) {
        divisions.add((Division) formation);
    }

    @Override
    public long getSize() {
        return divisions.size();
    }

    @Override
    public List<Formation> getFormations() {
        return divisions.stream().collect(Collectors.toList());
    }

    public static class ArmyBuilder {

        private Army army;

        public ArmyBuilder() {
            army = new Army();
        }

        public Army.ArmyBuilder divisions(int divisionNumber) {
            for (long i = 0; i < divisionNumber; i++) {
                army.divisions.add(new Division());
            }
            return this;
        }

        public Army.ArmyBuilder battalions(int battalionsNumber) {
            army.divisions.forEach(division -> division.addFormations(battalionsNumber));
            return this;
        }

        public Army.ArmyBuilder regiments(int regimentsNumber) {
            army.divisions.forEach(division -> division.getFormations().
                    forEach(formation -> formation.addFormations(regimentsNumber)));
            return this;
        }

        public Army.ArmyBuilder platoons(int platoonsNumber) {
            army.divisions.forEach(division -> division.getFormations().
                    forEach(formation -> formation.getFormations().
                            forEach(formation1 -> formation1.addFormations(platoonsNumber))));
            return this;
        }

        public Army.ArmyBuilder squards(int squardNumber) {
            army.divisions.forEach(division -> division.getFormations().
                    forEach(formation -> formation.getFormations().
                            forEach(formation1 -> formation1.getFormations()
                                    .forEach(formation2 -> formation2.addFormations(squardNumber)))));
            return this;
        }

        public Army.ArmyBuilder soldires(int soldiresNumber) {
            army.divisions.forEach(division -> division.getFormations().
                    forEach(formation -> formation.getFormations().
                            forEach(formation1 -> formation1.getFormations()
                                    .forEach(formation2 -> formation2.getFormations()
                                            .forEach(formation3 -> formation3.addFormations(soldiresNumber))))));
            return this;
        }

        public Army build() {
            return army;
        }
    }
}
