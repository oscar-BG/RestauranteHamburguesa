import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Ventana  extends  JFrame {
	
	private JPanel panel;
	private JLabel lblTitulo;
	private JLabel lblCantidad;
	private JLabel lblProducto;
	private JLabel lblTotal;
	private JButton btnMas;
	private JButton btnNuevo;
	private JTextField txtCantidad;
	private JComboBox<String> cbxMenu;
	private JTable tbMenu;
	public DefaultTableModel modelo;
	public JScrollPane barra;
	
	
	public Ventana(){
		
		setTitle("Hamburguesa");
		setSize(500,500); //Tamaño de la ventana
		setLocationRelativeTo(null);//Muestra la ventana en el centro de la pantall
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Cerrar ventana
		
		componentes();
	}
	
	private  void componentes(){
		panel = new JPanel(); //Creacion de un pannel
		panel.setLayout(null);//Desactivar los diseños por defecto
		panel.setBackground(Color.YELLOW);
		this.getContentPane().add(panel);//Agregamos el panel a la ventana
		
		//Agregamos etiqueta al panel
		
		lblTitulo = new JLabel();
		//lblTitulo.setOpaque(true); //Conceder permiso para intar
		lblTitulo.setText("Hamburguesa");//Establecemos el texto en la etiqueta
		lblTitulo.setBounds(190,10,150,25);//(x,y,ancho,alto)
		lblTitulo.setForeground(Color.RED); //Establecemos el color de la letra
		lblTitulo.setFont(new Font("arial",Font.BOLD,20));//Establecer fuente
		panel.add(lblTitulo);//Añadimos la etiqueta al panel
		
		lblCantidad = new JLabel();
		lblCantidad.setText("Cantidad");
		lblCantidad.setBounds(10,40,70,20);
		lblCantidad.setFont(new Font("Forte",Font.BOLD,15));
		panel.add(lblCantidad);
		
		lblProducto = new JLabel();
		lblProducto.setText("Producto");
		lblProducto.setBounds(90,40,70,20);
		lblProducto.setFont(new Font("Forte",Font.BOLD,15));
		panel.add(lblProducto);
		
		lblTotal = new JLabel();
		lblTotal.setText("Total");
		lblTotal.setBounds(300,420,50,20);
		panel.add(lblTotal);
		
		
		
		//Cajas de texto
		txtCantidad = new JTextField();
		txtCantidad.setBounds(10,60,70,20);
		panel.add(txtCantidad);
		
		tabla();
		colocarBoton();
	}
	
	private void tabla(){
		
		String hm = "Hamburguesa";
		String hq = "Hamburguesa con queso";
		String hbd = "Hamburguesa doble";
		String pp = "Ordenes de papa";
		String ml = "Malteadas";
		String rf = "Refrescos";
		String cf = "Cafe";
		
		//Lista desplegable
		//String[] menu = {hm,hq,hbd,pp,ml,rf,cf};
		
		cbxMenu = new JComboBox<String>();
		cbxMenu.setBounds(90,60,150,20);
		panel.add(cbxMenu);
		cbxMenu.addItem(hm);
		cbxMenu.addItem(hq);
		cbxMenu.addItem(hbd);
		cbxMenu.addItem(pp);
		cbxMenu.addItem(ml);
		cbxMenu.addItem(cf);
		//cbxMenu.addItemListener(this);
		
		/*
		//Codido para capturar item
		//@Override
		public void itemStateChanged(ItemEvent e){
			if(e.getSourse()==cbxMenu){
				String texItem = cbxMenu.getSelectedItem().toString();
			}
		}*/
		
	
		
		//Nuevo codigo
		tbMenu = new JTable();
		String[] encabazado = {"Cantidad","Producto","Importe","Total"};
		Object datos[][] = {};
		modelo = new DefaultTableModel(datos,encabazado){
			public boolean isCellEditable(int rowIndex, int vColIndex){
				return false;
			}	
		};
		tbMenu.setModel(modelo);
		tbMenu.getColumnModel().getColumn(0).setMaxWidth(110);
		tbMenu.getColumnModel().getColumn(1).setMaxWidth(110);
		tbMenu.getColumnModel().getColumn(2).setMaxWidth(110);
		tbMenu.getColumnModel().getColumn(3).setMaxWidth(110);
		
		barra = new JScrollPane();
		barra.setBounds(10,100,440,300);
		panel.add(barra);
		panel.add(tbMenu);
		barra.setViewportView(tbMenu);
	}
	
	//
	/*
	//Codido para capturar item
	@Override
	public void itemStateChanged(ItemEvent e){
		if(e.getSourse()==cbxMenu){
			String texItem = cbxMenu.getSelectedItem().toString();
		}
	}*/
	
	
	
	private void colocarBoton(){
		//Agregar botones
		btnMas = new JButton();
		btnMas.setText("+");
		//btnMas.setEnabled(false);//habilitar o desabilitar el boton
		btnMas.setForeground(Color.BLUE);
		btnMas.setFont(new Font("Forte",Font.BOLD,16));
		btnMas.setBounds(250,60,50,20);
		panel.add(btnMas);
		
		btnNuevo = new JButton();
		btnNuevo.setText("Nueva venta");
		btnNuevo.setForeground(Color.BLUE);
		btnNuevo.setFont(new Font("Forte",2,16));
		btnNuevo.setBounds(320,60,150,20);
		panel.add(btnNuevo);
		
		//Agregar un evento
		ActionListener oyente = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				 Object datos[]={txtCantidad.getText(),"hA","10","100"};
				 modelo.addRow(datos);
			}	
		};
		
		btnMas.addActionListener(oyente);
	}
}
