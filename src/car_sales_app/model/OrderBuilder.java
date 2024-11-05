package car_sales_app.model;

import java.util.logging.Logger;

public class OrderBuilder {
    private static final Logger logger = Logger.getLogger(OrderBuilder.class.getName());

    private Cart cart;
    private String address;
    private String paymentMethod;

    public OrderBuilder(Cart cart) {
        this.cart = cart;
    }

    public OrderBuilder setAddress(String address) {
        this.address = address;
        logger.info("Set order address: " + address);
        return this;
    }

    public OrderBuilder setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        logger.info("Set payment method: " + paymentMethod);
        return this;
    }

    public Order build() {
        logger.info("Building order");
        return new Order(cart, address, paymentMethod);
    }
}
