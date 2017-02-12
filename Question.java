
public abstract class Question
{
    private String myText;
    public Question(String a) {
        myText = a;
    }
    public String getText() {
        return myText;
    }
    public abstract String getQuestion();
    public abstract String getAnswer();
    public abstract boolean checkAnswer(String answer);
}
