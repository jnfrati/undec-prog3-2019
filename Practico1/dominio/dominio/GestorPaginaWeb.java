package dominio;

import java.util.ArrayList;
import java.util.List;

import excepciones.PaginaWebException;

public class GestorPaginaWeb {

	private static GestorPaginaWeb gpw = null;
	private List<PaginaWeb> historial = new ArrayList<PaginaWeb>();
	private int index=0;
	
	
	public static GestorPaginaWeb getInstancia() {
		if(gpw == null) {
			gpw = new GestorPaginaWeb();
		}
		return gpw;
	}
	
	public void limpiarHistorial() {
		this.historial.clear();
	}
	
	public PaginaWeb traerPagina(String urlOIp) throws PaginaWebException {
		PaginaWeb nuevaPagina = new PaginaWeb(urlOIp);
		this.historial.add(nuevaPagina);
		index = this.historial.size();
		return nuevaPagina;
		
	}

	public PaginaWeb traerPaginaAnterior() {
		
		return this.historial.get(--index);
	}
	
	public PaginaWeb traerPaginaSiguiente() {
		return null;
	}
	
}
