package land.brow.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import land.brow.model.DAO;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface Repository<E extends DAO> {
    default E read(String id) {
        return collection().find(Filters.eq(id)).first();
    }

    default List<E> read() {
        return toList(collection().find());
    }

    default List<E> read(int limit, int offset) {
        List<Bson> aggregates = List.of(new BasicDBObject("$skip", offset), new BasicDBObject("$limit", limit));
        return toList(collection().aggregate(aggregates));
    }

    default String create(E entity) {
        entity.setId(UUID.randomUUID().toString());
        InsertOneResult result = collection().insertOne(entity);

        if (result.getInsertedId() == null)
            return null;

        return result.getInsertedId().asString().getValue();
    }

    default String update(String id, E entity) {
        entity.setId(id);
        UpdateResult result = collection().replaceOne(Filters.eq(id), entity);

        if (result.getUpsertedId() == null)
            return null;

        return result.getUpsertedId().asString().getValue();
    }

    default boolean delete(String id) {
        DeleteResult result = collection().deleteOne(Filters.eq(id));

        return result.getDeletedCount() == 1;
    }

    default List<E> toList(Iterable<E> iterable) {
        List<E> items = new ArrayList<>();
        iterable.forEach(items::add);
        return items;
    }

    MongoCollection<E> collection();
}