package gym.access.service;

import gym.access.domain.Access;
import gym.user.domain.User;
import gym.user.service.UserService;

public class AccessService {

    private UserService userService;

    public AccessService(UserService userService) {
        this.userService = userService;
    }

    public User accessUser(String phone) {
        // 휴대폰 번호를 기준으로 유저를 조회
        User user = userService.join(phone);

        if (user == null) {
            System.out.println("등록되지 않은 회원입니다.");
            return null;
        }

        if (user.isActive()) {
            System.out.printf("[%s]님, 출입이 허용되었습니다.\n", user.getUserName());
        } else {
            System.out.println("출입 권한이 만료되었습니다.");
        }

        return user;
    }




    public void MembershipInformationInput() {  //출입


    }

}
