package interfaces;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import dominio.Estacion;
import dominio.LineaTransporte;
import dto.LineaTransporteDTO;
import estructuras.Ruta;
import gestores.GestorEstacion;
import gestores.GestorLineaTransporte;
import gestores.GestorRuta;


public class LineasDeTransporte {

	private JFrame frame;
	private JTextField textFieldID;
	private JTextField textFieldNOMBRE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LineasDeTransporte window = new LineasDeTransporte();
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
	public LineasDeTransporte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 780, 425);
		frame.setTitle("Ver Lineas De Transporte");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelEstado.setBounds(10, 22, 752, 138);
		frame.getContentPane().add(panelEstado);
		panelEstado.setLayout(null);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(157, 11, 182, 20);
		panelEstado.add(textFieldID);
		textFieldID.setColumns(10);
		
		JComboBox<String> estado = new JComboBox<String>();
		estado.addItem(null);
		estado.addItem("Activa");
		estado.addItem("NoActiva");
		
		estado.setSelectedItem(null);
		estado.setBounds(157, 64, 137, 22);
		panelEstado.add(estado);
	
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(641, 110, 101, 23);
		panelEstado.add(btnNewButton);
		
		JTextPane txtpnIdEstacion = new JTextPane();
		txtpnIdEstacion.setText("Id Linea:");
		txtpnIdEstacion.setBounds(10, 11, 137, 20);
		txtpnIdEstacion.setEditable(false);
		panelEstado.add(txtpnIdEstacion);
		
		JTextPane txtNombreEstacion = new JTextPane();
		txtNombreEstacion.setText("Nombre Linea:");
		txtNombreEstacion.setBounds(10, 35, 137, 20);
		txtNombreEstacion.setEditable(false);
		panelEstado.add(txtNombreEstacion);
		
		ArrayList<Estacion> estaciones= GestorEstacion.buscarTodasLasEstaciones();
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(350, 30, 395, 80);
		
		frame.getContentPane().add(scrollPane1);
		 JPanel panelEstaciones = new JPanel();
		 panelEstaciones.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelEstaciones.setPreferredSize(new Dimension(360, 35*estaciones.size()));
			panelEstaciones.setLayout(null);
		panelEstaciones.setAutoscrolls(true);
		scrollPane1.setViewportView(panelEstaciones);
		panelEstado.add(scrollPane1);
	
		ArrayList<JCheckBox> checkEstacion=new ArrayList<JCheckBox>();
		ArrayList<Integer> trayecto= new ArrayList<Integer>();
		int posicionX=0;
		int posicionY=0;
		for(int i=0;i<estaciones.size();i++) {
			int aux=i;
		checkEstacion.add(new JCheckBox(estaciones.get(i).getNombre()));
		checkEstacion.get(i).setEnabled(true);
		checkEstacion.get(i).setBounds(10+posicionX, 11+posicionY, 85, 14);
		panelEstaciones.add(checkEstacion.get(i));
		
		posicionX+=90;
		if(posicionX>350) {
			posicionX=0;
			posicionY+=30;
		}
	checkEstacion.get(i).addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				Integer aux2=GestorEstacion.getIdEstacionByNombre(checkEstacion.get(aux).getText().toString());
				if(checkEstacion.get(aux).isSelected()) {
				trayecto.add(aux2);
				System.out.println(trayecto);
				}
				else {
					if(trayecto.contains(aux2)) {
						trayecto.remove(aux2);
						System.out.println(trayecto);
					}
				}
			}});
	
		
		}
		
		JTextPane txtpnTrayectoria = new JTextPane();
		txtpnTrayectoria.setText("Trayectoria:");
		txtpnTrayectoria.setBounds(349, 11, 110, 20);
		txtpnTrayectoria.setEditable(false);
		panelEstado.add(txtpnTrayectoria);
		
		textFieldNOMBRE = new JTextField();
		textFieldNOMBRE.setColumns(10);
		textFieldNOMBRE.setBounds(157, 35, 182, 20);
		panelEstado.add(textFieldNOMBRE);
		
		JTextPane txtpnColor = new JTextPane();
		txtpnColor.setText("Color: ");
		txtpnColor.setBounds(10, 97, 137, 20);
		txtpnColor.setEditable(false);
		panelEstado.add(txtpnColor);
		
		JTextPane txtpnEstado = new JTextPane();
		txtpnEstado.setText("Estado:");
		txtpnEstado.setBounds(10, 66, 137, 20);
		txtpnEstado.setEditable(false);
		panelEstado.add(txtpnEstado);
		
		JComboBox<String> color = new JComboBox<String>();
		color.addItem(null);
		color.addItem("Azul");
		color.addItem("Amarillo");
		color.addItem("Verde");
		color.addItem("Naranja");
		color.addItem("Negro");
		color.setSelectedItem(null);
		color.setBounds(157, 94, 137, 22);
		panelEstado.add(color);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 177, 752, 169);
		frame.getContentPane().add(scrollPane);
		 
		class Auxiliar implements ActionListener{
		
			String n;
			String es;
			String id;
			String col;
			
			ArrayList<LineaTransporteDTO> lineas;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				this.id="all";
				this.n="all";
				this.es="all";
				this.col="all";
			
				
				if(!textFieldID.getText().isEmpty()) {
					System.out.println(textFieldID.getText()+"<-");
			    	 id=textFieldID.getText().toLowerCase();
			     
				}
				
				if(!textFieldNOMBRE.getText().isEmpty()) {
					System.out.println(textFieldNOMBRE.getText()+"<-");
			    	 n=textFieldNOMBRE.getText().toLowerCase();
				}
				
			     if(estado.getSelectedItem()!=null) {
			    	 es=estado.getSelectedItem().toString();
			     }
			     
			     if(!trayecto.isEmpty()) {
						System.out.println(trayecto+"<-");
				    	
					}
			     
			     if(color.getSelectedItem()!=null) {
			    	 col=color.getSelectedItem().toString().toLowerCase();
			     }
				
				System.out.println("-"+id+"-"+n+"-"+es+"-"+col+"-");

                lineas=GestorLineaTransporte.buscarlineast(n, es, col, id,trayecto);   // falta filtrar por trayecto
            	
			
				int cantidad=lineas.size(); //Setear la cantidad de resultados encontrados en la busqueda
				int contador=0;
				int agregadoY=0;
				 JPanel panelResultados = new JPanel();
				 panelResultados.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					panelResultados.setPreferredSize(new Dimension(360, 35*cantidad));
					panelResultados.setLayout(null);
				panelResultados.setAutoscrolls(true);
				scrollPane.setViewportView(panelResultados);
				ArrayList<JLabel> labelsID=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsNombre=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsTrayectoria=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsColor=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsEstado=new ArrayList<JLabel>();
				
				ArrayList<JTextField> ID2=new ArrayList<JTextField>();
				 ArrayList<JTextField> Nombre2=new ArrayList<JTextField>();
				 ArrayList<JTextField> Trayectoria2=new ArrayList<JTextField>();
				 ArrayList<JTextField> Color2=new ArrayList<JTextField>();
				 ArrayList<JTextField> Estado2=new ArrayList<JTextField>();
				 ArrayList<JButton>  RegTrayecto=new ArrayList<JButton>();
				 ArrayList<JButton>  Editar=new ArrayList<JButton>();
				 ArrayList<JButton>  DarDeBaja=new ArrayList<JButton>();
				
				
				labelsID.add(new JLabel("ID"));
				labelsNombre.add(new JLabel("Nombre"));
				labelsTrayectoria.add(new JLabel("Trayectoria"));
				labelsColor.add(new JLabel("Color"));
				labelsEstado.add(new JLabel("Estado"));
				RegTrayecto.add(new JButton("RegTrayecto"));
				Editar.add(new JButton("Editar"));
				DarDeBaja.add(new JButton("Dar de Baja"));
				
				labelsID.get(contador).setBounds(10, 11, 85, 14);
				panelResultados.add(labelsID.get(contador));
				labelsNombre.get(contador).setBounds(30, 11, 46, 14);
				panelResultados.add(labelsNombre.get(contador));
				labelsTrayectoria.get(contador).setBounds(150, 11, 85, 14);
				panelResultados.add(labelsTrayectoria.get(contador));
				labelsColor.get(contador).setBounds(255, 11, 85, 14);
				panelResultados.add(labelsColor.get(contador));
				labelsEstado.get(contador).setBounds(345, 11, 63, 14);
				panelResultados.add(labelsEstado.get(contador));
				
				while(cantidad>contador) {
					int contadorAux=contador;
					
			
					ID2.add(new JTextField());
					ID2.get(contador).setBounds(10, 41+agregadoY, 20, 20);
					ID2.get(contador).setEditable(false);
					ID2.get(contador).setText(lineas.get(contador).getIdLinea().toString());
					panelResultados.add(ID2.get(contador));
					
					Nombre2.add(new JTextField());
					Nombre2.get(contador).setBounds(32, 41+agregadoY, 110, 20);
					Nombre2.get(contador).setEditable(false);
					Nombre2.get(contador).setText(lineas.get(contador).getNombre());
					panelResultados.add(Nombre2.get(contador));
					
					Color2.add(new JTextField());
					Color2.get(contador).setBounds(255, 41+agregadoY, 85, 20);
					Color2.get(contador).setEditable(false);
					Color2.get(contador).setText(lineas.get(contador).getColor());
					panelResultados.add(Color2.get(contador));
					
					
					Trayectoria2.add(new JTextField());
					Trayectoria2.get(contador).setBounds(150, 41+agregadoY, 100, 20);
					Trayectoria2.get(contador).setEditable(false);
					ArrayList<Ruta<Estacion>> rutas2=GestorRuta.buscarTodasLasRutas();
					ArrayList<Integer> mostrar=new ArrayList<Integer>();
					for(int i=0;i<rutas2.size();i++) {
																									
						if(rutas2.get(i).getLineaTransporte().getIdLinea()!=lineas.get(contador).getIdLinea()) {
							rutas2.remove(i);
						}
						else {
							mostrar.add(rutas2.get(i).getOrigen().getValor().getId());
							mostrar.add(rutas2.get(i).getDestino().getValor().getId());}
						}
					
					Trayectoria2.get(contador).setText(mostrar.stream().distinct().collect(Collectors.toList()).toString()); 
					panelResultados.add(Trayectoria2.get(contador));  
					
					Estado2.add(new JTextField());
					Estado2.get(contador).setBounds(343, 41+agregadoY, 110, 20);
					Estado2.get(contador).setEditable(false);
					Estado2.get(contador).setText(lineas.get(contador).getEstadoLinea().toString());        
					panelResultados.add(Estado2.get(contador));
					
					
					RegTrayecto.add(new JButton("RegTrayecto")); 
					RegTrayecto.get(contador).setBounds(450, 41+agregadoY, 96, 20);
		RegTrayecto.get(contador).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
					RegistrarLinea window = new RegistrarLinea(lineas.get(contadorAux).getIdLinea());
					window.getFrame().setVisible(true);        
									} catch (Exception e) {
								e.printStackTrace();
									}
								}
							});
							frame.dispose();
						}
					});   
					panelResultados.add(RegTrayecto.get(contador)); 
					
					Editar.add(new JButton("Editar")); 
					Editar.get(contador).setBounds(547, 41+agregadoY, 100, 20);
		Editar.get(contador).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									EditarLinea window = new EditarLinea(Integer.parseInt(ID2.get(contadorAux).getText()));
				      				window.frmEditarLineaTransporte.setVisible(true);          
									} catch (Exception e) {
								e.printStackTrace();
									}
								}
							});
							frame.dispose();
						}
					});   
					panelResultados.add(Editar.get(contador)); 
					
					DarDeBaja.add(new JButton("Dar de baja")); 
					DarDeBaja.get(contador).setBounds(647, 41+agregadoY, 100, 20);
				DarDeBaja.get(contador).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									if(JOptionPane.showConfirmDialog(frame, "¿Esta seguro que desea eliminar la estacion?",
								            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
										
									GestorLineaTransporte.eliminarLineaTransporte(lineas.get(contadorAux));
									LineasDeTransporte window = new LineasDeTransporte();
									window.frame.setVisible(true);
									}
									
									} catch (Exception e) {
								e.printStackTrace();
									}
								}
							});
							frame.dispose();
						}
					}); 
					panelResultados.add(DarDeBaja.get(contador));
					
					
					agregadoY=agregadoY+30;
					contador++;
				}	
			}			 
		}
	     
		 Auxiliar aux= new Auxiliar();
		 btnNewButton.addActionListener(aux);
		 
		
		JButton crearlinea = new JButton("Crear Linea");
		crearlinea.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CrearLinea window = new CrearLinea();
							window.frmCrearLineaTransporte.setVisible(true);   
						} catch (Exception e) {
					e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		}); 
		crearlinea.setBounds(573, 357, 158, 23);
		frame.getContentPane().add(crearlinea);
		
		JButton regresar = new JButton("Regresar");
			regresar.addActionListener(new ActionListener() {
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
				frame.dispose();
			}
		}); 
		regresar.setBounds(10, 357, 126, 23);
		frame.getContentPane().add(regresar);
		
		JTextPane txtpnResultadoDeBusqueda = new JTextPane();
		txtpnResultadoDeBusqueda.setEditable(false);
		txtpnResultadoDeBusqueda.setText("Resultado de Busqueda");
		txtpnResultadoDeBusqueda.setBounds(10, 161, 244, 20);
		frame.getContentPane().add(txtpnResultadoDeBusqueda);
		
		
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
