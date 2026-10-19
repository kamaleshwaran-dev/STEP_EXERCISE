public class ClassTopperFinder {
    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int bestRow = 0;
        int bestTotal = -1;

        for (int i = 0; i < marks.length; i++) {
            int total = 0;

            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
            }

            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }

        System.out.println("(" + bestRow + ", " + bestTotal + ")");
    }
}

//Complexity: Time \(O(m \times n)\); auxiliary space \(O(1)\), where m 
// is the number of students and n is the number of subjects.