import java.util.ArrayList;
import java.util.Random;
public class multipleChoice extends Question
{
    private String myAnswer;
    private int numQs;
    private String[] ans;
    public multipleChoice(String Prompt, String[] ansL, String rAns) {
        super(Prompt);
        numQs = ansL.length;

        //         for(String q : ansL) {
        //             if(q.substring(0,2).equals("**")) {
        //                 myAnswer = q;
        //                 break;
        //             }
        // 
        //         }
        ArrayList<String> temp = new ArrayList<String>();
        for(int i = 0; i < ansL.length; i++) {
            temp.add(ansL[i]);
        }
        Random rand = new Random();
        String[] fin = new String[ansL.length];
        int count = 0;
        while(temp.size() > 0) {
            int n = rand.nextInt(temp.size());
            fin[count] = temp.remove(n);
            count++;
        }
        ans = fin;
        char c = 97;
        for(int i = 0; i < fin.length; i++) {
            if(fin[i].equals(rAns))
                rAns = Character.toString(c);
            c++;
        }
        myAnswer = rAns;

    }

    public String getQuestion() {
        char q = 97;//a
        String w = "";
        //             if(numAs > 122) 
        //                 throw new Exception("Too many answers, check numAs!");
        for(int i = 0; i < numQs; i++) {
            w = w + q + ".) " + ans[i] + "\n"; 
            q++;
        }
        String a = w;
        return super.getText() + "\n" + a;
    }

    public String getAnswer() {
        return myAnswer;
    }

    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(myAnswer);
    }
}
