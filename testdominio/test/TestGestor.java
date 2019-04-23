package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dominio.GestorPaginaWeb;
import dominio.PaginaWeb;
import excepciones.PaginaWebException;

class TestGestor {

	@Test
	void testSoySingleton() {
		GestorPaginaWeb gpw1 = GestorPaginaWeb.getInstancia();
		GestorPaginaWeb gpw2 = GestorPaginaWeb.getInstancia();
		assertEquals(true,gpw1.equals(gpw2));
		assertEquals(true,gpw1==gpw2);
	}
	
	@Test
	void testBuscarContenido_UNdeC() {
		try {
			PaginaWeb pw = new PaginaWeb("www.undec.com");
			assertEquals(true,pw.equals(GestorPaginaWeb.getInstancia().traerPagina("www.undec.com")));
			
		} catch (PaginaWebException e) {
			fail("Esta Excepcion no deberia correrse");
		} 
		catch (Exception e) {
			fail("Esta Excepcion no deberia correrse");
		}
	}
	
	@Test
	void testBuscarPagina_Google() {
		try {
			PaginaWeb pw = new PaginaWeb("www.google.com");
			assertEquals(true,pw.equals(GestorPaginaWeb.getInstancia().traerPagina("www.google.com")));
			
		} catch (PaginaWebException e) {
			fail("Esta Excepcion no deberia correrse");
		} catch (Exception e) {
			fail("Esta Excepcion no deberia correrse");
		}
	}
	
	@Test
	void testBuscarPagina_RestoUrl() {
		try {
			PaginaWeb pw = new PaginaWeb("www.youtube.com");
			assertEquals(true,pw.equals(GestorPaginaWeb.getInstancia().traerPagina("www.youtube.com")));
			
		} catch (PaginaWebException e) {
			fail("Esta Excepcion no deberia correrse");
		} catch (Exception e) {
			fail("Esta Excepcion no deberia correrse");
		}
	}
	
	@Test
	void testBuscarPagina_SinPagina() {	
		try {
			GestorPaginaWeb.getInstancia().traerPagina("");
			
		} catch (PaginaWebException e) {
			assertEquals("Not a Page",e.getMessage());
		} catch (Exception e) {
			fail("Esta Excepcion no deberia correrse");
		}
	}

	@Test
	void testNavegacion_Atras() {
		try {
			GestorPaginaWeb.getInstancia().limpiarHistorial();
			
			PaginaWeb pw1 = new PaginaWeb("www.undec.com");
			PaginaWeb pw2 = new PaginaWeb("www.google.com");
			PaginaWeb pw3 = new PaginaWeb("www.youtube.com");
			
			GestorPaginaWeb.getInstancia().traerPagina("www.undec.com");
			GestorPaginaWeb.getInstancia().traerPagina("www.google.com");
			GestorPaginaWeb.getInstancia().traerPagina("www.youtube.com");
			
			assertEquals(pw2,GestorPaginaWeb.getInstancia().traerPaginaAnterior());
			assertEquals(pw1,GestorPaginaWeb.getInstancia().traerPaginaAnterior());
			
		} catch (PaginaWebException e) {
			fail("Esta Excepcion no deberia correrse");
		} catch (Exception e) {
			fail("Esta Excepcion no deberia correrse");
		}
	}
	
	@Test
	void testNavegacion_Adelante() {
		try {
			GestorPaginaWeb.getInstancia().limpiarHistorial();
			
			PaginaWeb pw1 = new PaginaWeb("www.undec.com");
			PaginaWeb pw2 = new PaginaWeb("www.google.com");
			PaginaWeb pw3 = new PaginaWeb("www.youtube.com");
			
			GestorPaginaWeb.getInstancia().traerPagina("www.undec.com");
			GestorPaginaWeb.getInstancia().traerPagina("www.google.com");
			GestorPaginaWeb.getInstancia().traerPagina("www.youtube.com");
			
			GestorPaginaWeb.getInstancia().traerPaginaAnterior();
			GestorPaginaWeb.getInstancia().traerPaginaAnterior();
			
			assertEquals(pw2,GestorPaginaWeb.getInstancia().traerPaginaSiguiente());
			assertEquals(pw3,GestorPaginaWeb.getInstancia().traerPaginaSiguiente());
			
		} catch (PaginaWebException e) {
			fail("Esta Excepcion no deberia correrse");
		} catch (Exception e) {
			fail("Esta Excepcion no deberia correrse");
		}
	}

}
