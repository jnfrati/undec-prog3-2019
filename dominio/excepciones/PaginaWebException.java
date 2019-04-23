package excepciones;

@SuppressWarnings("serial")
public class PaginaWebException extends Exception {
	
	public PaginaWebException (String msg) {
		super(msg);
	}
}
