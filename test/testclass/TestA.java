//字符串转换成数字
public class TestA {
    public static void main(String[] args) {
        String s = "123";
        int num = Integer.parseInt(s);
        int sum = num + 100;
        System.out.println("Result is: " + sum);
        System.out.println((int)'a');
        System.out.println((int)'\uff1b');
        System.out.println((int)'我');
    }
}
