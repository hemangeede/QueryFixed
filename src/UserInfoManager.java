
import java.util.*;
import javax.swing.JFrame;
import java.io.*;

public class UserInfoManager {

    /**
     * @param args the command line arguments
     */
    public QFManager qf;
    public List<User> user;
    static int count =0;

    UserInfoManager(QFManager qf) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.qf=qf;
        user=new ArrayList<User>();
    }
    public void checkUser(String email){
        for(int i=0;i<user.size();i++){
            System.out.println(user.get(i).getEmail());
            if(user.get(i).getEmail().equals(email)){
                    //qf.dispmgr.userLogId=user.get(i).getUserId();
                qf.getdispmgr().showLogin();
            }
        }
    }
    public boolean verify(String email,String password){
        //System.out.println(email+" "+password);
        int flag=0;
        for(int i=0;i<user.size();i++){
            System.out.println(user.get(i).getEmail()+" "+user.get(i).getPassword());
            if(user.get(i).getEmail().equals(email)){
                if(user.get(i).getPassword().equals(password)){
                    //qf.userLogId=user.get(i).getUserId();
                    qf.setuserLogId(user.get(i).getUserId());
                    //assert(user.get(i).getEmail()==email);
                    flag=1;
                    break;
                }
                else{
                    flag=0;
                }
            }
            else{
                flag=0;
            }
        }
        if(flag==1) {
        	return true;
        }
        else {
            return false;
        }
    }
    
//    UserInfoManager(QFManager qf){
//        this.qf=qf;
//        user=new ArrayList<User>();
//    }
    public void displayDashboard(){
        qf.getdispmgr().showDashboard();
    }
    
    public void initialisation(String fname) {
    	FileReader reader;
    	BufferedReader br;
    	try {
    		reader= new FileReader(fname);
    		br = new BufferedReader(reader);
    		try { 
    			String line = br.readLine(); 
    			int i;
    			while(line != null) {
    				int c=0;
    				String arr[] = new String[7];
        			
    				StringTokenizer astr = new StringTokenizer(line, ",");
    				while(astr.hasMoreTokens()) {
    					arr[c++]=astr.nextToken();
    				}
    				c=0;
    				i = Integer.parseInt(arr[0]);
    				//System.out.println(arr[5]);
    				User u1 = new User(i, arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
    				user.add(u1);
                                count++;
    				line = br.readLine();
    			}
    			
    			//System.out.println(line);
    		}
    		catch (Exception e) {
    			System.out.println(e.getMessage());
    		}
    		
    		
    	}
    	catch (FileNotFoundException e) {
    		System.out.println(" User File not found");
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
            fw=new FileWriter("user.csv", true);
            bw= new BufferedWriter(fw);
            pw= new PrintWriter(bw);
            
            //for(Answers an: ans)
            //for(int i=length;i<ans.size();i++)
            //{
                //pw.println(an.getQId()+","+an.getAnswer()+","+an.getUserId()+","+an.getRId()
                  //      + ","+an.getAId()+","+an.getrAnsId());
                 pw.println(user.get(i).getUserId()+","+user.get(i).getUserName()+"," +user.get(i).getEmail()+","+user.get(i).getPassword()+","+user.get(i).getInstName()+","+user.get(i).getFullName()+","+user.get(i).getRegNo());
            //}
            pw.flush();
            pw.close();
        }
        catch (Exception E) {
  System.out.println(E);
}
    } 
    
    public void addUser(String uname,String email,String pass){
        //user=new ArrayList<User>();
        int flag=0;
        for(int i=0;i<user.size();i++){
            System.out.println(user.get(i).getEmail());
            if(user.get(i).getEmail().equals(email)){
                    //qf.dispmgr.userLogId=user.get(i).getUserId();
                    flag=1;
                    break;
                
            }
        }
        if(flag==0){
        User u=new User(count,uname,email,pass);
        user.add(u);
        count++;
        writeCsv(user.size()-1);
        qf.getdispmgr().showDashboard();
        }
        else{
            qf.getdispmgr().showLogin();
        }
    }
    
    public void addInstUser(String uname,String email,String pass,String iname, String fname, String regno){
        
        User u2=new User(count,uname,email,pass,iname,fname,regno);
        user.add(u2);
        count++;
        writeCsv(user.size()-1);
    }
    
    
    public void addInst(){}
    public boolean confMail(){
        return true;
    }
    
    public String getName(int ud) {
    	String s="";
    	for(User u: user ) {
    		int temp=u.getUserId();
    		if(ud==temp) {
    			return u.getUserName();
    		}
    	}
    	return s;
    }
    
    public void visibleSignUp(UserInfoManager us) {
    	JFrame SignUp=new SignUp(us);
    	SignUp.setVisible(true);
    }
    
//    public static void main(String[] args){
//        UserInfoManager us=new UserInfoManager();
//        us.initialisation("user.csv");
//        us.addUser("Neha","neha@gmail.com","12345");
//        //count++;
//        us.addInstUser("Neha","neha@gmail.com","12345","IEM","Neha Jhawar","2159");
//        //System.out.println(us.getName(0));
//        JFrame Login=new Login(us);
//        Login.setVisible(true);
//        //JFrame SignUp=new SignUp(us);
//        
//        //SignUp.setVisible(false);
//    }

    
}
