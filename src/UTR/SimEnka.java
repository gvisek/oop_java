package UTR;

import java.util.*;

public class SimEnka {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String prviRed = scan.nextLine();
        String drugiRed = scan.nextLine();
        String treciRed = scan.nextLine();
        String prihvatljivoStanje = scan.nextLine();
        String startStanje = scan.nextLine();

        //Stvaranje listi ulaza
        ArrayList<LinkedList<String>> nizovi = new ArrayList<>();
        String[] tmp = prviRed.split("\\|");
        for(String s : tmp){
            LinkedList<String> listaUlaza = new LinkedList<>();
            listaUlaza.addAll(Arrays.asList(s.split(",")));
            nizovi.add(listaUlaza);
        }

        ArrayList<String> listaStanja = new ArrayList<>(Arrays.asList(drugiRed.split(",")));

        HashMap<String, ArrayList<String>> lookupTable = new HashMap<>();

        //Stvaranje lookup Tablice za NKA
        while(scan.hasNextLine()){
            String prijelaz = scan.nextLine();
            if(prijelaz.length() == 0)
                break;
            String[] razdvojenPrijelaz = prijelaz.split("->");
            String[] stanjeIUlaz = razdvojenPrijelaz[0].split(",");
            String[] prijelaznaStanja = razdvojenPrijelaz[1].split(",");
            String key = stanjeIUlaz[0] + stanjeIUlaz[1];
            if(Objects.equals(razdvojenPrijelaz[1], "#"))
                continue;
            if(!lookupTable.containsKey(key)){
                lookupTable.put(key, new ArrayList<>());
            }
            for(String stanje : prijelaznaStanja){
                lookupTable.get(key).add(stanje);
            }

        }

        //Prolazak kroz sve listu ulaza, ispisivanje stanja u kojim se automat nalazi za koji ulaz
        for(LinkedList<String> listaUlaza : nizovi){
            StringBuilder izlaz = new StringBuilder();
            ArrayList<String> proslaStanja;
            proslaStanja = dodaj$Prijelaze(lookupTable, new ArrayList<String>(Collections.singleton(startStanje)), new ArrayList<String>(Collections.singleton(startStanje)) );
            //TODO ubaci DFS ovdje vjv
            proslaStanja.sort(String::compareTo);
            izlaz.append(proslaStanja.get(0));
            for(String s : proslaStanja) {
                if(!s.equals(proslaStanja.get(0)))
                    izlaz.append(",").append(s);
            }
            izlaz.append("|");
            izlaz.append(iduciIspis(lookupTable, listaUlaza, proslaStanja));
            izlaz.deleteCharAt(izlaz.length()-1);
            System.out.println(izlaz);
        }
    }
    public static String iduciIspis(HashMap<String, ArrayList<String>> lookupTable, LinkedList<String> listaUlaza, ArrayList<String> proslaStanja){

        ArrayList<String> trenutnaStanja = new ArrayList<>();
        StringBuilder izlaz = new StringBuilder();
//        if(lookupTable.containsKey(startStanje+"$")){
//            proslaStanja.addAll(lookupTable.get(startStanje + "$"));
//        }

        for(String ulaz : listaUlaza){
            for(String stanje : proslaStanja){
                if(lookupTable.containsKey(stanje+ulaz)){
                    for(String s : lookupTable.get(stanje+ulaz)){
                        if(!trenutnaStanja.contains(s))
                            trenutnaStanja.add(s);
                    }
                    trenutnaStanja = dodaj$Prijelaze(lookupTable, trenutnaStanja, new ArrayList<>(trenutnaStanja));
                }
            }
            if(trenutnaStanja.isEmpty()){
                izlaz.append("#|");
                proslaStanja = new ArrayList<>(trenutnaStanja);
                trenutnaStanja.clear();
                continue;
            }
            trenutnaStanja.sort(String::compareTo);
            izlaz.append(trenutnaStanja.toString(), 1, trenutnaStanja.toString().length()-1);
            izlaz.append("|");
            proslaStanja = new ArrayList<>(trenutnaStanja);
            trenutnaStanja.clear();
        }
        izlaz = new StringBuilder(izlaz.toString().replace(" ", ""));
        return izlaz.toString();
    }

    public static ArrayList<String> dodaj$Prijelaze(HashMap<String, ArrayList<String>> lookupTable, ArrayList<String> trenutnaStanja, ArrayList<String> svaStanja){
        ArrayList<String> novaStanja = new ArrayList<>();
        for(String stanje : trenutnaStanja){
            if(lookupTable.containsKey(stanje+"$") && !svaStanja.containsAll(lookupTable.get(stanje+"$"))){
                for(String s : lookupTable.get(stanje+"$"))
                    if(!svaStanja.contains(s)) {
                        svaStanja.add(s);
                        novaStanja.add(s);
                    }
            }
            svaStanja = dodaj$Prijelaze(lookupTable, novaStanja, svaStanja);

        }
        return svaStanja;
    }

}
