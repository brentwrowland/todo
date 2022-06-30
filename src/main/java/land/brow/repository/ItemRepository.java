package land.brow.repository;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import jakarta.inject.Singleton;
import land.brow.model.Item;

import java.util.List;

@Singleton
public class ItemRepository implements Repository<Item> {
    private static final String DATABASE = "todo";
    private static final String COLLECTION = "item";

    private final MongoClient client;

    public ItemRepository(MongoClient client) {
        this.client = client;
    }

    public List<Item> readByTodoId(String id)
    {
        return toList(collection().find(Filters.eq("todoID", id)));
    }

    public MongoCollection<Item> collection() {
        return client.getDatabase(DATABASE).getCollection(COLLECTION, Item.class);
    }
}