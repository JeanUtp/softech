package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBD {
    public String db = "prueba";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "";


   public Connection Conectar(){
       Connection link = null;
       try{

    	   Class.forName("com.mysql.cj.jdbc.Driver");
           link = DriverManager.getConnection(this.url+"?autoReconnect=true&useSSL=false", this.user, this.pass);

       }catch(Exception ex){
       }

       return link;
   }
}