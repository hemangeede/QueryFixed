
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JFrame;
/**
 *
 * @author hemangee
 */
public class QuestionManager {
    public QFManager qf;
    public List<Questions> ques;
    static int count=0;
    public QuestionManager(){
        ques=new ArrayList<Questions> ();
    }

    QuestionManager(QFManager qf) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.qf=qf;
        ques=new ArrayList<Questions> ();
    }
    
    
    public void initialisation(String fname) {
    	FileReader reader;
    	BufferedReader br;
    	try {
    		reader= new FileReader(fname);
    		br = new BufferedReader(reader);
    		try { 
    			String line = br.readLine(); 
    			int i, q, r, ra,ud;
    			while(line != null) {
    				int c=0;
    				String arr[] = new String[3];
        			
    				StringTokenizer astr = new StringTokenizer(line, ",");
    				while(astr.hasMoreTokens()) {
    					arr[c++]=astr.nextToken();
    				}
    				c=0;
    				i = Integer.parseInt(arr[0]);
    				
    				ud=Integer.parseInt(arr[2]);
    				//System.out.println(arr[5]);    q, string, userid, rid, aid, ransid
    				Questions u1 = new Questions(i,arr[1],ud);
    				ques.add(u1);
    				line = br.readLine();
    			}
    			
    			//System.out.println(line);
    		}
    		catch (Exception e) {
    			System.out.println(e);
    		}
    		
    		
    	}
    	catch (FileNotFoundException e) {
    		System.out.println("Question File not found");
    	}
    	
    	
    }
    
    
   public void  writeCsv(int i)
    {
        //int qId,String answer, int uId, int rId, int aId,int rAnsId
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        try
        {
            fw=new FileWriter("question.csv", true);
            bw= new BufferedWriter(fw);
            pw= new PrintWriter(bw);
            
            //for(Answers an: ans)
            //for(int i=length;i<ans.size();i++)
            //{
                //pw.println(an.getQId()+","+an.getAnswer()+","+an.getUserId()+","+an.getRId()
                  //      + ","+an.getAId()+","+an.getrAnsId());
                 pw.println(ques.get(i).getQId()+","+ques.get(i).getQuestion()+"," +ques.get(i).getUId());
            //}
            pw.flush();
            pw.close();
        }
        catch (Exception E) {
  System.out.println(E);
}
    } 
    
    
    public void addQuestion(int c,String q,int u){
        Questions q1=new Questions(c,q,u);
        ques.add(q1);
        count++;
        writeCsv(c);
    }
    public List<Questions> getQuestions(){
        return this.ques;
    }
    public String[] QuestionString(){
        String[] s=new String[ques.size()+1];
        s[0]="Choose the question you want to answer:";
        for(int i=0;i<ques.size();i++){
            s[i+1]=ques.get(i).getQuestion();
        }
        return s;
        
    }
    public String[] MyQuestionsDisplay(int n){
        String []s=new String[ques.size()];
        int i=0;
        for(Questions a:ques){
            //int n=qf.userLogId;
            //System.out.println("User Id"+qf.userLogId);
            if(a.getUId()==n){
                s[i++]=a.getQuestion();
            }
        }
        return s;
    }
    /*public static void main(String[] args){
        QuestionManager q=new QuestionManager();
        q.initialisation("question.csv");
       // q.addQuestion(count, "What is the velocity of Light?", 1);
       // q.addQuestion(count, "What are Collections in Java?", 0);
       assert(q.getQuestions().size()==3);
       //JFrame AskQuestion=new AskQuestion(q);
       //AskQuestion.setVisible(true);
       JFrame AskaQuestion=new AskaQuestion(q);
       AskaQuestion.setVisible(true);
        
    }*/

}
