package land.brow.repository;

import land.brow.model.DAO;

import java.util.List;

public interface Repository<E extends DAO> {
    List<E> read();

    E read(String id);

    E create(E object);

    E update(String id, E object);

    E delete(String id);
}