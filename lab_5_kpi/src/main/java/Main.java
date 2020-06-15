import controller.Controller;
import model.Model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.View;

import java.util.Scanner;

public class Main {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        Controller controller = new Controller(new View(), new Model(), new Scanner(System.in));
        logger.debug("Proggram started to run main procces");
        controller.proccesUser();
    }

}
