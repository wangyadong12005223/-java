import java.util.Scanner;
public class DeadGame {
    public static void main(String[] args) {
        System.out.println("死亡游戏 \n 如果你选择正确将会获得5块钱");
        System.out.println("按下 红色按钮：系统会自动杀一个人并让你获得10个亿美元  ");
        System.out.println("按下绿色按钮：系统会自动救活一个好人并让你损失10亿美元");
        System.out.println("按下橙色按钮：退出游戏并杀死你自己");
        System.out.println("*********************做出你的选择吧，少年**************************");
        Scanner sca = new Scanner(System.in);
        String str = sca.next();
  if ("红色".equals(str)) {
            System.out.println(str + "按钮：系统已自动杀了一人并让你获得10亿美元");
        }
  else if ("绿色".equals(str)) {
            System.out.println(str + "按钮：系统已自动救活一个人并让你损失10个亿美元 ");
        }
  else   {
            System.out.println(str + "按钮：退出游戏并杀死你自己 ");
        }
    }
}
