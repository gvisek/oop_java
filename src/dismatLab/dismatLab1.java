package dismatLab;
import java.util.*;

public class dismatLab1 {
    public static void main(String[] args){
        int n;
        double b0, b1, b2, c0, c1, c2;
        double alfa1, alfa2;
        double D1, D2, x1, x2;
        double an;
        double diskriminanta;

        Scanner s = new Scanner(System.in);
        System.out.println("Unesite nenegativan cijeli broj: ");
        n=s.nextInt();
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
        diskriminanta = alfa1*alfa1+4*alfa2;

        //Sve nultočke različite
        if(diskriminanta>0) {
            x1 = alfa1 / 2 + Math.sqrt(diskriminanta)/2;
            x2 = alfa1 / 2 - Math.sqrt(diskriminanta)/2;
            D2 = (b1-b0*x1)/(x2-x1);
            D1 = b0-D2;

            an = D1*Math.pow(x1, n) + D2*Math.pow(x2, n);

        } else if(diskriminanta==0) {     //jedna nultočka
            x1 = alfa1/2;
            D1 = b0;
            D2 = (b1-b0*x1)/x1;

            an= D1*Math.pow(x1, n) + D2*n*Math.pow(x1, n);
        }else {    //imaginarne nultočke
            double kut = Math.atan((Math.sqrt(Math.abs(diskriminanta))/2)/(alfa1/2));
            x1 = Math.sqrt(Math.pow(alfa1/2, 2)+Math.abs(diskriminanta/4)) ;
            D1 = b0;
            D2 = (b1-D1*(x1*Math.cos(kut)))/(x1*Math.sin(kut));

            an = D1*Math.pow(x1, n)*Math.cos(n*kut) + D2*Math.pow(x1, n)*Math.sin(n*kut);
        }


        System.out.println("Vrijednost broja b_n: " + String.format("%.2f", an));

    }
}
