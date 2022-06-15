package land.brow.repository;

import land.brow.model.DAO;

import java.util.List;

public interface Repository<E extends DAO> {
    public List<E> read();

    public E read(String id);

    public E create(E object);

    public E update(String id, E object);

    public E delete(String id);
}