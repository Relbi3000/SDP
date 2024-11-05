package car_sales_app.view;

import car_sales_app.model.Cart;
import car_sales_app.model.Car;

import java.util.logging.Logger;

public class View {
    private static final Logger logger = Logger.getLogger(View.class.getName());

    public void showCart(Cart cart) {
        logger.info("Displaying cart contents");
        System.out.println("Cars in your cart:");
        for (Car car : cart.getCars()) {
            System.out.println(car.getDetails());
        }
        System.out.println("Total: " + cart.getTotal());
    }
}
