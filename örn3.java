
package bmü112_hafta1;

public class örn3 {
     public static int usbul(int a,int b){
        if(b==0)  return 1;
        else      return a*usbul(a, b-1);   
    }
    public static void main(String[] args) {
       int a=4,b=5;
        System.out.println(a + "^" + b + "=" + usbul(a, b));
       
    }
}
