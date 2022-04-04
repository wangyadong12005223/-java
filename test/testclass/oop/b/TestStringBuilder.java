package oop.b;

/**
 * 1、通过StringBulider重组字符串。
 * 2、通过for循环语句控制添加空格数量
 * 3、通过tostring方法获得builder内的字符串
 */
public class TestStringBuilder {
    static void getToString() {
        StringBuilder sb = new StringBuilder();
        String str;
        sb.append("MR001");
        System.out.println(sb);
        sb.append("N");
        System.out.println(sb);
        sb.insert(6, "Java");
        System.out.println(sb);
        for (int i = 1; i <= 500; i++) {
            sb.append(" ");
        }
        System.out.println(sb);
        sb.append("纽曼粉");
        str = sb.toString();
        System.out.println(str);
        System.out.print(str.length());
    }

    public static void main(String[] args) {
        TestStringBuilder.getToString();
        InsertTimeIntoDbTable Db= new InsertTimeIntoDbTable();
        Db.conDb();
    }
}
