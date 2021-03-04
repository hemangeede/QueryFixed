
import java.time.LocalDate;
/**
 *
 * @author neha
 */

public class Notifications {
	private int notId=0;
    private String notification="";
    private int userId=0;
    private int questionId=0;
    private int answerId=0;
    private String d;
    private LocalDate dt;
    public Notifications(int notId,String notification, int userId, int questionId, int answerId, String d){
        this.notId=notId;
        this.notification=notification;
        this.userId=userId;
        this.questionId=questionId;
        this.answerId=answerId;
        this.d=d;
    }
    
    public int getnotId(){
        return this.notId;
    }
    public String getNotification(){
        return this.notification;
    }
    public int getUId(){
        return this.userId;
    }
    public int getQuestionId() {
    	return this.questionId;
    }
    public int getAnswerId() {
    	return this.answerId;
    }
    public String genNotification() {
    	String notiStr = "";
    	
    	return notiStr;
    }
    public String getDate(){
        return d;
    }
}
