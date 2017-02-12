 

/**
 * ShortAnswerQuestion implements a simple question class that encapsulates a
 * question text (one String) and a correct answer (one String). An answer must
 * match the answer string to be considered correct.
 * 
 * @author kvlinden
 * @version Fall, 2009
 */
public class ShortAnswerQuestion extends Question{
    
    private String myAnswer;

    public ShortAnswerQuestion(String text, String answer) {
        super(text);
        myAnswer = answer;
    }
    
    

    /**
     * Return the full text for this question, including the question text and
     * any appropriate instructions
     * 
     * @return the full question
     */
    public String getQuestion() {
        return super.getText();
    }

    /**
     * Return the answer to this question, potentially with helpful comments.
     * 
     * @return the answer
     */
    public String getAnswer() {
        return myAnswer;
    }

    /**
     * Return true if the given answer is correct for this question.
     * 
     * @param answer
     *            the user's answer
     * @return true if and only if the given answer is correct
     */
    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(myAnswer);
    }

}
