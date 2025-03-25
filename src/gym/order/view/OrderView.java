package gym.order.view;

import static common.AppUI.inputInteger;
import static common.AppUI.wrongNumber;

import gym.access.service.AccessService;
import gym.membership.domain.Membership;
import gym.product.domain.Product;
import gym.product.service.ProductService;

import java.util.List;

import gym.employee.service.EmployeeService;
import gym.membership.view.MembershipView;
import gym.order.service.OrderService;
import gym.user.domain.User;
import gym.user.service.UserService;
import java.util.Scanner;
import gym.order.domain.Order;

import java.util.List;


public class OrderView {

    private static final OrderService orderService = new OrderService();
    private static final UserService userService = new UserService();
    private static final EmployeeService employeeService = new EmployeeService();
    private static final AccessService accessService = new AccessService();

    /**
     * 회원권 결재
     */
    public static void purchaseMembershipView() {

        accessService.searchAccessInfoByMonth();

        Scanner sc = new Scanner(System.in);
        System.out.println("\n### 회원권을 등록할 유저를 입력해주세요.");

        // 1. 회원 이름이 입력이 되었는지 확인
        String userName = getUserName(sc);
        if (userName == null) {
            return; // 잘못된 입력시 종료
        }

        // 2. 회원 이름 입력 후 존재 여부 확인
        int userId = getUserId(userName, sc);
        if (userId == -1) {
            return; // 회원 선택 실패시 종료
        }

        // 3. 랜덤 직원 배정
        int employeeId = getRandomEmployeeId();
        if (employeeId == -1) {
            System.out.println("# 직원 정보가 없습니다.");
            return;
        }

        // 4. 회원권 등록
        purchaseMembership(sc, userId, employeeId);
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
            System.out.println("상품명: " + product.getProductName() + " 가격: " + product.getPrice());
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


    /**
     * 회원 이름이 입력이 되었는지 확인
     */
    private static String getUserName(Scanner sc) {
        System.out.print("# 회원 이름을 입력하세요: ");
        String userName = sc.nextLine();

        if (userName.isEmpty()) {
            System.out.println("# 이름을 입력해주세요.");
            return null;
        }

        return userName;
    }

    /**
     * 회운이 존재하는지, 있따면 회원이 여러 명일 경우 선택하도록 처리
     */
    private static int getUserId(String userName, Scanner sc) {
        List<User> userList = userService.showUserByName(userName);

        if (userList.isEmpty()) {
            System.out.println("# 해당 회원이 존재하지 않습니다.");
            return -1;
        }

        int userId = -1;
        if (userList.size() == 1) {
            userId = userList.get(0).getUserId();
        } else {
            System.out.println("\n# 동일한 이름의 회원이 여러 명 있습니다. 선택해주세요.");
            for (int i = 0; i < userList.size(); i++) {
                System.out.printf("### %d, %s, %s, %s\n",
                        (i + 1), userList.get(i).getUserName(), userList.get(i).getPhoneNumber(),
                        userList.get(i).getRegistDate());
            }
            System.out.print("# 회원 번호를 선택하세요: ");

            String choiceStr = sc.nextLine();
            if (choiceStr.isEmpty()) {
                System.out.println("# 번호를 입력해야 합니다.");
                return -1;
            }

            try {
                int choice = Integer.parseInt(choiceStr) - 1;
                if (choice < 0 || choice >= userList.size()) {
                    System.out.println("# 잘못된 입력입니다.");
                    return -1;
                }
                userId = userList.get(choice).getUserId();
            } catch (NumberFormatException e) {
                System.out.println("# 숫자만 입력해주세요.");
                return -1;
            }
        }

        return userId;
    }

    /**
     * 랜덤 직원 배정
     */
    private static int getRandomEmployeeId() {
        return employeeService.getRandomEmployeeId();
    }

    /**
     * 회원권 등록
     */
    private static void purchaseMembership(Scanner sc, int userId, int employeeId) {
        System.out.println("\n# 구매하시려는 회원권을 선택해주세요.");
        List<Membership> memberships = MembershipView.findMembershipView();
        System.out.print("\n구매할 회원권 번호를 입력하세요: ");
        String selectNumStr = sc.nextLine();

        try {
            int selectNum = Integer.parseInt(selectNumStr);

            if (selectNum >= 1 && selectNum <= memberships.size()) {
                orderService.purchaseMembership(userId, selectNum, employeeId);
            } else {
                System.out.println("# 잘못된 번호입니다. 1부터 " + memberships.size() + "까지의 번호를 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("# 숫자만 입력해주세요.");

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
