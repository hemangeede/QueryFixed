
import java.util.*;

public class Answers {
		private int rAnsId=0;
		private int qId=0;
	    private int aId=0;
	    private int rId=0;
	    private String answer="";
	    private int userId=0;
	    public Answers(int qId,String answer, int uId, int rId, int aId,int rAnsId){   
	        this.qId=qId;
	        this.answer=answer;
	        this.userId=uId;
	        this.aId=aId;
	        this.rId=rId;
	        this.rAnsId=rAnsId;
	    }
	    public int getQId(){
	        return this.qId;
	    }
	    public String getAnswer(){
	        return this.answer;
	    }
	    public int getUserId(){
	        return this.userId;
	    }
	    public int getRId(){
	        return this.rId;
	    }
	    public int getAId(){
	        return this.aId;
	    }
	    public int getrAnsId() {
	    	return this.rAnsId;
	    }
	    
	   

}
