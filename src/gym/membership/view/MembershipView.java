package gym.membership.view;

import static common.AppUI.inputInteger;

import gym.membership.domain.Membership;
import gym.membership.service.MembershipService;
import java.text.DecimalFormat;
import java.util.List;

public class MembershipView {

    /**
     * 회원권 종류 추가
     */
    public static void addUserView() {
        MembershipService membershipService = new MembershipService();
        System.out.println("\n====== 회원권 종류 추가. ======");
        int period = inputInteger("# 회원권 개월: ");
        int price = inputInteger("# 회원권 가격: ");

        Membership membership = membershipService.createMembership(period, price);
        System.out.printf("\n### [%d]개월 회원권이 등록되었습니다.\n", membership.getPeriod());
    }

}
