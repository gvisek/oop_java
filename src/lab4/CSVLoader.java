package lab4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;


public class CSVLoader {
    public static CSVData loadCSVFile(String path) throws Exception{
        CSVData csvData=new CSVData();
        Path p=Path.of(path);
        try {
            Scanner scanner=new Scanner(p);
            String[] firstLine=scanner.nextLine().split(",");
            int numOfInf = firstLine.length;
            for(int i=0;i<numOfInf;i++){
                firstLine[i]=firstLine[i].strip();
            }
            csvData.addHeaders(List.of(firstLine));

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                if (line.length == 0) break;
                if (line.length > numOfInf) throw new IndexOutOfBoundsException();

                CSVLine csvLine = new CSVLine();
                for (int i = 0; i < firstLine.length; i++) {
                    if(i>line.length-1) break;
                    csvLine.addElement(firstLine[i].strip(), line[i].strip());
                }
                csvData.addLine(csvLine);

            }
            return csvData;
        }catch(NoSuchFileException e){
            return new CSVData();
        }
    }
}
