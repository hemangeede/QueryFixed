



public class DisplayManager {
    public QFManager qf;
	public AskaQuestion askaquestion;
	public AnswerQuestion ansques;
	public ReviewAnswers reviewans;
	public SignUp signup;
	public Login login;
	public Dashboard dashboard;
        public DisplayQuestions dq;
	public int userLogId;
        //public int quesIndex;
	public Notification notification;
	
    DisplayManager(QFManager qf) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.qf=qf;
    }
	public void showLogin()
	{
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
                dq.setVisible(false);
		dashboard.setVisible(false);
		askaquestion.setVisible(false);
		signup.setVisible(false);
		login.setVisible(false);
		ansques.setVisible(false);
                reviewans=new ReviewAnswers(qf.answermgr,n);
		reviewans.setVisible(true);
	}
	public void showAskaQuestion()
	{
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
		notification.setVisible(false);
		signup.setVisible(false);
		login.setVisible(false);
		reviewans.setVisible(false);
		dashboard.setVisible(false);
		askaquestion.setVisible(false);
                dq.setVisible(false);
                qf.answermgr.quesIndex=n;
                qf.answermgr.genString(n);
                //qf.qs=n;
                ansques.TextShow(n);
                System.out.println(n+" "+qf.answermgr.quesIndex);
                ansques=new AnswerQuestion(qf.answermgr,n);
		ansques.setVisible(true);
                
		
	}
	public void showDashboard()
	{
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
		dq.setVisible(false);
                signup.setVisible(false);
		login.setVisible(false);
		reviewans.setVisible(false);
		askaquestion.setVisible(false);
		ansques.setVisible(false);
		dashboard.setVisible(false);
		notification.setVisible(true);
                System.out.println(qf.notimgr.generatedNoti(userLogId));
		
	}
        public int showIndex(){
            return this.qf.qs;
        }
	
	
	
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
