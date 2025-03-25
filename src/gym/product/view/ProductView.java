package gym.product.view;

import static common.AppUI.inputInteger;
import static common.AppUI.inputString;

import gym.product.domain.Product;
import gym.product.service.ProductService;

public class ProductView {

    /**
     * 상품 추가
     */
    public static void addProductView() {
        ProductService productService = new ProductService();
        System.out.println("\n====== 상품 추가. ======");
        String productName = inputString("# 상품 이름: ");
        int price = inputInteger("# 상품 가격: ");

        Product product = productService.createProduct(productName, price);
        System.out.printf("\n### [%s] 상품이 등록되었습니다.\n", product.getProductName());
    }
}
