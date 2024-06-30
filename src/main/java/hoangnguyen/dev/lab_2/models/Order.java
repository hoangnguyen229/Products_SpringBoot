package hoangnguyen.dev.lab_2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String customerName;

    @NotBlank
    private String address;

    @NotBlank
    private String email;

    @NotBlank
    private String note;

    @NotBlank
    private String phone;

    @NotBlank
    private String paymentMethod;

    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public double getTotalPrice() {
        return orderDetails.stream().mapToDouble(OrderDetail::getTotalPrice).sum();
    }
}
