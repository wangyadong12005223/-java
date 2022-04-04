import java.awt.*;
import  java.io.*;
import java.util.Scanner;
/**
 * @param 'args' class\method\for master need {}
 *             jishuORoushu() 有屏幕输入方法  可以和call() 做对比
 */
public class hello {
    public static void main(String[] args) {
   //     Callme.call();  //显示输入的字符串
    //    Callme.jishuORoushu();     //判断奇数还是偶数
    //    Callme.num(); //输出字符串
    //   Callme.leijia();           //1+2+3~+10
      //  Callme.quyushu ();
                RecusionMethod test= new RecusionMethod();
        int result=test.addRecurison(10);
        System.out.println(result);
    }
    public static class Callme {
        @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("DM_DEFAULT_ENCODING")
         static void call() {
            String  str;
            InputStreamReader stdin = new InputStreamReader(System.in);
            BufferedReader bufin = new BufferedReader(stdin);
            try {
                System.out.print("请输入字符:");
                str = bufin.readLine();
                System.out.println("n你输入的字符为：" + str);
                 } catch (Exception e) {
                System.err.println("发生I/O错误！！！");
                e.printStackTrace();
            }
        }
      static  void jishuORoushu() {
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
      static  void num (){
          int num = 5;
          System.out.print("this is number " + num);
          System.out.println("i have " + num);
          System.out.println("不抛弃,不放弃.Java, Iam coming!");
          int sum = 0;
          for (int i = 1; i <= 100; i++) {
              sum = sum + i;
              System.out.println("i="+i+" , sum=" + sum);
          }
      }
        static  void leijia (){
            int i = 1;
            int sum = 0;
            int [ ] numArray = {1,2,3,4,5,6};
            while (i < 11 )
            {
                sum+=i;
              //  ++i; 此处作用同 i++
                i++;
            }
            System.out.println("1+2~+10="+ sum);
            for (int k=0;k< numArray.length;k++)
            {
                System.out.println(numArray[k] );
            }
        }
        //insert here
        static  void  quyushu (){
            for (int i=1;i<10;i++)
            {
                if (i>6)
                    break;;
                System.out.println(i+"除以3的余数是： "+i%3);
            }
        }
        //insert here

    }
    }




