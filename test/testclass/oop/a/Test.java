package oop.a;
public class Test {
    @lombok.SneakyThrows
    public static void main(String[] args) {
        User u = new User();
        u.setId(100);
        u.setName("larsen");
        // u.setMan(true);
        u.printUserinfo();
        String g1 = "我的测试";
        String g2 = "我的测试";
        String g3 = new String("我的测试aaaabbb");
        //System.out.println("字符串的value相等" + g1.equals(g3));
        System.out.println( g3.indexOf("aaaa"));
        System.out.println(g3.length());
        System.out.println(g3.charAt(5));
        if (g3.indexOf("测试") !=-1) {
            System.out.println("g3包含测试");
        }else {
            System.out.println("g3不包含测试");
        }
        System.out.println(g3);
        System.out.println(g3.replace(" ",""));//去掉字符串中的空格
        System.out.println(g3.trim()); //去掉字符串首尾空格
        System.out.println(g3.replaceAll(".(?=.)", "$0 "));
        System.out.println(g3.length());
        System.out.println(g3.substring(g3.length()-4,g3.length()-2));//截取特定位置的字符串
        String str =(g3.substring(g3.length()-4,g3.length()-2));//将截取的字符串赋值给变量
        System.out.println(str);
         }
}