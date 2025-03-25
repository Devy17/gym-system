package gym.access.view;

import gym.access.service.AccessService;
import gym.user.domain.User;
import gym.user.service.UserService;

import java.util.List;

import static common.AppUI.inputInteger;
import static common.AppUI.inputString;

public class AccessView {
    public static void accessUserView() {
        String phoneBackNum;
        UserService userService = new UserService();

        // 핸드폰 번호 유효성 검증 로직
        do {
            System.out.println("# 핸드폰 번호 뒷 4자리를 입력해주세요");
            phoneBackNum = inputString(">>> ");
            if(phoneBackNum.length() != 4) {
                System.out.println("# 4자리를 입력해주세요!");
            } else {
                boolean flag = true;
                for (int i = 0; i < 4; i++) {
                    if(!Character.isDigit(phoneBackNum.charAt(i))) {
                        System.out.println("# 숫자만 입력해주세요");
                        flag = false; break;
                    }
                }

                if(flag) break; //통과
            }
        } while (true);

        AccessService accessService = new AccessService();
        accessService.accessUserService(phoneBackNum);
    }

    public static void cannotFindUser() {
        System.out.println("# 유저 정보를 찾을 수 없습니다.");
    }

    public static User findUserForUserList(List<User> userList) {
        for (User user : userList) {
            System.out.printf("%d. %s(%s) 등록 날짜 : %s\n",
                    user.getUserId(), user.getUserName(), user.getPhoneNumber(), user.getRegistDate().toString());
        }
        int selectNum = inputInteger(">>> ");
        for (User user : userList) {
            if(selectNum == user.getUserId()) {
                return user;
            }
        }
        System.out.println("# 잘못된 회원 번호입니다.");
        return null;
    }

    public static void accessSuccessful() {
        System.out.println("# 출입이 정상적으로 처리되었습니다.");
    }
}
