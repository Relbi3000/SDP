package car_sales_app.viewmodel;

import car_sales_app.model.Order;
import car_sales_app.utils.Handler;

import java.util.logging.Logger;

public class PaymentHandler extends Handler {
    private static final Logger logger = Logger.getLogger(PaymentHandler.class.getName());

    @Override
    public void handle(Order order) {
        logger.info("Processing payment for order to " + order.getAddress());
        if (next != null) {
            next.handle(order);
        }
    }
}
