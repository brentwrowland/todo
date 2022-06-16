package land.brow.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import land.brow.model.Item;
import land.brow.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/items")
public class ItemController implements ControllerI<Item> {
    private static final Logger LOG = LoggerFactory.getLogger(ItemController.class);

    private final Repository<Item> itemRepository;

    public ItemController(Repository<Item> itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Get
    public HttpResponse<List<Item>> get() {
        return HttpResponse.ok(itemRepository.read());
    }

    @Get("/{id}")
    public HttpResponse<Item> get(@PathVariable String id) {
        return HttpResponse.ok(itemRepository.read(id));
    }

    @Post
    public HttpResponse<Item> post(@Body Item item) {
        return HttpResponse.ok(itemRepository.create(item));
    }

    @Put("/{id}")
    public HttpResponse<Item> put(@PathVariable String id, @Body Item item) {
        return HttpResponse.ok(itemRepository.update(id, item));
    }

    @Delete("/{id}")
    public HttpResponse<Item> delete(@PathVariable String id) {
        return HttpResponse.ok(itemRepository.delete(id));
    }
}