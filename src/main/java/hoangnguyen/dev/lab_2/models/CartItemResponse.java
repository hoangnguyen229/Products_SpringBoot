package hoangnguyen.dev.lab_2.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
//@AllArgsConstructor
public class CartItemResponse {

    private Long productId;
    private String productName;
    private double price;
    private int quantity;
    private double total;

    public CartItemResponse(CartItem cartItem) {
        productId = cartItem.getProduct().getId();
        productName = cartItem.getProduct().getName();
        quantity = cartItem.getQuantity();
        price = cartItem.getProduct().getPrice();
    }
}
