package gym.product.service;

import gym.product.domain.Product;
import gym.product.repo.ProductRepository;

import java.util.List;


public class ProductService {

    private static final ProductRepository productRepositoryRepository = new ProductRepository();

    // 상품 조회
    public static List<Product> getProductOptions() {
        return productRepositoryRepository.findAll();
    }

    /**
     * 상품 추가
     */
    public Product createProduct(String productName, int price) {
        Product product = new Product(productName, price);
        productRepositoryRepository.addProduct(product);

        return product;
    }
}
