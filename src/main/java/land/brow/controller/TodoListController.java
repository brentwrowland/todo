package land.brow.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import land.brow.model.TodoList;
import land.brow.service.Service;

import java.util.List;

@Controller("/lists")
public class TodoListController implements ControllerI<TodoList> {
    private final Service<TodoList> service;

    public TodoListController(Service<TodoList> service) {
        this.service = service;
    }

    @Get
    public HttpResponse<List<TodoList>> get() {
        return HttpResponse.ok(service.get());
    }

    @Override
    public HttpResponse<TodoList> get(String id) {
        return null;
    }

    @Post
    public HttpResponse<TodoList> post(@Body TodoList todoList) {
        return HttpResponse.ok(service.post(todoList));
    }

    @Override
    public HttpResponse<TodoList> put(String id, TodoList todoList) {
        return null;
    }

    @Override
    public HttpResponse<TodoList> delete(String id) {
        return null;
    }
}
