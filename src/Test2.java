public class Test2 {
    public static void main(String[] args) {
        swap(1, 3);
        swap(9, 5);

    }

    public static void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;

//        a= a+b-(b=a);

        System.out.println(a + ":" + b);
    }
}