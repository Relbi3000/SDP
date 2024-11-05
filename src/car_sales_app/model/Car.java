package car_sales_app.model;

public class Car {
    private String model;
    private double price;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getDetails() {
        return "Car Model: " + model + ", Price: " + price;
    }

    public double getPrice() {
        return price;
    }
}
