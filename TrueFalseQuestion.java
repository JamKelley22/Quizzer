
public class TrueFalseQuestion extends Question
{
    private boolean myAnswer;
    public TrueFalseQuestion(String text, boolean answer) {
        super(text);
        myAnswer = answer;
    }
    public String getQuestion() {
        return super.getText() + "\nIs this statement true or false?";
    }
    public String getAnswer() {
        if(myAnswer)
            return "true";
        else 
            return "false";
    }
    public boolean checkAnswer(String answer) {
        String a;
        String b;
        if(myAnswer) {
            a = "true";
            b = "t";
        }
        else {
            a = "false";
            b = "f";
        }
        if(answer.equalsIgnoreCase(a) || answer.equalsIgnoreCase(b))
            return true;
        else
            return false;
    }
}
