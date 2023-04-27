package bodyPojo.gorestuser;

import lombok.Data;

import java.util.List;


@Data
public class ListUser {

    private List<UserResponse> userResponseList;

//    public ListUser(List<UserResponse> userResponseList){
//        this.userResponseList = userResponseList;
//    }
}
