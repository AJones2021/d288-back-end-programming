package com.d288.anna.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter

public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;


    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "excursion_title")
    private String excursion_title;

    @Column(name = "image_url")
    private String image_URL;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;
}


