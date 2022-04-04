public class RecusionMethod {
    public int addRecurison(int n) {
        if (n <= 1) return n;
        return n + addRecurison(n - 1);
    }
}
