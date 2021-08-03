package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dominio.Estacion;
import dominio.Mantenimiento;
import dto.EstacionDTO;
import estructuras.MonticuloMantenimiento;
import gestores.GestorEstacion;
import gestores.GestorMantenimiento;

import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ProximoMantenimiento {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ProximoMantenimiento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 569, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Page Rank");
		frame.getContentPane().setLayout(null);
		
		
		
		JTextPane txtProximoMantenimiento = new JTextPane();
		txtProximoMantenimiento.setEditable(false);
		txtProximoMantenimiento.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtProximoMantenimiento.setText("Proximo Mantenimiento");
		txtProximoMantenimiento.setBounds(210, 11, 176, 20);
		frame.getContentPane().add(txtProximoMantenimiento);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 40, 300, 299);
		frame.getContentPane().add(scrollPane);
		
	    PriorityQueue<Estacion> estacion = null;
		try {
			estacion = MonticuloMantenimiento.devolverMonticulo();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Integer contador=0;
		int cantidad=estacion.size();
		JPanel panelResultados = new JPanel();
		panelResultados.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelResultados.setPreferredSize(new Dimension(164, 35*cantidad));
		panelResultados.setLayout(null);
		panelResultados.setAutoscrolls(true);
		scrollPane.setViewportView(panelResultados);
		
		ArrayList<JLabel> labelsPosicion=new ArrayList<JLabel>();
		ArrayList<JLabel> labelsNombre=new ArrayList<JLabel>();
		labelsPosicion.add(new JLabel("Ultimo"));
		labelsPosicion.add(new JLabel("Mantenimiento"));
		labelsPosicion.get(contador).setBounds(27,0,80,23);
		labelsPosicion.get(contador).setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelsPosicion.get(contador+1).setBounds(10,10,80,23);
		labelsPosicion.get(contador+1).setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panelResultados.add(labelsPosicion.get(contador));
		panelResultados.add(labelsPosicion.get(contador+1));
		labelsNombre.add(new JLabel("Nombre Estacion"));
		labelsNombre.get(contador).setBounds(100,5,120,23);
		panelResultados.add(labelsNombre.get(contador));
		ArrayList<JTextField> Posicion=new ArrayList<JTextField>();
		ArrayList<JTextField> Nombre=new ArrayList<JTextField>();
		
		int agregadoY=0;
		while(contador<cantidad) {
			Estacion e = estacion.poll();
			String ultMantenimiento = null;
			if(e.getMantenimientos().size() == 0) {
				
				ultMantenimiento = "NUNCA";
			
			}else {ultMantenimiento = GestorMantenimiento.crearDTO(e.getMantenimientos().get(e.getMantenimientos().size()-1)).getFechaFin();}
			
		Posicion.add(new JTextField());
		Posicion.get(contador).setBounds(15, 30+agregadoY, 70, 20);
		Posicion.get(contador).setEditable(false);
		Posicion.get(contador).setText(ultMantenimiento);
		panelResultados.add(Posicion.get(contador));
		
		Nombre.add(new JTextField());
		Nombre.get(contador).setBounds(100, 30+agregadoY, 180, 20);
		Nombre.get(contador).setEditable(false);
		Nombre.get(contador).setText(e.getNombre());
		panelResultados.add(Nombre.get(contador));
		
		agregadoY+=35;
		contador++;
		}
		
		JButton Atras = new JButton("Atras");
		Atras.setBounds(10, 316, 89, 23);
		frame.getContentPane().add(Atras);
		Atras.addActionListener(new ActionListener() {
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
		
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
