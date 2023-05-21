package dismatLab;

import java.util.Scanner;

public class dismatLab11 {
    public static void main(String[] args) {
        int n;
        double b0, b1, b2, c0, c1, c2;
        double alfa1, alfa2;
        double an = 0;


        Scanner s = new Scanner(System.in);
        System.out.println("Unesite nenegativan cijeli broj: ");
        n = s.nextInt();
        System.out.println("Unesite vrijednost broja b_0: ");
        b0 = s.nextDouble();
        System.out.println("Unesite vrijednost broja b_1: ");
        b1 = s.nextDouble();
        System.out.println("Unesite vrijednost broja b_2: ");
        b2 = s.nextDouble();
        System.out.println("Unesite vrijednost broja c_0: ");
        c0 = s.nextDouble();
        System.out.println("Unesite vrijednost broja c_1: ");
        c1 = s.nextDouble();
        System.out.println("Unesite vrijednost broja c_2: ");
        c2 = s.nextDouble();

        alfa2 = (c2*b1-b2*c1)/(c0*b1-b0*c1);
        alfa1 = (b2-alfa2*b0)/b1;

        for(int i = 2; i <= n; i++){
            an = alfa1*b1 + alfa2*b0;
            b0 = b1;
            b1 = an;
        }

        System.out.println("Vrijednost broja b_n: " + String.format("%.2f", an));
    }
}
