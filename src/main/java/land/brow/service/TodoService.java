package land.brow.service;

import jakarta.inject.Singleton;
import land.brow.model.Item;
import land.brow.model.TodoList;
import land.brow.repository.ItemRepository;
import land.brow.repository.Repository;

import java.util.List;

@Singleton
public class TodoService implements Service<TodoList> {
    private final Repository<TodoList> repo;
    private final ItemRepository itemRepo;

    public TodoService(Repository<TodoList> repository, ItemRepository itemRepository) {
        this.repo = repository;
        this.itemRepo = itemRepository;
    }

    @Override
    public List<TodoList> get() {
        List<TodoList> todoLists = repo.read();
        for (TodoList todoList : todoLists)
        {
            todoList.setItems(itemRepo.readByTodoId(todoList.getId()));
        }
        return todoLists;
    }

    @Override
    public TodoList get(String id) {
        TodoList list = repo.read(id);
        list.setItems(itemRepo.readByTodoId(list.getId()));
        return list;
    }

    @Override
    public TodoList post(TodoList todoList) {
        List<Item> items = todoList.getItems();
        todoList.setItems(null);
        String id = repo.create(todoList);

        for(Item item : items)
        {
            item.setTodoID(id);
            itemRepo.create(item);
        }

        return get(id);
    }

    @Override
    public TodoList put(String id, TodoList entity) {
        return null;
    }

    @Override
    public TodoList delete(String id) {
        return null;
    }
}
