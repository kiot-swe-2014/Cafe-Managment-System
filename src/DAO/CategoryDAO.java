/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import MODEL.Category;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author SHREE
 */
public class CategoryDAO {
    
    public static void save(Category category){
       String query = "insert into category (name) values ('"+category.getName()+"')";
       DBoperations.setDataOrDelete(query,"Category Added Successfully");
    }
    
public static ArrayList<Category> getAllRecords(){
    ArrayList<Category> arrayList = new ArrayList<>();
 try{
     ResultSet rs = DBoperations.getData("select * from category");
     while (rs.next()){
     Category category = new Category();
     category.setId(rs.getInt("id"));
     category.setName(rs.getString("name"));
     arrayList.add(category);
     }
 }
 catch(Exception e){
     JOptionPane.showMessageDialog(null, e);
 }
 return arrayList;
}

public static void delete(String id){
  String query = "delete from category where id = '"+id+"'";
  DBoperations.setDataOrDelete(query,"Category deleted Sucessfully");
}
}
