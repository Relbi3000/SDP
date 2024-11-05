package car_sales_app;

import car_sales_app.model.Cart;
import car_sales_app.model.Order;
import car_sales_app.model.OrderBuilder;
import car_sales_app.view.View;
import car_sales_app.viewmodel.CarFactory;
import car_sales_app.viewmodel.CheckoutChain;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Application started");

        CarFactory factory = new CarFactory();
        var sedan = factory.createCar("Sedan");
        var suv = factory.createCar("SUV");

        Cart cart = new Cart();
        cart.addCar(sedan);
        cart.addCar(suv);

        logger.info("Cars added to cart");

        OrderBuilder orderBuilder = new OrderBuilder(cart);
        Order order = orderBuilder.setAddress("456 Elm St").setPaymentMethod("Credit Card").build();
        logger.info("Order created");

        CheckoutChain checkoutChain = new CheckoutChain();
        checkoutChain.handle(order);

        View view = new View();
        view.showCart(cart);

        logger.info("Application finished");
    }
}
