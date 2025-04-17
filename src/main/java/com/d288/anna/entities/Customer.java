package com.d288.anna.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName;


    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @Column(name = "phone", nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id")
    private Division division;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Cart> carts = new HashSet<>();

    public void add (Cart cart){
        if (cart != null){
            if(carts == null){
                carts = new HashSet<>();}
            carts.add(cart);
            cart.setCustomer(this);}
    }
}


