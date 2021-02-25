package TP;

public class Destination {
    private String name;
    private Integer demand;

    public Destination(String name, Integer demand) {
        setName(name);
        setDemand(demand);
    }

    @Override
    public String toString() {
        return getName();
    }

    // Compares both the name of the destination and the demand.
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Destination)) {
            return false;
        }

        Destination d = (Destination) obj;
        return this.getName().equals(d.getName()) && this.getDemand().equals(d.getDemand());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDemand(Integer demand) {
        this.demand = demand;
    }

    public String getName() {
        return this.name;
    }

    public Integer getDemand() {
        return this.demand;
    }
}
