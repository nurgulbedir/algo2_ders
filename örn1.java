
package bmü112_hafta1;

import java.util.Scanner;

public class Bmü112_Hafta1 {
    
    public static int Faktoriyelhesap(int x) {   //Faktöriyel hesabı
        int fakt=1;
        for (int i = 1; i <=x; i++) 
            fakt=fakt*i;
        return fakt;  
    }
    public static void main(String[] args) {
        Scanner k=new Scanner(System.in);       
        System.out.print("Sayı giriniz:");
        int x=k.nextInt();
        System.out.println(x + " sayısının faktöriyeli:"+ Faktoriyelhesap(x));
        
        int buyuksayi=Math.max(5,3);   //Büyük sayı bulma
        System.out.println("Büyük sayı:" + buyuksayi);
    }
}

