package car_sales_app.viewmodel;

import car_sales_app.model.Cart;
import car_sales_app.model.Car;

import java.util.logging.Logger;

public class AddToCartCommand {
    private static final Logger logger = Logger.getLogger(AddToCartCommand.class.getName());

    private Cart cart;
    private Car car;

    public AddToCartCommand(Cart cart, Car car) {
        this.cart = cart;
        this.car = car;
    }

    public void execute() {
        cart.addCar(car);
        logger.info("Added " + car.getDetails() + " to the cart");
    }
}
