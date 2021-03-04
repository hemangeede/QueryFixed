import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import javax.swing.JFrame;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author deepak,kundan
 */
public class AnswerManager {
    public QFManager qf;
    public List<Answers> ans;
    static int count=0;
    int length=0;
    public int quesIndex;
    public String q="";
    //public int quesIndex=0;
    public AnswerManager(){
        ans=new ArrayList<Answers> ();
        
    }

    AnswerManager(QFManager qf) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.qf=qf;
        ans=new ArrayList<Answers> ();
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
    String arr[] = new String[6];
       
    StringTokenizer astr = new StringTokenizer(line, ",");
    while(astr.hasMoreTokens()) {
    arr[c++]=astr.nextToken();
    }
    c=0;
    i = Integer.parseInt(arr[0]);
    q = Integer.parseInt(arr[1]);
    r = Integer.parseInt(arr[4]);
    ra = Integer.parseInt(arr[5]);
    ud=Integer.parseInt(arr[3]);
    //System.out.println(arr[5]);    q, string, userid, rid, aid, ransid
    Answers u1 = new Answers(q,arr[2],ud,r,i,ra);
    ans.add(u1);
    line = br.readLine();
    }
    length=ans.size();
    //System.out.println(line);
    }
    catch (Exception e) {
    System.out.println(e);
    }
   
   
    }
    catch (FileNotFoundException e) {
    System.out.println("Answer File not found");
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
            fw=new FileWriter("answer.csv", true);
            bw= new BufferedWriter(fw);
            pw= new PrintWriter(bw);
            
            //for(Answers an: ans)
            //for(int i=length;i<ans.size();i++)
            //{
                //pw.println(an.getQId()+","+an.getAnswer()+","+an.getUserId()+","+an.getRId()
                  //      + ","+an.getAId()+","+an.getrAnsId());
                 pw.println(ans.get(i).getAId()+","+ans.get(i).getQId()+"," +ans.get(i).getAnswer()+","+ans.get(i).getUserId()
                        + ","+ans.get(i).getRId()+","+ans.get(i).getrAnsId());
            //}
            pw.flush();
            pw.close();
        }
        catch (Exception E) {
  System.out.println(E);
}
    }
   
     
    public void addAnswer(int c,int u,String answer,int q){
        Answers a1=new Answers(q,answer,u, 0, c,0);
        ans.add(a1);
        count++;
        //System.out.println(c);
        writeCsv(c);
        
       
    }
    public void reviewAns(int c,int u,String answer,int q,int rAnsId) {
    Answers a1=new Answers(q,answer,u, 1, c,rAnsId);
        ans.add(a1);
        count++;
        writeCsv(c);
    }
    /*public List<Answers>getAnswer(){
        return this.ans;
    }*/
    public String getQues(int qd) {
		String s="";
    	for(Questions q: qf.getquestionmgr().ques) {
    		int temp= q.getQId();
    		if(qd==temp) {
    			s=q.getQuestion();
    			//System.out.println(s+" "+temp);
    			return s;
    		}
    	}
    	return s;
    }
    public String[] MyAnswerDisplay(){
        String []s=new String[ans.size()];
        int i=0;
        for(Answers a:ans){
            if(a.getUserId()==qf.getuserLogId()){
                int qid=a.getQId();
                s[i++]="Question : "+getQues(qid)+"\n"+"Answer : "+a.getAnswer();
            }
        }
        for(int j=0;j<i/2;j++){
            String temp=s[j];
            s[j]=s[i-1-j];
            s[i-1-j]=temp;
        }
        return s;
    }
    /*public int showIndex(){
        return this.quesIndex;
    }
    public void genString(int n){
        //System.out.println(quesIndex);
        String s=qf.questionmgr.ques.get(n).getQuestion();
        System.out.println(s);
        this.q=s;
    }*/
    public String getName(int ud) {
		String s="";
    	for(User u: qf.getusermgr().user) {
    		int temp=u.getUserId();
    		if(ud==temp) {
    			s=u.getUserName();
    			//System.out.println(s+" "+temp);
    			return u.getUserName();
    		}
    	}
    	return s;
    }
    public String[] getAnsForQues(int n){
        String[] s=new String[ans.size()];int i=0;
        for(Answers a:ans){
            if(a.getQId()==n){
                s[i++]="User "+getName(a.getUserId())+" : "+a.getAnswer()+" \n";
            }
        }
        return s;
    }
    /*public String Text(){
        return this.q;
    }*/
//    public static void main(String[] args){
//        AnswerManager q=new AnswerManager();
//        q.initialisation("answer.csv");
//        //assert(q.getAnswer().size()==4);
//        JFrame ReviewAnswers=new ReviewAnswers(q);
//        ReviewAnswers.setVisible(true);
//        
//        JFrame AnswerQuestion=new AnswerQuestion(q);
//        AnswerQuestion.setVisible(true);
////        q.writeCsv();
//        //q.addAnswer(count, 0,"velocity of light is 3 *10^8 ", 1);
//        //q.addAnswer(count, 1,"The magnetic field is the area around a magnet in which there is magnetic force", 1);
//        //q.reviewAns(count,1,"The real ans is ans",2,1);
//        //for(Answers a2:ans){
//            //System.out.println(""+a2.getAId()+","+a2.getQId()+", "+a2.getAnswer()+","+a2.getUserId()+", "+a2.getRId());
//        }
//    }

}

