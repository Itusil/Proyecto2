package gui;
import domain.*;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.*;
public class WindowTable extends JFrame{
	private User user;
	private JTable tabla;
	public WindowTable(User user){
		super("Apuestas realizadas por "+ user.getNombreUsuario()+":");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lo a�ado porque sino en la prueba se quedaba abierto pese a cerrar la ventana
		this.setBounds(100, 100, 700, 200);
		this.user = user;
		UserAdapter adapt = new UserAdapter(user);
		tabla = new JTable(adapt);
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(tabla);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}