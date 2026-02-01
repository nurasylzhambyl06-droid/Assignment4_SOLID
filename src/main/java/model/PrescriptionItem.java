package model;

public class PrescriptionItem {
    private BaseMedicine medicine;
    private int quantity;

    public PrescriptionItem(BaseMedicine medicine, int quantity) {
        this.medicine = medicine;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return medicine.calculateFinalPrice() * quantity;
    }

}
