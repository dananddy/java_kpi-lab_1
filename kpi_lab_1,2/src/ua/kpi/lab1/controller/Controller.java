package ua.kpi.lab1.controller;

import ua.kpi.lab1.model.Model;
import ua.kpi.lab1.view.View;
import ua.kpi.lab1.view.MenuMassege;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Controller {

    private View view;
    private Model model;



    private Scanner scanner;
    private MenuMassege menuMassege = new MenuMassege();

    public Controller(View view, Model model){
        this.view = view;
        this.scanner = new Scanner(System.in);
        this.model = model;
    }

    public void proccesUser(){
        Pattern regex = Pattern.compile(view.REGEX);
        try{
            model.genData();
        }catch(NullPointerException e){
            view.printMessage(view.ERROR_CREATING_DATA);
            System.exit(-1);
        }
        int menuRun = 1;
        String menuItem = menuMassege.printMenuList();
        while (!(menuRun == 0)) {

            if(menuRun!=1) menuItem = menuMassege.printMenuList();

            switch (menuItem){

                case "1": {
                    view.zalikovkaZalikovkaShow(model.getZalikovkas());
                    menuRun++;
                    break;
                }
                case "2": {
                    boolean validCourse=false;
                    view.printMessage(view.OUTPUT_LIST_STUDENT);
                    while(!validCourse){
                        try{
                            int numberRegex = Integer.parseInt(scanner.next(regex));
                            view.showStudentGoodGrade( model.getAllStudentsAverGrade(numberRegex));
                            validCourse = true;
                        }catch(InputMismatchException e){
                            view.printMessage(view.WRONG_NUMBER_COURSE);
                            scanner.nextLine();
                        }
                    }

                    menuRun++;
                    break;
                }
                case "3": {
                    boolean validCourse=false;
                    view.printMessage(view.INPUT_NUMBER_ZALIKOVKA);
                    view.printMessageInputNumberZalikovka(model.getZalikovkas());
                    String studentName = scanner.nextLine();
                    view.printMessage(view.INPUT_COURSE_NUMBER);
                    while(!validCourse){
                        try{
                            int numberRegex = Integer.parseInt(scanner.next(regex));
                            view.showSubjectsIsExam(model.getSubjectExamList(studentName, numberRegex));
                            validCourse = true;
                        }catch(InputMismatchException e){
                            view.printMessage(view.WRONG_NUMBER_COURSE);
                            scanner.nextLine();
                        }
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
                    view.printMessage(MenuMassege.MENU_WRONG_MENUITEM);
                    menuRun++;
                    break;
                }

            }
        }
    }
}
