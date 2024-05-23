package exam04;

public class LoginService {
    public  void  login(String userId, String userPw) {

            if (!userId.equals("user01")) {
                throw new UserIdException("아이디가 일치하지 않음");
            }
            if (!userPw.equals("123456")) {
                throw new UserPwException("비번 ㄴ");
            }
        }

    }
