/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bmü112_hafta2;

import java.io.*;

public class örn6 {
    public static void main(String[] args) {
        File dosya = new File("sayilar.txt");//dosya değişkeni ile dosya yolunu tut 
        PrintWriter p;//yazma işlemi için nesne tanımla
        try {
            if (!dosya.exists())//dosya yok ise
            
                dosya.createNewFile(); //oluştur
             else 
                System.out.println("Dosya mevcut");
            
            p = new PrintWriter(new FileOutputStream(dosya, true));//her yazdırdığımızda +10 ekliyor
            for (int i = 0; i < 10; i++) {
                int sayi = (int) (Math.random() * 20);
                p.println(sayi);//dosyaya yaz
            }
            p.close();//dosyayı kapat
            
        }catch(FileNotFoundException e) {
            System.out.println("Dosya bulunamadı" +e); 
        
        }catch (IOException e) {
            System.out.println("Yol bulunamadı" + e);
        }

    }

}
