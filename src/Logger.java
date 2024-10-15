public class Logger {

    // Step 1: Private static variable to hold the single instance of the Logger
    private static Logger instance;

    // Step 2: Private constructor to prevent instantiation from outside
    private Logger() {
        // private constructor to prevent instantiation
    }

    // Step 3: Public static method to provide access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Step 4: Method to log messages
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
