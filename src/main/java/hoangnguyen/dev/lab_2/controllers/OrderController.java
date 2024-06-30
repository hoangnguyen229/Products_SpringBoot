package hoangnguyen.dev.lab_2.controllers;

import hoangnguyen.dev.lab_2.models.CartItem;
import hoangnguyen.dev.lab_2.models.Order;
import hoangnguyen.dev.lab_2.services.CartService;
import hoangnguyen.dev.lab_2.services.OrderService;
import hoangnguyen.dev.lab_2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;

    @GetMapping
    public String getAllOrders(Model model){
        model.addAttribute("orders",orderService.getAllOrders());
        return "/order/order-list";
    }
    @GetMapping("/checkout")
    public String checkout() {
        return "/cart/checkout";
    }
    @PostMapping("/submit")
    public String submitOrder(String customerName, String email, String address, String phone, String note, String paymentMethod) {
        List<CartItem> cartItems = cartService.getCartItems();
        if (cartItems.isEmpty()) {
            return "redirect:/cart"; // Redirect if cart is empty
        }
        orderService.createOrder(customerName, cartItems, email, address, phone,note, paymentMethod);
        return "redirect:/order/confirmation";
    }
    @GetMapping("/confirmation")
    public String orderConfirmation(Model model) {
        model.addAttribute("message", "Your order has been successfully placed.");
        return "cart/order-confirmation";
    }
    @GetMapping("/details/{orderId}")
    public String showOrderDetails(@PathVariable Long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "order/order-detail";
    }
}
