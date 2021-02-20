import java.io.BufferedReader;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import javax.swing.JFrame;
public class NotificationManager {
	public QFManager qf;
	//public ArrayList<User> user = new ArrayList<User>();
	//public ArrayList<Questions> ques = new ArrayList<Questions>() ;
	public List<Notifications> notifications;
	static int count=0;
	
	public void initialisation(String fname) {
    	FileReader reader;
    	BufferedReader br;
    	try {
    		reader= new FileReader(fname);
    		br = new BufferedReader(reader);
    		try { 
    			String line = br.readLine(); 
    			int i, q, qd, ad,ud;
    			while(line != null) {
    				int c=0;
    				String arr[] = new String[5];
        			
    				StringTokenizer astr = new StringTokenizer(line, ",");
    				while(astr.hasMoreTokens()) {
    					arr[c++]=astr.nextToken();
    				}
    				c=0;
    				i = Integer.parseInt(arr[0]);
    				
    				ud=Integer.parseInt(arr[2]);
                                qd=Integer.parseInt(arr[3]);
                                ad=Integer.parseInt(arr[3]);
    				//System.out.println(arr[5]);    q, string, userid, rid, aid, ransid
    				Notifications u1 = new Notifications(i,arr[1],ud,qd,ad);
    				notifications.add(u1);
                                count++;
    				line = br.readLine();
    			}
    			
    			//System.out.println(line);
    		}
    		catch (Exception e) {
    			System.out.println(e);
    		}
    		
    		
    	}
    	catch (FileNotFoundException e) {
    		System.out.println("File not found");
    	}
    	
    	
    }
    
	
	public NotificationManager(QFManager qf) {
		// TODO Auto-generated constructor stub
		this.qf=qf;
		notifications = new ArrayList<Notifications>();
	}

	public String getName(int ud) {
		String s="";
    	for(User u: qf.usermgr.user) {
    		int temp=u.getUserId();
    		if(ud==temp) {
    			s=u.getUserName();
    			//System.out.println(s+" "+temp);
    			return u.getUserName();
    		}
    	}
    	return s;
    }
	
	public String getQues(int qd) {
		String s="";
    	for(Questions q: qf.questionmgr.ques) {
    		int temp= q.getQId();
    		if(qd==temp) {
    			s=q.getQuestion();
    			//System.out.println(s+" "+temp);
    			return s;
    		}
    	}
    	return s;
    }
	
	public int getUid(int qd) {
		int s=-1;
    	for(Questions q: qf.questionmgr.ques) {
    		int temp= q.getQId();
    		if(qd==temp) {
    			s=q.getUId();
    			//System.out.println(s+" "+temp);
    			return s;
    		}
    	}
    	return s;
    }
	
	public void writeInFile(List<Notifications> noti) {
		//BufferedWriter bw = null;
		FileWriter csvWriter;
	    try {
	    	csvWriter = new FileWriter("notification.csv");

	  		for (Notifications n : noti) {
	  		    //csvWriter.append(String.join(",", rowData));
	  			csvWriter.append(Integer.toString(n.getnotId()));
		  		csvWriter.append(",");
		  		csvWriter.append(n.getNotification());
		  		csvWriter.append(",");
		  		csvWriter.append(Integer.toString(n.getUId()));
		  		csvWriter.append(",");
		  		csvWriter.append(Integer.toString(n.getQuestionId()));
		  		csvWriter.append(",");
		  		csvWriter.append(Integer.toString(n.getAnswerId()));
		  		csvWriter.append("\n");

	  		}

	  		csvWriter.flush();
	  		csvWriter.close();

	    } 
	    catch (IOException ioe) {
		   ioe.printStackTrace();
		}
		finally
		{ 
		   try{
		      //if(csvWriter!=null)
		    	//  csvWriter.close();
		   }catch(Exception ex){
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}
		//int notId,String notification, int userId, int questionId, int answerId
			}
	
	
	//****Has to look over fetching question from user
	public String genNotification(NotificationManager n, int qid) {
		String s="";
		//System.out.println(n.getName(uid));
		int uid = n.getUid(qid);
		s=s+ n.getName(uid)+" has asked a question " +n.getQues(qid);
		Notifications n1 = new Notifications(count, s, uid, qid, -1);
		notifications.add(n1);
		count++;
		writeInFile(notifications);
		return s;
	}
	public void displayNotification() {
		
	}
	
	public List<Notifications> getNoti(){
        return this.notifications;
    }
	
	public String[] generatedNoti(int uid) {
            System.out.println(uid);
            System.out.println(notifications.size());
		String[] notiString = new String[notifications.size()];
		int i=0;
		for(Notifications n: notifications) {
			if(n.getUId()==uid) {
				//notiString.add(n.getNotification());
                                System.out.println("Inserted "+i);
				notiString[i++] = n.getNotification();
			}
		}
            for (String notiString1 : notiString) {
                System.out.println(notiString1);
            }
	return notiString;
	}
	
//	public static void main(String args[]) {
//		//NotificationManager noti = new NotificationManager();
//		//noti.addUser();
//		//noti.addQuestions();
//		noti.genNotification(noti, 0);
//		noti.genNotification(noti, 1);
//		assert(noti.getNoti().size()==2);
//		
//		//JFrame Notification = new Notification(noti);
//		//Notification.setVisible(true);
//		
//	}
}
