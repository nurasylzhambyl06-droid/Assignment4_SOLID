package controller;

import model.BaseMedicine;
import service.interfaces.MedicineService;

public class MedicineController {

    private MedicineService service;

    public MedicineController(MedicineService service) {
        this.service = service;
    }

    public void createMedicine(BaseMedicine medicine) {
        service.addMedicine(medicine);
    }
}
