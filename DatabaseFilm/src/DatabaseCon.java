import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//DAO
public class DatabaseCon {
	static DatabaseCon instance = null;
    static final String driver = "com.mysql.cj.jdbc.Driver";
    Connection con;
    Statement cmd;

    private DatabaseCon(String dbms) {
    	try {
	    	Class.forName(driver);
	        
	        con = DriverManager.getConnection(dbms, "root", "password");
	        cmd = con.createStatement();
    	}
    	catch(ClassNotFoundException ex) {
    		ex.printStackTrace();
    	}
    	catch(SQLException ex1) {
    		ex1.printStackTrace();
    	}
    }
    
    public static DatabaseCon getInstance(String dbms) {
    	if (instance == null)
    		instance = new DatabaseCon(dbms);
    	
    	return instance;
    }
    
    public void closeConnection() {
    	try {
			cmd.close();
	        con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public ArrayList<Regista> queryRegisti() {
		ArrayList<Regista> regs = new ArrayList<>();

    	ResultSet res;
		try {
			res = cmd.executeQuery("select * from registi");
	        while (res.next()) {
		          int id = res.getInt("id");
		          String nome = res.getString("nome");
		          String cognome = res.getString("cognome");
		          String paese = res.getString("paese");
		          
		          Regista r = new Regista(id, nome, cognome, paese);
		          regs.add(r);
	        }
	        res.close(); // chiudere le risorse DB è obbligatorio 
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return regs;
    }

    public ArrayList<Film> queryFilms() {
		ArrayList<Film> films = new ArrayList<>();

    	ResultSet res;
		try {
			res = cmd.executeQuery("select * from film");
	        while (res.next()) {
		          int id = res.getInt("id");
		          String titolo = res.getString("titolo");
		          String data = res.getString("data");
		          String categoria = res.getString("categoria");
		          int id_regista = res.getInt("id_regista");
		          
		          Film f = new Film(id, titolo, categoria, data, id_regista);
		          films.add(f);
	        }
	        res.close(); // chiudere le risorse DB è obbligatorio 
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return films;
    }

    public void queryFilmConRegisti() {
    	ResultSet res;
		try {
			res = cmd.executeQuery("select titolo, nome from film join registi on film.id_regista = registi.id where paese like 'USA'");
	        while (res.next()) {
		          String nome = res.getString("nome");
		          String titolo = res.getString("titolo");
		          
		          System.out.println("NomeReg: " + nome + " Titolo: " + titolo);
	        }
	        res.close(); // chiudere le risorse DB è obbligatorio 
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    
}
