package land.brow.service;

import jakarta.inject.Singleton;
import land.brow.model.Item;
import land.brow.repository.Repository;

import java.util.List;

@Singleton
public class ItemService implements Service<Item> {
    private final Repository<Item> repository;

    public ItemService(Repository<Item> repository) {
        this.repository = repository;
    }

    @Override
    public List<Item> get() {
        return repository.read();
    }

    @Override
    public Item get(String id) {
        return repository.read(id);
    }

    @Override
    public Item post(Item entity) {

        return repository.read(repository.create(entity));
    }

    @Override
    public Item put(String id, Item entity) {
        return repository.read(repository.update(id, entity));
    }

    @Override
    public Item delete(String id) {
        Item target = repository.read(id);
        if(!repository.delete(id))
            return null;
        return target;
    }
}