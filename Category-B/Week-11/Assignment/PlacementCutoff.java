
class PlacementCutoff {
    static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    static int kthHighest(int[] a, int k) {
        if (k < 1 || k > a.length)
            throw new IllegalArgumentException("Invalid k");

        int target = a.length - k;
        int low = 0, high = a.length - 1;

        while (low <= high) {
            int p = partition(a, low, high);

            if (p == target)
                return a[p];
            else if (p < target)
                low = p + 1;
            else
                high = p - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] marks = {72, 95, 60, 88, 79};

        System.out.println("2nd Highest: " + kthHighest(marks, 2));
    }
}

//Complexity:
// Average time: O(n)
// Worst time: O(n²)
// Auxiliary space: O(1) for this iterative implementation.
// Stable: No.