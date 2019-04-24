package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import dominio.PaginaWeb;
import excepciones.PaginaWebException;

class TestPaginaWeb {

	@Test
	void testPaginaWeb_BienFormada() {
		try {
			PaginaWeb pw1 = new PaginaWeb("128.234.0.12");
			assertEquals(128,pw1.getIp()[0]);
			assertEquals(234,pw1.getIp()[1]);
			assertEquals(0,pw1.getIp()[2]);
			assertEquals(12,pw1.getIp()[3]);
			
			assertEquals("", pw1.getUrl());
			
			PaginaWeb pw2 = new PaginaWeb("32.0.29.31");
			assertEquals(32,pw2.getIp()[0]);
			assertEquals(0,pw2.getIp()[1]);
			assertEquals(29,pw2.getIp()[2]);
			assertEquals(31,pw2.getIp()[3]);
			
			assertEquals("", pw2.getUrl());
			
			pw2 = new PaginaWeb("www.undec.com");
			assertEquals(0,pw2.getIp()[0]);
			assertEquals(0,pw2.getIp()[1]);
			assertEquals(0,pw2.getIp()[2]);
			assertEquals(0,pw2.getIp()[3]);
			
			assertEquals("undec.com", pw2.getUrl());
			
			PaginaWeb pw3 = new PaginaWeb("www.google.com");
			assertEquals(0,pw3.getIp()[0]);
			assertEquals(0,pw3.getIp()[1]);
			assertEquals(0,pw3.getIp()[2]);
			assertEquals(0,pw3.getIp()[3]);
			
			assertEquals("google.com", pw3.getUrl());
			
			
		} catch (PaginaWebException e) {
			fail("Esta excepcion no deberia correrse");
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
		
	}

	@Test
	void testPaginaWeb_MalFormada_IPNegativa() {
		try {
			@SuppressWarnings("unused")
			PaginaWeb pw1 = new PaginaWeb("-128.234.0.12");
			fail("Esta linea no deberia correrse");
			
		} catch (PaginaWebException e) {
			assertEquals("URL o IP Mal Formada",e.getMessage());
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
		
		try {
			@SuppressWarnings("unused")
			PaginaWeb pw1 = new PaginaWeb("128.-234.0.12");
			fail("Esta linea no deberia correrse");
			
		} catch (PaginaWebException e) {
			assertEquals("URL o IP Mal Formada",e.getMessage());
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
		
		try {
			@SuppressWarnings("unused")
			PaginaWeb pw1 = new PaginaWeb("128.234.0.-12");
			fail("Esta linea no deberia correrse");
			
		} catch (PaginaWebException e) {
			assertEquals("URL o IP Mal Formada",e.getMessage());
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
	}
	
	@Test
	void testPaginaWeb_MalFormada_IPCorta() {
		try {
			@SuppressWarnings("unused")
			PaginaWeb pw1 = new PaginaWeb("128.234.012");
			fail("Esta linea no deberia correrse");
			
		} catch (PaginaWebException e) {
			assertEquals("URL o IP Mal Formada",e.getMessage());
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
	}
	
	@Test
	void testPaginaWeb_MalFormada_IPLarga() {
		try {
			@SuppressWarnings("unused")
			PaginaWeb pw1 = new PaginaWeb("128.234.0.1.2");
			fail("Esta linea no deberia correrse");
			
		} catch (PaginaWebException e) {
			assertEquals("URL o IP Mal Formada",e.getMessage());
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
	}
	
	@Test
	void testPaginaWeb_MalFormada_URLDominioInvalido() {
		try {
			@SuppressWarnings("unused")
			PaginaWeb pw1 = new PaginaWeb("www.undec.gov");
			fail("Esta linea no deberia correrse");
			
		} catch (PaginaWebException e) {
			assertEquals("URL o IP Mal Formada",e.getMessage());
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
	}
	
	@Test
	void testPaginaWeb_MalFormada_URLInicioInvalido() {
		try {
			@SuppressWarnings("unused")
			PaginaWeb pw1 = new PaginaWeb("wwww.undec.com");
			fail("Esta linea no deberia correrse");
			
		} catch (PaginaWebException e) {
			assertEquals("URL o IP Mal Formada",e.getMessage());
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
	}
	
	@Test
	void testPaginaWeb_MalFormada_URLcorta() {
		try {
			@SuppressWarnings("unused")
			PaginaWeb pw1 = new PaginaWeb("wwww..com");
			fail("Esta linea no deberia correrse");
			
		} catch (PaginaWebException e) {
			assertEquals("URL o IP Mal Formada",e.getMessage());
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
	}
	
	@Test
	void testPaginaWeb_MalFormada_Sin_URLOIp() {
		try {
			@SuppressWarnings("unused")
			PaginaWeb pw1 = new PaginaWeb("");
			fail("Esta linea no deberia correrse");
			
		} catch (PaginaWebException e) {
			assertEquals("Not a Page",e.getMessage());
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
	}

	@Test
	void testPaginaWeb_ContenidoCorrectoUNdeC() {
		try {
			PaginaWeb pw1 = new PaginaWeb("www.undec.com");
			assertEquals("html-Soy La UNdeC",pw1.getContenido());
			
		} catch (PaginaWebException e) {
			fail("Esta linea no deberia correrse");
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
	}
	
	@Test
	void testPaginaWeb_ContenidoCorrectoGoogle() {
		try {
			PaginaWeb pw1 = new PaginaWeb("www.google.com");
			assertEquals("html-Soy Google",pw1.getContenido());
			
		} catch (PaginaWebException e) {
			fail("Esta linea no deberia correrse");
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
	}
	
	@Test
	void testPaginaWeb_ContenidoCorrectoResto() {
		try {
			PaginaWeb pw1 = new PaginaWeb("www.CualquierOtraCosa.com");
			assertEquals("html-404 Not Found",pw1.getContenido());
			
		} catch (PaginaWebException e) {
			fail("Esta linea no deberia correrse");
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
		
		try {
			PaginaWeb pw1 = new PaginaWeb("www.youtube.com");
			assertEquals("html-404 Not Found",pw1.getContenido());
			
		} catch (PaginaWebException e) {
			fail("Esta linea no deberia correrse");
			
		} catch (Exception e) {
			fail("Esta excepcion no deberia correrse");
		}
		
	}
	
}