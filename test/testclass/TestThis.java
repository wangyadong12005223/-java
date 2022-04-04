import jdk.nashorn.internal.runtime.regexp.joni.Config;

/**
 * 测试this用法
 */

public class TestThis {
    int a,b,c;
    TestThis(){
        System.out.println("正在初始化 ---"+this); //默认调用toString方法,this.toString
    }
    TestThis(int a,int b){
        this();//调用无参构造器，并且必须在程序的第一行
        this.a = a; //this.a指的是 类里面的 int a, b,c里的a
        this.b = b; //同上
        System.out.println("运行了TestThis(a,b)");
    }
    TestThis(int a,int b,int c){
        this(a,b); //调用带参构造器，必须在程序第一行
        this.c = c;//this.c指的是 类里面的 int a, b,c里的c
        System.out.println("run TestThis(a,b,c)");
    }
    void  sing(){
        System.out.println("just look.");
    }
    void eat(){
        System.out.println("当前对象--- "+this);
        sing();  //也可以直接写成sing()
        System.out.println("你妈妈喊你回家吃饭");
    }

    public static void main(String[] args) {
        TestThis hi=new TestThis(3,2,4);
      Config.log.println("接下来调用eat方法");
        hi.eat();

    }
}
