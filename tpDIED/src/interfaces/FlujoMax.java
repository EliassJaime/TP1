package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import dominio.Estacion;
import dominio.LineaTransporte;
import estructuras.Grafo;
import gestores.GestorEstacion;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class FlujoMax {

	JFrame frameFlujoMax;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public FlujoMax() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameFlujoMax = new JFrame();
		frameFlujoMax.setTitle("Flujo Maximo");
		frameFlujoMax.setBounds(100, 100, 550, 431);
		frameFlujoMax.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFlujoMax.getContentPane().setLayout(null);
		
		JLabel lblIngreseOrigen = new JLabel("Ingrese Origen");
		lblIngreseOrigen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseOrigen.setBounds(74, 10, 120, 25);
		frameFlujoMax.getContentPane().add(lblIngreseOrigen);
		
		JLabel lblIngreseDestino = new JLabel("Ingrese Destino");
		lblIngreseDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseDestino.setBounds(364, 11, 120, 25);
		frameFlujoMax.getContentPane().add(lblIngreseDestino);
		
		JComboBox comboBoxOrigen = new JComboBox();
		ArrayList<Estacion> estaciones= GestorEstacion.buscarTodasLasEstaciones();
		for(Estacion d:estaciones) {
			comboBoxOrigen.addItem(d);
		}
		comboBoxOrigen.setSelectedItem(null);
		comboBoxOrigen.setBounds(51, 62, 164, 30);
		frameFlujoMax.getContentPane().add(comboBoxOrigen);
		
		JComboBox comboBoxDestino = new JComboBox();
		ArrayList<Estacion> estaciones2= GestorEstacion.buscarTodasLasEstaciones();
		for(Estacion d:estaciones2) {
			comboBoxDestino.addItem(d);
		}
		comboBoxDestino.setSelectedItem(null);
		comboBoxDestino.setBounds(339, 62, 164, 30);
		frameFlujoMax.getContentPane().add(comboBoxDestino);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(350, 350, 80, 30);
		frameFlujoMax.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.setBounds(50, 350, 80, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Principal window = new Principal();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frameFlujoMax.dispose();}
			});
		
		frameFlujoMax.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 129, 452, 199);

		frameFlujoMax.getContentPane().add(scrollPane);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer auxId = GestorEstacion.getIdEstacionByNombre((comboBoxOrigen.getSelectedItem().toString()));
				Integer auxId2 = GestorEstacion.getIdEstacionByNombre((comboBoxDestino.getSelectedItem().toString()));
				
				
				//JOptionPane.showMessageDialog(null,GestorEstacion.flujoMaximoGestor(GestorEstacion.getEstacionById(auxId), 
						//GestorEstacion.getEstacionById(auxId2)));
				
				
				List<List<String>> aux1 = GestorEstacion.flujoMaximoGestor(GestorEstacion.getEstacionById(auxId), 
						GestorEstacion.getEstacionById(auxId2));
				
				int cantidad=aux1.size(); //Setear la cantidad de resultados encontrados en la busqueda
				int contador=0;
				int agregadoY=0;
				
				JPanel panelResultados = new JPanel();
				 panelResultados.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					panelResultados.setPreferredSize(new Dimension(360, 25*cantidad*5));
					panelResultados.setLayout(null);
				panelResultados.setAutoscrolls(true);
				scrollPane.setViewportView(panelResultados);

				
				ArrayList<JTextField> prueba=new ArrayList<JTextField>();
				
				
				for(List<String> d:aux1 ) {
					for(String auxxx:d) {
						System.out.println(auxxx);
						prueba.add(new JTextField());
						prueba.get(contador).setBounds(10, 21+agregadoY, 100, 20);
						prueba.get(contador).setEditable(false);
						prueba.get(contador).setText(auxxx);
						panelResultados.add(prueba.get(contador));
						
						agregadoY=agregadoY+30;
						contador++;
						
					}
				}
				
				//frameFlujoMax.getContentPane().add(scrollPane);
			}
		});
	
	}
}
