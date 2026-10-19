import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSumSecondExample {
    static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int number : nums) {
            if (seen.contains(target - number)) {
                return true;
            }

            seen.add(number);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(
            hasPairWithSum(new int[]{2, 7, 11, 15}, 9)
        );

        System.out.println(
            hasPairWithSum(new int[]{3, 4, 6}, 20)
        );
    }
}

//Complexity: Expected time \(O(n)\); auxiliary space \(O(n)\).