import com.sun.org.apache.xerces.internal.xpointer.XPointerHandler;

/**
 * 1.确认坐标轴上连个点（x,y）
 * 2.求出两个点的距离 d
 * 计算公式 sqrt（x*x+y*y）
 */
public class Point {
    double x,y;
    //创建构造器Point
    public   Point(double _x,double _y){
        x=_x;
        y=_y;
    }
    public double getDistance(Point p){
         return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
     }

    public static void main(String[] args) {
        //调用构造器Point
        Point p1 = new Point(3.0,4.0);
        Point origin = new Point(0,0);
        System.out.println(p1.getDistance(origin));
    }
}
