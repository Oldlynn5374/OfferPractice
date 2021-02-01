package Q_5;

public class Solution {
    public static void main(String[] args) {
        String str = "We are happy";
        long begin = System.currentTimeMillis();
        str = str.replaceAll(" ", "%20");
        long end = System.currentTimeMillis();
        System.out.println(str);
        System.out.println(end - begin);




    }

}
