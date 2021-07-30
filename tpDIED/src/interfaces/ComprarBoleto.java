package interfaces;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dominio.Estacion;
import gestores.GestorBoletos;
import gestores.GestorEstacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ComprarBoleto {

	JFrame frmComprarBoleto;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ComprarBoleto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmComprarBoleto = new JFrame();
		frmComprarBoleto.setTitle("Comprar Boleto");
		frmComprarBoleto.setBounds(100, 100, 550, 431);
		frmComprarBoleto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComprarBoleto.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ORIGEN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(58, 5, 60, 15);
		frmComprarBoleto.getContentPane().add(lblNewLabel);
		
		JLabel lblDestino = new JLabel("DESTINO");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDestino.setBounds(360, 5, 60, 15);
		frmComprarBoleto.getContentPane().add(lblDestino);
		
		JComboBox comboBoxOrigen = new JComboBox();
		ArrayList<Estacion> estaciones= GestorEstacion.buscarTodasLasEstaciones();
		for(Estacion d:estaciones) {
			comboBoxOrigen.addItem(d);
		}
		comboBoxOrigen.setSelectedItem(null);
		comboBoxOrigen.setBounds(58, 22, 134, 22);
		frmComprarBoleto.getContentPane().add(comboBoxOrigen);
		
		JComboBox comboBoxDestino = new JComboBox();
		ArrayList<Estacion> estaciones2= GestorEstacion.buscarTodasLasEstaciones();
		for(Estacion d:estaciones2) {
			comboBoxDestino.addItem(d);
		}
		comboBoxDestino.setSelectedItem(null);
		comboBoxDestino.setBounds(360, 22, 134, 22);
		frmComprarBoleto.getContentPane().add(comboBoxDestino);
		
		
		JRadioButton botonSeleccionCamino = new JRadioButton("Seleccionar camino mas rapido");
		botonSeleccionCamino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonSeleccionCamino.setBounds(41, 270, 254, 23);
		frmComprarBoleto.getContentPane().add(botonSeleccionCamino);
		
		JRadioButton rdbtnSeleccionarCaminoDe = new JRadioButton("Seleccionar camino de menor distancia");
		rdbtnSeleccionarCaminoDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSeleccionarCaminoDe.setBounds(41, 295, 254, 23);
		frmComprarBoleto.getContentPane().add(rdbtnSeleccionarCaminoDe);
		
		JRadioButton rdbtnSeleccionarCaminoMas = new JRadioButton("Seleccionar camino mas barato");
		rdbtnSeleccionarCaminoMas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSeleccionarCaminoMas.setBounds(41, 320, 254, 23);
		frmComprarBoleto.getContentPane().add(rdbtnSeleccionarCaminoMas);
		
		botonSeleccionCamino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(botonSeleccionCamino.isSelected()) {
					rdbtnSeleccionarCaminoDe.setSelected(false);
					rdbtnSeleccionarCaminoMas.setSelected(false);
				}
			}
		});
		rdbtnSeleccionarCaminoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnSeleccionarCaminoDe.isSelected()) {
					botonSeleccionCamino.setSelected(false);
					rdbtnSeleccionarCaminoMas.setSelected(false);
				}
			}
		});
		rdbtnSeleccionarCaminoMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnSeleccionarCaminoMas.isSelected()) {
					rdbtnSeleccionarCaminoDe.setSelected(false);
					botonSeleccionCamino.setSelected(false);
				}
			}
		});
		
		JButton actualizarOriDes = new JButton("VER MAPA");
		actualizarOriDes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		actualizarOriDes.setBounds(407, 50, 87, 29);
		frmComprarBoleto.getContentPane().add(actualizarOriDes);
		
		JButton btnComprarBoleto = new JButton("Comprar Boleto");
		btnComprarBoleto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnComprarBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(botonSeleccionCamino.isSelected()) {
					Integer auxId = GestorEstacion.getIdEstacionByNombre((comboBoxOrigen.getSelectedItem().toString()));
					Integer auxId2 = GestorEstacion.getIdEstacionByNombre((comboBoxDestino.getSelectedItem().toString()));
					GestorBoletos.guardarBoleto((GestorBoletos.generarBoletoRutaMenosTiempo(auxId, auxId2, 1)));
					
				    JOptionPane.showMessageDialog(null, "Has comprado Boleto mas rapido desde: "+(comboBoxOrigen.getSelectedItem().toString())+" hasta: "+(comboBoxDestino.getSelectedItem().toString()));
					
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
					frmComprarBoleto.dispose();
				} else if(rdbtnSeleccionarCaminoMas.isSelected()) {
					Integer auxId = GestorEstacion.getIdEstacionByNombre((comboBoxOrigen.getSelectedItem().toString()));
					Integer auxId2 = GestorEstacion.getIdEstacionByNombre((comboBoxDestino.getSelectedItem().toString()));
					GestorBoletos.guardarBoleto((GestorBoletos.generarBoletoRutaMasBarata(auxId, auxId2, 1)));
					JOptionPane.showMessageDialog(null, "Has comprado Boleto mas barato desde: "+(comboBoxOrigen.getSelectedItem().toString())+
							" hasta: "+(comboBoxDestino.getSelectedItem().toString()));
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
					frmComprarBoleto.dispose();
				}else if(rdbtnSeleccionarCaminoDe.isSelected()) {
					Integer auxId = GestorEstacion.getIdEstacionByNombre((comboBoxOrigen.getSelectedItem().toString()));
					Integer auxId2 = GestorEstacion.getIdEstacionByNombre((comboBoxDestino.getSelectedItem().toString()));
					GestorBoletos.guardarBoleto((GestorBoletos.generarBoletoRutaMasCorta(auxId, auxId2, 1)));
					JOptionPane.showMessageDialog(null, "Has comprado Boleto por ruta mas corta desde: "+(comboBoxOrigen.getSelectedItem().toString())+
							" hasta: "+(comboBoxDestino.getSelectedItem().toString()));
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
					frmComprarBoleto.dispose();
				}
				
			
			
		}});
		btnComprarBoleto.setBounds(360, 355, 126, 29);
		frmComprarBoleto.getContentPane().add(btnComprarBoleto);
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtras.addActionListener(new ActionListener() {
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
				frmComprarBoleto.dispose();
			}
		});
		btnAtras.setBounds(10, 354, 126, 29);
		frmComprarBoleto.getContentPane().add(btnAtras);
	
	
		
	}
}
