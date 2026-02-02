package org.example;

import controller.MedicineController;
import dto.MedicineDTO;
import model.BaseMedicine;
import model.OTCMedicine;
import model.PrescriptionMedicine;
import repository.InMemoryMedicineRepository;
import repository.interfaces.CrudRepository;
import service.MedicineServiceImpl;
import service.interfaces.MedicineService;
import utils.ReflectionUtils;
import utils.SortingUtils;
import service.interfaces.PricedItem;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CrudRepository<BaseMedicine> repository = new InMemoryMedicineRepository();
        MedicineService service = new MedicineServiceImpl(repository);
        MedicineController controller = new MedicineController(service);

        MedicineDTO dto1 = new MedicineDTO(1, "Ibuprofen", "OTC");
        MedicineDTO dto2 = new MedicineDTO(2, "Paracetamol", "OTC");
        MedicineDTO dto3 = new MedicineDTO(3, "Amoxicillin", "PRESCRIPTION");

        controller.createMedicine(map(dto1));
        controller.createMedicine(map(dto2));
        controller.createMedicine(map(dto3));

        List<BaseMedicine> medicines = service.getAll();

        for (BaseMedicine m : medicines) {
            System.out.println(m.getDisplayName() + " " + m.calculateFinalPrice());
        }

        SortingUtils.sortByPrice(medicines);

        for (BaseMedicine m : medicines) {
            System.out.println(m.getDisplayName() + " " + m.calculateFinalPrice());
        }

        for (BaseMedicine m : medicines) {
            PricedItem.printPrice(m.calculateFinalPrice());
        }


        ReflectionUtils.inspectClass(OTCMedicine.class);
        ReflectionUtils.inspectClass(PrescriptionMedicine.class);

        try {
            MedicineDTO badDto = new MedicineDTO(4, "", "OTC");
            controller.createMedicine(map(badDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static BaseMedicine map(MedicineDTO dto) {
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new RuntimeException("Medicine name cannot be empty");
        }
        if ("OTC".equalsIgnoreCase(dto.getType())) {
            return new OTCMedicine(dto.getId(), dto.getName());
        }
        return new PrescriptionMedicine(dto.getId(), dto.getName(), true);
    }

}//


