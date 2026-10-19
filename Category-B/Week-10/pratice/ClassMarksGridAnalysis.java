import java.util.Locale;

public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        String[] names = {"Asha", "Ravi", "Neha"};

        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int[] totals = new int[names.length];
        int[] subjectSum = new int[3];
        int topper = 0;

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < 3; j++) {
                totals[i] += marks[i][j];
                subjectSum[j] += marks[i][j];
            }

            if (totals[i] > totals[topper]) {
                topper = i;
            }
        }

        System.out.print("Totals ");
        for (int i = 0; i < names.length; i++) {
            System.out.print(
                names[i] + " " + totals[i]
                + (i == names.length - 1 ? "\n" : ", ")
            );
        }

        System.out.printf(
            Locale.US,
            "averages %.2f, %.2f, %.2f%n",
            subjectSum[0] / (double) names.length,
            subjectSum[1] / (double) names.length,
            subjectSum[2] / (double) names.length
        );

        System.out.println(
            "topper " + names[topper] + " (" + totals[topper] + ")"
        );
    }
}