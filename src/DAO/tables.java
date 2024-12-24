/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;

/**
 *
 * @author SHREE
 */
public class tables {
    public static void main (String[]args)
  {
     try
    {
    String userTable="create table user (id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200), mobileNumber varchar(10), address varchar(200),password varchar(200),securityQuestion varchar(200), answer varchar(200), status varchar(20),UNIQUE(email))";
    String adminDetails="insert into user(name, email, mobileNumber, address, password, securityQuestion, answer, status) values ('Admin','admin@gmail.com','1234567890','INDIA','admin','What is This for','dbms project','true')";
    String category="create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
    String product= "create table product(id int AUTO_INCREMENT primary key,name varchar(200), category varchar(200), price varchar(200))";
    String Bill="create table bill(id int primary key,name varchar(200),mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createdby varchar(200))";
    DBoperations.setDataOrDelete(userTable, "User Table created sucessfully");
    DBoperations.setDataOrDelete(adminDetails, "Admin details added sucessfully");
    DBoperations.setDataOrDelete(category, "Category Table created sucessfully");
    DBoperations.setDataOrDelete(product, "Product Table created sucessfully");
    DBoperations.setDataOrDelete(Bill, "Bill Table created sucessfully");
    }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null, e);
     }
  }
    
}
