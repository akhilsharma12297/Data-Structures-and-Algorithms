package rip;

public class setZero {

    public static void setZeroes(int[][] arr) {

        printMatrix(arr);

        boolean[][] visited = new boolean[arr.length][arr[0].length];

        printMatrixBoolean(visited);

        //  for(int i = 0 ; i < arr.length ;i++){
        //     for(int j = 0 ; j < arr.length ; i++){

        //         if (arr[i][j] == 0){
        //             visited[i][j] =
        //         }

        //     }
        // }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j] == 0 && !visited[i][j]) {
                    changeIt(arr, visited, i, j);
                }

            }
        }

        printMatrix(arr);
        printMatrixBoolean(visited);


    }

    public static void changeIt(int[][] arr, boolean[][] visited, int i, int j) {

        int ctr = 0;


        while (ctr < arr[0].length) {
            if (arr[i][ctr] != 0) {
                visited[i][ctr] = true;
            }
            arr[i][ctr] = 0;
            ctr++;
        }

        ctr = 0;

        while (ctr < arr.length) {
            if (arr[ctr][j] != 0) {
                visited[ctr][j] = true;
            }
            arr[ctr][j] = 0;
            ctr++;
        }

    }

    public static void main(String[] args) {

//        int[][] mat = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//
//        int[][] mat = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

//        int[][] mat = {{0,1}};

        int[][] mat = {{1, 0, 3}};

        setZeroes(mat);


    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printMatrixBoolean(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
