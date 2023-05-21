package lab3;

//public class CreditCard {
//
//    public static boolean checkCreditCard(String stringPAN, String cardType) {
//        if(stringPAN.length()!=16){
//            throw new InvalidPANLengthException();
//        }
//        for(int i=0;i<stringPAN.length();i++){
//            if(!Character.isDigit(stringPAN.charAt(i))) throw new InvalidPANCharacterException();
//        }
//        if(stringPAN.charAt(stringPAN.length()-1)-48!=CreditCard.getChecksum(Long.parseLong(stringPAN))) throw new InvalidPANChecksumException();
//        if(stringPAN.charAt(0)=='3'&& !cardType.equals("Diners"))throw new InvalidCardException();
//        if(stringPAN.charAt(0)=='4'&& !cardType.equals("Visa"))throw new InvalidCardException();
//        if(stringPAN.charAt(0)=='5'&& !cardType.equals("MasterCard"))throw new InvalidCardException();
//        if(stringPAN.charAt(0)=='6'&& !cardType.equals("AmEx"))throw new InvalidCardException();
//
//        return true;
//    }
//    public static int getChecksum(Long numbPAN){
//        int number=0;
//        numbPAN=numbPAN/10;
//        while (numbPAN!=0){
//            number+=numbPAN%10;
//            numbPAN=numbPAN/10;
//        }
//        return number%10;
//    }
//}
