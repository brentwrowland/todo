package land.brow.controller;

import io.micronaut.http.annotation.*;
import land.brow.model.Item;
import land.brow.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/items")
public class ItemController {
    private static final Logger LOG = LoggerFactory.getLogger(ItemController.class);

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Get
    public List<Item> get() {
        return itemRepository.read();
    }

    @Get("/{id}")
    public Item get(@PathVariable String id) {
        return itemRepository.read(id);
    }

    @Post
    public Item post(@Body Item item) {
        return itemRepository.create(item);
    }

    @Put("/{id}")
    public Item put(@PathVariable String id, @Body Item item)
    {
        return itemRepository.update(id, item);
    }

    @Delete("/{id}")
    public Item delete(@PathVariable String id)
    {
        return itemRepository.delete(id);
    }
}