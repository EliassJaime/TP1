package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import dominio.Estacion;
import gestores.GestorEstacion;

import javax.swing.JComboBox;
import javax.swing.JLabel;
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
				
			List<List<String>> aux1 = GestorEstacion.flujoMaximoGestor(GestorEstacion.getEstacionById(auxId), 
									GestorEstacion.getEstacionById(auxId2));
				
			int cantidad=aux1.size(); //Setear la cantidad de resultados encontrados en la busqueda
			int contador=0;
			int agregadoY=0;
			int agregadoX=0;
			int dimX=0;
			for(List<String> d:aux1 ) {
				
				if(dimX<d.size()) {
					dimX=d.size();
				}
				}
			
			JPanel panelResultados = new JPanel();
		    panelResultados.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelResultados.setPreferredSize(new Dimension(150*dimX, 25*cantidad*5));
			panelResultados.setLayout(null);
			panelResultados.setAutoscrolls(true);
			scrollPane.setViewportView(panelResultados);
		
			ArrayList<JLabel> detalle=new ArrayList<JLabel>();
			ArrayList<JLabel> nro=new ArrayList<JLabel>();
			ArrayList<JTextField> prueba=new ArrayList<JTextField>();
			
			System.out.println(aux1);
				Integer nro1=0;
				for(List<String> d:aux1 ) {
					
					nro.add(new JLabel());
					nro.get(nro1).setBounds(10, 15+agregadoY, 10, 20);
				    nro.get(nro1).setText(nro1.toString());
					panelResultados.add(nro.get(nro1));
					
					for(int i=0;i<d.size();i++) {

						prueba.add(new JTextField());
						prueba.get(contador).setBounds(30+agregadoX, 15+agregadoY, 100, 20);
						prueba.get(contador).setEditable(false);
						prueba.get(contador).setText(d.get(i).toString());
						panelResultados.add(prueba.get(contador));
						
						detalle.add(new JLabel());
						detalle.get(contador).setBounds(135+agregadoX, 15+agregadoY, 50, 20);
						detalle.get(contador).setText("---->");
						panelResultados.add(detalle.get(contador));
					if(i==d.size()-1) {
						detalle.get(contador).setVisible(false);
						}
					
						
						agregadoX+=150;
						contador++;
					}
					agregadoX=0;
					agregadoY=agregadoY+30;
					nro1++;
				}}
		});
	
	}
}
