package dominio;

import java.util.Arrays;

import excepciones.PaginaWebException;

public class PaginaWeb {

	private String url = "";
	private String contenido = "";
	private int [] ip = new int[4];
	
	public PaginaWeb(String urlOIp) throws PaginaWebException   {
		if(urlOIp.isEmpty()) {
			throw new PaginaWebException("Not a Page");
		}
		String[] aux = urlOIp.split("\\.");
		if(aux.length == 4) {
			int i = 0;
			try {
				for (String string : aux) {
					ip[i] = Integer.parseInt(string);
					if(ip[i++] < 0) {
						throw new PaginaWebException("URL o IP Mal Formada");
					}
				}
			}catch(Exception e) {
				throw e;
			} 
		}else {
			if(!aux[0].equalsIgnoreCase("www")) {
				throw new PaginaWebException("URL o IP Mal Formada");
			}
			if(aux[1].isEmpty()) {
				throw new PaginaWebException("URL o IP Mal Formada");
			}
			if(!aux[2].equalsIgnoreCase("com")) {
				throw new PaginaWebException("URL o IP Mal Formada");
			}
			url = aux[1]+"."+aux[2];
			switch (aux[1].toLowerCase()) {
			case "undec":
				this.contenido = "html-Soy La UNdeC";
				break;
			case "google":
				this.contenido = "html-Soy Google";
				break;
			default:
				
				this.contenido = "html-404 Not Found";
				break;
			}
		}
	}
	
	public String getUrl() {
		return url;
	}

	public String getContenido() {
		return contenido;
	}
	
	public int[] getIp() {
		return ip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(ip);
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaginaWeb other = (PaginaWeb) obj;
		if (!Arrays.equals(ip, other.ip))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	


}
