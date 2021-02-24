import java.io.BufferedReader;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
    				String arr[] = new String[6];
        			
    				StringTokenizer astr = new StringTokenizer(line, ",");
    				while(astr.hasMoreTokens()) {
    					arr[c++]=astr.nextToken();
    				}
    				c=0;
    				i = Integer.parseInt(arr[0]);
    				
    				ud=Integer.parseInt(arr[2]);
                                qd=Integer.parseInt(arr[3]);
                                ad=Integer.parseInt(arr[4]);
                                
    				//System.out.println(arr[5]);    q, string, userid, rid, aid, ransid
    				Notifications u1 = new Notifications(i,arr[1],ud,qd,ad,arr[5]);
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
    		System.out.println("Notification File not found");
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
        public String getAns(int ad) {
		String s="";
    	for(Answers q: qf.answermgr.ans) {
    		int temp= q.getAId();
    		if(ad==temp) {
    			s=q.getAnswer();
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
        public int getAnsUid(int ad) {
		int s=-1;
    	for(Answers q: qf.answermgr.ans) {
    		int temp= q.getAId();
    		if(ad==temp) {
    			s=q.getUserId();
    			//System.out.println(s+" "+temp);
    			return s;
    		}
    	}
    	return s;
    }
        public int getQuesIdOfAns(int aid,int uid){
            int s=-1;
    	for(Answers q: qf.answermgr.ans) {
    		int temp= q.getAId();int t=q.getUserId();
    		if(aid==temp && uid==t) {
    			s=q.getQId();
    			//System.out.println(s+" "+temp);
    			return s;
    		}
    	}
    	return s;
        }
        public void  writeCsv(int i)
    {
        //int qId,String answer, int uId, int rId, int aId,int rAnsId
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        try
        {
            fw=new FileWriter("notification.csv", true);
            bw= new BufferedWriter(fw);
            pw= new PrintWriter(bw);
            
            //for(Answers an: ans)
            //for(int i=length;i<ans.size();i++)
            //{
                //pw.println(an.getQId()+","+an.getAnswer()+","+an.getUserId()+","+an.getRId()
                  //      + ","+an.getAId()+","+an.getrAnsId());
                 pw.println(notifications.get(i).getnotId()+","+notifications.get(i).getNotification()+"," +notifications.get(i).getUId()+","+notifications.get(i).getQuestionId()+","+notifications.get(i).getAnswerId()+","+notifications.get(i).getDate());
                System.out.println(notifications.get(i).getDate());
            //}
            pw.flush();
            pw.close();
        }
        catch (Exception E) {
  System.out.println(E);
}
    } 
        public String[] oneDayAgo(){
            String[] s=new String[notifications.size()];int c=0;
            String today=(LocalDate.now()).toString();
            int lenDate=today.length();
            int date=Integer.parseInt(today.substring(8,lenDate));
            int month=Integer.parseInt(today.substring(5,7));
            int year=Integer.parseInt(today.substring(0,4));
            for(Notifications n:notifications){
                String d=n.getDate();
                System.out.println(d);
                int y=Integer.parseInt(d.substring(6,lenDate));
                int m=Integer.parseInt(d.substring(3,5));
                int dVal=Integer.parseInt(d.substring(0,2));
                if(y==year){
                    if(month==m){
                        if(dVal+1==date){
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			}
                        }
                    }
                    else if(m+1==month){
                        if(date==1 && (dVal==31||dVal==28||dVal==29||dVal==30)){
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			}
                        }
                    }
                }
                else if(y+1==year){
                    if(month==1 && m==12){
                        if(date==1 && dVal==31){
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			}
                    }
                }
            }
            }
            return s;
        }
        public String[] oneWeekAgo(){
            String[] s=new String[notifications.size()];int c=0;
            String today=(LocalDate.now()).toString();
            int lenDate=today.length();
            int date=Integer.parseInt(today.substring(8,lenDate));
            int month=Integer.parseInt(today.substring(5,7));
            int year=Integer.parseInt(today.substring(0,4));
            for(Notifications n:notifications){
                String d=n.getDate();
                System.out.println(d);
                int y=Integer.parseInt(d.substring(6,lenDate));
                int m=Integer.parseInt(d.substring(3,5));
                int dVal=Integer.parseInt(d.substring(0,2));
                if(y==year){
                    if(month==m){
                        if(dVal+7<=date){
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			}
                        }
                    }
                    else if(m+1==month){
                        if(date==1 && (dVal<=24||dVal<=21||dVal<=22||dVal<=23)){
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			}
                        }
                    }
                }
                else if(y+1==year){
                    if(month==1 && m==12){
                        if(date==1 && dVal<=24){
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			}
                    }
                }
            }
            }
            return s;
        }
        public String[] twoWeekAgo(){
            String[] s=new String[notifications.size()];int c=0;
            String today=(LocalDate.now()).toString();
            int lenDate=today.length();
            int date=Integer.parseInt(today.substring(8,lenDate));
            int month=Integer.parseInt(today.substring(5,7));
            int year=Integer.parseInt(today.substring(0,4));
            for(Notifications n:notifications){
                String d=n.getDate();
                System.out.println(d);
                int y=Integer.parseInt(d.substring(6,lenDate));
                int m=Integer.parseInt(d.substring(3,5));
                int dVal=Integer.parseInt(d.substring(0,2));
                if(y==year){
                    if(month==m){
                        if(dVal+14<=date){
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			}
                        }
                    }
                    else if(m+1==month){
                        if(date==1 && (dVal<=17||dVal<=14||dVal<=15||dVal<=16)){
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			}
                        }
                    }
                }
                else if(y+1==year){
                    if(month==1 && m==12){
                        if(date==1 && dVal<=17){
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			}
                    }
                }
            }
            }
            return s;
        }
        public String[] oneMonthAgo(){
            String[] s=new String[notifications.size()];int c=0;
            String today=(LocalDate.now()).toString();
            int lenDate=today.length();
            int date=Integer.parseInt(today.substring(8,lenDate));
            int month=Integer.parseInt(today.substring(5,7));
            int year=Integer.parseInt(today.substring(0,4));
            for(Notifications n:notifications){
                String d=n.getDate();
                System.out.println(d);
                int y=Integer.parseInt(d.substring(6,lenDate));
                int m=Integer.parseInt(d.substring(3,5));
                int dVal=Integer.parseInt(d.substring(0,2));
                if(y==year){
                    if(m+1==month){
                        
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			
                        }
                    }
                }
                else if(y+1==year){
                    if(month==1 && m==12){
                        
                            if(n.getUId()!=qf.dispmgr.userLogId) {
				s[c++] = n.getNotification();
			
                    }
                }
            }
            }
            return s;
        }


	
