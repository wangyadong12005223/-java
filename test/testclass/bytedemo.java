import java.util.Scanner;

public class bytedemo {
    public static void main(String[] args) {
        //给任意一个数判断是奇数还是偶数
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        int number = sc.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + "是偶数");
        }else {
            System.out.println(number + "是奇数");
        }
    }

}