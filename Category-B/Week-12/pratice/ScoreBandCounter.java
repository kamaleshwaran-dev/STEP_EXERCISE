
class ScoreBandCounter {
    static int lowerBound(int[] a, int x) {
        int low = 0, high = a.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (a[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    static void query(int[] a, int x) {
        int below = lowerBound(a, x);
        int exactly = lowerBound(a, x + 1) - below;

        System.out.println(x + ": exactly " + exactly +
                           ", below " + below);
    }

    public static void main(String[] args) {
        int[] scores = {40, 55, 70, 70, 70, 85, 90};

        query(scores, 70);
        query(scores, 60);
        query(scores, 95);
    }
}

//Complexity:
// Time per query: O(log n)
// Space: O(1).