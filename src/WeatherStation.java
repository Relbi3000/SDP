import java.util.List;
import java.util.ArrayList;

// Интерфейс Observer (Наблюдатель)
interface Observer {
    void update(float temperature);
}

// Класс WeatherStation (Издатель)
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    // Метод для добавления наблюдателя
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Метод для удаления наблюдателя
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Метод для уведомления всех наблюдателей об изменении температуры
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    // Метод для изменения температуры
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

// Класс PhoneDisplay (Конкретный Наблюдатель)
class PhoneDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Телефон: Температура изменилась, теперь " + temperature + " градусов");
    }
}

// Класс LaptopDisplay (Конкретный Наблюдатель)
class LaptopDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Ноутбук: Температура изменилась, теперь " + temperature + " градусов");
    }
}
