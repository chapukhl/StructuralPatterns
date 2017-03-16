package com.epam.mp.composite;

import java.util.List;

public interface Formation {

    void cryHooray();

    Formation getElement(int index);

    void addFormations(long number);

    List<Formation> getFormations();
}
