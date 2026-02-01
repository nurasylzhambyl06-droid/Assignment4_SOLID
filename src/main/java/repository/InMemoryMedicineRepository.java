package repository;

import model.BaseMedicine;
import repository.interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMedicineRepository implements CrudRepository<BaseMedicine> {

    private final List<BaseMedicine> storage = new ArrayList<>();

    @Override
    public void save(BaseMedicine entity) {
        storage.add(entity);
    }

    @Override
    public BaseMedicine findById(int id) {
        return storage.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BaseMedicine> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void update(BaseMedicine entity) {
        delete(entity.getId());
        storage.add(entity);
    }

    @Override
    public void delete(int id) {
        storage.removeIf(m -> m.getId() == id);
    }
}

