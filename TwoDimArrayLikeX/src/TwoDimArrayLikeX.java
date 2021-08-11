public class TwoDimArrayLikeX {
    public static void main(String[] args) {

        char[][] charX = new char[7][7];

        for (int i = 0; i < charX.length; ++i) {
            for (int j = 0; j < charX.length; ++j) {
                charX[i][j] = (i == j || i + j == charX.length - 1) ? 'x' : ' ';
            }
        }
        for (char[] x : charX) {
            for (int j = 0; j < charX.length; ++j) {
                System.out.print(x[j]);
            }
            System.out.println();
        }
    }
}
