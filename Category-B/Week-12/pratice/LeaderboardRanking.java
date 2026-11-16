
class LeaderboardRanking {
    static class Participant {
        String name;
        int score;

        Participant(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static void sort(Participant[] p) {
        for (int i = 1; i < p.length; i++) {
            Participant key = p[i];
            int j = i - 1;

            while (j >= 0 && p[j].score < key.score) {
                p[j + 1] = p[j];
                j--;
            }

            p[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Participant[] p = {
            new Participant("Asha", 90),
            new Participant("Ravi", 85),
            new Participant("Neha", 90),
            new Participant("Kiran", 70)
        };

        sort(p);

        int rank = 1;

        for (int i = 0; i < p.length; i++) {
            if (i > 0 && p[i].score != p[i - 1].score)
                rank = i + 1;

            System.out.println(rank + " " +
                               p[i].name + " " + p[i].score);
        }
    }
}

//Complexity:
// Sorting: O(n²)
// Printing ranks: O(n)
// Auxiliary space: O(1)
// Stable: Yes.