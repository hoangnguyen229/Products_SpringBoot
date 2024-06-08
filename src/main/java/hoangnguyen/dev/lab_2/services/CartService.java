package hoangnguyen.dev.lab_2.services;

import hoangnguyen.dev.lab_2.models.CartItem;
import hoangnguyen.dev.lab_2.models.Product;
import hoangnguyen.dev.lab_2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class CartService {
    private List<CartItem> cartItems = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    public void addToCart(Long productId, int quantity){
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new IllegalStateException("Product not found: " + productId)
        );
        double totalPrice = product.getPrice() * quantity;
        cartItems.add(new CartItem(product,quantity, totalPrice));
    }

    public List<CartItem> getCartItems(){
        return cartItems;
    }

    public void removeFromCart(Long productId){
        cartItems.removeIf(item -> item.getProduct().getId().equals(productId));
    }

    public void clearCart(){
        cartItems.clear();
    }



}
