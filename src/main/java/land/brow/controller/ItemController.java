package land.brow.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import land.brow.model.Item;
import land.brow.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/items")
public class ItemController implements ControllerI<Item> {
    private static final Logger LOG = LoggerFactory.getLogger(ItemController.class);

    private final Service<Item> service;

    public ItemController(Service<Item> service) {
        this.service = service;
    }

    @Get
    public HttpResponse<List<Item>> get() {
        return HttpResponse.ok(service.get());
    }

    @Get("/{id}")
    public HttpResponse<Item> get(@PathVariable String id) {
        return HttpResponse.ok(service.get(id));
    }

    @Post
    public HttpResponse<Item> post(@Body Item item) {
        return HttpResponse.ok(service.post(item));
    }

    @Put("/{id}")
    public HttpResponse<Item> put(@PathVariable String id, @Body Item item) {
        return HttpResponse.ok(service.put(id, item));
    }

    @Delete("/{id}")
    public HttpResponse<Item> delete(@PathVariable String id) {
        return HttpResponse.ok(service.delete(id));
    }
}