package gym.access.service;

import gym.access.domain.Access;
import gym.access.repo.AccessRepository;
import gym.access.view.AccessView;
import gym.user.domain.User;
import gym.user.repo.UserRepository;
import gym.user.view.UserView;
import gym.domain.Status;

import java.util.List;
import java.util.Map;

public class AccessService {
    AccessRepository accessRepository = new AccessRepository();
    UserRepository userRepository = new UserRepository();

    public void accessUserService() {
        String phoneBackNum = AccessView.accessUserView();
        if(phoneBackNum.isEmpty()) return;

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
            Status status = accessRepository.checkUserStatus(user);
            if(status != null && status.getRemainedMonth() > 0) {
                // 출입 승인
                if(AccessView.selectAccessMode()) { // 상품 선택했다면 상품 카운트 - 1
                   accessRepository.updateUserStatus(user);
                }
                accessRepository.addAccessData(user);
                AccessView.accessSuccessful();
            } else {
                if(AccessView.requestMembershipExtend()) {
                    // TODO 주문하는 곳으로 이동
                } else {
                    userRepository.updateUserActive(user, false);
                    UserView.accessUserFail();
                }
            }
        }
    }

    public void searchAccessInfoByMonth() {
        String[] dateInfo = AccessView.accessUserView().split("-");
        Map<Access, User> userMap = accessRepository.searchAccessByDate(dateInfo[0], dateInfo[1]);
        AccessView.showAccessByDate(userMap);
    }

}
