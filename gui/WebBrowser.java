import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import dominio.GestorPaginaWeb;
import dominio.PaginaWeb;
import excepciones.PaginaWebException;

import javax.swing.*;

@SuppressWarnings("serial")
public class WebBrowser extends JFrame {
	JButton btnAtras;
	JButton btnAdelante;
	JTextField txtBusqueda;
	JButton btnBuscar;
	JLabel lblContenido;
	JLabel lblBarraDeEstado;
		
	public WebBrowser() {
		super("Web Browser");
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new WebBrowser();
	}	
	
}
