package land.brow.model;

import java.util.Date;
import java.util.UUID;

public class Item implements DAO {
    private String id;
    private String todoID;
    private String text;
    private Date date;
    private Boolean done;

    public Item() {
    }

    public Item(String id, String todoID, String text, Date date, Boolean done) {
        setId(id);
        setTodoID(todoID);
        setText(text);
        setDate(date);
        setDone(done);
    }

    public Item(Item item) {
        this.id = item.id;
        this.todoID = item.todoID;
        this.text = item.text;
        this.date = item.date;
        this.done = item.done;
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

    public String getTodoID() {
        return todoID;
    }

    public void setTodoID(String todoID) {
        UUID.fromString(todoID); //throw error if string is not formatted as UUID
        this.todoID = todoID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return Boolean.TRUE.equals(done);
    }

    public boolean isDate() {
        return date != null;
    }
}