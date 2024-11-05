package car_sales_app.viewmodel;

import java.util.logging.Logger;

public class PaymentAdapter {
    private static final Logger logger = Logger.getLogger(PaymentAdapter.class.getName());

    public void processPayment(double amount, String paymentMethod) {
        logger.info("Processing " + paymentMethod + " payment of " + amount);
        // Логика обработки платежа
    }
}
