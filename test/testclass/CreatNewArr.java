public class CreatNewArr {
    public static void main(String[]args){
        int oldArr[]={1,2,0,0,3,4};
        int zero=0;
        for (int i:oldArr){
            if(oldArr[i]==0)
                zero++;
        }
        int newArr[]= new  int[oldArr.length-zero];
        int  j= 0 ;  // 新数组的索引
        for ( int  i= 0 ;i<oldArr.length;i++){  // 遍历原来旧的数组
            if (oldArr[i]!= 0 ){  // 假如不等于0
                newArr[j]=oldArr[i];  // 赋值给新的数组
                j++;
            }
        }
        System.out.print( "新数组：" );
        for ( int  n:newArr){
            System.out.print(n+ " " );
        }
    }
}
