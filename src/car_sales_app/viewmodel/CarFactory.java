package car_sales_app.viewmodel;

import car_sales_app.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CarFactory {
    private static final Logger logger = Logger.getLogger(CarFactory.class.getName());

    // Статический список для хранения всех доступных моделей автомобилей
    private static final List<Car> availableCars = new ArrayList<>();

    // Инициализация предопределенных моделей
    static {
        availableCars.add(new Car("Sedan", 20000));
        availableCars.add(new Car("SUV", 30000));
    }

    // Метод для получения списка доступных моделей
    public List<Car> getAvailableCars() {
        return availableCars;
    }

    // Метод для добавления новой кастомной модели в каталог
    public Car createCustomCar(String modelName, double price) {
        Car customCar = new Car(modelName, price);
        availableCars.add(customCar);
        logger.info("Added custom car to catalog: " + modelName + " with price " + price);
        return customCar;
    }

    // Метод для создания автомобиля из каталога по имени
    public Car createCarFromCatalog(String carType) {
        for (Car car : availableCars) {
            if (car.getModel().equalsIgnoreCase(carType)) {
                // Создаем копию объекта автомобиля из каталога, чтобы избежать изменения оригинала
                return new Car(car.getModel(), car.getPrice());
            }
        }
        throw new IllegalArgumentException("Unknown car type: " + carType);
    }
}
