

public class Questions {
	private int qId=0;
    private String question="";
    private int userId=0;
    public Questions(int qId,String question, int uId){
        this.qId=qId;
        this.question=question;
        this.userId=uId;
    }
    public int getQId(){
        return this.qId;
    }
    public String getQuestion(){
        return this.question;
    }
    public int getUId(){
        return this.userId;
    }

}
