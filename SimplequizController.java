
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
/**
* SimplequizController implements a GUI driver for Simplequiz.
* 
* @author kvlinden
* @version Fall, 2009
* @version Added inner class, Spring, 2012
*/
@SuppressWarnings("serial")
public class SimplequizController extends JFrame {
    //private JFrame jF;
    private JTextArea questionArea;
    private JTextField answerField;
    private JLabel messageLabel;
    private Simplequiz simplequiz;

    private static int score = 0;
    private static int total = 0;
    static int finT;
    static boolean run = true;
    public SimplequizController() throws Exception {
        super("Simplequiz");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font font = new Font("Ariel", 0, 18);

        questionArea = new JTextArea(7, 40);
        questionArea.setEditable(false);
        questionArea.setFont(font);
        add(questionArea, BorderLayout.NORTH);

        answerField = new JTextField(12);
        answerField.setFont(font);
        answerField.addActionListener(new AnswerFieldListener());
        add(answerField, BorderLayout.WEST);

        messageLabel = new JLabel();
        messageLabel.setFont(font);
        messageLabel.setText("\u21D0 Enter your answers here.");
        add(messageLabel, BorderLayout.CENTER);

        //setLocationRelativeTo(null);
        this.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //         System.out.println(dim);
        //         System.out.println(this.getSize());
        //         System.out.println(this.getSize().width);
        //         System.out.println(this.getSize().height);
        this.setLocation((int)((dim.width/2)-(this.getSize().width/2.0)), (int)(dim.height/2-this.getSize().height/2.0));

        //System.out.println(this.getSize().width);
        //System.out.println(this.getSize().height);

        //      this.setUndecorated(true);
        //      Color c = new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
        //      c = c.brighter();
        //      this.getContentPane().setBackground(c);
        //      questionArea.setBackground(c);
        //      answerField.setBackground(c);

        simplequiz = new Simplequiz();

        startQuiz();

    }

    class AnswerFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            try {
                //                 if (!simplequiz.hasNext()) {
                //                     endQuiz();
                //                 }
                if (simplequiz.checkCurrentAnswer(answerField.getText())) {
                    messageLabel.setText("Well done!");
                    score++;
                    total++;
                } else {
                    if (run) {///////////////

                        messageLabel.setText("Sorry, the answer was " + simplequiz.getCurrentAnswer());
                        total++;
                    }
                }
                answerField.setText("");
                if (simplequiz.hasNext()) {
                    try {
                        simplequiz.next();
                        startQuiz();
                    } catch (Exception e) {
                        // Control should never get here.
                        endQuiz();

                    }
                } else {
                    endQuiz();

                }
            } catch (Exception e) {
                messageLabel.setText(e.getMessage());
            }

        }
    }

    private void startQuiz() {
        questionArea.setText(simplequiz.getCurrentQuestion());
    }

    private void endQuiz() {

        questionArea.setText("Quiz finished.\n" + " Your Score: " + score + "/" + total + " correct!");
        answerField.setEditable(false);

        run = false;

        //         simplequiz.resetQNum();
        //         startQuiz();
    }

    public static void main(String[] args) throws Exception {
        SimplequizController application = new SimplequizController();
        application.pack();
        application.setVisible(true);
    }

}
