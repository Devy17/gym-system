package gym.order.service;

import gym.order.repo.OrderRepository;

public class OrderService {

    private final OrderRepository orderRepository = new OrderRepository();

    public void purchaseMembership(int userId, int membershipId, int employeeId) {
        boolean result = orderRepository.insertOrder(userId, membershipId, employeeId);

        if (result) {
            System.out.println("# 회원권이 성공적으로 구매되었습니다.");
        } else {
            System.out.println("# 회원권 구매에 실패했습니다. 다시 시도해주세요.");
        }
    }

}
