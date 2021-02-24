
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class QFManager {
    public UserInfoManager usermgr;
    public QuestionManager questionmgr;
    public AnswerManager answermgr;
    public NotificationManager notimgr;
    public DisplayManager dispmgr;
    public int qs;
    public void showScreen(QFManager qf){
        qf.dispmgr.askaquestion=new AskaQuestion(qf.questionmgr);
        qf.dispmgr.ansques=new AnswerQuestion(qf.answermgr,0);
        qf.dispmgr.reviewans= new ReviewAnswers(qf.answermgr,0);
        qf.dispmgr.signup=new SignUp(qf.usermgr);
        qf.dispmgr.login=new Login(qf.usermgr);
        qf.dispmgr.dashboard=new Dashboard(qf.dispmgr);
        qf.dispmgr.myans=new MyAnswer(qf.answermgr);
        qf.dispmgr.myques=new MyQuestion(qf.questionmgr);
        qf.dispmgr.notification = new Notification(qf.notimgr);
        qf.dispmgr.dq = new DisplayQuestions(qf.dispmgr);
        qf.dispmgr.showLogin();
    }
    private Path getFolderPath() throws URISyntaxException, IOException {
    URI uri = getClass().getClassLoader().getResource("fileLoc").toURI();
    if ("jar".equals(uri.getScheme())) {
      FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap(), null);
      return fileSystem.getPath("/fileLoc/");
    } else {
      return Paths.get(uri);
    }
  }
    public void init(QFManager qf){
        try{
        qf.usermgr.initialisation(getFolderPath()+"user.csv");
        qf.questionmgr.initialisation(getFolderPath()+"question.csv");
        qf.answermgr.initialisation(getFolderPath()+"answer.csv");
        qf.notimgr.initialisation(getFolderPath()+"notification.csv");
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
        qf.showScreen(qf);
        
    }
}