//	public void writeInFile(List<Notifications> noti) {
//		//BufferedWriter bw = null;
//		FileWriter csvWriter;
//	    try {
//	    	csvWriter = new FileWriter("notification.csv");
//
//	  		for (Notifications n : noti) {
//	  		    //csvWriter.append(String.join(",", rowData));
//	  			csvWriter.append(Integer.toString(n.getnotId()));
//		  		csvWriter.append(",");
//		  		csvWriter.append(n.getNotification());
//		  		csvWriter.append(",");
//		  		csvWriter.append(Integer.toString(n.getUId()));
//		  		csvWriter.append(",");
//		  		csvWriter.append(Integer.toString(n.getQuestionId()));
//		  		csvWriter.append(",");
//		  		csvWriter.append(Integer.toString(n.getAnswerId()));
//		  		csvWriter.append("\n");
//
//	  		}
//
//	  		csvWriter.flush();
//	  		csvWriter.close();
//
//	    } 
//	    catch (IOException ioe) {
//		   ioe.printStackTrace();
//		}
//		finally
//		{ 
//		   try{
//		      //if(csvWriter!=null)
//		    	//  csvWriter.close();
//		   }catch(Exception ex){
//		       System.out.println("Error in closing the BufferedWriter"+ex);
//		    }
//		}
//		//int notId,String notification, int userId, int questionId, int answerId
//			}
//	
	
	//****Has to look over fetching question from user
	public String genNotification(NotificationManager n, int qid, LocalDate dt) {
		String s="";
		//System.out.println(n.getName(uid));
		int uid = n.getUid(qid);
                
                String d=dt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		s=s+ n.getName(uid)+" has asked a question " +n.getQues(qid);
		Notifications n1 = new Notifications(count, s, uid, qid, -1,d);
		notifications.add(n1);
		count++;
		writeCsv(count-1);
		return s;
	}
        public String genAnsNotification(NotificationManager n, int aid, LocalDate dt) {
		String s="";
		//System.out.println(n.getName(uid));
		int uid = n.getAnsUid(aid);
                String d=dt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		s=s+ n.getName(uid)+" has given an Answer of the question " +n.getQues(n.getQuesIdOfAns(aid,uid));
		Notifications n1 = new Notifications(count, s, uid, n.getQuesIdOfAns(aid,uid), aid,d);
		notifications.add(n1);
		count++;
		writeCsv(count-1);
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
			if(n.getUId()!=uid) {
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
