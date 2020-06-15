package model;

import com.google.gson.*;
import javafx.util.Pair;
import model.entities.Zalikovka;

import view.View;

import java.io.*;
import java.util.ArrayList;

import java.util.List;

public class FileManager {

    Constants constants = new Constants();

    public void writeFileForGoodStudent(List<Pair> allStudentsAverGrade) throws IOException {
        FileWriter writer = new FileWriter(constants.FILE_GOOD_ST, false);
        for(Pair student: allStudentsAverGrade){
            writer.write(student.getKey()+" ");
            writer.write( student.getValue()+" ");
            writer.flush();
            writer.close();
        }

    }

    public void writeFileExamList(List<String> subjectExamList) throws IOException {
       FileWriter writer = new FileWriter(constants.FILE_EXAM, false);
            for(String student: subjectExamList){
                writer.write(student+"\n");
                writer.flush();
                writer.close();
            }

    }
    public List<Zalikovka> readFile() throws FileNotFoundException {

        List<Zalikovka> zalikovkas = new ArrayList<>();
        zalikovkas.add(parseFromJson(constants.FILE_1));
        zalikovkas.add(parseFromJson(constants.FILE_2));
        zalikovkas.add(parseFromJson(constants.FILE_3));

        return zalikovkas;
    }

    private Zalikovka parseFromJson(String fileName) throws FileNotFoundException {
        Gson gson = new Gson();
        Reader reader = new FileReader(fileName);
        return gson.fromJson(reader, Zalikovka.class);

    }
}
