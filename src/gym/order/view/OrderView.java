package gym.order.view;

import static common.AppUI.inputInteger;
import static common.AppUI.wrongNumber;

import gym.membership.domain.Membership;
import gym.membership.service.MembershipService;
import java.text.DecimalFormat;
import java.util.List;

public class OrderView {

    public static void purchaseMembershipView() {
        List<Membership> membershipOptions = MembershipService.getMembershipOptions();
        System.out.println("\n# 구매하시려는 회원권을 선택해주세요.");

        for (int i = 1; i <= membershipOptions.size(); i++) {
            Membership membership = membershipOptions.get(i - 1);

            DecimalFormat formatter = new DecimalFormat("#,###");
            String formattedPrice = formatter.format(membership.getPrice());

            System.out.println("### " + i + ". "
                    + membership.getPeriod() + "개월 - " + formattedPrice + "원");
        }


        int selectNum = inputInteger(">>> ");
        switch (selectNum) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                wrongNumber();
                break;
        }
        // TODO 여기에 order 테이블에 회원권을 추가하는 로직이 들어가야 함 -> order.service에 구현해주세요
    }

    public static void purchaseProductView() {
        // TODO 여기에 상품 조회하는 로직이 들어가야 함. -> product.service에 구현해주세요
//        System.out.println("\n# 구매하시려는 회원권을 선택해주세요.");
//        System.out.println("### 1. 3개월");
//        System.out.println("### 2. 6개월");
//        System.out.println("### 3. 9개월");
//        System.out.println("### 4. 12개월");

        int selectNum = inputInteger(">>> ");
        switch (selectNum) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                wrongNumber();
                break;
        }
        // TODO 여기에 order 테이블에 회원권과 상품을 추가하는 로직이 들어가야 함 -> order.service에 구현해주세요
    }
}