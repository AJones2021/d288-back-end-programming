package com.d288.anna.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")

    private Long id;

    @Column(name="package_price")
    private BigDecimal package_price;

    @Column(name="party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusType status;

    @Column(name="order_tracking_number")
    private String orderTrackingNumber;

    @CreationTimestamp
    @Column(name="create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name="last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItem =new HashSet<>();

   public void add (CartItem item) {

        if (item != null) {
            if(cartItem == null){
                cartItem = new HashSet<>();
            }            this.cartItem.add(item);
                            item.setCart(this);
        }
    }
}


