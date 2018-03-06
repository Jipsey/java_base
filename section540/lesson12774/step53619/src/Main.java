import java.util.logging.*;

class Main {


    //Stepik code: start
    public static void configureLogging() {

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());

       // создаём и настраиваем логгер А
       Logger LOGGER_A = Logger.getLogger("org.stepic.java.logging.ClassA");
              LOGGER_A.setLevel(Level.ALL);

       // создаём и настраиваем логгер B
       Logger LOGGER_B = Logger.getLogger("org.stepic.java.logging.ClassB");
              LOGGER_B.setLevel(Level.WARNING);

       Logger LOGGER_C = Logger.getLogger("org.stepic.java");
              LOGGER_C.setLevel(Level.ALL);
              LOGGER_C.addHandler(handler);
       LOGGER_C.setUseParentHandlers(false);
    }
//Stepik code: end
}
