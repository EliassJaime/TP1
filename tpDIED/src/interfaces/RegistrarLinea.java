package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;

import dominio.Estacion;
import dto.RutaDTO;
import gestores.GestorEstacion;
import gestores.GestorRuta;
 
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarLinea {

	private JFrame frame;
	/**
	 * Create the application.
	 * @param idLinea 
	 */
	public RegistrarLinea(Integer idLinea) {
		initialize(idLinea);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param idLinea 
	 */
	private void initialize(Integer idLinea) {
		
		frame = new JFrame();
		frame.setTitle("Registrar Trayecto");
		frame.setBounds(100, 100, 704, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnIndicarTrayecto = new JTextPane();
		txtpnIndicarTrayecto.setEditable(false);
		txtpnIndicarTrayecto.setText("Seleccione las estaciones en el orden que desee el trayecto:");
		txtpnIndicarTrayecto.setBounds(10, 11, 350, 20);
		frame.getContentPane().add(txtpnIndicarTrayecto);
		
		ArrayList<Estacion> estaciones= GestorEstacion.buscarTodasLasEstaciones();
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 50, 668, 100);
		frame.getContentPane().add(scrollPane1);
		 JPanel panelEstaciones = new JPanel();
		 panelEstaciones.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelEstaciones.setPreferredSize(new Dimension(360, 35*estaciones.size()));
			panelEstaciones.setLayout(null);
		panelEstaciones.setAutoscrolls(true);
		scrollPane1.setViewportView(panelEstaciones);
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
		if(posicionX>560) {
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
		
		
		JButton registrar = new JButton("Registrar Trayecto");
		registrar.setBounds(532, 360, 146, 23);
		frame.getContentPane().add(registrar);
		registrar.setEnabled(false);
		
		JButton ok = new JButton("Ok");
		ok.setBounds(564, 11, 89, 23);
		frame.getContentPane().add(ok);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 668, 170);
		frame.getContentPane().add(scrollPane);
		 
		class Auxiliar implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				int cantidad=trayecto.size()-1; //Cantidad de tramos a registrar
				int contador=0;
				int agregadoY=0;
				 JPanel panelResultados = new JPanel();
				 panelResultados.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					panelResultados.setPreferredSize(new Dimension(360, 35*cantidad));
					panelResultados.setLayout(null);
				panelResultados.setAutoscrolls(true);
				scrollPane.setViewportView(panelResultados);
				ArrayList<JLabel> labelsOrigen=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsDestino=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsDistancia=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsDuracion=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsCantidad=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsCosto=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsEstado=new ArrayList<JLabel>();
				
				ArrayList<JTextField> Origen2=new ArrayList<JTextField>();
				 ArrayList<JTextField> Destino2=new ArrayList<JTextField>();
				 ArrayList<JTextField> Distancia=new ArrayList<JTextField>();
				 ArrayList<JTextField> Duracion=new ArrayList<JTextField>();
				 ArrayList<JTextField> Cantidad=new ArrayList<JTextField>();
				 ArrayList<JTextField> Costo=new ArrayList<JTextField>();
				 ArrayList<JComboBox<String>> Estado=new ArrayList<JComboBox<String>>();
				
				
				labelsOrigen.add(new JLabel("Origen"));
				labelsDestino.add(new JLabel("Destino"));
				labelsDistancia.add(new JLabel("(*) Distancia [km]"));
				labelsDuracion.add(new JLabel("(*) Duracion [min]"));
				labelsCantidad.add(new JLabel("(*) Cant Max Pasajeros"));
				labelsCosto.add(new JLabel("(*) Costo"));
				labelsEstado.add(new JLabel("(*) Estado"));
				
				labelsOrigen.get(contador).setBounds(10, 11, 85, 14);
				panelResultados.add(labelsOrigen.get(contador));
				labelsDestino.get(contador).setBounds(60, 11, 46, 14);
				panelResultados.add(labelsDestino.get(contador));
				labelsDistancia.get(contador).setBounds(110, 11, 100, 14);
				panelResultados.add(labelsDistancia.get(contador));
				labelsDuracion.get(contador).setBounds(220, 11, 100, 14);
				panelResultados.add(labelsDuracion.get(contador));
				labelsCantidad.get(contador).setBounds(330, 11, 150, 14);
				panelResultados.add(labelsCantidad.get(contador));
				labelsCosto.get(contador).setBounds(480, 11, 63, 14);
				panelResultados.add(labelsCosto.get(contador));
				labelsEstado.get(contador).setBounds(550, 11, 63, 14);
				panelResultados.add(labelsEstado.get(contador));
				
				
				registrar.setEnabled(true);
				registrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						

						Boolean ok=true;
						ArrayList<RutaDTO> dto=new ArrayList<RutaDTO>();
						for(int i=0;i<trayecto.size()-1;i++) {
							RutaDTO agregar= new RutaDTO();
						if(Distancia.get(i).getText().toString().length()==0) {
							labelsDistancia.get(0).setForeground(Color.RED);
							ok=false;
						}
						else {
				    	agregar.setDistancia(Double.parseDouble(Distancia.get(i).getText()));
						} 
						if(Duracion.get(i).getText().toString().length()==0) {
							labelsDuracion.get(0).setForeground(Color.RED);
							ok=false;
						}
						else {
						agregar.setDuracionDelViaje(Double.parseDouble(Duracion.get(i).getText()));
						}
						if(Cantidad.get(i).getText().toString().length()==0) {
							labelsCantidad.get(0).setForeground(Color.RED);
							ok=false;
						}
						else {
						agregar.setCantidadMaxPasajeros(Integer.parseInt(Cantidad.get(i).getText()));
						}
						if(Costo.get(i).getText().toString().length()==0) {
							labelsCosto.get(0).setForeground(Color.RED);
							ok=false;
						}
						else {
						agregar.setCosto(Double.parseDouble(Costo.get(i).getText()));
						}
					if(Estado.get(i).getSelectedItem()==null) {      
							labelsEstado.get(0).setForeground(Color.RED);
							ok=false;
						}
						else {
						agregar.setEstado((Estado.get(i).getSelectedItem().toString()));
						} 
						if(ok) {
							agregar.setIdOrigenE(trayecto.get(i));       
							agregar.setIdDestinoE(trayecto.get(i+1));
							agregar.setIdLineaTransporte(idLinea);
							dto.add(agregar);
						}
						
						}
						if(!ok) {
							JOptionPane.showMessageDialog(null,"Debe Completar Todos los Campos (*)");
						}
						else {
							if(JOptionPane.showConfirmDialog(frame, "¿Esta seguro que desea continuar?",
						            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
								
							for(int i=0;i<trayecto.size()-1;i++) {
								GestorRuta.guardarRuta(dto.get(i));
							// Guardo cada ruta del dto en la BD
							}
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
						}
					}});
				
				while(cantidad>contador) {
					String origen=GestorEstacion.getEstacionById(trayecto.get(contador)).getNombre();
					String destino=GestorEstacion.getEstacionById(trayecto.get(contador+1)).getNombre();
					
					Origen2.add(new JTextField());
					Origen2.get(contador).setBounds(10, 41+agregadoY, 46, 20);
					Origen2.get(contador).setEditable(false);
					Origen2.get(contador).setText(origen);
					panelResultados.add(Origen2.get(contador));
					
					Destino2.add(new JTextField());
					Destino2.get(contador).setBounds(60, 41+agregadoY, 46, 20);
					Destino2.get(contador).setEditable(false);
					Destino2.get(contador).setText(destino);
					panelResultados.add(Destino2.get(contador));
					
					Distancia.add(new JTextField());
					Distancia.get(contador).setBounds(110, 41+agregadoY, 100, 20);
					Distancia.get(contador).setEditable(true);
					Distancia.get(contador).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							labelsDistancia.get(0).setForeground(Color.black);
						}});
					panelResultados.add(Distancia.get(contador));
					
					Duracion.add(new JTextField());
					Duracion.get(contador).setBounds(220, 41+agregadoY, 100, 20);
					Duracion.get(contador).setEditable(true);
					Duracion.get(contador).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							labelsDuracion.get(0).setForeground(Color.black);
						}});
					panelResultados.add(Duracion.get(contador));
					
					Cantidad.add(new JTextField());
					Cantidad.get(contador).setBounds(330, 41+agregadoY, 140, 20);
					Cantidad.get(contador).setEditable(true);
					Cantidad.get(contador).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							labelsCantidad.get(0).setForeground(Color.black);
						}});
					panelResultados.add(Cantidad.get(contador));
					
					Costo.add(new JTextField());
					Costo.get(contador).setBounds(480, 41+agregadoY, 63, 20);
					Costo.get(contador).setEditable(true);
					Costo.get(contador).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							labelsCosto.get(0).setForeground(Color.black);
						}});
					panelResultados.add(Costo.get(contador));
					
					Estado.add(new JComboBox<String>());
					Estado.get(contador).addItem("Activa");
					Estado.get(contador).addItem("NoActiva");
					Estado.get(contador).setSelectedItem(null);
					Estado.get(contador).setBounds(550, 41+agregadoY, 80, 20);
					Estado.get(contador).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							labelsEstado.get(0).setForeground(Color.black);
						}});
					Estado.get(contador).setEditable(false);
					panelResultados.add(Estado.get(contador));

					agregadoY=agregadoY+30;
					contador++;
				}	
			}			 
		}
	     
		 Auxiliar aux= new Auxiliar();
		 ok.addActionListener(aux);
		
		JButton atras = new JButton("Atras");
		atras.setBounds(10, 360, 89, 23);
		atras.addActionListener(new ActionListener() {
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
				
			}});
		frame.getContentPane().add(atras);
		
		
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
