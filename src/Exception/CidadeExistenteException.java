package Exception;

@SuppressWarnings("serial")
public class CidadeExistenteException extends Exception {
	private String titulo;
	
	public CidadeExistenteException(String nomeCidade, String titulo) {
		super("Ops... A Cidade " + nomeCidade + " Já Foi Cadastrada");
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
