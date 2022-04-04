public class ArrayReferce
{
public  static  void  changeReferValue(int a,int[]myArr) {
    a += 1;
    myArr[0] = 0;
    myArr[1] = 0;
    myArr[2] = 0;
}
public  static void printArr(int[]arr)
{
    for(int i:arr) {
        System.out.print(i + " ");
    }
    System.out.println();
    }
    public static void print(int in,int[]arr)
    {
        System.out.println("in:"+in);
        System.out.println("arr:");
        printArr(arr);
    }
    public static void main(String[]args)
    {
        int in=10;
        int arr[]={1,2,3,4,5};
        System.out.println("--调用changeReferValue方法之前——");
        print(in,arr);
        changeReferValue(in,arr);
        System.out.println("--调用changeReferValue方法之后——");
        print(in,arr);
     }
}

