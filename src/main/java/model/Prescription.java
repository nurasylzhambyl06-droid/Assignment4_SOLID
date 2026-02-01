package model;

import java.util.List;

public class Prescription {

    private Patient patient;
    private List<Medicine> medicines;

    public Prescription(Patient patient, List<Medicine> medicines) {
        this.patient = patient;
        this.medicines = medicines;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }
    private int id;
    private List<PrescriptionItem> items;

    public Prescription(int id, List<PrescriptionItem> items) {
        this.id = id;
        this.items = items;
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(PrescriptionItem::getTotalPrice)
                .sum();
    }
}

