package lab2;

class IntWordCounter implements IntWordVisitor{
    private int intCount;
    private int wordCount;

    public IntWordCounter(){
        intCount=0;
        wordCount=0;
    }
    public void foundInt(int i){
        intCount++;
    }
    public void foundWord(String word){
        wordCount++;
    }
    public int getIntCount() {
        return intCount;
    }
    public int getWordCount() {
        return wordCount;
    }


}
