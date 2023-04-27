package bodyPojo.gorestuser;

import lombok.Data;

@Data
public class User {
    private String name;
    private String gender;
    private String email;
    private String status;

    public User(String name,String gender,String email,String status){
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }
}
