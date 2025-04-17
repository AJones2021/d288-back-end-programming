package com.d288.anna.services;

import com.d288.anna.entities.Cart;
import com.d288.anna.entities.CartItem;
import com.d288.anna.entities.Customer;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}

