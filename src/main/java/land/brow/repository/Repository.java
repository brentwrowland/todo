package land.brow.repository;

import land.brow.model.DAO;

import java.util.ArrayList;
import java.util.List;

public interface Repository<E extends DAO> {
    List<E> read();

    List<E> read(int limit, int offset);

    E read(String id);

    E create(E object);

    E update(String id, E object);

    E delete(String id);



    default List<E> toList(Iterable<E> iterable) {
        List<E> items = new ArrayList<>();
        iterable.forEach(items::add);
        return items;
    }
}