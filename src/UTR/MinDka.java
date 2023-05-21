package UTR;

import java.util.*;

public class MinDka {
    static String startStanje;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String lista_stanja = scan.nextLine();
        String lista_ulaza= scan.nextLine();
        String prihvatljivoStanje = scan.nextLine();
        startStanje = scan.nextLine();


        ArrayList<String> listaStanja = new ArrayList<>(Arrays.asList(lista_stanja.split(",")));
        ArrayList<String> prihvatljivaStanja = new ArrayList<>();
        if(!prihvatljivoStanje.isEmpty()){
            prihvatljivaStanja.addAll(Arrays.asList((prihvatljivoStanje.split(","))));
        }
        HashMap<String, String> lookupTable = new HashMap<>();
        ArrayList<String> listaUlaza = new ArrayList<>(Arrays.asList(lista_ulaza.split(",")));

        //Stvaranje lookup Tablice za DKA
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
            lookupTable.put(key, razdvojenPrijelaz[1]);

        }
        listaStanja = izbaciNedohvatna(lookupTable, listaStanja, listaUlaza, new ArrayList<>(List.of(startStanje)), new ArrayList<>(List.of(startStanje)));
        listaStanja.sort(String::compareTo);

        ArrayList<String> listaStanjaNova = pronadiIstovjetna(lookupTable, listaStanja, listaUlaza, prihvatljivaStanja);
        ispis(lookupTable, listaStanjaNova, listaUlaza, prihvatljivaStanja, startStanje);
    }

    public static ArrayList<String> izbaciNedohvatna(HashMap<String, String> lookupTable, ArrayList<String> listaStanja,
                                        ArrayList<String> listaUlaza, ArrayList<String> trenutnaStanja, ArrayList<String> dohvacenaStanja){
        ArrayList<String> novaStanja = new ArrayList<>();
       for(String stanje : trenutnaStanja){
           for(String ulaz : listaUlaza){
               if(lookupTable.containsKey(stanje + ulaz)){
                   String s = lookupTable.get(stanje + ulaz);
                       if(!dohvacenaStanja.contains(s)){
                           dohvacenaStanja.add(s);
                           novaStanja.add(s);
                       }
                   }
               }

           dohvacenaStanja = izbaciNedohvatna(lookupTable, listaStanja, listaUlaza, novaStanja, dohvacenaStanja);
       }
        return dohvacenaStanja;
    }
    public static ArrayList<String> pronadiIstovjetna(HashMap<String, String> lookupTable, ArrayList<String> listaStanja,
                                                      ArrayList<String> listaUlaza, ArrayList<String> prihvatljivaStanja){
        HashMap<String, String> marked = new HashMap<>();
        ArrayList<String> neprihvatljivaStanja = new ArrayList<>();
        for(String stanje1 : listaStanja){
            if(!prihvatljivaStanja.contains(stanje1)){
                for(String stanje2 : prihvatljivaStanja){
                    marked.put(stanje1 + stanje2, "x");
                }
                neprihvatljivaStanja.add(stanje1);
            }
        }
        algoritam(lookupTable, neprihvatljivaStanja, listaUlaza, marked);
        algoritam(lookupTable, prihvatljivaStanja, listaUlaza, marked);
        ArrayList<String> istovjetnaStanja = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        for(String s1 : neprihvatljivaStanja){
            for(String s2 : neprihvatljivaStanja){
                if(s1.compareTo(s2) != 0){
                    if(!marked.containsKey(s1+s2) && !marked.containsKey(s2+s1)){
                        istovjetnaStanja.addAll(List.of(s1,s2));
                        istovjetnaStanja.sort(String::compareTo);
                        temp.add(istovjetnaStanja.get(1));
                        for(String key : lookupTable.keySet()){
                            if(lookupTable.get(key).equals(istovjetnaStanja.get(1))){
                                lookupTable.replace(key, istovjetnaStanja.get(1), istovjetnaStanja.get(0));
                            }
                        }
                        if(startStanje.compareTo(istovjetnaStanja.get(1))==0){
                            startStanje = istovjetnaStanja.get(0);
                        }
                        istovjetnaStanja.clear();
                    }
                }
            }
        }
        for(String s1 : prihvatljivaStanja){
            for(String s2 : prihvatljivaStanja){
                if(s1.compareTo(s2) != 0){
                    if(!marked.containsKey(s1+s2) && !marked.containsKey(s2+s1)){
                        istovjetnaStanja.addAll(List.of(s1,s2));
                        istovjetnaStanja.sort(String::compareTo);
                        temp.add(istovjetnaStanja.get(1));
                        for(String key : lookupTable.keySet()){
                            if(lookupTable.get(key).equals(istovjetnaStanja.get(1))){
                                lookupTable.replace(key, istovjetnaStanja.get(1), istovjetnaStanja.get(0));
                            }
                        }
                        if(startStanje.compareTo(istovjetnaStanja.get(1))==0){
                            startStanje = istovjetnaStanja.get(0);
                        }
                        istovjetnaStanja.clear();
                    }
                }
            }
        }
        for(String s : temp){
            listaStanja.remove(s);
        }
        return listaStanja;
    }
    public static void algoritam(HashMap<String, String> lookupTable, ArrayList<String> stanja,
                                                    ArrayList<String> listaUlaza,
                                                    HashMap<String, String> marked){
        HashMap<String, ArrayList<String>> ovisni = new HashMap<>();
        boolean flag = false;
        for(String s1 : stanja){
            for(String s2 : stanja){
                if(s1.compareTo(s2) != 0){
                    for(String ulaz : listaUlaza){
                        if(marked.containsKey(lookupTable.get(s1+ulaz)+lookupTable.get(s2+ulaz)) || marked.containsKey(lookupTable.get(s2+ulaz)+lookupTable.get(s1+ulaz))){
                            marked.put(s1+s2, "x");
                            oznaciRekurzivno(ovisni,marked,s1+s2);
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        for(String ulaz : listaUlaza){
                            if(lookupTable.get(s1+ulaz).compareTo(lookupTable.get(s2+ulaz)) != 0){
                                if(!ovisni.containsKey(lookupTable.get(s1+ulaz)+lookupTable.get(s2+ulaz))){
                                    ovisni.put(lookupTable.get(s1+ulaz)+lookupTable.get(s2+ulaz), new ArrayList<>(List.of(s1+','+s2)));
                                }else{
                                    ovisni.get(lookupTable.get(s1+ulaz)+lookupTable.get(s2+ulaz)).add(s1+','+s2);
                                }
                            }
                        }
                    }
                    flag = false;
                }
            }
        }
    }
    public static void oznaciRekurzivno(HashMap<String, ArrayList<String>> ovisni, HashMap<String, String> marked, String key){
        if(!ovisni.containsKey(key))
            return;
        for(String s : ovisni.get(key)){
            String[] stanja = s.split(",");
            marked.put(stanja[0] + stanja[1], "x");
            oznaciRekurzivno(ovisni, marked, stanja[0] + stanja[1]);
        }
    }
    public static void ispis(HashMap<String, String> lookupTable, ArrayList<String> listaStanja,
                             ArrayList<String> listaUlaza, ArrayList<String> prihvatljivaStanja, String startStanje){
        StringBuilder sb = new StringBuilder();
        prihvatljivaStanja.removeIf(s1 -> !listaStanja.contains(s1));
        for(String stanje : listaStanja){
            sb.append(stanje);
            sb.append(",");
        }
        sb.replace(sb.length()-1, sb.length(), "");
        System.out.println(sb);
        sb.delete(0, sb.length());
        for(String stanje : listaUlaza){
            sb.append(stanje);
            sb.append(",");
        }
        sb.replace(sb.length()-1, sb.length(), "");
        System.out.println(sb);
        sb.delete(0, sb.length());
        for(String stanje : prihvatljivaStanja){
            sb.append(stanje);
            sb.append(",");
        }
        if(sb.length()>0) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        System.out.println(sb);
        sb.delete(0, sb.length());
        System.out.println(startStanje);
        for(String stanje : listaStanja){
            for(String ulaz : listaUlaza){
                if(lookupTable.containsKey(stanje+ulaz)){
                    System.out.println(stanje+","+ulaz+"->"+lookupTable.get(stanje+ulaz));
                }
            }
        }
    }
 }


