public class PalindromeNumber {
    public static void main(String[] args) {
        int number=-72;
        int temp=number;
        int reversenumber=0;
        while(temp!=0){
            reversenumber+= temp%10;
            if(temp/10!=0)
            reversenumber*=10;
            temp/=10;
        }
        System.out.println(number);
        System.out.println(reversenumber);
    }
}