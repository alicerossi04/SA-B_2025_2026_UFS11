import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Principale {
	
	public static void main(String[] args) {
		ArrayList<Regista> regs = new ArrayList<>();
		ArrayList<Film> films = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/netfluxdb?useSSL=false&serverTimezone=Europe/Rome";

        DatabaseCon dbc = DatabaseCon.getInstance(url);
        regs = dbc.queryRegisti();
        films = dbc.queryFilms();
		
        System.out.println("Stampo tutti i registi");
	    for(Regista x: regs) 
	    	System.out.println(x);
        System.out.println("Stampo tutti i film");
	    for(Film f: films) 
	    	System.out.println(f);
	    
	    System.out.println("Stampo tutti i film con Registi USA");
	    dbc.queryFilmConRegisti();

	}

}
