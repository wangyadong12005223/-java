public class TestStatic {
    int id;                 //类里面属于成员变量
    String name;
    String pwd;
    static String company="oh my company";   //静态变量
    TestStatic(int id,String name){
        this.id = id;
        this.name = name;
        System.out.println("学号是： "+id+"姓名是 "+name);
    }
    public void login(){
        System.out.println(name);
    }
    public static void printCompany(){
        System.out.println(company);
    }
    public static void main(String[] args) {
        TestStatic u = new TestStatic(1001,"larsen");   //局部变量
        TestStatic.printCompany();
        TestStatic.company="这是公司";
        TestStatic.printCompany();
    }
}
