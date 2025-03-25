package gym.access.view;

import gym.access.domain.Access;
import gym.access.service.AccessService;
import gym.user.domain.User;
import gym.user.service.UserService;

import java.util.List;
import java.util.Map;

import static common.AppUI.inputInteger;
import static common.AppUI.inputString;

public class AccessView {
    public static String accessUserView() {
        String phoneBackNum;

        // 핸드폰 번호 유효성 검증 로직
        do {
            System.out.println("# 핸드폰 번호 뒷 4자리를 입력해주세요 \n종료를 원하시면 q를 입력하세요.");
            phoneBackNum = inputString(">>> ");

            if(phoneBackNum.equals("q")) return "";

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
        return phoneBackNum;
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

    public static String searchAccessView() {
        System.out.println("# 조회하고자 하는 년도를 입력해주세요.");
        int year = inputInteger(">>> ");
        System.out.println("# 조회하고자 하는 달을 입력해주세요.");
        int month;
        do {
            month = inputInteger(">>> ");
            if(month < 1 || month > 12) {
                System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
            } else break;
        } while (true);

        return year + "-" + month;
    }

    public static void showAccessByDate(Map<Access, User> userMap) {
        for (Access access : userMap.keySet()) {
            User user = userMap.get(access);
            System.out.printf("# 날짜 : %s, 회원명 %s(%s)", access.getAccessDate().toString(), user.getUserName(), user.getPhoneNumber());
        }
    }
}
