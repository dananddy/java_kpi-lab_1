package model.entities;

import java.util.List;

public class Zalikovka {
    private int numZalikovka;

    private int idStudent;

    private String NameStudent;

    private List<Course> course;

    public Zalikovka(int idStudent, List<Course> courses, String studentName, int numZalikovka){
        this.idStudent = idStudent;
        this.NameStudent = studentName;
        this.course = courses;
        this.numZalikovka = numZalikovka;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getNameStudent() {
        return NameStudent;
    }

    public List<Course> getCourse() {
        return course;
    }

    public int getNumZalikovka() {
        return numZalikovka;
    }

    public static class DataConst {
        public static final int NUMBER_MAX_GRADE = 4;

        public static final int NUMBER_MIN_GRADE =3;

        public static final double NUMBER_GOOD_GRADE_STUDENT = 4.5;

        public static final int NUMBER_ID_MIN = 10000;
        public static final int NUMBER_ID_MAX = 99999;

        public static final int NUMBER_SUBJECT_MIN = 3;
        public static final int NUMBER_SUBJECT_MAX =5;

        public static final int NUMBER_COURSES_MIN = 1;
        public static final int NUMBER_COURSES_MAX =4;

        public static final int NUMBER_ZALIKOVKA_MIN = 5;
        public static final int NUMBER_ZALIKOVKA_MAX =12;


    }
}
