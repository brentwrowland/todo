package land.brow.model;

import java.util.UUID;

public class Todo implements DAO {
    private String id;
    @Override
    public String id() {
        return id;
    }

    @Override
    public void setId(String id) {
        UUID.fromString(id); //throw error if string is not formatted as UUID
        this.id = id;
    }
}
