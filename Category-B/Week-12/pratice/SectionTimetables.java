
import java.util.ArrayList;
import java.util.List;

class SectionTimetables {
    static class Timetable {
        String name;
        List<String> periods;

        Timetable(String name, List<String> periods) {
            this.name = name;
            this.periods = periods;
        }

        Timetable copy(String newName) {
            return new Timetable(
                newName, new ArrayList<>(periods)
            );
        }

        void setPeriod(int period, String subject) {
            periods.set(period - 1, subject);
        }

        void display() {
            System.out.println(name + ": " + periods);
        }
    }

    public static void main(String[] args) {
        List<String> subjects = new ArrayList<>();

        subjects.add("Java");
        subjects.add("DSA");
        subjects.add("Maths");

        Timetable original = new Timetable("CSE-A", subjects);

        Timetable copy = original.copy("CSE-B");

        copy.setPeriod(2, "Physics");

        original.display();
        copy.display();
    }
}

//Complexity:
// Copy time: O(n)
// Copy space: O(n)
// The new list is independent of the original list.