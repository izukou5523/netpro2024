public class TaskObject implements ITask {

    private static final long serialVersionUID = 1L;

    private int number;
    private int result;

    @Override
    public void setExecNumber(int x) {
        this.number = x;
    }

    @Override
    public void exec() {
        this.result = findLargestPrime(number);
    }

    @Override
    public int getResult() {
        return result;
    }

    public int getExecNumber() {
        return number;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // 最大の素数を見つけるメソッド
    private static int findLargestPrime(int x) {
        for (int i = x; i > 1; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        return 2; // 最小の素数
    }
}
