package view;

import javafx.util.Pair;
import model.entities.Course;
import model.entities.Subjects;
import model.entities.Zalikovka;

import java.util.List;

public class View {

    public static final double NUMBER_GOOD_GRADE_STUDENT = 4.5;
    public final String NONE_FILE = "No files were found";
    public final String ERROR_CREATING_DATA= "NO zalikovkas created";
    public final String ERROR_WRITING_DATA= "NO data written";


    public static final String TABLE_SIGN = "_____________________________________________________________________________";
    public static final String INPUT_NUMBER_ZALIKOVKA= "There are these students available for investigation:\n";
    public static final String INPUT_NUMBER_ZALIKOVKA_AGAIN= "\nIf you want to see exmas of other student\nenter the number of zalikovka\nIf you want to exit - press any non-numirical symbol\n";
    public static final String NONE_STUDENT_GOOD_GRADE = "None of the Students have average grade higher then 4.5";
    public static final String NONE_ZALIKOVKA = "No such Zalikovka!\n";
    public static final String NONE_EXAMS = "Student had not any exams!";
    public static final String OUTPUT_LIST_STUDENT = "\nStudents with excellent grades (higher then 4.5):\nEnter course number:\n";

    public static final String MENU_MAIN = "Welcome to zalikovkas base!\n1.Display all base of zalikovkas\n2.Display students with high grades\n3.Find student via id\n4.Exit";

    public static final String FORMATED_TOP_TABLE = "%-3s|%-8s|%-30s|\n";
    public static final String FORMATED_COURSE_DISPLAY ="%3s|%8s|%30s: \n";
    public static final String FORMATED_SUBJECT_DISPLAY ="%3s|%8s|%30s|%-20s (%4s) - %3d\n";
    public static final String FORMATED_GRADE_DISPLAY ="%-30s  %.1f\n";

    public static final String IF_EXAM ="Exam";
    public static final String IF_TEST ="Test";
    public static final String YEAR ="(Year ";
    public static final String PERENS =") ";
    public static final String EMPTY ="";
    public void printTableOfZalikovka(){System.out.format("%-2s|%-8s|%-24s%5s|%3s  %3s\n","№","ID","STUDENT NAME","COURSE","SUBJECT","","GRADE");}

    public void printMessageInputNumberZalikovka(List<Zalikovka> zalikovkas){
        System.out.println(INPUT_NUMBER_ZALIKOVKA);
        int columnForIds = zalikovkas.size()/10 + 1;
        int columnCounter = 0;
        for (Zalikovka zalikovka: zalikovkas) {
            columnCounter++;
            System.out.print("["+zalikovka.getNameStudent()+"]"+"\t\t\t");
            if (columnCounter/columnForIds == 1) {
                System.out.println("\n");
                columnCounter = 0;
            }
        }
        System.out.print("\n"+TABLE_SIGN+"\n");
    }
    public void zalikovkaZalikovkaShow(List<Zalikovka> zalikovkas) {

        printTableOfZalikovka();
        printMessage(TABLE_SIGN);
        for (Zalikovka zalikovka: zalikovkas){
            System.out.format (FORMATED_TOP_TABLE,zalikovka.getNumZalikovka(),zalikovka.getIdStudent(),
                    zalikovka.getNameStudent());
            zalikovkaCourseShow(zalikovka.getCourse());
            printMessage(TABLE_SIGN);
        }
    }

    private void zalikovkaCourseShow(List<Course> courses) {
        for (Course course: courses){
            System.out.format(FORMATED_COURSE_DISPLAY,EMPTY,EMPTY,course.getCourseNumber());
            zalikovkaSubjectShow(course.getSubject());
        }
    }

    private void zalikovkaSubjectShow(List<Subjects> subjects) {
        for (Subjects subject: subjects){
            System.out.format (FORMATED_SUBJECT_DISPLAY,EMPTY,EMPTY,EMPTY,subject.getNameSubject(),getExamOfSubject(subject),subject.getGradeSubject());

        }
    }

    private String getExamOfSubject(Subjects subject) {
        return (subject.getExamSubject()) ? IF_EXAM: IF_TEST;
    }

    public void showStudentGoodGrade(List<Pair> students) {
        System.out.println(OUTPUT_LIST_STUDENT);
        if (students.size()==0) System.out.println(NONE_STUDENT_GOOD_GRADE);
        else for (Pair student: students){
            System.out.format (FORMATED_GRADE_DISPLAY,student.getKey(),student.getValue());
        }
    }

    public void outSubjectsIsExamShow(List<String> subjects) {
        try {
            for (String subject: subjects){
                printMessage(subject);
            }
        }catch (NullPointerException e){
            System.out.println(e);
        }

    }

    public void printMessage(String message){System.out.println(message);}
}
