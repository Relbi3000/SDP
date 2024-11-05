package car_sales_app.viewmodel;

import car_sales_app.model.Order;
import car_sales_app.utils.Handler;

import java.util.logging.Logger;

public class CheckoutChain {
    private static final Logger logger = Logger.getLogger(CheckoutChain.class.getName());
    private Handler chain;

    public CheckoutChain() {
        this.chain = new StockCheckHandler();
        Handler paymentHandler = new PaymentHandler();
        chain.setNext(paymentHandler);
        logger.info("Checkout chain initialized");
    }

    public void handle(Order order) {
        logger.info("Starting order checkout process");
        chain.handle(order);
    }
}
