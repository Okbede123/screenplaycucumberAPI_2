package common.ultility;



import java.util.Random;

public class CommonSupport {
    public static int getRandomNum(){
       return new Random().nextInt(100);
    }

    public static String TOKEN_API_POSTMAN = "PMAK-64032f29aa0bed48225a64f7-bb96ac5aae72ef0d12d1c0f6d2ba490838";

    public static String COLLECTIONS_ID = "15142729-a60c7d68-9457-4dbb-97c8-02c91662d0e3";

    public static String WORKSPACE_ID = "63ae61dc-29ec-4aa3-8004-51e97019d29f";

    public static String ENVIRONMENT_ID = "15142729-87db98c9-8bb4-4d92-ab7d-afa8675f4478";

    public static String COLLECTION_ID_MOCK = "15142729-eece0217-e3dc-43b6-85c5-170f47e20505";
}
