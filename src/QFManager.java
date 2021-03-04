
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hemangee,neha
 */
public class QFManager {
    private UserInfoManager usermgr;
    private QuestionManager questionmgr;
    private AnswerManager answermgr;
    private NotificationManager notimgr;
    private DisplayManager dispmgr;
    private int userLogId=-1;
    
//    public void showScreen(QFManager qf){
//        qf.dispmgr.askaquestion=new AskaQuestion(qf.questionmgr);
//        qf.dispmgr.ansques=new AnswerQuestion(qf.answermgr,0);
//        qf.dispmgr.reviewans= new ReviewAnswers(qf.answermgr,0);
//        qf.dispmgr.signup=new SignUp(qf.usermgr);
//        qf.dispmgr.login=new Login(qf.usermgr);
//        qf.dispmgr.dashboard=new Dashboard(qf.dispmgr);
//        qf.dispmgr.myans=new MyAnswer(qf.answermgr);
//        qf.dispmgr.myques=new MyQuestion(qf.questionmgr);
//        qf.dispmgr.notification = new Notification(qf.notimgr);
//        qf.dispmgr.dq = new DisplayQuestions(qf.dispmgr);
//        qf.dispmgr.showLogin();
//    }
    /*private Path getFolderPath() throws URISyntaxException, IOException {
    URI uri = getClass().getClassLoader().getResource("fileLoc").toURI();
    if ("jar".equals(uri.getScheme())) {
      FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap(), null);
      return fileSystem.getPath("midsem2.jar/fileLoc/");
    } else {
      return Paths.get(uri);
    }
  }*/
    public int getuserLogId(){
        return this.userLogId;
    }
    public void setuserLogId(int id){
        this.userLogId=id;
    }
    public UserInfoManager getusermgr(){
        return this.usermgr;
    }
    public AnswerManager getanswermgr(){
        return this.answermgr;
    }
    public QuestionManager getquestionmgr(){
        return this.questionmgr;
    }
    public NotificationManager getnotimgr(){
        return this.notimgr;
    }
    public DisplayManager getdispmgr(){
        return this.dispmgr;
    }
    public void init(QFManager qf){
        try{
        //URL u=QFManager.class.getResource("/fileLoc/");
        /*qf.usermgr.initialisation(getFolderPath()+"user.csv");
        qf.questionmgr.initialisation(getFolderPath()+"question.csv");
        qf.answermgr.initialisation(getFolderPath()+"answer.csv");
        qf.notimgr.initialisation(getFolderPath()+"notification.csv");*/
        qf.usermgr.initialisation("user.csv");
        qf.questionmgr.initialisation("question.csv");
        qf.answermgr.initialisation("answer.csv");
        qf.notimgr.initialisation("notification.csv");
        assert(usermgr.user.isEmpty()==false);
        assert(questionmgr.ques.isEmpty()==false);
        assert(answermgr.ans.isEmpty()==false);
        assert(notimgr.notifications.isEmpty()==false);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        QFManager qf=new QFManager();
        qf.dispmgr=new DisplayManager(qf);
        
        qf.usermgr=new UserInfoManager(qf);
        qf.questionmgr=new QuestionManager(qf);
        qf.answermgr=new AnswerManager(qf);
        qf.notimgr=new NotificationManager(qf);
        qf.init(qf);
        
        //JFrame Login=new Login(qf.usermgr);
        //Login.setVisible(true);
        //JFrame SignUp=new SignUp(qf.usermgr);
        //SignUp.setVisible(true);
        qf.dispmgr.showScreen();
        
    }
}
