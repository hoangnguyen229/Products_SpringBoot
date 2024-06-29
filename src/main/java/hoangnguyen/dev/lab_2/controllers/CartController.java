package hoangnguyen.dev.lab_2.controllers;

import hoangnguyen.dev.lab_2.models.CartItem;
import hoangnguyen.dev.lab_2.models.CartItemResponse;
import hoangnguyen.dev.lab_2.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "/cart/cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, @RequestParam int
            quantity) {
        cartService.addToCart(productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable Long productId) {
        cartService.removeFromCart(productId);
        return "redirect:/cart";
    }

    @GetMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }

    @ResponseBody
    @PostMapping("/api/update")
    public List<CartItemResponse> updateQuantity(@RequestParam long productId, @RequestParam int quantity) {
        System.out.println("ccc");
        cartService.updateQuantity(productId, quantity);
        List<CartItem> carts = cartService.getCartItems();
        return carts.stream().map(CartItemResponse::new).toList();
    }
}
