package model;

public class PrescriptionMedicine extends BaseMedicine {
    private boolean requiresDoctorApproval;

    public PrescriptionMedicine(int id, String name, boolean requiresDoctorApproval) {
        super(id, name);
        this.requiresDoctorApproval = requiresDoctorApproval;
    }

    @Override
    public double calculateFinalPrice() {
        return 500.0; // demo logic
    }

    @Override
    public String getType() {
        return "Prescription";
    }
}