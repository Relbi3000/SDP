package car_sales_app.viewmodel;

import car_sales_app.model.Cart;
import car_sales_app.model.Car;

import java.util.logging.Logger;

public class RemoveFromCartCommand {
    private static final Logger logger = Logger.getLogger(RemoveFromCartCommand.class.getName());
    private Cart cart;
    private Car car;

    public RemoveFromCartCommand(Cart cart, Car car) {
        this.cart = cart;
        this.car = car;
    }

    public void execute() {
        cart.removeCar(car);
        logger.info("Removed " + car.getDetails() + " from the cart");
    }
}
