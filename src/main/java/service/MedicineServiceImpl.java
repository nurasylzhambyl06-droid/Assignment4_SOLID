package service;

import model.BaseMedicine;
import repository.interfaces.CrudRepository;
import service.interfaces.MedicineService;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    private CrudRepository<BaseMedicine> repository;

    public MedicineServiceImpl(CrudRepository<BaseMedicine> repository) {
        this.repository = repository;
    }

    @Override
    public void addMedicine(BaseMedicine medicine) {
        repository.save(medicine);
    }

    @Override
    public List<BaseMedicine> getAll() {
        return repository.findAll();
    }
}
