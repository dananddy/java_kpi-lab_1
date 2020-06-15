import controller.Controller;
import model.Model;
import view.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller(new View(), new Model(), new Scanner(System.in));

        controller.proccesUser();

    }
}
