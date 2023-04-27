package testcase.postman.collections;

import common.postmanAPI.collections.CollectionsAPI;
import org.junit.Test;

public class GetListCollection {

    @Test
    public void getListCollections(){
        CollectionsAPI.getListAllCollections("PMAK-64032f29aa0bed48225a64f7-bb96ac5aae72ef0d12d1c0f6d2ba490838").prettyPrint();
    }
}
