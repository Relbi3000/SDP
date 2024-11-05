package car_sales_app.viewmodel;

import car_sales_app.model.Car;

import java.util.logging.Logger;

public class CarFactory {
    private static final Logger logger = Logger.getLogger(CarFactory.class.getName());

    public Car createCar(String carType) {
        logger.info("Creating car of type: " + carType);
        switch (carType) {
            case "Sedan":
                return new Car("Sedan", 20000);
            case "SUV":
                return new Car("SUV", 30000);
            default:
                throw new IllegalArgumentException("Unknown car type");
        }
    }
}
