package bodyPojo.postman.mock;

import lombok.Data;

@Data
public class Mock {

    private String collection;
    private String environment;
    private String name;
    private String description;
    private boolean privateCheck;
    private String versionTag;
}
