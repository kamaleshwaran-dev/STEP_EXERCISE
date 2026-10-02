abstract class Assignment {
    protected int maxMarks;

    Assignment(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public abstract double penalty(int lateDays);
}

class CodingAssignment extends Assignment {

    CodingAssignment(int maxMarks) {
        super(maxMarks);
    }

    public double penalty(int lateDays) {
        return lateDays * 0.10;
    }
}

class WrittenAssignment extends Assignment {

    WrittenAssignment(int maxMarks) {
        super(maxMarks);
    }

    public double penalty(int lateDays) {
        return lateDays * 0.20;
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Submission {
    Student student;
    Assignment assignment;
    boolean submitted;
    boolean graded;
    int lateDays;

    Submission(Student student, Assignment assignment) {
        this.student = student;
        this.assignment = assignment;
    }

    void submit(int lateDays) {
        if (graded) {
            System.out.println(
                student.name + ": resubmit blocked"
            );
            return;
        }

        submitted = true;
        this.lateDays = lateDays;
    }

    void grade(double marks) {
        if (!submitted) {
            System.out.println(
                "Cannot grade before submission"
            );
            return;
        }

        double finalMarks =
            marks * (1 - assignment.penalty(lateDays));

        graded = true;

        System.out.printf(
            "%s final marks: %.0f/%d%n",
            student.name,
            finalMarks,
            assignment.maxMarks
        );
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding =
            new CodingAssignment(50);

        Submission s1 =
            new Submission(asha, coding);

        s1.submit(0);
        s1.grade(45);

        Submission s2 =
            new Submission(ravi, coding);

        s2.submit(2);
        s2.grade(40);
        s2.submit(0);
    }
}