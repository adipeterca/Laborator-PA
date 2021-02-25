package TP;

import java.util.*;

public abstract class Source {
    protected String name;
    protected int initialSupply;
    protected int remainingSupply;

    @Override
    public String toString() {
        return getName();
    }

    // Compares both the name of the source and its initial supply.
    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Source)) {
            return false;
        }
        Source s = (Source) obj;
        return this.getName().equals(s.getName()) && this.getInitialSupply().equals(s.getInitialSupply());
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setInitialSupply(Integer newSupply) {
        this.initialSupply = newSupply;
        this.remainingSupply = newSupply;
    }

    public String getName() {
        return this.name;
    }

    public Integer getInitialSupply() {
        return initialSupply;
    }

    public Integer getRemainingSupply() {
        return remainingSupply;
    }
}
