package lab4;




import java.io.IOException;
import java.nio.file.*;


public class TextFileAnalyser {
    public static Language detectLanguage(Path file) throws IOException{

        boolean hrv=false;
        boolean de=false;
        for(String s:Files.readAllLines(file)){
            if(s.contains("š")||s.contains("đ")||s.contains("č")||
                    s.contains("ć")||s.contains("ž")||s.contains("Š")||
                    s.contains("Đ")||s.contains("Č")||s.contains("Ć")||s.contains("Ž")){
                hrv=true;
            }
            if(s.contains("ä") || s.contains("ö") || s.contains("ü") ||
                    s.contains("Ä") || s.contains("Ö") || s.contains("Ü") ||
                    s.contains("ß") ) de=true;
        }
        if(hrv && de ) return Language.UNKNOWN;
        else if(hrv) return Language.HR;
        else if(de) return Language.DE;
        return Language.EN;
    }
}
