package test.内部类;

public class OuterClass {
    public final static String outerInfo = "OuterClass's static field";
    static {
        System.out.println("Outer static block" + " " );
    }

    public static class InnerClass {
        public String str = "sss";
        static {
            System.out.println("Inner static block");
        }
        public static String info = "hhhhhhhh";

        public InnerClass() {
            System.out.println("Inner constructor");
        }
        public static void print() {
            System.out.println(info);
        }
    }

    public class InnerClass2{
        {
            System.out.println("InnerClass2");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        // System.out.println(new InnerClass().str);
    }
}
