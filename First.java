public class First {
    public static void main(String[] args) {
        Array numbers =new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.print();
        System.out.println(numbers.indexof(330));
    }
}