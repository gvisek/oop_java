package lab2;

class Parser {

    public static void parse(String line, IntWordVisitor visitor){
        String[] strings=line.split(" ");
        for(String s: strings){
            if(s.contains("0") ||s.contains("1") ||s.contains("2") ||s.contains("3") ||s.contains("4") ||
                    s.contains("5") ||s.contains("6") ||s.contains("7") ||s.contains("8") ||
                    s.contains("9")){
                visitor.foundInt(Integer.parseInt(s));
            }else visitor.foundWord(s);
        }
    }
}
