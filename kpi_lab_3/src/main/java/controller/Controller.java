package controller;

import javafx.util.Pair;
import model.FileManager;
import model.Model;
import view.Menu;
import view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static view.Menu.MENU_WRONG_MENUITEM;

public class Controller {
    private View view;
    private Model model;



    private Scanner scanner;
    private Menu menuMassege = new Menu();

    public Controller(View view, Model model, Scanner scanner){
        this.view = view;
        this.scanner = scanner;
        this.model = model;
    }

    public void proccesUser() {



        try {
            model.getData();
        }catch(FileNotFoundException e){
            view.printMessage(view.NONE_FILE);
            System.exit(-1);
        }catch(NullPointerException e){
            view.printMessage(view.ERROR_CREATING_DATA);
            System.exit(-1);
        }

        int menuRun = 1;

        String menuItem = (menuMassege.printMenuList(menuRun));
        while (!(menuRun == 0)) {

            if(menuRun!=1) menuItem = menuMassege.printMenuList(menuRun);

            switch (menuItem){

                case "1": {
                    view.zalikovkaZalikovkaShow(model.getZalikovkas());
                    menuRun++;
                    break;
                }
                case "2": {
                    try {
                        List<Pair> students = model.getAllStudentsAverGrade();
                        view.showStudentGoodGrade( students);
                    } catch (IOException e) {
                        view.printMessage(view.ERROR_WRITING_DATA);
                    }
                    menuRun++;
                    break;
                }
                case "3": {
                    view.printMessageInputNumberZalikovka(model.getZalikovkas());
                    try {
                        List<String> subjects = model.getSubjectExamList((scanner.nextLine()));
                        view.outSubjectsIsExamShow(subjects);
                    } catch (IOException e) {
                        view.printMessage(view.ERROR_WRITING_DATA);
                    }

                    menuRun++;
                    break;
                }
                case "E": {
                    menuRun = 0;
                    break;
                }
                case "e": {
                    menuRun = 0;
                    break;
                }
                default:{
                    System.out.println(MENU_WRONG_MENUITEM);
                }

            }
        }
    }
}
