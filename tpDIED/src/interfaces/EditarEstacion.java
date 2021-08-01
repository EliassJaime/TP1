package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import dominio.Estacion;
import dto.EstacionDTO;

import gestores.GestorEstacion;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class EditarEstacion {

	private JFrame frame;
	private JTextField textFieldNombreEstacion;
	private JTextField textFieldHorarioAperturaHora;
	private JTextField textFieldHorarioCierreHora;
	private JTextField textFieldHorarioAperturaMin;
	private JTextField textFieldHorarioCierreMin;
	 private JTextField nombreBD;
	 private JTextField horarioAperturaBD;
	 private JTextField horarioCierreBD;
	 private JTextField estadoBD;
	 private JTextPane txtpnDatosCargadosEn;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 * @param i 
	 */
	public EditarEstacion(int i) {
		Estacion esta=GestorEstacion.getEstacionById(i);
		initialize(esta);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param esta 
	 */
	private void initialize(Estacion esta) {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 433);
		frame.setTitle("Editar Estacion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldNombreEstacion = new JTextField();
		textFieldNombreEstacion.setBounds(147, 53, 198, 20);
		textFieldNombreEstacion.setText(esta.getNombre());
		frame.getContentPane().add(textFieldNombreEstacion);
		textFieldNombreEstacion.setColumns(10);
		
		JTextPane txtpnNombreEstacion = new JTextPane();
		txtpnNombreEstacion.setText("(*) Nombre Estacion:");
		txtpnNombreEstacion.setBounds(10, 53, 127, 20);
		txtpnNombreEstacion.setEditable(false);
		frame.getContentPane().add(txtpnNombreEstacion);
		
		textFieldHorarioAperturaHora = new JTextField();
		textFieldHorarioAperturaHora.setColumns(10);
		textFieldHorarioAperturaHora.setBounds(147, 114, 35, 20);
		textFieldHorarioAperturaHora.setText(esta.getHorarioApertura().substring(0, 2));
		frame.getContentPane().add(textFieldHorarioAperturaHora);
		
		textFieldHorarioCierreHora = new JTextField();
		textFieldHorarioCierreHora.setColumns(10);
		textFieldHorarioCierreHora.setBounds(147, 169, 35, 20);
		textFieldHorarioCierreHora.setText(esta.getHorarioCierre().substring(0, 2));
		frame.getContentPane().add(textFieldHorarioCierreHora);
		
		textFieldHorarioAperturaMin = new JTextField();
		textFieldHorarioAperturaMin.setColumns(10);
		textFieldHorarioAperturaMin.setBounds(191, 114, 35, 20);
		textFieldHorarioAperturaMin.setText(esta.getHorarioApertura().substring(3, 5));
		frame.getContentPane().add(textFieldHorarioAperturaMin);
		
		textFieldHorarioCierreMin = new JTextField();
		textFieldHorarioCierreMin.setColumns(10);
		textFieldHorarioCierreMin.setBounds(191, 169, 35, 20);
		textFieldHorarioCierreMin.setText(esta.getHorarioCierre().substring(3, 5));
		frame.getContentPane().add(textFieldHorarioCierreMin);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(":");
		textPane.setBounds(180, 114, 13, 20);
		textPane.setEditable(false);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText(":");
		textPane_1.setBounds(180, 169, 13, 20);
		textPane_1.setEditable(false);
		frame.getContentPane().add(textPane_1);
		
		JTextPane txtpnHorarioApertura = new JTextPane();
		txtpnHorarioApertura.setText("(*) Horario Apertura:");
		txtpnHorarioApertura.setBounds(10, 114, 127, 20);
		txtpnHorarioApertura.setEditable(false);
		frame.getContentPane().add(txtpnHorarioApertura);
		
		JTextPane txtpnHorarioCierre = new JTextPane();
		txtpnHorarioCierre.setText("(*) Horario Cierre:");
		txtpnHorarioCierre.setBounds(10, 169, 127, 20);
		txtpnHorarioCierre.setEditable(false);
		frame.getContentPane().add(txtpnHorarioCierre);
		
		JTextPane txtpnEstado = new JTextPane();
		txtpnEstado.setText("(*) Estado:");
		txtpnEstado.setBounds(10, 223, 127, 20);
		txtpnEstado.setEditable(false);
		frame.getContentPane().add(txtpnEstado);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(147, 223, 198, 20);
		comboBox.addItem("Operativo");
		comboBox.addItem("En Mantenimiento");
		comboBox.setSelectedItem(esta.getEstado());
		frame.getContentPane().add(comboBox);
		
		textFieldNombreEstacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldNombreEstacion.setText("");
				txtpnNombreEstacion.setForeground(Color.BLACK);
			}
		});
		textFieldHorarioAperturaHora.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldHorarioAperturaHora.setText("");
				txtpnHorarioApertura.setForeground(Color.BLACK);
			}
		});
		textFieldHorarioAperturaMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldHorarioAperturaMin.setText("");
				txtpnHorarioApertura.setForeground(Color.BLACK);
			}
		});
		textFieldHorarioCierreHora.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldHorarioCierreHora.setText("");
				txtpnHorarioCierre.setForeground(Color.BLACK);
			}
		});
		textFieldHorarioCierreMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldHorarioCierreMin.setText("");
				txtpnHorarioCierre.setForeground(Color.BLACK);
			}
		});
		
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.setSelectedItem(null);
				txtpnEstado.setForeground(Color.BLACK);
			}
		});
		
		JButton btnNewButtonAtras = new JButton("Atras");
		btnNewButtonAtras.setBounds(10, 360, 89, 23);
		frame.getContentPane().add(btnNewButtonAtras);
		btnNewButtonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Estaciones window = new Estaciones();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();}
			});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(589, 360, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		nombreBD = new JTextField();
		nombreBD.setEditable(false);
		nombreBD.setEnabled(false);
		nombreBD.setBounds(410, 53, 226, 20);
		nombreBD.setText(esta.getNombre());
		frame.getContentPane().add(nombreBD);
		nombreBD.setColumns(10);
		
		horarioAperturaBD = new JTextField();
		horarioAperturaBD.setEditable(false);
		horarioAperturaBD.setEnabled(false);
		horarioAperturaBD.setBounds(410, 114, 100, 20);
		horarioAperturaBD.setText(esta.getHorarioApertura());
		frame.getContentPane().add(horarioAperturaBD);
		horarioAperturaBD.setColumns(10);
		
		horarioCierreBD = new JTextField();
		horarioCierreBD.setEditable(false);
		horarioCierreBD.setEnabled(false);
		horarioCierreBD.setColumns(10);
		horarioCierreBD.setBounds(410, 169, 100, 20);
		horarioCierreBD.setText(esta.getHorarioCierre());
		frame.getContentPane().add(horarioCierreBD);
		
		estadoBD = new JTextField();
		estadoBD.setEditable(false);
		estadoBD.setEnabled(false);
		estadoBD.setColumns(10);
		estadoBD.setBounds(410, 223, 226, 20);
		estadoBD.setText(esta.getEstado().toString());
		frame.getContentPane().add(estadoBD);
		
		txtpnDatosCargadosEn = new JTextPane();
		txtpnDatosCargadosEn.setText("Datos Cargados en BD");
		txtpnDatosCargadosEn.setBounds(410, 22, 179, 20);
		txtpnDatosCargadosEn.setEditable(false);
		frame.getContentPane().add(txtpnDatosCargadosEn);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Boolean ok=true;
				
				EstacionDTO dto=new EstacionDTO();
				if(textFieldNombreEstacion.getText().length()==0 || textFieldNombreEstacion.getText().length()>50) {
					txtpnNombreEstacion.setForeground(Color.RED);
					ok=false;
				}
				else {
					dto.setNombre(textFieldNombreEstacion.getText());
				}
				
				if((textFieldHorarioCierreHora.getText().length()==0 || textFieldHorarioCierreHora.getText().length()>2 || 
						Integer.valueOf(textFieldHorarioCierreHora.getText())>=24 || (Integer.valueOf(textFieldHorarioCierreHora.getText())<0))  || 
						(textFieldHorarioCierreMin.getText().length()==0 || textFieldHorarioCierreMin.getText().length()>2) 
						|| Integer.valueOf(textFieldHorarioCierreMin.getText())>=60 || (Integer.valueOf(textFieldHorarioCierreMin.getText())<0))  {
					txtpnHorarioCierre.setForeground(Color.RED);
					ok=false;
				}
				else {
					dto.setHorarioCierre(textFieldHorarioCierreHora.getText()+":"+textFieldHorarioCierreMin.getText());
				}
				
				if((textFieldHorarioAperturaHora.getText().length()==0 || textFieldHorarioAperturaHora.getText().length()>2 || 
						Integer.valueOf(textFieldHorarioAperturaHora.getText())>=24 || (Integer.valueOf(textFieldHorarioAperturaHora.getText())<0))  || 
						(textFieldHorarioAperturaMin.getText().length()==0 || textFieldHorarioAperturaMin.getText().length()>2) 
						|| Integer.valueOf(textFieldHorarioAperturaMin.getText())>=60 || (Integer.valueOf(textFieldHorarioAperturaMin.getText())<0)) {
					txtpnHorarioApertura.setForeground(Color.RED);
					ok=false;
				}
				else {
					dto.setHorarioApertura(textFieldHorarioAperturaHora.getText()+":"+textFieldHorarioAperturaMin.getText());
				}
				if(comboBox.getSelectedItem()==null) {
					txtpnEstado.setForeground(Color.RED);
					ok=false;
				}
				else {
					dto.setEstado(comboBox.getSelectedItem().toString());
				}
				
				dto.setId(esta.getId());
				
				if(!ok) {
					JOptionPane.showMessageDialog(null,"Debe Completar Todos los Campos (*)");
				}
				else {
					if(JOptionPane.showConfirmDialog(frame, "¿Esta seguro que desea continuar?",
				            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
						
				GestorEstacion.editarEstacion(dto);    //VER PARA ENVIAR MENSAJE DE EDITADO CN EXITO
						
						//EDITADO CN EXITO
					//	if(creada==0) {JOptionPane.showMessageDialog(null,"Competencia Creada con Exito");
					//	System.out.println(dto.toString());
						
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Estaciones window = new Estaciones();
									window.getFrame().setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						frame.dispose();}
					}
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