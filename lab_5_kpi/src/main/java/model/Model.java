package model;

import javafx.util.Pair;
import model.FileManager;
import model.entities.Course;
import model.entities.Subjects;
import model.entities.Zalikovka;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static view.View.*;

public class Model {
    private static Logger logger = LogManager.getLogger();

    private List<Zalikovka> zalikovkas;
    FileManager fileManager = new FileManager();
    private List<Pair> studentGoodGradeList= new ArrayList<>();


    public void getData() throws FileNotFoundException {
        logger.debug("creating zalikovkas");
        zalikovkas = fileManager.readFile();

    }

    public List<Zalikovka> getZalikovkas() {
        return zalikovkas;
    }

    public List<Pair> getAllStudentsAverGrade() throws IOException {
        Pair nameStudentAndAverGrade;
        for(Zalikovka zalikovka: zalikovkas){
                nameStudentAndAverGrade = averageGradeStudent(zalikovka);
                if (((double) nameStudentAndAverGrade.getValue()) >= NUMBER_GOOD_GRADE_STUDENT) {
                    studentGoodGradeList.add(nameStudentAndAverGrade);
                }
        }
        fileManager.writeFileForGoodStudent(studentGoodGradeList);
        logger.debug("created student list");
        return studentGoodGradeList;
    }

    private Pair averageGradeStudent(Zalikovka zalikovka){
        Pair nameStudentAndAverGrade;
        int countSubjects =0;
        double averageGrade = 0;
        for(Course course: zalikovka.getCourse()){

                for (Subjects subject: course.getSubject()){
                    averageGrade +=subject.getGradeSubject();
                    countSubjects++;
                }

        }
        averageGrade= averageGrade / countSubjects;
        nameStudentAndAverGrade = new Pair(zalikovka.getNameStudent(), averageGrade);
        return nameStudentAndAverGrade;
    }

    public List<String> getSubjectExamList(String nameZalikovka) throws IOException {
        List<String> subjectExamList = new ArrayList<>();
        Zalikovka zalikovka;
        if (findZalikovkaByName(nameZalikovka)){
            zalikovka = getZalikovkaByName(nameZalikovka);

            subjectExamList = subjectExamList(zalikovka);
            if (subjectExamList.size()==0) subjectExamList.add(NONE_EXAMS);

        } else subjectExamList.add(NONE_ZALIKOVKA);
        fileManager.writeFileExamList(subjectExamList);
        logger.debug("created exam list");
        return  subjectExamList;
    }


    private boolean findZalikovkaByName(String nameZalikovka){
        boolean zalikovkaExist = false;
        for(Zalikovka zalikovka: zalikovkas){
            if (zalikovka.getNameStudent().equalsIgnoreCase(nameZalikovka)) zalikovkaExist = true;
        }
        return zalikovkaExist;
    }
    private Zalikovka getZalikovkaByName(String zalikovkaName){
        Zalikovka validZalikovka = null;

        for(Zalikovka zalikovka: zalikovkas){
            if (zalikovka.getNameStudent().equalsIgnoreCase(zalikovkaName)) validZalikovka = zalikovka;
        }
        return validZalikovka;
    }
    private List<String> subjectExamList(Zalikovka zalikovka){
        List<String> isExamSubjectsList = new ArrayList<>();
        for(Course course: zalikovka.getCourse()){
            for (Subjects subject: course.getSubject()){
                if(subject.getExamSubject()) isExamSubjectsList.add(getExamList(course.getCourseNumber(),subject.getNameSubject()));
            }
        }
        return isExamSubjectsList;
    }

    public String getExamList(int courseNumber, String subjectName){
        return YEAR +courseNumber+PERENS+subjectName;
    }


}
