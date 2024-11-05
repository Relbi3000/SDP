package car_sales_app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Cart {
    private static final Logger logger = Logger.getLogger(Cart.class.getName());
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
        logger.info("Car added to cart: " + car.getDetails());
    }

    public void removeCar(Car car) {
        cars.remove(car);
        logger.info("Car removed from cart: " + car.getDetails());
    }

    public double getTotal() {
        return cars.stream().mapToDouble(Car::getPrice).sum();
    }

    public List<Car> getCars() {
        return cars;
    }

    // Method to find a car by type in the cart
    public Car findCarByType(String carType) {
        for (Car car : cars) {
            if (car.getDetails().contains(carType)) {
                return car;
            }
        }
        return null;
    }
}
