package oop.a;



public class User {
    private  int id;
    private  String name;
    private  boolean man;
    public void printUserinfo(){
        System.out.println("用户ID: "+getId()+"\n"+"用户名: "+getName()+"\n"+isMan());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }
}
