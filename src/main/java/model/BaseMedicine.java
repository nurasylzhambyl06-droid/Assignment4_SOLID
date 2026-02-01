package model;

public abstract class BaseMedicine {
    private int id;
    private String name;

    protected BaseMedicine(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract double calculateFinalPrice();
    public abstract String getType();

    public String getDisplayName() {
        return name + " (" + getType() + ")";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
