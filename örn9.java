
package bmü112_hafta2;

import java.io.*;
import java.util.Scanner;

public class örn9 {

    public static void main(String[] args) {
        File dosya = new File("c:\\dosyam\\1.doc");
        Scanner oku;
        try {
            oku = new Scanner(dosya);
            int i = 0, enk = 0, top = 0;
            while (oku.hasNext()) {
                int sayi = oku.nextInt();
                top = top + sayi; 
                if (i == 0) enk = sayi;
                if (sayi < enk)  enk = sayi;
                System.out.print(sayi + "\t");
                i++;
            }
            oku.close();
            
            System.out.println("\nEn küçük sayı:" + enk + "\n" + "toplam:" + top + " dosyada " + i + " adet sayı var");

        } catch (FileNotFoundException e) {

        }
    }
}
