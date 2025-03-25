package gym.order.service;

import gym.order.domain.Order;
import gym.order.repo.OrderRepository;
import gym.order.view.OrderView;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    public void showAllOrderInfo() {
        List<Order> orderList = orderRepository.getOrderList();
        OrderView.showOrderInfo(orderList);
    }
}
