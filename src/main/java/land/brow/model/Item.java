package land.brow.model;

import java.util.Date;
import java.util.UUID;

public class Item implements DAO{
    private String id;
    private String text;
    private Date date;
    private Boolean done;

    public Item() {
        id = UUID.randomUUID().toString();
    }

    public Item(String id, String text, Date date, Boolean done) {
        setId(id);
        setText(text);
        setDate(date);
        setDone(done);
    }

    public Item(Item item) {
        this(item.id, item.text, item.date, item.done);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        UUID.fromString(id);
        this.id = id;
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