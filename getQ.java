import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
import javax.swing.JFileChooser;
public class getQ
{

    public static ArrayList<Question> gQ() throws FileNotFoundException{ 

        //         Scanner console = new Scanner(System.in);
        //         System.out.print("Input File: ");
        //         String inputFileName = console.next();

        //Quiz 1 test
        
//"C:\\Users\\Jameel\\Desktop\\Quiz 1 test.txt"
        File inputFile = new File("Questions and Instructions.txt");
        Scanner in = new Scanner(inputFile);

        //         JFileChooser chooser = new JFileChooser();
        //         Scanner in = null;
        //         if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        //             File selectedFile = chooser.getSelectedFile();
        //             in = new Scanner(selectedFile);
        //         }

        ArrayList<Question> q = new ArrayList<Question>();
        while(in.hasNextLine()) {
            String line = in.nextLine();

            if(line.length() > 1) {
                String tag = line.substring(1,3);
                if(tag.equals("--")) {

                }
                else if(tag.equals("*b")) {
                    q.add(new FillInBlankQuestion(line.substring(4), in.nextLine().substring(4)));
                }
                else if(tag.equals("*t")) {
                    String a = line.substring(4);
                    String b = in.nextLine().substring(4).toLowerCase();
                    boolean c;
                    if(b.equals("true"))
                        c = true;
                    else
                        c = false;
                    q.add(new TrueFalseQuestion(a, c));
                }
                else if(tag.equals("*m")) {
                    String a = line.substring(4);
                    String rAns = "";
                    //int count = 0;
                    List<String> ansLines = new ArrayList<String>();
                    String n = in.nextLine();
                    for(int i = 0; n.length() > 2; n = in.nextLine()) {

                        if(n.substring(1,3).equals("*!") || n.substring(1,3).equals("**"))
                            ansLines.add(n.substring(4));

                        if(n.substring(1,3).equals("**"))
                            rAns = n.substring(4);
                    }

                    String[] ans;
                    ans = ansLines.toArray(new String[ansLines.size()]);

                    q.add(new multipleChoice(a,ans,rAns));
                    //need to add an real ans peramater
                }
                else if(tag.equals("*s")) {
                    q.add(new ShortAnswerQuestion(line.substring(4), in.nextLine().substring(4)));
                }
                //                 else if(tag.equals("**")) {
                // 
                //                 }
                //                 else if(tag.equals("*!")) {
                // 
                //                 }

            }
        }

        in.close();
        return q;
    }
}
// ArrayList<String> ansLines = new ArrayList<String>();
//                     String x = line.substring(1,3);
//                     while(x.equals("*!") || x.equals("**")) {
//                         String y = in.nextLine();
//                         
//                         ansLines.add(y.substring(4));
// count++;
//                         y = in.nextLine();
//                         x = y.substring(1,3);
//                         
//                     }
