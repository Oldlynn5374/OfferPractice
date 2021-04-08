package test.内部类;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("test.内部类.OuterClass");
        System.out.println();
    }
}
