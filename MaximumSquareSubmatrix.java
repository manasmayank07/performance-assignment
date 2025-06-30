// MaximumSquareSubmatrix.java

public class MaximumSquareSubmatrix {

    public static int size(int[][] a) {
        if (a.length == 0 || a[0].length == 0) return 0;

        int maxSize = 0;
        int rows = a.length;
        int cols = a[0].length;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = a[i][j];
                } else if (a[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]),
                            dp[i - 1][j - 1]) + 1;
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}
        };

        System.out.println("Maximum square submatrix size: " + size(matrix));
    }
}
