package ua.kpi.lab1.model.entities.studentnames;

import java.util.Random;

public enum StudentMiddleName {
    PETRIVICH,
    ADAMOVICH,
    VIKTOROVICH,
    MIKHAYLOVICH,
    DANIELOVICH,
    IGOREVICH,
    ROMANOVICH,
    PILIPOVICH,
    GEKTOROVICH,
    PHILOSOVICH;
    private static final StudentMiddleName[] STUDEN_NAME = values();
    private static final int SIZE = STUDEN_NAME.length;
    private static final Random RANDOM = new Random();

    public static StudentMiddleName getRandomStudentName()  {
        return STUDEN_NAME[RANDOM.nextInt(SIZE)];
    }

    public static String getRandomMiddleNameStudentAsString(){
        return String.valueOf(StudentMiddleName.getRandomStudentName());
    }
}
