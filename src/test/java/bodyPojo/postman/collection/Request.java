package bodyPojo.postman.collection;

import lombok.Data;

import java.util.List;

@Data
public class Request {
    private String url;
    private String method;
    private String description;
    private List<Header> header;
    private Body body;
}
