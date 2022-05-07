package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBD {
    public String db = "softech";
    public String url = "jdbc:mysql://db4free.net/"+db;
    public String user = "softech";
    public String pass = "softech2022";


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