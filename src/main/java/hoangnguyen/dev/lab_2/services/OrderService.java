package hoangnguyen.dev.lab_2.services;

import hoangnguyen.dev.lab_2.models.CartItem;
import hoangnguyen.dev.lab_2.models.Order;
import hoangnguyen.dev.lab_2.models.OrderDetail;
import hoangnguyen.dev.lab_2.models.Product;
import hoangnguyen.dev.lab_2.repositories.OrderDetailRepository;
import hoangnguyen.dev.lab_2.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CartService cartService; // Assuming you have a CartService

    @Transactional
    public Order createOrder(String customerName,
                             List<CartItem> cartItems,
                             String email,
                             String address,
                             String phone,
                             String note,
                             String paymentMethod) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setEmail(email);
        order.setPhone(phone);
        order.setAddress(address);
        order.setNote(note);
        order.setPaymentMethod(paymentMethod);
        order = orderRepository.save(order);
        for (CartItem item : cartItems) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(item.getProduct());
            detail.setQuantity(item.getQuantity());
            orderDetailRepository.save(detail);
        }
        // Optionally clear the cart after order placement
        cartService.clearCart();
        return order;
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
