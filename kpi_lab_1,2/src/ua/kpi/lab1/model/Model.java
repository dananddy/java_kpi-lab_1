package ua.kpi.lab1.model;

import javafx.util.Pair;
import ua.kpi.lab1.model.entities.course.Course;
import ua.kpi.lab1.model.entities.Subjects;
import ua.kpi.lab1.model.entities.Zalikovka;

import java.util.ArrayList;
import java.util.List;

import static ua.kpi.lab1.model.entities.Zalikovka.DataConst.*;
import static ua.kpi.lab1.view.View.*;


public class Model {

    private DataGen dataGen = new DataGen();
    private List<Zalikovka> zalikovkas;




    public void genData(){

            dataGen.createZalikovkas();
            zalikovkas = dataGen.getZalikovkas();
    }

    public List<Zalikovka> getZalikovkas(){
        return zalikovkas;
    }

    public List<Pair> getAllStudentsAverGrade(int courseNumber){
        List<Pair> studentGoodGradeList= new ArrayList<>();
            Pair nameStudentAndAverGrade;
            for(Zalikovka zalikovka: zalikovkas){
                try{
                    nameStudentAndAverGrade = averageGradeStudent(zalikovka, courseNumber);
                    if (((double) nameStudentAndAverGrade.getValue()) >= NUMBER_GOOD_GRADE_STUDENT) {
                        studentGoodGradeList.add(nameStudentAndAverGrade);
                    }
                }catch (NullPointerException e){
                    studentGoodGradeList.add(new Pair(NONE_STUDENT_GOOD_GRADE,0));
                }
            }
        return studentGoodGradeList;
    }


    private Pair averageGradeStudent(Zalikovka zalikovka, int courseNumber){
        Pair nameStudentAndAverGrade;

        int countSubjects =0;
        double averageGrade = 0;
        for(Course course: zalikovka.getCourse()){
            if (course.getCourseNumber()== courseNumber){
                for (Subjects subject: course.getSubject()){
                    averageGrade +=subject.getGradeSubject();
                    countSubjects++;
                }
            }
        }
        averageGrade = averageGrade / countSubjects;
        nameStudentAndAverGrade = new Pair(zalikovka.getNameStudent(), averageGrade);


        return nameStudentAndAverGrade;
    }

    public List<String> getSubjectExamList(String nameZalikovka, int courseNumber){
        List<String> subjectExamList = new ArrayList<>();

        if (checkZalikovkaByName(nameZalikovka)){
            Zalikovka zalikovka = getZalikovkaByName(nameZalikovka);

            subjectExamList = subjectExamList(zalikovka, courseNumber);
            if (subjectExamList.size()==0) {
                subjectExamList.add(NONE_EXAMS);
            }

        } else {
            subjectExamList.add(NONE_ZALIKOVKA);
        }
        return  subjectExamList;
    }


    private boolean checkZalikovkaByName(String nameZalikovka){
        for(Zalikovka zalikovka: zalikovkas){
            if (zalikovka.getNameStudent().equalsIgnoreCase(nameZalikovka)) {
                return true;
            }
        }
        return false;
    }

    private Zalikovka getZalikovkaByName(String zalikovkaName){
        for(Zalikovka zalikovka: zalikovkas){
            if (zalikovka.getNameStudent().equalsIgnoreCase(zalikovkaName)) {
                return zalikovka;
            }
        }
        return null;
    }

    private List<String> subjectExamList(Zalikovka zalikovka, int courseNumber){
        List<String> isExamSubjectsList = new ArrayList<>();
        for(Course course: zalikovka.getCourse()){
            if (course.getCourseNumber() == courseNumber){
                for (Subjects subject : course.getSubject()) {
                    if (subject.getExamSubject())
                        isExamSubjectsList.add(getExamList(course.getCourseNumber(), subject.getNameSubject()));
                }
            }
        }
        return isExamSubjectsList;
    }

    public String getExamList(int courseNumber, String subjectName){
        return courseNumber+" "+subjectName;
    }


}
