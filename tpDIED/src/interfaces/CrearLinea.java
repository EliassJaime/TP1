package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import dominio.LineaTransporte;
import enums.EstadoRuta;
import gestores.GestorLineaTransporte;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class CrearLinea {

	JFrame frmCrearLineaTransporte;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public CrearLinea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrearLineaTransporte = new JFrame();
		frmCrearLineaTransporte.setTitle("Crear Linea Transporte");
		frmCrearLineaTransporte.setBounds(100, 100, 704, 433);
		frmCrearLineaTransporte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewNombreLinea = new JLabel("(*) Nombre Linea: ");
		lblNewNombreLinea.setBounds(19, 20, 120, 14);
		
		textField = new JTextField();
		textField.setBounds(160, 20, 200, 20);
		textField.setColumns(10);
		
		JLabel lblcomboBox2Linea = new JLabel("(*) Color Linea: ");
		lblcomboBox2Linea.setBounds(19, 60, 94, 14);
		
		JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.setBounds(160, 60, 200, 22);
		comboBox2.addItem("Azul");
		comboBox2.addItem("Amarillo");
		comboBox2.addItem("Verde");
		comboBox2.addItem("Naranja");
		comboBox2.addItem("Negro");
		comboBox2.setSelectedItem(null);
		
		JLabel lblEstadoLinea = new JLabel("(*) Estado Linea: ");
		lblEstadoLinea.setBounds(19, 100, 102, 14);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(160, 100, 200, 22);
		
		comboBox.addItem("Activa");
		comboBox.addItem("No Activa");
		comboBox.setSelectedItem(null);
		
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewNombreLinea.setForeground(Color.BLACK);
			}
		});
		comboBox2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblcomboBox2Linea.setForeground(Color.BLACK);
			}
		});
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblEstadoLinea.setForeground(Color.BLACK);
			}
		});
		frmCrearLineaTransporte.getContentPane().setLayout(null);
		frmCrearLineaTransporte.getContentPane().add(lblEstadoLinea);
		frmCrearLineaTransporte.getContentPane().add(comboBox);
		frmCrearLineaTransporte.getContentPane().add(lblcomboBox2Linea);
		frmCrearLineaTransporte.getContentPane().add(comboBox2);
		frmCrearLineaTransporte.getContentPane().add(lblNewNombreLinea);
		frmCrearLineaTransporte.getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("Atras");
		frmCrearLineaTransporte.getContentPane().add(btnNewButton);
		btnNewButton.setBounds(10, 360, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
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
				frmCrearLineaTransporte.dispose();}
			});
		
		frmCrearLineaTransporte.getContentPane().add(btnNewButton);
		
		JButton btnCrearLineaTransporte = new JButton("Crear Linea ");
		btnCrearLineaTransporte.setBounds(530, 360, 148, 23);
		btnCrearLineaTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Boolean ok=true;

				if(textField.getText().length()==0 || textField.getText().length()>50) {
					lblNewNombreLinea.setForeground(Color.RED); 
					ok=false;
				}
				if(comboBox2.getSelectedItem()==null) {
					lblcomboBox2Linea.setForeground(Color.RED);
					ok=false;
				}
				if(comboBox.getSelectedItem()==null) {
					lblEstadoLinea.setForeground(Color.RED);
					ok=false;
				}
				if(ok) {
					if(comboBox.getSelectedItem().toString() == "Activa") {
					LineaTransporte dto = new LineaTransporte(0,textField.getText(),comboBox2.getSelectedItem().toString(),EstadoRuta.Activa,null );
					GestorLineaTransporte.altaLineaTransporte(dto);
					}else {
						LineaTransporte dto = new LineaTransporte(0,textField.getText(),comboBox2.getSelectedItem().toString(),EstadoRuta.NoActiva,null );
						GestorLineaTransporte.altaLineaTransporte(dto);
					}
				}
				if(!ok) {
					JOptionPane.showMessageDialog(null,"Debe Completar Todos los Campos (*)");
				}
				else {
					if(JOptionPane.showConfirmDialog(frmCrearLineaTransporte, "¿Esta seguro que desea continuar?",
				            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
						
				}
			}
			}
		});
		frmCrearLineaTransporte.getContentPane().add(btnCrearLineaTransporte);

	}
}
