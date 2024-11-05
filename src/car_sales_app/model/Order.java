package car_sales_app.model;

public class Order {
    private Cart cart;
    private String address;
    private String paymentMethod;

    public Order(Cart cart, String address, String paymentMethod) {
        this.cart = cart;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }

    public Cart getCart() {
        return cart;
    }

    public String getAddress() {
        return address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
