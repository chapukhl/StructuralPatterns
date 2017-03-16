package com.epam.mp.composite;

import java.util.List;

public interface CompositeFormation extends Formation {

    void addFormation(Formation formation);

    long getSize();
}
