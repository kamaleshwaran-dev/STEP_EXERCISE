abstract class Question {
    String text;

    Question(String text) {
        this.text = text;
    }

    public abstract boolean evaluate(String answer);
}

class MCQQuestion extends Question {
    String correct;

    MCQQuestion(
        String text,
        String correct
    ) {
        super(text);
        this.correct = correct;
    }

    public boolean evaluate(String answer) {
        return correct.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {
    boolean correct;

    TrueFalseQuestion(
        String text,
        boolean correct
    ) {
        super(text);
        this.correct = correct;
    }

    public boolean evaluate(String answer) {
        return Boolean.parseBoolean(answer)
                == correct;
    }
}

class Examination {
    Question[] questions;

    Examination(Question[] questions) {
        this.questions = questions;
    }
}

class Attempt {
    Examination exam;
    String[] answers;
    boolean submitted;

    Attempt(Examination exam) {
        this.exam = exam;
        answers = new String[exam.questions.length];
    }

    void answer(int index, String answer) {

        if (submitted) {
            System.out.println(
                "Submitted answers are immutable"
            );
            return;
        }

        answers[index] = answer;
    }

    void submit() {
        submitted = true;
    }

    int score() {
        int score = 0;

        for (int i = 0;
             i < exam.questions.length;
             i++) {

            if (exam.questions[i]
                    .evaluate(answers[i])) {
                score++;
            }
        }

        return score;
    }
}

public class OnlineExaminationSystem {

    public static void main(String[] args) {

        Question[] questions = {
            new MCQQuestion(
                "Java creator?",
                "James Gosling"
            ),

            new TrueFalseQuestion(
                "Java is object-oriented?",
                true
            )
        };

        Examination exam =
            new Examination(questions);

        Attempt attempt =
            new Attempt(exam);

        attempt.answer(
            0,
            "James Gosling"
        );

        attempt.answer(1, "true");

        attempt.submit();

        System.out.println(
            "Score: " +
            attempt.score() +
            "/" +
            questions.length
        );

        attempt.answer(
            0,
            "Wrong Answer"
        );
    }
}