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

import dominio.Boleto;
import dominio.Estacion;
import estructuras.Grafo;
import estructuras.Ruta;
import estructuras.Vertice;
import gestores.GestorBoletos;
import gestores.GestorCliente;
import gestores.GestorEstacion;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JTextField textFieldNombre;
	private JTextField textFieldCorreo;
	public Boleto bol=null;
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
		frmComprarBoleto.setBounds(100, 30, 693, 700);
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
	
		comboBoxOrigen.setBounds(58, 22, 134, 22);
		frmComprarBoleto.getContentPane().add(comboBoxOrigen);
		
		JComboBox comboBoxDestino = new JComboBox();
		ArrayList<Estacion> estaciones2= GestorEstacion.buscarTodasLasEstaciones();
		for(Estacion d:estaciones2) {
			comboBoxDestino.addItem(d);
		}

		comboBoxDestino.setBounds(360, 22, 134, 22);
		frmComprarBoleto.getContentPane().add(comboBoxDestino);
		
		
		JRadioButton caminoRapido = new JRadioButton("Seleccionar camino mas rapido");
		caminoRapido.setEnabled(false);
		caminoRapido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		caminoRapido.setBounds(10, 536, 254, 23);
		
		frmComprarBoleto.getContentPane().add(caminoRapido);
		
		JRadioButton caminoMenorDis = new JRadioButton("Seleccionar camino de menor distancia");
		caminoMenorDis.setEnabled(false);
		caminoMenorDis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		caminoMenorDis.setBounds(10, 562, 254, 23);
		
		frmComprarBoleto.getContentPane().add(caminoMenorDis);
		
		JRadioButton caminoBarato = new JRadioButton("Seleccionar camino mas barato");
		caminoBarato.setEnabled(false);
		caminoBarato.setFont(new Font("Tahoma", Font.PLAIN, 12));
		caminoBarato.setBounds(10, 588, 254, 23);
		
		frmComprarBoleto.getContentPane().add(caminoBarato);
		caminoRapido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caminoBarato.setForeground(Color.BLACK);
				caminoMenorDis.setForeground(Color.BLACK);
				caminoRapido.setForeground(Color.BLACK);
			}});
		caminoMenorDis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caminoBarato.setForeground(Color.BLACK);
				caminoMenorDis.setForeground(Color.BLACK);
				caminoRapido.setForeground(Color.BLACK);
			}});
		caminoBarato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caminoBarato.setForeground(Color.BLACK);
				caminoMenorDis.setForeground(Color.BLACK);
				caminoRapido.setForeground(Color.BLACK);
			}});
		
		JScrollPane scrollPane = new JScrollPane();
	 	 scrollPane.setBounds(10, 81, 645, 448);
	 	frmComprarBoleto.getContentPane().add(scrollPane);
	 	
	 	
	
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
				      JOptionPane.showMessageDialog(null, "Fallo");
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
				caminoBarato.setEnabled(true);
				caminoMenorDis.setEnabled(true);
				caminoRapido.setEnabled(true);
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
					caminoBarato.setForeground(Color.BLACK);
					caminoMenorDis.setForeground(Color.BLACK);
					caminoRapido.setForeground(Color.BLACK);
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
					caminoBarato.setForeground(Color.BLACK);
					caminoMenorDis.setForeground(Color.BLACK);
					caminoRapido.setForeground(Color.BLACK);
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
					caminoBarato.setForeground(Color.BLACK);
					caminoMenorDis.setForeground(Color.BLACK);
					caminoRapido.setForeground(Color.BLACK);
					caminoMenorDis.setSelected(false);
					caminoRapido.setSelected(false);
					verticeaux=Grafo.getInstance().caminoMinimoCosto(origen, destino);

					aux.init(verticeaux,Color.GREEN);
				}
			}
		});
		
		JLabel lblNombre = new JLabel("(*) Nombre:");
		lblNombre.setBounds(402, 562, 72, 14);
		
		frmComprarBoleto.getContentPane().add(lblNombre);
		
		JLabel lblCorreo = new JLabel("(*) Correo:");
		lblCorreo.setBounds(402, 593, 72, 14);
		frmComprarBoleto.getContentPane().add(lblCorreo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(472, 559, 183, 20);
		textFieldNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNombre.setForeground(Color.BLACK);
			}
		});
		frmComprarBoleto.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(472, 590, 183, 20);
		textFieldCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCorreo.setForeground(Color.BLACK);
			}
		});
		frmComprarBoleto.getContentPane().add(textFieldCorreo);
	
		
		JButton btnComprarBoleto = new JButton("Comprar Boleto");
		btnComprarBoleto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnComprarBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean ok=true;
				if(textFieldNombre.getText().isEmpty()) {
					lblNombre.setForeground(Color.RED);
					ok=false;
				}
				if(textFieldCorreo.getText().isEmpty()) {
					lblCorreo.setForeground(Color.RED);
					ok=false;
				}
				if(!(caminoRapido.isSelected() || caminoBarato.isSelected() || caminoMenorDis.isSelected())) {
					caminoRapido.setForeground(Color.RED);
					caminoBarato.setForeground(Color.RED);
					caminoMenorDis.setForeground(Color.RED);
				}
			
					Integer auxId = GestorEstacion.getIdEstacionByNombre((comboBoxOrigen.getSelectedItem().toString()));
					Integer auxId2 = GestorEstacion.getIdEstacionByNombre((comboBoxDestino.getSelectedItem().toString()));
				Estacion origen=GestorEstacion.getEstacionById(auxId);
				Estacion destino=GestorEstacion.getEstacionById(auxId2);
				List<Ruta<Estacion>> camino=Grafo.getInstance().caminoMinimoCosto(origen, destino);
			
				if(camino.isEmpty()) {
					
					ok=false;
				}
					if(ok) {
						
				if(caminoRapido.isSelected()) {
					
					Integer idCliente = GestorCliente.crearCliente(textFieldNombre.getText(),textFieldCorreo.getText());
					bol=GestorBoletos.generarBoletoRutaMenosTiempo(auxId, auxId2, idCliente);
					GestorBoletos.guardarBoleto(bol);
					
				    JOptionPane.showMessageDialog(null, "Has comprado Boleto mas rapido desde: "+(comboBoxOrigen.getSelectedItem().toString())+" hasta: "+(comboBoxDestino.getSelectedItem().toString()));
					
					
					
				} else if(caminoBarato.isSelected()) {
					Integer idCliente = GestorCliente.crearCliente(textFieldNombre.getText(),textFieldCorreo.getText());
					bol=GestorBoletos.generarBoletoRutaMasBarata(auxId, auxId2, idCliente);
					GestorBoletos.guardarBoleto(bol);
					JOptionPane.showMessageDialog(null, "Has comprado Boleto mas barato desde: "+(comboBoxOrigen.getSelectedItem().toString())+
							" hasta: "+(comboBoxDestino.getSelectedItem().toString()));
					
					
				}else if(caminoMenorDis.isSelected()) {
					Integer idCliente = GestorCliente.crearCliente(textFieldNombre.getText(),textFieldCorreo.getText());
					bol=GestorBoletos.generarBoletoRutaMasCorta(auxId, auxId2, idCliente);
					GestorBoletos.guardarBoleto(bol);
					JOptionPane.showMessageDialog(null, "Has comprado Boleto por ruta mas corta desde: "+(comboBoxOrigen.getSelectedItem().toString())+
							" hasta: "+(comboBoxDestino.getSelectedItem().toString()));
				
				}
				
				EventQueue.invokeLater(new Runnable() {
				
					public void run() {
						try {
							MostrarBoleto window = new MostrarBoleto(bol);
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frmComprarBoleto.dispose();
				}
				else {
					if(camino.isEmpty()) {
					JOptionPane.showMessageDialog(null,"No existe camino desde origen a destino");
				}
					else {
						JOptionPane.showMessageDialog(null,"Debe Completar Todos los Campos (*) y seleccionar un camino");
					}
				}
		}});
		btnComprarBoleto.setBounds(529, 621, 126, 29);	
		JLabel lblNewLabel_2 = new JLabel("Este sistema contempla el estado de rutas y estaciones");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(143, 636, 351, 14);
		frmComprarBoleto.getContentPane().add(lblNewLabel_2);
	
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
		btnAtras.setBounds(10, 621, 126, 29);
		frmComprarBoleto.getContentPane().add(btnAtras);
		
	
		 	 
		 	 
		 	 
				
			
			
		
		
	
	
		 
}	
}
