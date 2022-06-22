package land.brow.service;

import land.brow.model.DAO;

import java.util.List;

public interface Service<E extends DAO> {
    List<E> get();
    E get(String id);
    E post(E entity);
    E put(String id, E entity);
    E delete(String id);
}