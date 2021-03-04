/**
 *
 * @author hemangee,neha,deepak,kundan
 */
public class DisplayManager {
    public QFManager qf;
	public AskaQuestion askaquestion;
	public AnswerQuestion ansques;
	public ReviewAnswers reviewans;
	public SignUp signup;
	public Login login;
	public Dashboard dashboard;
        public MyAnswer myans;
        public MyQuestion myques;
        public DisplayQuestions dq;
	//public int userLogId;
        //public int quesIndex;
	public Notification notification;
	
    DisplayManager(QFManager qf) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.qf=qf;
    }
    public void showScreen(){
        askaquestion=new AskaQuestion(qf.getquestionmgr());
        ansques=new AnswerQuestion(qf.getanswermgr(),0);
        reviewans= new ReviewAnswers(qf.getanswermgr(),0);
        signup=new SignUp(qf.getusermgr());
        login=new Login(qf.getusermgr());
        dashboard=new Dashboard(qf.getdispmgr());
        myans=new MyAnswer(qf.getanswermgr());
        myques=new MyQuestion(qf.getquestionmgr());
        notification = new Notification(qf.getnotimgr());
        dq = new DisplayQuestions(qf.getdispmgr());
        showLogin();
    }
	public void showLogin()
	{
        myques.setVisible(false);
        myans.setVisible(false);
        dq.setVisible(false);
        notification.setVisible(false);
		dashboard.setVisible(false);
		reviewans.setVisible(false);
		ansques.setVisible(false);
		askaquestion.setVisible(false);
		signup.setVisible(false);
		login.setVisible(true);
		
	}
	public void showSignUp()
	{
                myques.setVisible(false);
                myans.setVisible(false);
                dq.setVisible(false);	
                notification.setVisible(false);
		dashboard.setVisible(false);
		login.setVisible(false);
		askaquestion.setVisible(false);
		ansques.setVisible(false);
		reviewans.setVisible(false);
		signup.setVisible(true);
	}
	public void showAnswer(int n)
	{
                myques.setVisible(false);
                myans.setVisible(false);
                dq.setVisible(false);
		dashboard.setVisible(false);
		askaquestion.setVisible(false);
		signup.setVisible(false);
		login.setVisible(false);
		ansques.setVisible(false);
                reviewans=new ReviewAnswers(qf.getanswermgr(),n);
		reviewans.setVisible(true);
	}
	public void showAskaQuestion()
	{
                myques.setVisible(false);
                myans.setVisible(false);
                dq.setVisible(false);
		notification.setVisible(false);
		signup.setVisible(false);
		login.setVisible(false);
		ansques.setVisible(false);
		reviewans.setVisible(false);
		dashboard.setVisible(false);
		askaquestion.setVisible(true);
                
		
	}
	public void answerQuestion()
	{
		myques.setVisible(false);
                myans.setVisible(false);
                notification.setVisible(false);
		signup.setVisible(false);
		login.setVisible(false);
		reviewans.setVisible(false);
		dashboard.setVisible(false);
		askaquestion.setVisible(false);
		ansques.setVisible(false);
                dq.setVisible(true);
		
	}
        public void answer(int n)
	{
		myques.setVisible(false);
                myans.setVisible(false);
                notification.setVisible(false);
		signup.setVisible(false);
		login.setVisible(false);
		reviewans.setVisible(false);
		dashboard.setVisible(false);
		askaquestion.setVisible(false);
                dq.setVisible(false);
                qf.getanswermgr().quesIndex=n;
                //qf.answermgr.genString(n);
                //qf.qs=n;
                //ansques.TextShow(n);
                //System.out.println(n+" "+qf.getanswermgr().quesIndex);
                ansques=new AnswerQuestion(qf.getanswermgr(),n);
		ansques.setVisible(true);
                
		
	}
	public void showDashboard()
	{
		myques.setVisible(false);
                myans.setVisible(false);
                dq.setVisible(false);
                notification.setVisible(false);
		signup.setVisible(false);
		login.setVisible(false);
		reviewans.setVisible(false);
		askaquestion.setVisible(false);
		ansques.setVisible(false);
		dashboard.setVisible(true);
		
	}
	
	public void showNotification()
	{
                myques.setVisible(false);
                myans.setVisible(false);
		dq.setVisible(false);
                signup.setVisible(false);
		login.setVisible(false);
		reviewans.setVisible(false);
		askaquestion.setVisible(false);
		ansques.setVisible(false);
		dashboard.setVisible(false);
		notification.setVisible(true);
                //System.out.println(qf.getnotimgr().generatedNoti(qf.getuserLogId()));
		
	}
        public void showMyAnswer()
	{
		dq.setVisible(false);
                signup.setVisible(false);
		login.setVisible(false);
		reviewans.setVisible(false);
		askaquestion.setVisible(false);
		ansques.setVisible(false);
		dashboard.setVisible(false);
		notification.setVisible(false);
                myques.setVisible(false);
                //myans=new MyAnswer(qf.answermgr);
                myans.setAnswers();
                myans.setVisible(true);
                qf.getanswermgr().MyAnswerDisplay();
                
		
	}
        public void showMyQuestion()
	{
		dq.setVisible(false);
                signup.setVisible(false);
		login.setVisible(false);
		reviewans.setVisible(false);
		askaquestion.setVisible(false);
		ansques.setVisible(false);
		dashboard.setVisible(false);
		notification.setVisible(false);
                //myques=new MyQuestion(qf.questionmgr);
                myques.setQuestions();
                myques.setVisible(true);
                myans.setVisible(false);
                qf.getquestionmgr().MyQuestionsDisplay(qf.getuserLogId());
		
	}
        public void showLogout()
    	{
            
        	qf.setuserLogId(-1);
        	login.setPlaceholder();
        	showLogin();
                login.showReguser();

    		//login.setVisible(true);
    		
    	}
        /*public int showIndex(){
            return this.qf.qs;
        }*/
	
	
	
//	public static void main(String[] rr)
//	{
//		DisplayManager dispmgr= new DisplayManager();
//		dispmgr.askaquestion=new AskaQuestion(dispmgr);
//		dispmgr.ansques=new AnswerQuestion(dispmgr);
//		dispmgr.reviewans= new ReviewAnswers(dispmgr);
//		dispmgr.signup=new SignUp(dispmgr);
//		dispmgr.login=new Login(dispmgr);
//		dispmgr.dashboard=new Dashboard(dispmgr);
//		dispmgr.showLogin();
//		
//		
//	}

}
