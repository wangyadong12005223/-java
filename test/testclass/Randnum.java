import java.util.Random;
import java.util.Scanner;
public class Randnum {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please inut the first number: ");
        int x = sc.nextInt();
        System.out.println("Please inut the second number: ");
        int y = sc.nextInt();

        System.out.println("The random number is: " + getRandom(x,y));
    }
    private static int getRandom(int i, int j)
    {
        int max = Math.max(i,j);
        int min = Math.min(i,j);
        int mid = max - min;
        int random = (int)(Math.random()*(mid + 1) + min);
        return random;
    }
}
