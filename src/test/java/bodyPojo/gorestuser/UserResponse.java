package bodyPojo.gorestuser;

import lombok.Data;

@Data
public class UserResponse {

    private String id;
    private String name;
    private String gender;
    private String email;
    private String status;

//    public UserResponse(String id,String name,String gender,String email,String status){
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.email = email;
//        this.status = status;
//    }


}
