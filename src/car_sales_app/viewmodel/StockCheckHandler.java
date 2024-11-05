package car_sales_app.viewmodel;

import car_sales_app.model.Order;
import car_sales_app.utils.Handler;

import java.util.logging.Logger;

public class StockCheckHandler extends Handler {
    private static final Logger logger = Logger.getLogger(StockCheckHandler.class.getName());

    @Override
    public void handle(Order order) {
        logger.info("Checking stock for order");
        if (next != null) {
            next.handle(order);
        }
    }
}
