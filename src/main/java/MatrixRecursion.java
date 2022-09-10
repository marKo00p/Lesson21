import java.util.Arrays;

class MatrixRecursion {
    private static final int n = 3;
    private static int[][] array = new int[n][n];
    private static int[][] reversArray = new int[n][n];

    public static void main(String[] args) {

        System.out.println("Result without recursion: ");
        pathsForCell(n );

        System.out.println("Result with recursion: ");
        long start = System.nanoTime();
        pathsForCellWithRecursion(n - 1,n - 1);
        System.out.println("Total time = " + (System.nanoTime() - start) / 1_000_00d);

        for(int i = array.length - 1, j = 0; i >= 0; i--, j++){
            reversArray[j] = array[i];
        }

        for(int[] a : reversArray){
            System.out.println(Arrays.toString(a));
        }
    }

    // method to count possible paths from cell [0][0] to cell [2][2] and print the result
    // without using recursion
    static void pathsForCell(int n) {
        int array[][] = new int[n][n];
        long start = System.nanoTime();

        for(int i =0; i < 3; i++) {
            for(int j = 0; j < 3 ; j++){
                if ( i == 0 || j == 0) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j] + array[i][j - 1];
                }
            }
        }
        System.out.println("Total time = " + (System.nanoTime() - start) / 1_000_00d);


        for(int[] a: array){
            System.out.println(Arrays.toString(a));
        }

    }

    // method to count possible paths from cell [0][2] to cell [2][0]
    static int pathsForCellWithRecursion(int n, int m) {
        if(n <= 0 || m <= 0){
            return 1;
        }
        if(array[n][m] != 0) {
            return array[n][m];
        }
        array[n][m] = pathsForCellWithRecursion(n -1, m) + pathsForCellWithRecursion(n, m - 1);
        return array[n][m];
    }
}
