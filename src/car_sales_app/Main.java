package car_sales_app;

import car_sales_app.model.Cart;
import car_sales_app.model.Car;
import car_sales_app.model.Order;
import car_sales_app.viewmodel.CarFactory;
import car_sales_app.viewmodel.ExtendedWarrantyDecorator;
import car_sales_app.model.OrderBuilder;
import car_sales_app.viewmodel.AddToCartCommand;
import car_sales_app.viewmodel.RemoveFromCartCommand;
import car_sales_app.viewmodel.CheckoutChain;
import car_sales_app.view.View;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarFactory factory = new CarFactory();
    private static final Cart cart = new Cart();
    private static Order order;

    public static void main(String[] args) {
        logger.info("Application started");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nSelect an action:");
            System.out.println("1. Add a car from catalog to the cart"); // Добавление из каталога
            System.out.println("2. Add a custom car to catalog"); // Добавление новой модели в каталог
            System.out.println("3. View available cars in catalog"); // Просмотр доступных моделей
            System.out.println("4. Remove a car from the cart");
            System.out.println("5. View cart contents");
            System.out.println("6. Add extended warranty to a car");
            System.out.println("7. Checkout and create order");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addCarFromCatalogToCart();
                    break;
                case 2:
                    addCustomCarToCatalog();
                    break;
                case 3:
                    viewAvailableCars();
                    break;
                case 4:
                    removeCarFromCart();
                    break;
                case 5:
                    viewCart();
                    break;
                case 6:
                    addWarrantyToCar();
                    break;
                case 7:
                    checkout();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        logger.info("Application finished");
    }

    // Функция для добавления автомобиля из каталога в корзину
    private static void addCarFromCatalogToCart() {
        viewAvailableCars(); // Показываем доступные автомобили для выбора
        System.out.print("Enter the car model name to add to the cart: ");
        String carType = scanner.nextLine();

        try {
            Car car = factory.createCarFromCatalog(carType); // Создаем автомобиль из каталога
            AddToCartCommand addCommand = new AddToCartCommand(cart, car);
            addCommand.execute();
            System.out.println("Added " + carType + " to the cart.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Функция для добавления кастомного автомобиля в каталог
    private static void addCustomCarToCatalog() {
        System.out.print("Enter custom car model name: ");
        String modelName = scanner.nextLine();
        System.out.print("Enter custom car price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        factory.createCustomCar(modelName, price);
        System.out.println("Added custom car " + modelName + " with price " + price + " to catalog.");
    }

    // Функция для просмотра доступных автомобилей в каталоге
    private static void viewAvailableCars() {
        System.out.println("Available cars in catalog:");
        for (Car car : factory.getAvailableCars()) {
            System.out.println("- " + car.getDetails());
        }
    }

    // Функция для удаления автомобиля из корзины
    private static void removeCarFromCart() {
        System.out.print("Enter car type or model name to remove: ");
        String carType = scanner.nextLine();
        var car = cart.findCarByType(carType);
        if (car != null) {
            RemoveFromCartCommand removeCommand = new RemoveFromCartCommand(cart, car);
            removeCommand.execute();
            System.out.println("Removed " + carType + " from the cart.");
        } else {
            System.out.println("Car not found in the cart.");
        }
    }

    // Функция для просмотра содержимого корзины
    private static void viewCart() {
        View view = new View();
        view.showCart(cart);
    }

    // Функция для добавления расширенной гарантии к автомобилю в корзине
    private static void addWarrantyToCar() {
        System.out.print("Enter car type or model name to add warranty: ");
        String carType = scanner.nextLine();
        var car = cart.findCarByType(carType);
        if (car != null) {
            var carWithWarranty = new ExtendedWarrantyDecorator(car);
            cart.removeCar(car); // Remove the original car
            cart.addCar(carWithWarranty); // Add the car with warranty
            System.out.println("Extended warranty added to " + carType + ".");
        } else {
            System.out.println("Car not found in the cart.");
        }
    }

    // Функция для оформления заказа
    private static void checkout() {
        System.out.print("Enter delivery address: ");
        String address = scanner.nextLine();
        System.out.print("Enter payment method (e.g., Credit Card): ");
        String paymentMethod = scanner.nextLine();

        OrderBuilder orderBuilder = new OrderBuilder(cart);
        order = orderBuilder.setAddress(address).setPaymentMethod(paymentMethod).build();

        CheckoutChain checkoutChain = new CheckoutChain();
        checkoutChain.handle(order);

        System.out.println("Order created and processed.");
    }
}
