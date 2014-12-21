package algo3.algocity.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import algo3.algocity.model.RegistroUsuarios;
import algo3.algocity.model.excepciones.NoSeEncontroElFicheroException;
import algo3.algocity.model.excepciones.NombreDeUsuarioYaExisteException;
import algo3.algocity.view.VentanaInicial;

public class AccionMouseCrearJugadorNuevo implements ActionListener {

	VentanaInicial ventanaPortadora;
	String nombreIngresado;
	JTextField panelInforme;
	
	
	
	public AccionMouseCrearJugadorNuevo(VentanaInicial ventanaPortadora,
			String nombre, JTextField panelInforme) {
		this.ventanaPortadora = ventanaPortadora;
		this.nombreIngresado = nombre;
		this.panelInforme = panelInforme;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			RegistroUsuarios ru = new RegistroUsuarios();
			try {
				if(ru.existeNombreUsuario(nombreIngresado)){
					panelInforme.setText("Jugador ya existente. Ingrese otro");
				}else{
					if(!ru.crearUsuario(nombreIngresado)){
						panelInforme.setText("El nombre de jugador debe contener al menos 4 caracteres");
					}
				}
				
			} catch (NombreDeUsuarioYaExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} catch (NoSeEncontroElFicheroException e) {
			e.printStackTrace();
		}

	}

}
