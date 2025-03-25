package gym.order.service;

import gym.order.domain.Order;
import gym.order.repo.OrderRepository;
import gym.order.view.OrderView;
import gym.product.domain.Product;
import gym.product.service.ProductService;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private ProductService productService = new ProductService();

    public void showAllOrderInfo() {
        List<Order> orderList = orderRepository.getOrderList();
        OrderView.showOrderInfo(orderList);
    }

    public List<Product> getProductOptionService()
    {
        return productService.getProductOptions();
    }
}
