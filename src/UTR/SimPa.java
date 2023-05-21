package UTR;

import java.util.*;
public class SimPa {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String ulazniNizovi = scanner.nextLine();
        String stanja = scanner.nextLine();
        String ulazi = scanner.nextLine();
        String znakoviStoga = scanner.nextLine();
        String prihvatljivaStanjaLinija = scanner.nextLine();
        String pocetnoStanje = scanner.nextLine();
        String pocetniZnakStoga = scanner.nextLine();
        int prihvatljivost = 0;
        int fail = 0;
        ArrayList<String> prihvatljivaStanja = new ArrayList<>(Arrays.asList(prihvatljivaStanjaLinija.split(",")));
        ArrayList<LinkedList<String>> nizovi = new ArrayList<>();
        String[] tmp = ulazniNizovi.split("\\|");
        for(String s : tmp){
            LinkedList<String> listaUlaza = new LinkedList<>();
            listaUlaza.addAll(Arrays.asList(s.split(",")));
            nizovi.add(listaUlaza);
        }
        Stack<String> stog = new Stack<>();

        HashMap<String, String> lookupTable = new HashMap<>();

        while(scanner.hasNextLine()) {
            String prijelaz = scanner.nextLine();
            if (prijelaz.length() == 0)
                break;
            String[] razdvojenPrijelaz = prijelaz.split("->");
            lookupTable.put(razdvojenPrijelaz[0], razdvojenPrijelaz[1]);
        }

        for(LinkedList<String> ulazniNiz : nizovi){
            stog.clear();
            stog.add(pocetniZnakStoga);
            String trenutnoStanje = pocetnoStanje;
            System.out.print(trenutnoStanje+"#");
            ispisiStog(stog);
            System.out.print("|");
            int zadnji = 0;
            if(lookupTable.containsKey(trenutnoStanje+",$,"+stog.peek())){
                trenutnoStanje = provjeri$Prijelaze(stog, trenutnoStanje, lookupTable, prihvatljivaStanja, zadnji);
            }
            //TODO napravi prijelaz;
            for(String ulaz : ulazniNiz){
                String vrhStoga = stog.empty()?"$":stog.peek();
                if(lookupTable.containsKey(trenutnoStanje+","+ulaz+","+vrhStoga)){
                    String prijelaz = lookupTable.get(trenutnoStanje+","+ulaz+","+stog.peek());
                    String[] stanje_znakStoga = prijelaz.split(",");
                    if(stanje_znakStoga[1].length()>1){
                        String[] staviNaStog = stanje_znakStoga[1].split("");
                        stog.pop();
                        for(int i = staviNaStog.length-1; i >= 0; i--){
                            stog.add(staviNaStog[i]);
                        }
                    }else if(stanje_znakStoga[1].equals("$")){
                        stog.pop();
                    }
                    trenutnoStanje = stanje_znakStoga[0];
                }else{
                    System.out.print("fail|");
                    fail = 1;
                    break;
                }
                for(String s : prihvatljivaStanja){
                    if(s.equals(trenutnoStanje) && ulazniNiz.indexOf(ulaz) == ulazniNiz.size()-1){
                        prihvatljivost = 1;
                        break;
                    }
                }
                System.out.print(trenutnoStanje+"#");
                ispisiStog(stog);
                System.out.print("|");
                if(ulazniNiz.indexOf(ulaz) == ulazniNiz.size()-1 && prihvatljivost == 1){
                    break;
                }
                if(!stog.empty() && lookupTable.containsKey(trenutnoStanje+",$,"+stog.peek())){
                    if(ulazniNiz.indexOf(ulaz) == ulazniNiz.size()-1)
                        zadnji = 1;
                    trenutnoStanje = provjeri$Prijelaze(stog, trenutnoStanje, lookupTable, prihvatljivaStanja, zadnji);
                }
            }
            for(String s : prihvatljivaStanja){
                if(s.equals(trenutnoStanje)){
                    prihvatljivost = 1;
                    break;
                }
            }
            if(prihvatljivost == 1 && fail != 1){
                System.out.print("1");
                prihvatljivost = 0;
            }else{
                System.out.print("0");
            }
            fail = 0;
            System.out.println();
        }
    }
    public static void ispisiStog(Stack<String> stog){
        Stack<String> pom = new Stack<>();
        if(stog.empty()){
            System.out.print("$");
            return;
        }
        pom.addAll(stog);
        String tmp = pom.pop();
        while(true){
            System.out.print(tmp);
            try {
                tmp = pom.pop();
            }catch (EmptyStackException e){
                break;
            }
        }
    }
    public static String provjeri$Prijelaze(Stack<String> stog, String trenutnoStanje, HashMap<String, String> lookupTable, ArrayList<String> prihvatljivaStanja, int zadnji){
        while(true){
            if(!stog.empty() && lookupTable.containsKey(trenutnoStanje+",$,"+stog.peek())){
                String prijelaz = lookupTable.get(trenutnoStanje+",$,"+stog.peek());
                String[] stanje_znakStoga = prijelaz.split(",");
                trenutnoStanje = stanje_znakStoga[0];
                if(stanje_znakStoga[1].length()>1){
                    String[] staviNaStog = stanje_znakStoga[1].split("");
                    stog.pop();
                    for(int i = staviNaStog.length-1; i >= 0; i--){
                        stog.add(staviNaStog[i]);
                    }
                }else if(stanje_znakStoga[1].equals("$")){
                    stog.pop();
                }
                System.out.print(trenutnoStanje+"#");
                ispisiStog(stog);
                System.out.print("|");
                for(String s : prihvatljivaStanja){
                    if(s.equals(trenutnoStanje) && zadnji == 1){
                        return trenutnoStanje;
                    }
                }
            }else{
                break;
            }
        }
        return trenutnoStanje;
    }

}
