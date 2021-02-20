



public class DisplayManager {
    public QFManager qf;
	public AskaQuestion askaquestion;
	public AnswerQuestion ansques;
	public ReviewAnswers reviewans;
	public SignUp signup;
	public Login login;
	public Dashboard dashboard;
	public int userLogId;
        
	public Notification notification;
	
    DisplayManager(QFManager qf) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.qf=qf;
    }
	public void showLogin()
	{
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
		notification.setVisible(false);
		dashboard.setVisible(false);
		login.setVisible(false);
		askaquestion.setVisible(false);
		ansques.setVisible(false);
		reviewans.setVisible(false);
		signup.setVisible(true);
	}
	public void showAnswer()
	{
		dashboard.setVisible(false);
		askaquestion.setVisible(false);
		signup.setVisible(false);
		login.setVisible(false);
		ansques.setVisible(false);
		reviewans.setVisible(true);
	}
	public void showAskaQuestion()
	{
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
		ansques.setVisible(true);
		
	}
	public void showDashboard()
	{
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
		signup.setVisible(false);
		login.setVisible(false);
		reviewans.setVisible(false);
		askaquestion.setVisible(false);
		ansques.setVisible(false);
		dashboard.setVisible(false);
		notification.setVisible(true);
                System.out.println(qf.notimgr.generatedNoti(userLogId));
		
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
