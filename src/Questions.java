import java.util.ArrayList;

public class Questions {
    private ArrayList<String> options = new ArrayList<>();
    private String question;

    public Questions(String option1, String option2, String option3, String correctOption, String question) {
        this.question = question;
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(correctOption);
    }

    public String getOption(int x) {
        if (x >= 0 && x < 4) {
            return options.get(x);
        }
        return "";
    }

    public String getCorrectOption() {
        return options.get(3);
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }
}