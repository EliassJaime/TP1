package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dominio.Estacion;
import gestores.GestorEstacion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Estaciones");
		btnNewButton.setBounds(168, 21, 162, 51);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Estaciones window = new Estaciones();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		});
		
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnLineaDeTransporte = new JButton("Linea de Transporte");
		btnLineaDeTransporte.setBounds(168, 83, 162, 51);
		btnLineaDeTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LineasDeTransporte window = new LineasDeTransporte();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnLineaDeTransporte);
		
		JButton btnVentaBoleto = new JButton("Venta Boleto");
		btnVentaBoleto.setBounds(168, 145, 162, 51);
		btnVentaBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ComprarBoleto window = new ComprarBoleto();
							window.frmComprarBoleto.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnVentaBoleto);
		
		JButton btnFlujoMaximo = new JButton("Flujo Maximo");
		btnFlujoMaximo.setBounds(10, 218, 170, 33);
		btnFlujoMaximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FlujoMax window = new FlujoMax();
							window.frameFlujoMax.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnFlujoMaximo);
		
		JButton btnPageRank = new JButton("Page Rank");
		btnPageRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null,GestorEstacion.obtenerPageRank());
			}
		});
		btnPageRank.setBounds(10, 267, 170, 33);
		frame.getContentPane().add(btnPageRank);
		
		JButton btnProximoMantenimiento = new JButton("Proximo Mantenimiento");
		btnProximoMantenimiento.setBounds(10, 317, 170, 33);
		frame.getContentPane().add(btnProximoMantenimiento);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(JOptionPane.showConfirmDialog(frame, "¿Esta seguro que desea salir?",
					            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
						frame.setVisible(false);
					}
				
			}
		});
		btnSalir.setBounds(421, 348, 103, 33);
		frame.getContentPane().add(btnSalir);
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
