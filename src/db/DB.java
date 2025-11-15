package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    //faz a conexao com o banco de dados;
    public static Connection getConnection() {
        if(conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                String user = props.getProperty("user");
                String password = props.getProperty("password");
                conn = DriverManager.getConnection(url, user, password);

                System.out.println("Connected ;)");
                return  conn;

            } catch(SQLException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return conn;
    }

    //carrega os dados do banco de dados;
    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("src/db/db.properties")){
            Properties prop = new Properties();
            prop.load(fs);
            return prop;
        } catch(IOException e){
            throw new DBException(e.getMessage());
        }
    }

    //fechar a conexao com o banco de dados;
    public static void closeConnection(){
        if(conn != null){
            try{
                System.out.println("Sistema fechado");
                conn.close();
            } catch(SQLException e){
                throw new DBException("Erro ao finalizar com banco de dados: " + e.getMessage());
            }
        }

    }
}
