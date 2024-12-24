/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import MODEL.User;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author SHREE
 */
public class UserDAO {
    public static void save(User user){
    String query = "insert into user(name, email, mobileNumber, address, password, securityQuestion, answer, status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
    DBoperations.setDataOrDelete(query, "Registered sucessfully wait for admin approval");
    }
    
    public static User login(String email, String password){
    User user = null;
    try{
    ResultSet rs = DBoperations.getData("select * from user where email='"+email+"'and password='"+password+"'");
    while(rs.next()){
    user= new User();
    user.setStatus(rs.getString("status"));
    
    }
    }
    catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            }
    return user;
    } 
    
    public static User getSecurityQuestion(String email){
    User user = null;
    try{
    ResultSet rs = DBoperations.getData("select *  from user where email ='"+email+"'");
    while(rs.next()){
      user = new User();
      user.setSecurityQuestion(rs.getString("securityQuestion"));
      user.setAnswer(rs.getString("answer"));
    }
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    return user;
    }
    
    public static void update(String EMAIL, String newPassword){
    String query = "Update user set password = '"+newPassword+"' where email='"+ EMAIL+"'";
    DBoperations.setDataOrDelete(query,"Password changed sucessfully");
    }
    
     public static ArrayList<User> getAllRecords(String email) {
        ArrayList<User> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DBoperations.getData("select *from user where email like '%"+email+"%'");
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void ChangeStatus(String email, String status)
    {
    String query="update user set status ='"+status+"' where email='"+email+"'";
    DBoperations.setDataOrDelete(query,"Status updated successfully ");
    }
    
    public static void changePassword(String email, String OldPassword,String NewPassword)
    {
    try{
        ResultSet rs = DBoperations.getData("select * from user where email='"+email+"' and password = '"+OldPassword+"'");
        if(rs.next()){
            update(email, NewPassword);
        }
        else{
        JOptionPane.showMessageDialog(null,"Old Password is Wrong");
        }
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    }
    
    public static void changeSecurityQuestion(String Email,String Password,String securityQuestion,String Answer ){
    try{
    ResultSet rs = DBoperations.getData("select * from user where email = '"+Email+"' and password = '"+Password+"'");
    if(rs.next()){
        update(Email, securityQuestion, Answer);
    }
    else{
    JOptionPane.showMessageDialog(null,"Password is wrong");
    }
            }
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    }
    
    public static void update(String email,String SecurityQuestion, String answer) {
    String query = "Update user set securityQuestion = '"+SecurityQuestion+"' and answer ='"+answer+"' where email = '"+email+"'";
    DBoperations.setDataOrDelete(query,"Security Question Changed successfully");
    }
}
