 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Simplequiz {

    private List<Question> myQuestions;
    private int currentQuestion;

    public Simplequiz() throws Exception {
        myQuestions = new ArrayList<Question>();

//         myQuestions.add(new ShortAnswerQuestion("Who won the English football cup in 1949?",
//                 "Wolverhampton"));
//         myQuestions.add(new ShortAnswerQuestion(
//                 "What is the name of Jerry Lee Lewis's bigg est solid gold hit?",
//                 "Great Balls of Fire"));
//         ShortAnswerQuestion a = new ShortAnswerQuestion("What is ...", "blank");
//         myQuestions.add(a);
//         
//         myQuestions.add(new FillInBlankQuestion("do re ...", "mi"));
//         
//         myQuestions.add(new TrueFalseQuestion("true or false?", true));
        
        //myQuestions.add(new multipleChoice("Which Letter is A?", new String[]{"asdf", "asdf", "asdf", "asdf", "asdf"}, "a"));
        
        myQuestions = getQ.gQ();
        
        Collections.shuffle(myQuestions);
        currentQuestion = 0;
    }

    /**
     * Return the full specification for the current question.
     * 
     * @return the full question
     */
    public String getCurrentQuestion() {
        return myQuestions.get(currentQuestion).getQuestion();
    }

    /**
     * Return the answer to the current question
     * 
     * @return the answer
     */
    public String getCurrentAnswer() {
        return myQuestions.get(currentQuestion).getAnswer();
    }
    
    public void resetQNum() {
        currentQuestion = 0;
    }

    /**
     * Returns true if the given answer is correct for the current question.
     * 
     * @param answer
     *            the user's answer
     * @return true if and only if the given answer is correct
     */
    public boolean checkCurrentAnswer(String answer) {
        return myQuestions.get(currentQuestion).checkAnswer(answer);
    }

    /**
     * Returns true if this quiz has another question.
     * 
     * @return true if and only if this quiz has another question
     */
    public boolean hasNext() {
        return currentQuestion < myQuestions.size() - 1;
    }

    /**
     * Advance to the next question.
     * 
     * @throws Exception
     *             if there are no more questions
     */
    public void next() throws Exception {
        if (currentQuestion == myQuestions.size() - 1) {
            throw new Exception("There are no more questions.");
        }
        currentQuestion++;
    }

}
