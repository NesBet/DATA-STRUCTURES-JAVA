import java.util.HashSet;

public class LCSMatrix {
    private String string1;
    private String string2;
    private int[][] matrix;

    public LCSMatrix(String str1, String str2) {
        string1 = str1;
        string2 = str2;
        int rowCount = string1.length();
        int columnCount = string2.length();
        matrix = new int[rowCount + 1][columnCount + 1];

        for (int i = 0; i <= rowCount; i++) {
            for (int j = 0; j <= columnCount; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
    }

    public int getRowCount() {
        return matrix.length - 1;
    }

    public int getColumnCount() {
        return matrix[0].length - 1;
    }

    public int getEntry(int row, int column) {
        if (row < 0 || row >= matrix.length - 1 || column < 0 || column >= matrix[0].length - 1) {
            return 0;
        }
        return matrix[row + 1][column + 1];
    }

    public HashSet<String> getLongestCommonSubsequences() {
        HashSet<String> subsequences = new HashSet<>();
        calculateSubsequences(subsequences, "", string1.length(), string2.length());
        return subsequences;
    }

    private void calculateSubsequences(HashSet<String> subsequences, String current, int i, int j) {
        if (i == 0 || j == 0) {
            if (!current.isEmpty()) {
                subsequences.add(current);
            }
            return;
        }
        if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
            calculateSubsequences(subsequences, string1.charAt(i - 1) + current, i - 1, j - 1);
        } else {
            if (matrix[i - 1][j] >= matrix[i][j - 1]) {
                calculateSubsequences(subsequences, current, i - 1, j);
            }
            if (matrix[i][j - 1] >= matrix[i - 1][j]) {
                calculateSubsequences(subsequences, current, i, j - 1);
            }
        }
    }
}
