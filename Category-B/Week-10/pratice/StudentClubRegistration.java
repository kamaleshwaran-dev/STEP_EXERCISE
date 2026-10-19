import java.util.HashSet;
import java.util.Set;

public class StudentClubRegistration {
    static class Student {
        String roll;
        String name;

        Student(String roll, String name) {
            this.roll = roll;
            this.name = name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Student)) {
                return false;
            }

            Student other = (Student) obj;
            return roll.equals(other.roll);
        }

        public int hashCode() {
            return roll.hashCode();
        }
    }

    static void addStudent(Set<Student> members, Student student) {
        if (members.add(student)) {
            System.out.println("Added");
        } else {
            System.out.println("duplicate rejected");
        }
    }

    public static void main(String[] args) {
        Set<Student> members = new HashSet<>();

        addStudent(members, new Student("21CS01", "Asha"));
        addStudent(members, new Student("21CS01", "Asha"));
        addStudent(members, new Student("21CS02", "Ravi"));

        System.out.println("member count " + members.size());

        System.out.println(
            "contains: " +
            members.contains(new Student("21CS02", "Ravi"))
        );

        System.out.println(
            "contains: " +
            members.contains(new Student("21CS03", "Priya"))
        );
    }
}