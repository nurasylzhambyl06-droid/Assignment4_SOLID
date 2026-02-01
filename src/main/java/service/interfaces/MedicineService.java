package service.interfaces;

import model.BaseMedicine;
import java.util.List;

public interface MedicineService {
    void addMedicine(BaseMedicine medicine);
    List<BaseMedicine> getAll();
}
