package ua.kpi.lab1;

import ua.kpi.lab1.controller.Controller;
import ua.kpi.lab1.model.DataGen;
import ua.kpi.lab1.model.Model;
import ua.kpi.lab1.view.View;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller(new View(), new Model());

        controller.proccesUser();

    }
}
