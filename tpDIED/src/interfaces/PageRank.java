package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dto.EstacionDTO;
import gestores.GestorEstacion;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;

import dominio.Estacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PageRank {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public PageRank() {
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
		
		
		
		JTextPane txtpnPageRank = new JTextPane();
		txtpnPageRank.setEditable(false);
		txtpnPageRank.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtpnPageRank.setText("PAGE RANK");
		txtpnPageRank.setBounds(231, 11, 104, 20);
		frame.getContentPane().add(txtpnPageRank);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 40, 300, 299);
		frame.getContentPane().add(scrollPane);
		
		ArrayList<Estacion> estaciones = GestorEstacion.buscarTodasLasEstaciones();
		
	ArrayList<EstacionDTO> page=GestorEstacion.obtenerPageRank();
		Integer contador=0;
		int cantidad=page.size();
		JPanel panelResultados = new JPanel();
		panelResultados.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelResultados.setPreferredSize(new Dimension(164, 40*cantidad));
		panelResultados.setLayout(null);
		panelResultados.setAutoscrolls(true);
		scrollPane.setViewportView(panelResultados);
		
		ArrayList<JLabel> labelsPage=new ArrayList<JLabel>();
		ArrayList<JLabel> labelsPosicion=new ArrayList<JLabel>();
		ArrayList<JLabel> labelsNombre=new ArrayList<JLabel>();
		labelsPosicion.add(new JLabel("Posicion"));
		labelsPosicion.get(contador).setBounds(30,5,50,23);
		panelResultados.add(labelsPosicion.get(contador));
		labelsNombre.add(new JLabel("Nombre Estacion"));
		labelsNombre.get(contador).setBounds(100,5,120,23);
		panelResultados.add(labelsNombre.get(contador));
		labelsPage.add(new JLabel("PageRank"));
		labelsPage.get(contador).setBounds(235,5,120,23);
		panelResultados.add(labelsPage.get(contador));
		ArrayList<JTextField> Posicion=new ArrayList<JTextField>();
		ArrayList<JTextField> Nombre=new ArrayList<JTextField>();
		ArrayList<JTextField> NumeroPage=new ArrayList<JTextField>();
		
		int agregadoY=0;
		while(contador<cantidad) {
			
		Posicion.add(new JTextField());
		Posicion.get(contador).setBounds(40, 30+agregadoY, 20, 20);
		Posicion.get(contador).setEditable(false);
		Integer mostrar=contador+1;
		Posicion.get(contador).setText(mostrar.toString());
		panelResultados.add(Posicion.get(contador));
		
		NumeroPage.add(new JTextField());
		NumeroPage.get(contador).setBounds(240, 30+agregadoY, 50, 20);
		NumeroPage.get(contador).setEditable(false);
		NumeroPage.get(contador).setText(GestorEstacion.obtenerPageRankNumero(estaciones.get(contador)).toString());
		panelResultados.add(NumeroPage.get(contador));
		
		Nombre.add(new JTextField());
		Nombre.get(contador).setBounds(100, 30+agregadoY, 100, 20);
		Nombre.get(contador).setEditable(false);
		Nombre.get(contador).setText(page.get(contador).getNombre());
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

