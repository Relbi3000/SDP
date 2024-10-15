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

// Пример использования
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Создаем издателя (метеостанцию)
        WeatherStation weatherStation = new WeatherStation();

        // Создаем два наблюдателя (телефон и ноутбук)
        Observer phoneDisplay = new PhoneDisplay();
        Observer laptopDisplay = new LaptopDisplay();

        // Добавляем наблюдателей к метеостанции
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(laptopDisplay);

        // Изменяем температуру и наблюдатели автоматически получают обновление
        weatherStation.setTemperature(25.0f);
        weatherStation.setTemperature(30.5f);
    }
}
