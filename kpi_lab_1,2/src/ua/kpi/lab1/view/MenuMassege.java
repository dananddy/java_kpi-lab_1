package ua.kpi.lab1.view;

import java.util.Scanner;

public class MenuMassege {

    public static final String MENU_SHOW_STUDENTS= "1\tShow list of the students\n";
    public static final String MENU_SHOW_GOOD_GRADE_LIST= "2\tShow list of the students with good grades\n";
    public static final String MENU_SUBJECT_IS_EXAM = "3\tShow student's exams\n";

    public static final String MENU_LOG_INFO = "\nL\tShow information in Log\n";

    public static final String MENU_WRONG_MENUITEM = "Enter valid menu item!\n";

    public static final String MENU_EXIT = "E\tEXIT\n";

    public static void clearScreen() {

        System.out.print("\033[H\033[2J");

        System.out.flush();

    }
    public String printMenuList(){
        Scanner scanner = new Scanner(System.in);

        clearScreen();
        System.out.println("\n\n\n\n"+MENU_SHOW_STUDENTS+MENU_SHOW_GOOD_GRADE_LIST+MENU_SUBJECT_IS_EXAM+MENU_LOG_INFO+MENU_EXIT);
        String menuItem = scanner.next();
        return menuItem;
    }


}
