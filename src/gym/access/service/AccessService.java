package gym.access.service;

import gym.access.repo.AccessRepository;
import gym.access.view.AccessView;
import gym.user.domain.User;
import gym.user.service.UserService;

import java.util.List;

public class AccessService {

    private UserService userService;

    public AccessService() {
        this.userService = userService;
    }

    AccessRepository accessRepository = new AccessRepository();

    public void accessUserService(String phoneBackNum) {
        List<User> userList = accessRepository.searchUserByPhoneNumber(phoneBackNum);
        User user = null;

        if (userList.size() == 1) {
            user = userList.get(0);
        } else if (!userList.isEmpty()) {
            user = AccessView.findUserForUserList(userList);
        } else {
            AccessView.cannotFindUser();
        }

        if(user != null) {
            if(accessRepository.checkUserStatus(user)) {
                // 출입 승인
                accessRepository.addAccessData(user);
                AccessView.accessSuccessful();
            } else {
                // TODO 주문하는 곳으로 이동
            }
        }
    }





    public void MembershipInformationInput() {  //출입


    }

}
