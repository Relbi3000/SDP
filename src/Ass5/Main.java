package Ass5;

public class Main {
    public static void main(String[] args) {
        // Создаем модель и представление
        DataModel model = new DataModel();
        ConsoleView view = new ConsoleView();

        // Создаем презентер
        DataPresenter presenter = new DataPresenter(model, view);

        // Обновляем данные
        presenter.updateData();

        // Выполняем дополнительные операции
        presenter.performMoreOperations();
    }
}

