
public class FillInBlankQuestion extends Question
{
    private String myAnswer;
    public FillInBlankQuestion(String text, String answer) {
        super(text);
        myAnswer = answer;
    }
    public String getQuestion() {
        String a = super.getText() + "\nFill in the blank.";
        return a;
    }
    public String getAnswer() {
        return myAnswer;
    }
    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(myAnswer);
    }
    
}
