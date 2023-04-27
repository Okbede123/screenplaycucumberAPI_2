package bodyPojo.postman.collection;

import lombok.Data;

import java.util.List;

@Data
public class Item {
    private String name;
    private List<Item> item;
    private Request request;
}
