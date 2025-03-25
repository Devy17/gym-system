package gym.order.view;

import static common.AppUI.inputInteger;
import static common.AppUI.wrongNumber;

import gym.membership.domain.Membership;
import gym.membership.service.MembershipService;
import gym.product.domain.Product;
import gym.product.service.ProductService;

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
        // 상품 목록 가져오기
        List<Product> productOptions = ProductService.getProductOptions();

        System.out.println("\n=== 상품 목록 ===");
        if (productOptions.isEmpty()) {
            System.out.println("등록된 상품이 없습니다.");
            return;
        }

        // 상품 정보 출력
        for (Product product : productOptions) {
            System.out.println("상품명: " + product.getProductName() + " 가격: " + product.getPrice() );
            System.out.println("----------------------");
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
    }
        // TODO 여기에 order 테이블에 회원권과 상품을 추가하는 로직이 들어가야 함 -> order.service에 구현해주세요
}
