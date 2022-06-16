package land.brow.repository;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import jakarta.inject.Singleton;
import land.brow.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ItemRepository implements Repository<Item> {
    private static final Logger LOG = LoggerFactory.getLogger(ItemRepository.class);
    private static final String DATABASE = "todo";
    private static final String COLLECTION = "item";

    private final MongoClient client;

    public ItemRepository(MongoClient client) {
        this.client = client;
    }

    public Item read(String id) {
        List<Item> items = toList(collection().find(Filters.eq(id)));

        if (items.size() != 1)
            return null;

        return items.get(0);
    }

    public List<Item> read() {
        return toList(collection().find());
    }

    public Item create(Item item) {
        InsertOneResult result = collection().insertOne(item);
        LOG.info("create result:  {}", result);

        if (result.getInsertedId() == null)
            return null;

        return read(result.getInsertedId().asString().getValue());
    }

    public Item update(String id, Item item) {
        item.setId(id);
        var result = collection().replaceOne(Filters.eq(id), item);
        LOG.info("update result:  {}", result);
        if (result.getMatchedCount() == 0)
            return null;

        return read(id);
    }


    public Item delete(String id) {
        Item target = read(id);
        if (target == null)
            return null;

        DeleteResult result = collection().deleteOne(Filters.eq(id));
        LOG.info("delete result:  {}", result);

        if (result.getDeletedCount() != 1)
            return null;

        return target;
    }

    private MongoCollection<Item> collection() {
        return client.getDatabase(DATABASE).getCollection(COLLECTION, Item.class);
    }

    private static List<Item> toList(Iterable<Item> iterable) {
        List<Item> items = new ArrayList<>();
        iterable.forEach(items::add);
        return items;
    }
}