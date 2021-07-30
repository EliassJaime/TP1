package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.JTextComponent;

import dominio.Estacion;
import dominio.LineaTransporte;
import enums.EstadoRuta;
import gestores.GestorEstacion;
import gestores.GestorLineaTransporte;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class EditarLinea {

	JFrame frmEditarLineaTransporte;
	private JTextField textField;
	private JTextField textFieldColorNuevo;
	private JTextField textFieldNombreNuevo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public EditarLinea(int i) {
		LineaTransporte esta=GestorLineaTransporte.obtenerLineaTransportePorId(i);
		initialize(esta);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(LineaTransporte esta) {
		frmEditarLineaTransporte = new JFrame();
		frmEditarLineaTransporte.setTitle("Editar Linea Transporte");
		frmEditarLineaTransporte.setBounds(100, 100, 704, 433);
		frmEditarLineaTransporte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewNombreLinea = new JLabel("(*) Nuevo Nombre Linea: ");
		lblNewNombreLinea.setBounds(19, 50, 155, 14);

		
		textFieldNombreNuevo = new JTextField();
		textFieldNombreNuevo.setColumns(10);
		textFieldNombreNuevo.setBounds(190, 50, 200, 20);
		frmEditarLineaTransporte.getContentPane().add(textFieldNombreNuevo);

		
		JLabel lblColorLinea = new JLabel("(*) Nuevo Color Linea: ");
		lblColorLinea.setBounds(19, 100, 135, 14);
		
		textFieldColorNuevo = new JTextField();
		textFieldColorNuevo.setBounds(190, 100, 200, 20);
		textFieldColorNuevo.setColumns(10);
		
		JLabel lblEstadoLinea = new JLabel("(*) Nuevo Estado Linea: ");
		lblEstadoLinea.setBounds(19, 150, 145, 14);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(190, 150, 200, 22);
		comboBox.addItem("Activa");
		comboBox.addItem("No Activa");
		comboBox.setSelectedItem(null);
		frmEditarLineaTransporte.getContentPane().setLayout(null);
		frmEditarLineaTransporte.getContentPane().add(lblEstadoLinea);
		frmEditarLineaTransporte.getContentPane().add(lblColorLinea);
		frmEditarLineaTransporte.getContentPane().add(textFieldColorNuevo);
		frmEditarLineaTransporte.getContentPane().add(lblNewNombreLinea);
		frmEditarLineaTransporte.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Atras");
		frmEditarLineaTransporte.getContentPane().add(btnNewButton);
		btnNewButton.setBounds(45, 320, 120, 30);
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
				frmEditarLineaTransporte.dispose();}
			});
		
		frmEditarLineaTransporte.getContentPane().add(btnNewButton);
		
		JTextField nombreBD = new JTextField();
		nombreBD.setEditable(false);
		nombreBD.setEnabled(false);
		nombreBD.setBounds(410, 50, 226, 20);
		nombreBD.setText(esta.getNombre());
		frmEditarLineaTransporte.getContentPane().add(nombreBD);
		nombreBD.setColumns(10);
		
		JTextComponent colorBD = new JTextField();
		colorBD.setEditable(false);
		colorBD.setEnabled(false);
		((JTextField) colorBD).setColumns(10);
		colorBD.setBounds(410, 100, 226, 20);
		colorBD.setText(esta.getColor().toString());
		frmEditarLineaTransporte.getContentPane().add(colorBD);
		

		JTextComponent estadoBD = new JTextField();
		estadoBD.setEditable(false);
		estadoBD.setEnabled(false);
		((JTextField) estadoBD).setColumns(10);
		estadoBD.setBounds(410, 150, 226, 20);
		estadoBD.setText(esta.getEstadolinea().toString());
		frmEditarLineaTransporte.getContentPane().add(estadoBD);
		
		JTextPane txtpnDatosCargadosEn = new JTextPane();
		txtpnDatosCargadosEn.setText("Datos Cargados en BD");
		txtpnDatosCargadosEn.setBounds(410, 20, 179, 20);
		txtpnDatosCargadosEn.setEditable(false);
		frmEditarLineaTransporte.getContentPane().add(txtpnDatosCargadosEn);
		
		JButton btnCrearLineaTransporte = new JButton("Editar Linea ");
		btnCrearLineaTransporte.setBounds(512, 320, 120, 30);
		btnCrearLineaTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Boolean ok=true;
				
				
				if(textFieldNombreNuevo.getText().length()==0 || textFieldNombreNuevo.getText().length()>50 || textFieldColorNuevo.getText().length()==0 
						|| textFieldColorNuevo.getText().length()>50 || comboBox.getSelectedItem()==null) {
					lblNewNombreLinea.setForeground(Color.RED);
					lblColorLinea.setForeground(Color.RED);
					lblEstadoLinea.setForeground(Color.RED);
					ok=false;
				}
				else {
					if(comboBox.getSelectedItem().toString() == "Activa") {
						
						
					LineaTransporte dto = new LineaTransporte(esta.getIdLinea()
							,textFieldNombreNuevo.getText(),textFieldColorNuevo.getText(),EstadoRuta.Activa,null);
					GestorLineaTransporte.editarLineaTransporte(dto);;
					}else {
						LineaTransporte dto = new LineaTransporte(esta.getIdLinea()
								,textFieldNombreNuevo.getText(),textFieldColorNuevo.getText(),EstadoRuta.NoActiva,null);
						GestorLineaTransporte.editarLineaTransporte(dto);
					}
				}
				if(!ok) {
					JOptionPane.showMessageDialog(null,"Debe Completar Todos los Campos (*)");
				}
				else {
					if(JOptionPane.showConfirmDialog(frmEditarLineaTransporte, "¿Esta seguro que desea continuar?",
				            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
						
				}
			}
			}
		});
		frmEditarLineaTransporte.getContentPane().add(btnCrearLineaTransporte);
		
		
	}
}
