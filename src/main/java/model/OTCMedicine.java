package model;

public class OTCMedicine extends BaseMedicine {

    public OTCMedicine(int id, String name) {
        super(id, name);
    }

    @Override
    public double calculateFinalPrice() {
        return 200.0;
    }

    @Override
    public String getType() {
        return "OTC";
    }
}