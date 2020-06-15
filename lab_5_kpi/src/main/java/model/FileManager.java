package model;

import com.google.gson.*;
import javafx.util.Pair;
import model.entities.Zalikovka;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static Logger logger = LogManager.getLogger();
    Constants constants = new Constants();

    public void writeFileForGoodStudent(List<Pair> allStudentsAverGrade) throws IOException {
        logger.debug("writing file for good students list");
        FileWriter writer = new FileWriter(constants.FILE_GOOD_ST, false);
        for(Pair student: allStudentsAverGrade){
            writer.write(student.getKey()+" ");
            writer.write( student.getValue()+" ");
            writer.flush();
        }

    }

    public void writeFileExamList(List<String> subjectExamList) throws IOException {
        logger.debug("writing file for exam list");
       FileWriter writer = new FileWriter(constants.FILE_EXAM, false);
            for(String student: subjectExamList){
                writer.write(student+"\n");
                writer.flush();
            }

    }
    public List<Zalikovka> readFile() throws FileNotFoundException {
        logger.debug("reading file with students");
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
