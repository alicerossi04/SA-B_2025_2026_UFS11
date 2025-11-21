
public class Regista {
	int id;
	String nome;
	String cognome;
	String paese;
	
	public Regista(int id, String nome, String cognome, String paese) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.paese = paese;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getPaese() {
		return paese;
	}
	
	public void setPaese(String paese) {
		this.paese = paese;
	}
	
	public String toString() {
		return "Regista [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", paese=" + paese + "]";
	}
	
	
}
