package interfaces;



import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import dominio.Estacion;
import estructuras.Grafo;
import estructuras.Ruta;
import estructuras.Vertice;
import gestores.GestorBoletos;
import gestores.GestorEstacion;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;



public class ComprarBoleto {

	JFrame frmComprarBoleto;
	int x=150;
	int y=150;
	int ancho=30;
	int alto=30;
	public ArrayList<Integer> xvs;
	public ArrayList<Integer> yvs;
	public ArrayList<Grafo> vgrafos;
	int indice=0;

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
		frmComprarBoleto.setBounds(100, 100, 681, 620);
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
		
		
		JRadioButton caminoRapido = new JRadioButton("Seleccionar camino mas rapido");
		caminoRapido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		caminoRapido.setBounds(41, 459, 254, 23);
		frmComprarBoleto.getContentPane().add(caminoRapido);
		
		JRadioButton caminoMenorDis = new JRadioButton("Seleccionar camino de menor distancia");
		caminoMenorDis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		caminoMenorDis.setBounds(41, 485, 254, 23);
		frmComprarBoleto.getContentPane().add(caminoMenorDis);
		
		JRadioButton caminoBarato = new JRadioButton("Seleccionar camino mas barato");
		caminoBarato.setFont(new Font("Tahoma", Font.PLAIN, 12));
		caminoBarato.setBounds(41, 511, 254, 23);
		frmComprarBoleto.getContentPane().add(caminoBarato);
		
		
	/*if(caminoBarato.isSelected()) {
		vertices=Grafo.getInstance().caminoMinimoCosto(origen, destino);
		
		}
		if(caminoMenorDis.isSelected()) {
		vertices=Grafo.getInstance().caminoMinimoDistancia(origen, destino);
		}
		if(caminoRapido.isSelected()) {
		vertices=Grafo.getInstance().caminoMinimoDuracion(origen, destino);
		}*/

		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
	 	 scrollPane.setBounds(10, 81, 645, 371);
	 	frmComprarBoleto.getContentPane().add(scrollPane);
	 	
	 	
	//	List<List<String>> aux1 = GestorEstacion.flujoMaximoGestor(GestorEstacion.getEstacionById(auxId), 
		//						GestorEstacion.getEstacionById(auxId2));
		
		//vertices=(ArrayList<Vertice>) vertices.subList(2, vertices.size()-1);
		class Auxiliar extends JApplet{
			 
			 PanelDibujo pd;
			 
			 public void init(List<Estacion> vertices){
		
				 
				
			  pd=new PanelDibujo();
			  pd.setLayout(null);
			  pd.setAutoscrolls(true);
			  scrollPane.setViewportView(pd);

			     try{
			      pd.setVgrafos(vertices);
			      pd.repaint();
			      repaint();
			     
			     }catch(NumberFormatException ne){
			      JOptionPane.showMessageDialog(null, "Digite un numero valido");
			     }
			
			 }
			 public void init(List<Ruta<Estacion>> verticeaux,Color c){
				 try{
				      pd.setColor(verticeaux,c);
				      pd.repaint();
				      repaint();
				     
				     }catch(NumberFormatException ne){
				      JOptionPane.showMessageDialog(null, "Digite un numero valido");
				     }
				 
			 }
			}
		Auxiliar aux=new Auxiliar();
		
		JButton actualizarOriDes = new JButton("VER MAPA");
		actualizarOriDes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		actualizarOriDes.setBounds(568, 47, 87, 29);
		frmComprarBoleto.getContentPane().add(actualizarOriDes);
		actualizarOriDes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 List<Estacion> vertices=Grafo.getInstance().getEstacions();
				aux.init(vertices);                                               //Grafico los vertices (estaciones)
			}});
		
	
		
		
	 
	 
		caminoRapido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer auxId = GestorEstacion.getIdEstacionByNombre((comboBoxOrigen.getSelectedItem().toString()));
				Integer auxId2 = GestorEstacion.getIdEstacionByNombre((comboBoxDestino.getSelectedItem().toString()));
			Estacion origen=GestorEstacion.getEstacionById(auxId);
			Estacion destino=GestorEstacion.getEstacionById(auxId2);
				List<Ruta<Estacion>> verticeaux=new ArrayList<Ruta<Estacion>>();
				if(caminoRapido.isSelected()) {
					caminoMenorDis.setSelected(false);
					caminoBarato.setSelected(false);
					verticeaux=Grafo.getInstance().caminoMinimoDuracion(origen, destino);
					
					aux.init(verticeaux,Color.RED);
				}
			}
		});
		
		caminoMenorDis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer auxId = GestorEstacion.getIdEstacionByNombre((comboBoxOrigen.getSelectedItem().toString()));
				Integer auxId2 = GestorEstacion.getIdEstacionByNombre((comboBoxDestino.getSelectedItem().toString()));
			Estacion origen=GestorEstacion.getEstacionById(auxId);
			Estacion destino=GestorEstacion.getEstacionById(auxId2);
				List<Ruta<Estacion>> verticeaux=new ArrayList<Ruta<Estacion>>();
				if(caminoMenorDis.isSelected()) {
					caminoRapido.setSelected(false);
					caminoBarato.setSelected(false);
					verticeaux=Grafo.getInstance().caminoMinimoDistancia(origen, destino);
				System.out.println(verticeaux);
					
					
					aux.init(verticeaux,Color.BLUE);
				}
			}
		});
		
		caminoBarato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer auxId = GestorEstacion.getIdEstacionByNombre((comboBoxOrigen.getSelectedItem().toString()));
				Integer auxId2 = GestorEstacion.getIdEstacionByNombre((comboBoxDestino.getSelectedItem().toString()));
			Estacion origen=GestorEstacion.getEstacionById(auxId);
			Estacion destino=GestorEstacion.getEstacionById(auxId2);
				List<Ruta<Estacion>> verticeaux=new ArrayList<Ruta<Estacion>>();
				if(caminoBarato.isSelected()) {
					caminoMenorDis.setSelected(false);
					caminoRapido.setSelected(false);
					verticeaux=Grafo.getInstance().caminoMinimoCosto(origen, destino);
					
				
					aux.init(verticeaux,Color.GREEN);
				}
			}
		});
		
		JButton btnComprarBoleto = new JButton("Comprar Boleto");
		btnComprarBoleto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnComprarBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(caminoRapido.isSelected()) {
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
				} else if(caminoBarato.isSelected()) {
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
				}else if(caminoMenorDis.isSelected()) {
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
		btnComprarBoleto.setBounds(529, 540, 126, 29);
		frmComprarBoleto.getContentPane().add(btnComprarBoleto);
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		btnAtras.setBounds(10, 541, 126, 29);
		frmComprarBoleto.getContentPane().add(btnAtras);
	
		 	 
		 	 
		 	 
				
			
			
		
		
	
	
		 
}}
