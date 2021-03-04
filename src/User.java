/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hemangee
 */
public class User {
    private int userId=0;
    private String userName="";
    private String email="";
    private String password="";
    private String instName="";
    private String fullName="";
    private String regNo="";
    
    public User(int uid,String userName, String email, String password){
        this.userId=uid;
        this.userName=userName;
        this.email=email;
        this.password=password;
    }
    public User(int uid,String userName, String email, String password,String instName,String fullName, String regNo){
        this.userId=uid;
        this.userName=userName;
        this.email=email;
        this.password=password;
        this.instName=instName;
        this.fullName=fullName;
        this.regNo=regNo;
    }
    public int getUserId(){
        return this.userId;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getInstName(){
        return this.instName;
    }
    public String getFullName(){
        return this.fullName;
    }
    public String getRegNo(){
        return this.regNo;
    }
}
