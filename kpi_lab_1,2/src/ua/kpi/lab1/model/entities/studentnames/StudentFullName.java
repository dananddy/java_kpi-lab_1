package ua.kpi.lab1.model.entities.studentnames;

import static ua.kpi.lab1.model.entities.studentnames.StudentFirstName.getRandomFirstNameStudentAsString;
import static ua.kpi.lab1.model.entities.studentnames.StudentLastName.getRandomLastNameStudentAsString;
import static ua.kpi.lab1.model.entities.studentnames.StudentMiddleName.getRandomMiddleNameStudentAsString;

public class StudentFullName {

    public String getNameStudentFull(){
        String nameStudentFull;

        nameStudentFull =getRandomLastNameStudentAsString()+' '+
                         getRandomFirstNameStudentAsString()+' '+
                         getRandomMiddleNameStudentAsString();
        return nameStudentFull;
    }
}
