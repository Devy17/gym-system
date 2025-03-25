package gym.order.view;

import static common.AppUI.inputInteger;
import static common.AppUI.wrongNumber;

import gym.membership.view.MembershipView;
import gym.order.domain.Order;

import java.util.List;

public class OrderView {

    public static void purchaseMembershipView() {
        System.out.println("\n# 구매하시려는 회원권을 선택해주세요.");
        // 회원권 조회 로직
        MembershipView.findMembershipView();

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

    public static void showOrderInfo(List<Order> orderList) {
        System.out.println("========== 결제 목록 ==========");
        for (Order order : orderList) {
            if(order.getProduct() == null) {
                System.out.printf("결제 ID | %d, 회원 정보 | %s(%s), 결제 상품 | %s, 담당 직원 | %s",
                        order.getOrderId(), order.getUser().getUserId(), order.getUser().getPhoneNumber(),
                        order.getMembership().getPeriod() + "개월", order.getEmployee().getEmployeeName());
            } else {
                System.out.printf("결제 ID | %d, 회원 정보 | %s(%s), 결제 상품 | %s, %s, 담당 직원 | %s",
                        order.getOrderId(), order.getUser().getUserId(), order.getUser().getPhoneNumber(),
                        order.getProduct().getProductName(), order.getMembership().getPeriod() + "개월", order.getEmployee().getEmployeeName());
            }
        }
    }
}
