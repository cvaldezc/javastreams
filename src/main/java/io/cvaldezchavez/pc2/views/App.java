package io.cvaldezchavez.pc2.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import io.cvaldezchavez.pc2.controller.ProfesorController;
import io.cvaldezchavez.pc2.exceptions.InvalidDataProfesorException;
import io.cvaldezchavez.pc2.model.Profesor;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtresult;
	private JTextField txtidI;
	private JTextField txtfirstnameI;
	private JTextField txtlastnameI;
	private JTextField txtsalaryI;
	private JTextField txtageI;
	private JTextField txtidU;
	private JTextField txtfirstnameU;
	private JTextField txtlastnameU;
	private JTextField txtsalaryU;
	private JTextField txtageU;
	private JTextField txtidD;
	private JTextArea txtlist;
	private JLabel firstnameD;
	private JLabel lastnameD;
	private JLabel salaryD;
	private JLabel ageD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 566, 148);
		contentPane.add(tabbedPane);
		
		JPanel panelInsert = new JPanel();
		tabbedPane.addTab("Insertar", null, panelInsert, null);
		panelInsert.setLayout(null);
		
		JLabel lblIdProfesor = new JLabel("ID Profesor");
		lblIdProfesor.setBounds(10, 11, 74, 14);
		panelInsert.add(lblIdProfesor);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 43, 46, 14);
		panelInsert.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 79, 46, 14);
		panelInsert.add(lblApellidos);
		
		txtidI = new JTextField();
		txtidI.setBounds(75, 8, 86, 20);
		panelInsert.add(txtidI);
		txtidI.setColumns(10);
		
		txtfirstnameI = new JTextField();
		txtfirstnameI.setBounds(75, 36, 209, 20);
		panelInsert.add(txtfirstnameI);
		txtfirstnameI.setColumns(10);
		
		txtlastnameI = new JTextField();
		txtlastnameI.setBounds(75, 76, 209, 20);
		panelInsert.add(txtlastnameI);
		txtlastnameI.setColumns(10);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(312, 11, 46, 14);
		panelInsert.add(lblSueldo);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(312, 43, 46, 14);
		panelInsert.add(lblEdad);
		
		txtsalaryI = new JTextField();
		txtsalaryI.setBounds(368, 8, 117, 20);
		panelInsert.add(txtsalaryI);
		txtsalaryI.setColumns(10);
		
		txtageI = new JTextField();
		txtageI.setBounds(368, 40, 117, 20);
		panelInsert.add(txtageI);
		txtageI.setColumns(10);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						if (new ProfesorController()
								.insertProfesor(
										new Profesor(
												Integer.parseInt(txtidI.getText()),
												txtfirstnameI.getText(),
												txtlastnameI.getText(),
												Double.parseDouble(txtsalaryI.getText()),
												Integer.parseInt(txtageI.getText()))))
						{
							JOptionPane.showMessageDialog(null, "El Profesor se ha guardado correctamente!");
						}
						else {
							JOptionPane.showMessageDialog(null, "Error al guardar al profesor");
						}
					} catch (InvalidDataProfesorException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
					}
				
				
			}
		});
		btnSave.setBounds(312, 75, 173, 23);
		panelInsert.add(btnSave);
		
		JPanel panelUPdate = new JPanel();
		tabbedPane.addTab("Modificar", null, panelUPdate, null);
		panelUPdate.setLayout(null);
		
		JLabel label = new JLabel("ID Profesor");
		label.setBounds(10, 11, 74, 14);
		panelUPdate.add(label);
		
		JLabel label_1 = new JLabel("Nombres");
		label_1.setBounds(10, 40, 46, 14);
		panelUPdate.add(label_1);
		
		JLabel label_2 = new JLabel("Apellidos");
		label_2.setBounds(10, 71, 46, 14);
		panelUPdate.add(label_2);
		
		txtidU = new JTextField();
		txtidU.setColumns(10);
		txtidU.setBounds(83, 11, 86, 20);
		panelUPdate.add(txtidU);
		
		txtfirstnameU = new JTextField();
		txtfirstnameU.setColumns(10);
		txtfirstnameU.setBounds(82, 36, 209, 20);
		panelUPdate.add(txtfirstnameU);
		
		txtlastnameU = new JTextField();
		txtlastnameU.setColumns(10);
		txtlastnameU.setBounds(83, 70, 209, 20);
		panelUPdate.add(txtlastnameU);
		
		JLabel label_3 = new JLabel("Sueldo");
		label_3.setBounds(330, 11, 46, 14);
		panelUPdate.add(label_3);
		
		JLabel label_4 = new JLabel("Edad");
		label_4.setBounds(331, 38, 46, 14);
		panelUPdate.add(label_4);
		
		txtsalaryU = new JTextField();
		txtsalaryU.setColumns(10);
		txtsalaryU.setBounds(374, 11, 117, 20);
		panelUPdate.add(txtsalaryU);
		
		txtageU = new JTextField();
		txtageU.setColumns(10);
		txtageU.setBounds(375, 34, 117, 20);
		panelUPdate.add(txtageU);
		
		JButton btnUpdate = new JButton("Modificar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new ProfesorController()
						.updateProfesor(
								new Profesor(
										Integer.parseInt(txtidU.getText()),
										txtfirstnameU.getText(),
										txtlastnameU.getText(),
										Double.parseDouble(txtsalaryU.getText()),
										Integer.parseInt(txtageU.getText()))))
				{
					JOptionPane.showMessageDialog(null, "El Profesor se ha guardado correctamente!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al guardar al profesor");
				}
			}
		});
		btnUpdate.setBounds(342, 86, 173, 23);
		panelUPdate.add(btnUpdate);
		
		JButton btnBucarU = new JButton("Bucar");
		btnBucarU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor pr = findProfesor(Integer.parseInt(txtidU.getText()));
				if (pr != null) {
					txtfirstnameU.setText(pr.getFirstName());
					txtlastnameU.setText(pr.getLastName());
					txtsalaryU.setText("" + pr.getSalary());
					txtageU.setText("" + pr.getAge());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No se han encontrado Datos para la busqueda!");
				}
			}
		});
		btnBucarU.setBounds(178, 11, 89, 23);
		panelUPdate.add(btnBucarU);
		
		JPanel panelDelete = new JPanel();
		tabbedPane.addTab("Eliminar", null, panelDelete, null);
		panelDelete.setLayout(null);
		
		JLabel lblIdProfesor_1 = new JLabel("ID Profesor");
		lblIdProfesor_1.setBounds(10, 11, 65, 14);
		panelDelete.add(lblIdProfesor_1);
		
		txtidD = new JTextField();
		txtidD.setBounds(85, 8, 86, 20);
		panelDelete.add(txtidD);
		txtidD.setColumns(10);
		
		JButton btnBuscarD = new JButton("Buscar");
		btnBuscarD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor pr = findProfesor(Integer.parseInt(txtidD.getText()));
				if (pr != null)
				{
					firstnameD.setText(pr.getFirstName());
					lastnameD.setText(pr.getLastName());
					salaryD.setText("" + pr.getSalary());
					ageD.setText("" + pr.getAge());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No se han encontrado datos solicitados");
				}
			}
		});
		btnBuscarD.setBounds(182, 7, 89, 23);
		panelDelete.add(btnBuscarD);
		
		JLabel lblNombres_1 = new JLabel("Nombres");
		lblNombres_1.setBounds(10, 51, 46, 14);
		panelDelete.add(lblNombres_1);
		
		JLabel lblApellidos_1 = new JLabel("Apellidos");
		lblApellidos_1.setBounds(10, 83, 46, 14);
		panelDelete.add(lblApellidos_1);
		
		JLabel lblSueldo_1 = new JLabel("Sueldo");
		lblSueldo_1.setBounds(214, 51, 46, 14);
		panelDelete.add(lblSueldo_1);
		
		JLabel lblEdad_1 = new JLabel("Edad");
		lblEdad_1.setBounds(214, 83, 46, 14);
		panelDelete.add(lblEdad_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new ProfesorController()
						.deleteProfesor(new Profesor(Integer.parseInt(txtidD.getText()))))
				{
					JOptionPane.showMessageDialog(null, "El Profesor se ha eliminado correctamente!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al eliminar al profesor");
				}
			}
		});
		btnEliminar.setBounds(462, 7, 89, 23);
		panelDelete.add(btnEliminar);
		
		firstnameD = new JLabel("");
		firstnameD.setBounds(66, 51, 138, 14);
		panelDelete.add(firstnameD);
		
		lastnameD = new JLabel("");
		lastnameD.setBounds(66, 83, 138, 14);
		panelDelete.add(lastnameD);
		
		salaryD = new JLabel("");
		salaryD.setBounds(270, 51, 101, 14);
		panelDelete.add(salaryD);
		
		ageD = new JLabel("");
		ageD.setBounds(270, 83, 46, 14);
		panelDelete.add(ageD);
		
		JPanel panelOperations = new JPanel();
		tabbedPane.addTab("Operaciones", null, panelOperations, null);
		panelOperations.setLayout(null);
		
		JButton btnPrimerElemento = new JButton("Primer Elemento");
		btnPrimerElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtlist.setText(new ProfesorController().getFirstElement().toTextArea());
			}
		});
		btnPrimerElemento.setBounds(10, 11, 109, 23);
		panelOperations.add(btnPrimerElemento);
		
		JButton btnTodosSueldo = new JButton("Todos Sueldo > 2500");
		btnTodosSueldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean state = new ProfesorController().salaryTodosMayor2500();
				txtresult.setText((state) ? "VERDADERO":"FALSO");
			}
		});
		btnTodosSueldo.setBounds(139, 11, 153, 23);
		panelOperations.add(btnTodosSueldo);
		
		JButton btnSueldoEdadApellido = new JButton("Sueldo > 1500 edad < 40, Apellido <> \"A\"");
		btnSueldoEdadApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder line =  new StringBuilder();
				new ProfesorController().sueldoMayoryEdadMenoryApellidoNOA()
						.forEach(s -> line.append(s.toTextArea()));
				txtlist.setText(line.toString());
			}
		});
		btnSueldoEdadApellido.setBounds(302, 11, 237, 23);
		panelOperations.add(btnSueldoEdadApellido);
		
		JButton btnSueldoBrutoAnual = new JButton("Sueldo Bruto Anual");
		btnSueldoBrutoAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder line =  new StringBuilder();
				line.append("ID\t");
				line.append("NOMBRES\t");
				line.append("APELLIDOS\t");
				line.append("SUELDO\t");
				line.append("EDAD\t");
				line.append("SUELDO BRUTO\t");
				line.append("\n");
				new ProfesorController().sueldoBruto()
						.forEach(s -> line.append(s));
				txtlist.setText(line.toString());
			}
		});
		btnSueldoBrutoAnual.setBounds(106, 57, 142, 23);
		panelOperations.add(btnSueldoBrutoAnual);
		
		JButton btnPromedioSueldo = new JButton("Promedio Sueldo > 40");
		btnPromedioSueldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double promedio = new ProfesorController().sueldoPromedio();
				txtresult.setText("El Sueldo promedio de los profesores es:  " + promedio);
			}
		});
		btnPromedioSueldo.setBounds(271, 57, 167, 23);
		panelOperations.add(btnPromedioSueldo);
		
		JPanel panelResult = new JPanel();
		panelResult.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelResult.setBounds(5, 164, 561, 241);
		contentPane.add(panelResult);
		panelResult.setLayout(null);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(10, 11, 66, 14);
		panelResult.add(lblResultado);
		
		txtresult = new JTextField();
		txtresult.setBounds(86, 8, 252, 20);
		panelResult.add(txtresult);
		txtresult.setColumns(10);
		
		txtlist = new JTextArea();
		txtlist.setEditable(false);
		txtlist.setBounds(10, 36, 541, 194);
		panelResult.add(txtlist);
		
		JButton btnRecargar = new JButton("Recargar");
		btnRecargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		btnRecargar.setBounds(462, 7, 89, 23);
		panelResult.add(btnRecargar);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelInsert, panelUPdate, panelDelete, tabbedPane, panelOperations}));
		
		// init method
		showList();
	}

	private void showList() {
		StringBuilder lines = new StringBuilder();
		lines.append("ID\t");
		lines.append("NOMBRES\t");
		lines.append("APELLIDOS\t");
		lines.append("SUELDO\t");
		lines.append("EDAD\t");
		lines.append("\n");
		new ProfesorController().listProfesor().stream()
			.sorted()
			.forEach(s -> lines.append(s.toTextArea()));
		System.out.println(lines);
		this.txtlist.setText(lines.toString());
	}
	
	private Profesor findProfesor(int id)
	{
		return new ProfesorController().getProfesor(id);
	}
	
}
