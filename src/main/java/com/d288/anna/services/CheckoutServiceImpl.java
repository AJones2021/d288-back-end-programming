package com.d288.anna.services;

import com.d288.anna.dao.CartItemRepository;
import com.d288.anna.dao.CartRepository;
import com.d288.anna.dao.CustomerRepository;
import com.d288.anna.entities.Cart;
import com.d288.anna.entities.CartItem;
import com.d288.anna.entities.Customer;
import com.d288.anna.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.UUID;

import static com.d288.anna.entities.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements  CheckoutService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartItemRepository cartItemRepository, CartRepository cartRepository, CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        try {
            Cart cart = purchase.getCart();
            String orderTrackingNumber = generateOrderTrackingNumber();

            cart.setOrderTrackingNumber(orderTrackingNumber);

            Set<CartItem> cartItems = purchase.getCartItems();

            cartItems.forEach(item -> item.setCart(cart));

            cartItems.forEach(item -> cart.add(item));

            Customer customer = purchase.getCustomer();
            customer.add(cart);
            cartRepository.save(cart);
            cart.setStatus(StatusType.ordered);

            if (cartItems.isEmpty()) {
                throw new IllegalArgumentException("Cart cannot be empty");
            }


            return new PurchaseResponse(orderTrackingNumber);
        }
        catch (Exception e) {
            return new PurchaseResponse(e.getMessage());

        }

    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }

}


