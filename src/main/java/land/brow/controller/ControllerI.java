package land.brow.controller;

import io.micronaut.http.HttpResponse;

import java.util.List;

public interface ControllerI<E> {
    HttpResponse<List<E>> get();

    HttpResponse<E> get(String id);

    HttpResponse<E> post(E entity);

    HttpResponse<E> put(String id, E entity);

    HttpResponse<E> delete(String id);
}