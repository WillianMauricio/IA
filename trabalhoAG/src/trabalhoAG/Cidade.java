package trabalhoAG;

public class Cidade {
	public String nome;
	public String letra;
	
	/**
	 * construct
	 */
	public Cidade(String nome_) {
		nome = nome_;
		letra = nome.toUpperCase().substring(0, 1);
				
	}
}
