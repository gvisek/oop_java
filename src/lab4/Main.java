package lab4;

import java.nio.file.Path;
import java.util.*;

import static lab4.CSVLoader.loadCSVFile;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(TextFileAnalyser.detectLanguage(Path.of("C:\\Users\\vkci1\\Desktop\\nexto.txt")));
    }

}
