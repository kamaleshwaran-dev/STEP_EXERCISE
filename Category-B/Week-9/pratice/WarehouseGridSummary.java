public class WarehouseGridSummary {
    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        int total = 0;
        int max = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                total += grid[row][col];

                if (grid[row][col] > max) {
                    max = grid[row][col];
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        System.out.println("(" + total + ", (" + maxRow + ", " + maxCol + "))");
    }
}

//Complexity: Time \(O(mn)\); auxiliary space \(O(1)\)