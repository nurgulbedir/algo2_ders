/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bmü112_hafta2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bmü112_Hafta2 {

    public static void main(String[] args) {
        boolean devam = true;
        do {
            Scanner k = new Scanner(System.in);
            try {
                System.out.print("x sayısını giriniz: ");
                int x = k.nextInt();
                System.out.print("y sayısını giriniz: ");
                int y = k.nextInt();
                int sonuc = x / y;
                System.out.println("Sonuç:" + sonuc);
                devam = false;
            } catch (ArithmeticException e) {
                System.out.println("Sıfıra bölme hatası oluştu! "+e);
                k.nextLine();            //hatayı atlayacak, bir sonrakini okuyacak böylece program çalışmaya devam edecek
            } catch (InputMismatchException e) {
                System.out.println("Tip uyuşmazlığı oluştu! " +e);
                k.nextLine();
            }
        } while (devam);
    }
}
