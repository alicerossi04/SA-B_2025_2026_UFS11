public class Film {
	int id;
	String titolo;
	String categoria;
	String data;
	int id_regista;
	
	public Film(int id, String titolo, String categoria, String data, int id_regista) {
		this.id = id;
		this.titolo = titolo;
		this.categoria = categoria;
		this.data = data;
		this.id_regista = id_regista;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public int getId_regista() {
		return id_regista;
	}
	
	public void setId_regista(int id_regista) {
		this.id_regista = id_regista;
	}
	
	public String toString() {
		return "Film [id=" + id + ", titolo=" + titolo + ", categoria=" + categoria + ", data=" + data + "]";
	}
	
}
