package car_sales_app.utils;

import car_sales_app.model.Order;

public abstract class Handler {
    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(Order order);
}
