package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dominio.LineaTransporte;
import enums.EstadoRuta;
import gestores.GestorLineaTransporte;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class CrearLinea {

	JFrame frmCrearLineaTransporte;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

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
		
		JLabel lblColorLinea = new JLabel("(*) Color Linea: ");
		lblColorLinea.setBounds(19, 60, 94, 14);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 60, 200, 20);
		textField_1.setColumns(10);
		
		JLabel lblEstadoLinea = new JLabel("(*) Estado Linea: ");
		lblEstadoLinea.setBounds(19, 100, 102, 14);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(160, 100, 200, 22);
		
		comboBox.addItem("Activa");
		comboBox.addItem("No Activa");
		comboBox.setSelectedItem(null);
		frmCrearLineaTransporte.getContentPane().setLayout(null);
		frmCrearLineaTransporte.getContentPane().add(lblEstadoLinea);
		frmCrearLineaTransporte.getContentPane().add(comboBox);
		frmCrearLineaTransporte.getContentPane().add(lblColorLinea);
		frmCrearLineaTransporte.getContentPane().add(textField_1);
		frmCrearLineaTransporte.getContentPane().add(lblNewNombreLinea);
		frmCrearLineaTransporte.getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("Atras");
		frmCrearLineaTransporte.getContentPane().add(btnNewButton);
		btnNewButton.setBounds(45, 320, 120, 30);
		btnNewButton.addActionListener(new ActionListener() {
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
				frmCrearLineaTransporte.dispose();}
			});
		
		frmCrearLineaTransporte.getContentPane().add(btnNewButton);
		
		JButton btnCrearLineaTransporte = new JButton("Crear Linea ");
		btnCrearLineaTransporte.setBounds(525, 320, 120, 30);
		btnCrearLineaTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Boolean ok=true;
				
				
				if(textField.getText().length()==0 || textField.getText().length()>50 || 
						textField_1.getText().length()==0 || textField.getText().length()>50 || comboBox.getSelectedItem()==null) {
					lblNewNombreLinea.setForeground(Color.RED);
					lblColorLinea.setForeground(Color.RED);
					lblEstadoLinea.setForeground(Color.RED);
					ok=false;
				}
				else {
					if(comboBox.getSelectedItem().toString() == "Activa") {
					LineaTransporte dto = new LineaTransporte(0,textField.getText(),textField_1.getText(),EstadoRuta.Activa,null );
					GestorLineaTransporte.altaLineaTransporte(dto);
					}else {
						LineaTransporte dto = new LineaTransporte(0,textField.getText(),textField_1.getText(),EstadoRuta.NoActiva,null );
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
