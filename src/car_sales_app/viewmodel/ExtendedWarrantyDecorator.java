package car_sales_app.viewmodel;

import car_sales_app.model.Car;

import java.util.logging.Logger;

public class ExtendedWarrantyDecorator extends Car {
    private static final Logger logger = Logger.getLogger(ExtendedWarrantyDecorator.class.getName());
    private Car car;

    public ExtendedWarrantyDecorator(Car car) {
        super(car.getDetails(), car.getPrice());
        this.car = car;
        logger.info("Extended warranty added to: " + car.getDetails());
    }

    @Override
    public String getDetails() {
        return car.getDetails() + " (Extended Warranty)";
    }

    @Override
    public double getPrice() {
        return car.getPrice() + 1000;
    }
}
