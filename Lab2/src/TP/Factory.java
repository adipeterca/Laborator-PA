package TP;

import java.util.*;


public class Factory extends Source {

    public Factory(String name, int supply) {
        setName(name);
        setInitialSupply(supply);

        System.out.printf("Created the %s Factory!\n", this.name);
    }
}
