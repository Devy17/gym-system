package gym.order.view;

import static common.AppUI.inputInteger;
import static common.AppUI.wrongNumber;

public class OrderView {
    public static void purchaseMembershipView() {
        // TODO 여기에 회원권 조회하는 로직이 들어가야 함. -> membership.service에 구현해주세요
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
