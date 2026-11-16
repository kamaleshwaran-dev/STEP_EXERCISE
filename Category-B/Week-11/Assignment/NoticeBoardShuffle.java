
class NoticeBoardShuffle {
    static int[] bubbleStats(int[] a) {
        int passes = 0, swaps = 0;

        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }

        System.out.print("Sorted: ");
        for (int x : a)
            System.out.print(x + " ");

        System.out.println("\nPasses: " + passes);
        System.out.println("Swaps: " + swaps);

        return new int[]{passes, swaps};
    }

    public static void main(String[] args) {
        int[] scores = {5, 1, 4, 2, 8};
        bubbleStats(scores);
    }
}

//Complexity:
// Best: O(n)
// Worst: O(n²)
// Space: O(1)
// Stable: Yes.