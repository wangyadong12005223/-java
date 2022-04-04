import java.util.Arrays;

public class ArraySortUsingPackage {
    public  static  void printArr(int[]arr,String msg){
        System.out.println(msg);
        for(int i:arr)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public  static  void main(String[]args)
    {
        int[]arr={3,5,2,6,8,4,7};
        printArr(arr,"排序前： ");
      Arrays.sort(arr); //利用JAVA的包库提供的方法来排序
        printArr(arr,"排序后： ");
    }
}
