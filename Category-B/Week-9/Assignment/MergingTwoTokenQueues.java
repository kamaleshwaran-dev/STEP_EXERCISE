import java.util.Arrays;

public class MergingTwoTokenQueues {
    static int[] mergeTokens(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) {
            result[k++] = a[i++];
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] counterA = {3, 8, 15, 20};
        int[] counterB = {5, 8, 12};

        System.out.println(Arrays.toString(
            mergeTokens(counterA, counterB)
        ));

        int[] empty = {};
        int[] second = {4, 9};

        System.out.println(Arrays.toString(
            mergeTokens(empty, second)
        ));
    }
}

//Complexity: Time \(O(m+n)\); output space \(O(m+n)\), 
// where m and n are the lengths of the two arrays.