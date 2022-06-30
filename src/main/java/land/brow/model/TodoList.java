package land.brow.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TodoList implements DAO {
    private String id;
    private String title;
    private Date date;
    private List<Item> items;

    public TodoList() {
    }

    public TodoList(String id, String title, Date date, List<Item> items) {
        setId(id);
        setTitle(title);
        setDate(date);
        setItems(items);
    }

    public TodoList(TodoList todoList) {
        this.id = todoList.id;
        this.title = todoList.title;
        this.date = todoList.date;
        this.items = todoList.items;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        UUID.fromString(id); //throw error if string is not formatted as UUID
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(item);
    }
}