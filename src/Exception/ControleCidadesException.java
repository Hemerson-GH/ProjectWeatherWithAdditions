package Exception;

@SuppressWarnings("serial")
public class ControleCidadesException extends Exception {
	private String titulo;
	
	public ControleCidadesException(String msg, String titulo) {
		super(msg);	
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
