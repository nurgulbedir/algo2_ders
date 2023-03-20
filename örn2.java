package bmü112_hafta1;

public class örn2 {

    public static int[] enb_enk_bul(int d[]) {
        int ee[] = new int[2];
        ee[0] = d[0];
        ee[1] = d[0];
        for (int i = 0; i < d.length; i++) {
            if (ee[0] > d[i])  ee[0] = d[i];
            
            if (ee[1] < d[i]) ee[1] = d[i];   
        }
        return ee;
    }

    public static void main(String[] args) {
        int dizi[] = {1, 5, 6, 10, 2, 18, 7, 3, -1, 9, 12};
        int s[] = enb_enk_bul(dizi);
        System.out.println("En küçük:" + s[0] + " En büyük:" + s[1]);

    }
}
