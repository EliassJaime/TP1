package interfaces;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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
import gestores.GestorEstacion;


public class Estaciones {

	private JFrame frame;
	private JTextField textFieldID;
	private JTextField textFieldNOMBRE;
	private JTextField textFieldHORAAPERTURA;
	private JTextField textFieldHORACIERRE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estaciones window = new Estaciones();
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
	public Estaciones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 433);
		frame.setTitle("Ver Estaciones");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelEstado.setBounds(10, 22, 668, 113);
		frame.getContentPane().add(panelEstado);
		panelEstado.setLayout(null);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(157, 11, 182, 20);
		panelEstado.add(textFieldID);
		textFieldID.setColumns(10);
		
		JComboBox<String> estado = new JComboBox<String>();
		estado.addItem("Operativo");
		estado.addItem("En Mantenimiento");
		estado.setSelectedItem(null);
		estado.setBounds(521, 41, 137, 22);
		panelEstado.add(estado);
	
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(557, 85, 101, 23);
		panelEstado.add(btnNewButton);
		
		JTextPane txtpnIdEstacion = new JTextPane();
		txtpnIdEstacion.setText("Id Estacion:");
		txtpnIdEstacion.setBounds(10, 11, 137, 20);
		txtpnIdEstacion.setEditable(false);
		panelEstado.add(txtpnIdEstacion);
		
		JTextPane txtNombreEstacion = new JTextPane();
		txtNombreEstacion.setText("Nombre Estacion:");
		txtNombreEstacion.setBounds(349, 11, 110, 20);
		txtNombreEstacion.setEditable(false);
		panelEstado.add(txtNombreEstacion);
		
		JTextPane txtpnHoraApertura = new JTextPane();
		txtpnHoraApertura.setText("Horario Apertura");
		txtpnHoraApertura.setBounds(10, 41, 137, 20);
		txtpnHoraApertura.setEditable(false);
		panelEstado.add(txtpnHoraApertura);
		
		textFieldNOMBRE = new JTextField();
		textFieldNOMBRE.setColumns(10);
		textFieldNOMBRE.setBounds(476, 11, 182, 20);
		panelEstado.add(textFieldNOMBRE);
		
		JTextPane txtpnHorarioCierre = new JTextPane();
		txtpnHorarioCierre.setText("Horario Cierre:");
		txtpnHorarioCierre.setBounds(10, 72, 137, 20);
		txtpnHorarioCierre.setEditable(false);
		panelEstado.add(txtpnHorarioCierre);
		
		textFieldHORAAPERTURA = new JTextField();
		textFieldHORAAPERTURA.setColumns(10);
		textFieldHORAAPERTURA.setBounds(157, 42, 182, 20);
		panelEstado.add(textFieldHORAAPERTURA);
		
		textFieldHORACIERRE = new JTextField();
		textFieldHORACIERRE.setColumns(10);
		textFieldHORACIERRE.setBounds(157, 72, 182, 20);
		panelEstado.add(textFieldHORACIERRE);
		
		JTextPane txtpnEstado = new JTextPane();
		txtpnEstado.setText("Estado:");
		txtpnEstado.setBounds(349, 43, 137, 20);
		txtpnEstado.setEditable(false);
		panelEstado.add(txtpnEstado);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 177, 668, 169);
		frame.getContentPane().add(scrollPane);
		 
		class Auxiliar implements ActionListener{
		
			String n;
			String es;
			String id;
			String horarioapertura;
			String horariocierre;
			ArrayList<Estacion> estaciones;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				this.id="all";
				this.n="all";
				this.es="all";
				this.horarioapertura="all";
				this.horariocierre="all";
				
				if(!textFieldID.getText().isEmpty()) {
					System.out.println(textFieldID.getText()+"<-");
			    	 id=textFieldID.getText().toLowerCase();
			     
				}
				
				if(!textFieldNOMBRE.getText().isEmpty()) {
					System.out.println(textFieldNOMBRE.getText()+"<-");
			    	 n=textFieldNOMBRE.getText().toLowerCase();
				}
				
			     if(estado.getSelectedItem()!=null) {
			    	 es=estado.getSelectedItem().toString().toLowerCase();
			     }
			     
			     if(!textFieldHORAAPERTURA.getText().isEmpty()) {
						System.out.println(textFieldHORAAPERTURA.getText()+"<-");
				    	 horarioapertura=textFieldHORAAPERTURA.getText().toLowerCase();
					}
			     
			     if(!textFieldHORACIERRE.getText().isEmpty()) {
						System.out.println(textFieldHORACIERRE.getText()+"<-");
				    	 horariocierre=textFieldHORACIERRE.getText().toLowerCase();
					}
				
				System.out.println("-"+id+n+"-"+es+"-"+horarioapertura+"-"+horariocierre+"-");

estaciones=GestorEstacion.buscarTodasLasEstaciones();       //EJECUTAR FUNCION FILTRO EN GESTOR, HACER FUNCION
		
		
			//	for(CompetenciaDTO c:competencias) {
			//		System.out.println(c.getNombre()+" "+c.getModalidad());
			//	}  
				
				// TODO Auto-generated method stub
				int cantidad=estaciones.size(); //Setear la cantidad de resultados encontrados en la busqueda
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
				ArrayList<JLabel> labelsHoraApertura=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsHoraCierre=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsEstado=new ArrayList<JLabel>();
				
				ArrayList<JTextField> ID2=new ArrayList<JTextField>();
				 ArrayList<JTextField> Nombre2=new ArrayList<JTextField>();
				 ArrayList<JTextField> HoraApertura2=new ArrayList<JTextField>();
				 ArrayList<JTextField> HoraCierre2=new ArrayList<JTextField>();
				 ArrayList<JTextField> Estado2=new ArrayList<JTextField>();
				 ArrayList<JButton>  Editar=new ArrayList<JButton>();
				 ArrayList<JButton>  DarDeBaja=new ArrayList<JButton>();
				
				
				labelsID.add(new JLabel("ID"));
				labelsNombre.add(new JLabel("Nombre"));
				labelsHoraApertura.add(new JLabel("Hora Apertura"));
				labelsHoraCierre.add(new JLabel("Hora Cierre"));
				labelsEstado.add(new JLabel("Estado"));
				Editar.add(new JButton("Editar"));
				DarDeBaja.add(new JButton("Dar de Baja"));
				
				labelsID.get(contador).setBounds(10, 11, 85, 14);
				panelResultados.add(labelsID.get(contador));
				labelsNombre.get(contador).setBounds(30, 11, 46, 14);
				panelResultados.add(labelsNombre.get(contador));
				labelsHoraApertura.get(contador).setBounds(150, 11, 85, 14);
				panelResultados.add(labelsHoraApertura.get(contador));
				labelsHoraCierre.get(contador).setBounds(255, 11, 85, 14);
				panelResultados.add(labelsHoraCierre.get(contador));
				labelsEstado.get(contador).setBounds(345, 11, 63, 14);
				panelResultados.add(labelsEstado.get(contador));
				
				while(cantidad>contador) {
					int contadorAux=contador;
					
					//agregar settext del id de la estacion del resultado de busqueda, igual con nombre, horaapertura,etc/
					ID2.add(new JTextField());
					ID2.get(contador).setBounds(10, 41+agregadoY, 20, 20);
					ID2.get(contador).setEditable(false);
					ID2.get(contador).setText(estaciones.get(contador).getId().toString());
					panelResultados.add(ID2.get(contador));
					
					Nombre2.add(new JTextField());
					Nombre2.get(contador).setBounds(32, 41+agregadoY, 110, 20);
					Nombre2.get(contador).setEditable(false);
					Nombre2.get(contador).setText(estaciones.get(contador).getNombre());
					panelResultados.add(Nombre2.get(contador));
					
					HoraCierre2.add(new JTextField());
					HoraCierre2.get(contador).setBounds(255, 41+agregadoY, 85, 20);
					HoraCierre2.get(contador).setEditable(false);
					HoraCierre2.get(contador).setText(estaciones.get(contador).getHorarioCierre().toString());
					panelResultados.add(HoraCierre2.get(contador));
					
					HoraApertura2.add(new JTextField());
					HoraApertura2.get(contador).setBounds(150, 41+agregadoY, 100, 20);
					HoraApertura2.get(contador).setEditable(false);
					HoraApertura2.get(contador).setText(estaciones.get(contador).getHorarioApertura().toString());
					panelResultados.add(HoraApertura2.get(contador));
					
					Estado2.add(new JTextField());
					Estado2.get(contador).setBounds(343, 41+agregadoY, 103, 20);
					Estado2.get(contador).setEditable(false);
					Estado2.get(contador).setText(estaciones.get(contador).getEstado().toString());
					panelResultados.add(Estado2.get(contador));
					
					Editar.add(new JButton("Editar")); 
					Editar.get(contador).setBounds(450, 41+agregadoY, 96, 20);
		Editar.get(contador).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									EditarEstacion window = new EditarEstacion(Integer.parseInt(ID2.get(contadorAux).getText()));
										window.getFrame().setVisible(true);    
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
					DarDeBaja.get(contador).setBounds(547, 41+agregadoY, 100, 20);
				DarDeBaja.get(contador).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									if(JOptionPane.showConfirmDialog(frame, "¿Esta seguro que desea eliminar la estacion?",
								            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
										
									GestorEstacion.eliminarEstacion(estaciones.get(contadorAux));
									Estaciones window = new Estaciones();
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
		 
		
		JButton crearestacion = new JButton("Crear Estacion");
		crearestacion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CrearEstacion window = new CrearEstacion();
							window.getFrame().setVisible(true);     //LLAMO CU Crear estacion
						} catch (Exception e) {
					e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		}); 
		crearestacion.setBounds(520, 357, 158, 23);
		frame.getContentPane().add(crearestacion);
		
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
		txtpnResultadoDeBusqueda.setBounds(10, 146, 244, 20);
		frame.getContentPane().add(txtpnResultadoDeBusqueda);
		
		
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}