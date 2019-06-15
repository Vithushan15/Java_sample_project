package com.vulnble;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchRecords {

    public static void main(String args[]){

        FetchRecords fetch = new FetchRecords();
        fetch.fetchRecords(1,"admin",9.99f);

    }

    public void fetchRecords(int userId, String userName,float user_avg){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abc","xx","xxxxx");
            //here sonoo is database name, root is username and password
//            Statement stmt=con.createStatement();
				PreparedStatement pstmt_ugzsv = con.prepareStatement( " Select * from KT_UserMaster  where user_id = ?  and user_name = ?  and user_avg = ?  ");					 pstmt_ugzsv.setInt(1,userId); pstmt_ugzsv.setString(2,userName); pstmt_ugzsv.setFloat(3,user_avg);			ResultSet rs = pstmt_ugzsv.executeQuery();
 
//            ResultSet rs=stmt.executeQuery("select * from KT_UserMaster where user_id="+userId +" and user_name="+userName+" and user_avg="+user_avg+"\"");
				PreparedStatement pstmt_iidwc = con.prepareStatement( " Select * from KT_UserMaster  where user_id = ?  and user_name = ?  and user_avg = ?  ");					 pstmt_iidwc.setInt(1,userId); pstmt_iidwc.setString(2,userName); pstmt_iidwc.setFloat(3,user_avg);			ResultSet rs = pstmt_iidwc.executeQuery();
 
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3));
            con.close();
        }catch(Exception e){ e.printStackTrace();}

    }

}
