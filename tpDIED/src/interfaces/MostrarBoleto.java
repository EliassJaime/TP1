package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import dominio.Boleto;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class MostrarBoleto {

	private JFrame frame;
	private JTextField textFieldIdBoleto;
	private JTextField textFieldCliente;
	private JTextField textFieldCorreo;
	private JTextField textFieldFecha;
	private JTextField textFieldCosto;


	/**
	 * Create the application.
	 * @param bol 
	 */
	public MostrarBoleto(Boleto bol) {
		initialize(bol);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Boleto bol) {
		frame = new JFrame();
		frame.setBounds(100, 100, 523, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIdBoleto = new JLabel("Id Boleto:");
		lblIdBoleto.setBounds(10, 11, 70, 14);
		frame.getContentPane().add(lblIdBoleto);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(224, 11, 70, 14);
		frame.getContentPane().add(lblCliente);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(224, 49, 70, 14);
		frame.getContentPane().add(lblCorreo);
		
		JLabel lblFecha = new JLabel("Fecha de compra:");
		lblFecha.setBounds(10, 49, 104, 14);
		frame.getContentPane().add(lblFecha);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(10, 84, 84, 14);
		frame.getContentPane().add(lblCosto);
		
		JLabel lblTrayectoria = new JLabel("Trayectoria:");
		lblTrayectoria.setBounds(10, 120, 84, 14);
		frame.getContentPane().add(lblTrayectoria);
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
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

		aceptar.setBounds(408, 321, 89, 23);
		frame.getContentPane().add(aceptar);
		
		textFieldIdBoleto = new JTextField();
		textFieldIdBoleto.setEditable(false);
		textFieldIdBoleto.setBounds(113, 8, 86, 20);
		textFieldIdBoleto.setText(bol.getidBoleto().toString());
		frame.getContentPane().add(textFieldIdBoleto);
		textFieldIdBoleto.setColumns(10);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setEditable(false);
		textFieldCliente.setColumns(10);
		textFieldCliente.setBounds(294, 8, 147, 20);
		textFieldCliente.setText(bol.getCliente().getNombre());
		frame.getContentPane().add(textFieldCliente);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setEditable(false);
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(294, 46, 147, 20);
		textFieldCorreo.setText(bol.getCliente().getCorreo());
		frame.getContentPane().add(textFieldCorreo);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setEditable(false);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(113, 46, 86, 20);
		
		SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
		
		String fecha = f.format(Date.from(bol.getFechaDeVenta()));
		
		textFieldFecha.setText(fecha);
		frame.getContentPane().add(textFieldFecha);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setEditable(false);
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(113, 81, 86, 20);
		textFieldCosto.setText(bol.getCostoBol().toString());
		frame.getContentPane().add(textFieldCosto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 487, 165);
		frame.getContentPane().add(scrollPane);
		
		JPanel panelTrayecto = new JPanel();
		panelTrayecto.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelTrayecto.setPreferredSize(new Dimension(360, 35*1));
		panelTrayecto.setLayout(null);
		panelTrayecto.setAutoscrolls(true);
		scrollPane.setViewportView(panelTrayecto);
		
		ArrayList<JTextField> trayecto=new ArrayList<JTextField>();
		int cantidad=bol.getCamino().size();
		int contador=0;
		int agregadoY=0;
		while(contador<cantidad) {
		trayecto.add(new JTextField());
		trayecto.get(contador).setEditable(false);
		trayecto.get(contador).setColumns(10);
		trayecto.get(contador).setBounds(10, 10+agregadoY, 400, 20);
		trayecto.get(contador).setText(bol.getCamino().get(contador).toString());
		panelTrayecto.add(trayecto.get(contador));
		
		agregadoY+=35;
		contador++;
		}
	}
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
