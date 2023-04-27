package bodyPojo.postman.collection;

import lombok.Data;

import java.util.List;

@Data
public class Collection {

    private Info info;
    private List<Item> item;

}
