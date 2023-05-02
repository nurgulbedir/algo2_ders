package buyuktamsayi;

public class BuyukTamsayi {

    private int[] basamaklar;

    public BuyukTamsayi() {
        basamaklar = new int[40]; //40 tamsayıyı depolamak için
    }

    public BuyukTamsayi(String str) {
        this.basamaklar = new int[40]; //40 elemanlı bir basamak dizisi
        for (int i = 0; i < str.length(); i++) {//str uzunluğu döndürüldü
            int uzunluk = str.length() - 1 - i;//sondan başlayarak i kaçıncı karakter 
            char c = str.charAt(uzunluk);//karakter dizisinin her bir karakterini döndürdü
            basamaklar[i] = Character.getNumericValue(c);//str karakter-->sayısal değer
        }
    }

    public int[] getBasamaklar() {
        return basamaklar;
    }

    public BuyukTamsayi topla(BuyukTamsayi tamsayi) {
        BuyukTamsayi yeniTamsayi = new BuyukTamsayi();
        int deger = 0;
        for (int i = 0; i < basamaklar.length; i++) {//büyük tamsayı basamaklarını tuttu
            int toplam = basamaklar[i] + tamsayi.getBasamaklar()[i] + deger;
            yeniTamsayi.getBasamaklar()[i] = toplam % 10;//birler basamağını almak için 
            deger = toplam / 10;//onlar basamağını almak için
        }
        return yeniTamsayi;
    }

    public BuyukTamsayi cikar(BuyukTamsayi tamsayi) {
        BuyukTamsayi yeniTamsayi = new BuyukTamsayi();
        int deger = 0;
        for (int i = 0; i < basamaklar.length; i++) { //sayac görevinde basamakları tutuyor
            int fark = basamaklar[i] - tamsayi.getBasamaklar()[i] - deger;
            if (fark < 0) {//fark negatif ise
                fark += 10;//-3+10=7
                deger = 1;//değere göre onlar basamağı 1 elde şeklinde oldu
            } else {
                deger = 0;//amaç farkın pozitif olması
            }
            yeniTamsayi.getBasamaklar()[i] = fark;
        }
        return yeniTamsayi;
    }

    public BuyukTamsayi carp(BuyukTamsayi tamsayi) {
        BuyukTamsayi yeniTamsayi = new BuyukTamsayi();
        for (int i = 0; i < basamaklar.length; i++) {//sayac görevinde basamakları tutuyor
            int deger = 0;
            for (int j = 0; j < basamaklar.length; j++) {//sayac görevinde basamakları tutuyor
                if (i + j >= basamaklar.length) {//carpmadaki basamaklar toplamı büyük ya da eşitse
                    break;                       //kır
                }
                int carpim = basamaklar[i] * tamsayi.getBasamaklar()[j] + yeniTamsayi.getBasamaklar()[i + j] + deger;
                yeniTamsayi.getBasamaklar()[i + j] = carpim % 10;
                deger = carpim / 10;
            }
        }
        return yeniTamsayi;
    }

    public BuyukTamsayi bol(BuyukTamsayi tamsayi) {
        BuyukTamsayi bolumTamsayi = new BuyukTamsayi();
        BuyukTamsayi kalanTamsayi = new BuyukTamsayi(toString());//[4,2,6]-->"426" şeklinde basamakları birleştirdi

        for (int i = basamaklar.length - 1; i >= 0; i--) {
            kalanTamsayi.solaKaydir();
            kalanTamsayi.getBasamaklar()[0] = basamaklar[i];
            int x = 0;
            int sol = 0;//sol sınır 0dan başladı
            int sağ = 10;//sağ sınır 10dan başladı
            BuyukTamsayi ortalamaTamsayi;
            BuyukTamsayi carpTamsayi;
            String ortalamaStr;
            while (sol <= sağ) {//alan daralana kadar devam ediyor
                int ortalama = (sol + sağ) / 2;//orta nokta bulundu
                ortalamaStr = String.valueOf(ortalama);//ortalama String e dönüştürüldü
                ortalamaTamsayi = new BuyukTamsayi(ortalamaStr);
                carpTamsayi = tamsayi.carp(ortalamaTamsayi);
                if (carpTamsayi.buyukEsitmi(kalanTamsayi)) {
                    x = ortalama;//x e orta nokta atanır 
                    sol = ortalama + 1;//sol 1 artırılıp
                } else {
                    sağ = ortalama - 1;//sağ 1 azaltılıp alan daraltılmış oldu
                }
            }
            bolumTamsayi.getBasamaklar()[i] = x;
            ortalamaStr = String.valueOf(x);
            ortalamaTamsayi = new BuyukTamsayi(ortalamaStr);
            carpTamsayi = tamsayi.carp(ortalamaTamsayi);
            kalanTamsayi.cikar(carpTamsayi);
        }
        return bolumTamsayi;
    }

