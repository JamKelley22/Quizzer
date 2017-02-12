 

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * SimplequizTest tests the functionality of Simplequiz's individual question
 * classes. It doesn't test the Simplequiz mechanism itself.
 * 
 * @author kvlinden
 * @version Fall, 2009
 */
public class SimplequizTest {

	@Test
	public void shortAnswerQuestionTest() {
		Question q = new ShortAnswerQuestion("a question", "answer");
		assertTrue(q.checkAnswer("answer"));
		assertEquals("a question", q.getQuestion());
		assertEquals("answer", q.getAnswer());
	}
	@Test
	public void FillInBlankQuestion() {
		Question q = new FillInBlankQuestion("a question", "answer");
		assertTrue(q.checkAnswer("answer"));
		assertEquals("a question", q.getQuestion());
		assertEquals("answer", q.getAnswer());
	}
	@Test
	public void TrueFalseQuestion() {
		Question q = new TrueFalseQuestion("a question", true);
		assertTrue(q.checkAnswer("true"));
		assertEquals("a question", q.getQuestion());
		assertEquals("true", q.getAnswer());
	}
}
