enum Color {红色,黄色,绿色};
public class ValueOfEnum2 {
 public static void main(String[]args)
    {
     //遍历枚举元素值和编号
       /*    Color[] allcolor= Color.values();
        for(Color aColor:allcolor)
        {
            System.out.println(aColor.name()+"-->"+aColor.ordinal());
        }
    } */

          Color c = Color.valueOf("红色");
          System.out.println(c);
          System.out.println(Color.valueOf("红色"));
      }
  }

