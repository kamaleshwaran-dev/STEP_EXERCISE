interface NotificationChannel {
    void send(Student student, Notice notice);
}

class EmailChannel implements NotificationChannel {
    public void send(Student student, Notice notice) {
        System.out.println(
            "Email -> " + student.name +
            ": " + notice.title
        );
    }
}

class SmsChannel implements NotificationChannel {
    public void send(Student student, Notice notice) {
        System.out.println(
            "SMS -> " + student.name +
            ": " + notice.title
        );
    }
}

class AppChannel implements NotificationChannel {
    public void send(Student student, Notice notice) {
        System.out.println(
            "App -> " + student.name +
            ": " + notice.title
        );
    }
}

class Student {
    String name;
    String department;
    NotificationChannel[] channels;

    Student(String name, String department,
            NotificationChannel[] channels) {

        this.name = name;
        this.department = department;
        this.channels = channels;
    }
}

class Notice {
    String title;
    String[] departments;

    Notice(String title, String[] departments) {
        this.title = title;
        this.departments = departments;
    }

    boolean targets(String department) {
        for (String d : departments) {
            if (d.equalsIgnoreCase(department)) {
                return true;
            }
        }
        return false;
    }
}

class NoticeBoard {

    void broadcast(
        Notice notice,
        Student[] students
    ) {

        for (Student student : students) {

            if (notice.targets(student.department)) {

                for (NotificationChannel channel :
                     student.channels) {

                    channel.send(student, notice);
                }
            }
        }
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {

        NotificationChannel email =
            new EmailChannel();

        NotificationChannel sms =
            new SmsChannel();

        NotificationChannel app =
            new AppChannel();

        Student asha =
            new Student(
                "Asha",
                "CSE",
                new NotificationChannel[]{email, app}
            );

        Student ravi =
            new Student(
                "Ravi",
                "ECE",
                new NotificationChannel[]{sms}
            );

        Student neha =
            new Student(
                "Neha",
                "CSE",
                new NotificationChannel[]{app}
            );

        Notice notice =
            new Notice(
                "Hackathon Registration",
                new String[]{"CSE"}
            );

        new NoticeBoard().broadcast(
            notice,
            new Student[]{asha, ravi, neha}
        );
    }
}