package TP;

import java.util.*;

public final class Warehouse extends Source {

    public Warehouse(String name, int supply) {
        setName(name);
        setInitialSupply(supply);

        System.out.printf("Created the %s Warehouse!\n", this.name);
    }

}
