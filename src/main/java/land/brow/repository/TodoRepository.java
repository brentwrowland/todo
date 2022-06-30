package land.brow.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Singleton;
import land.brow.model.TodoList;

@Singleton
public class TodoRepository implements Repository<TodoList> {
    private static final String DATABASE = "todo";
    private static final String COLLECTION = "list";

    private final MongoClient client;

    public TodoRepository(MongoClient client) {
        this.client = client;
    }

    @Override
    public MongoCollection<TodoList> collection() {
        return client.getDatabase(DATABASE).getCollection(COLLECTION, TodoList.class);
    }
}
