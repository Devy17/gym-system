package gym.access.service;

import gym.access.domain.Access;
import gym.access.repo.AccessRepository;
import gym.access.view.AccessView;
import gym.user.domain.User;
import java.util.List;
import java.util.Map;

import static common.AppUI.inputInteger;
import static common.AppUI.inputString;

public class AccessService {
    AccessRepository accessRepository = new AccessRepository();

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
            if(accessRepository.checkUserStatus(user)) {
                // 출입 승인
                accessRepository.addAccessData(user);
                AccessView.accessSuccessful();
            } else {
                // TODO 주문하는 곳으로 이동
            }
        }
    }

    public void searchAccessInfoByMonth() {
        String[] dateInfo = AccessView.accessUserView().split("-");
        Map<Access, User> userMap = accessRepository.searchAccessByDate(dateInfo[0], dateInfo[1]);
        AccessView.showAccessByDate(userMap);
    }

}