    public boolean esitMi(BuyukTamsayi tamsayi) {
        for (int i = 0; i < basamaklar.length; i++) {
            if (basamaklar[i] != tamsayi.getBasamaklar()[i]) {//eşit mi kontrolü
                return false;//farklı ise false
            }
        }
        return true;
    }

    public boolean esitDegilMi(BuyukTamsayi tamsayi) {
        return !esitMi(tamsayi);
    }

    public boolean buyukMu(BuyukTamsayi tamsayi) {
        for (int i = basamaklar.length - 1; i >= 0; i--) {
            if (basamaklar[i] > tamsayi.getBasamaklar()[i]) {//nesne basamak dizisinin i. elemanı > parametre basamak dizisinin i.elemanı ise
                return true;
            } else if (basamaklar[i] < tamsayi.getBasamaklar()[i]) {//nesne basamak dizisinin i. elemanı < parametre basamak dizisinin i.elemanı ise
                return false;
            }
        }
        return false;
    }

    public boolean kucukMu(BuyukTamsayi tamsayi) {
        return !buyukMu(tamsayi) && !esitMi(tamsayi);//büyük değil ve eşit değil mi?
    }

    public boolean buyukEsitmi(BuyukTamsayi tamsayi) {
        return buyukMu(tamsayi) || esitMi(tamsayi);//büyük veya eşit mi?
    }

    public boolean kucukEsitmi(BuyukTamsayi tamsayi) {
        return kucukMu(tamsayi) || esitMi(tamsayi);//küçük veya eşit mi?
    }

    private void solaKaydir() {
        for (int i = basamaklar.length - 1; i > 0; i--) {//sondan başa elemanlar döndürüldü
            basamaklar[i] = basamaklar[i - 1];//elemanı bir öncekiyle değiştirir yani sola kaydırır.
        }
        basamaklar[0] = 0;//ilk eleman=0
    }

    public String toString() {//String e çevrildi
        StringBuilder str = new StringBuilder();//Nesne, String oluşturmak için kullanılır
        boolean sifirOlmayan = false;
        for (int i = basamaklar.length - 1; i >= 0; i--) {
            if (!sifirOlmayan && basamaklar[i] == 0) {//sıfır olmayan eleman bulunmadıysa ve eleman=0 ise
                continue;//döngü başına dönüp 0'ları siler
            }
            sifirOlmayan = true;//sıfır olmayan eleman bulundu
            str.append(basamaklar[i]);//nesneye eleman ekler
        }
        if (!sifirOlmayan) {//sıfır olmayan bir eleman bulunmadıysa
            str.append(0);//nesneye sıfır ekler
        }
        return str.toString();//nesneyi String'e dönüştürüldü
    }

    public static void main(String[] args) {
        BuyukTamsayi ilkTamsayi = new BuyukTamsayi("123456789123456789123456789123456788"); 
        System.out.println("İlk Tamsayi   :" + ilkTamsayi);
        BuyukTamsayi sonTamsayi = new BuyukTamsayi("987654321987654321987654321987654321");
        System.out.println("Son Tamsayi   :" + sonTamsayi);
        System.out.println("Toplama       :" + ilkTamsayi.topla(sonTamsayi));
        System.out.println("Çıkarma       :" + ilkTamsayi.cikar(sonTamsayi));
        System.out.println("Çarpma        :" + ilkTamsayi.carp(sonTamsayi));
        System.out.println("Bölme         :" + ilkTamsayi.bol(sonTamsayi));
        System.out.println("Eşit mi       :" + ilkTamsayi.esitMi(sonTamsayi));
        System.out.println("Eşit degil mi :" + ilkTamsayi.esitDegilMi(sonTamsayi));
        System.out.println("Büyük mu      :" + ilkTamsayi.buyukMu(sonTamsayi));
        System.out.println("Küçük mu      :" + ilkTamsayi.kucukMu(sonTamsayi));
        System.out.println("Büyük eşit mi :" + ilkTamsayi.buyukEsitmi(sonTamsayi));
        System.out.println("Küçük eşit mi :" + ilkTamsayi.kucukEsitmi(sonTamsayi));
    }

}
