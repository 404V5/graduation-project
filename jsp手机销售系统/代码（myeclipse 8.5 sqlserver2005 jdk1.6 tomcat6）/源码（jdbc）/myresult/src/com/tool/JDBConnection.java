

package com.tool;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnection
{

    private String dbDriver;
    private String url;
    public Connection connection;

    public JDBConnection()
    {
        dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=db_shopping";
        connection = null;
        try
        {
            Class.forName(dbDriver).newInstance();
            connection = DriverManager.getConnection(url, "sa", "liushuai");
//            if(connection!=null){
//            	connection.close();
//            	System.out.println("ok");
//            }
        }
        catch(Exception ex)
        {
            System.out.println(" ˝æ›ø‚º”‘ÿ ß∞‹");
        }
    }
//    public static void main(String[] args) {
//    	JDBConnection B = new JDBConnection();
//	}
}
