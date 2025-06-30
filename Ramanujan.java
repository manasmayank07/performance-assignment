// Ramanujan.java

public class Ramanujan {
    public static boolean isRamanujan(int n) {
        for (int i = 1; i * i * i < n; i++) {
            for (int j = i + 1; j * j * j < n; j++) {
                if (i * i * i + j * j * j == n) {
                    for (int k = i + 1; k * k * k < n; k++) {
                        for (int l = k + 1; l * l * l < n; l++) {
                            if (k * k * k + l * l * l == n) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 10000; // You can change this limit
        for (int i = 1; i <= n; i++) {
            if (isRamanujan(i)) {
                System.out.println(i);
            }
        }
    }
}
