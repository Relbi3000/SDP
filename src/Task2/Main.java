package Task2;


class UserApp {
    private UserViewModel userViewModel;
    private UserView userView;

    public UserApp() {
        userViewModel = new UserViewModel();
        userView = new UserView();
    }

    public static void main(String[] args) {
        UserApp app = new UserApp();
        app.run();
    }

    public void run() {
        while (true) {
            int option = userView.showMenu();

            switch (option) {
                case 1:
                    String name = userView.getUserName();
                    userViewModel.addUser(name);
                    userView.showMessage("User added!");
                    break;
                case 2:
                    userView.displayUsers(userViewModel.getUsers());
                    break;
                case 3:
                    userView.showMessage("Exiting...");
                    userView.close();
                    return;
                default:
                    userView.showMessage("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
