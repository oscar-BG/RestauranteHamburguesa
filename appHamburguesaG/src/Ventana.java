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
	
	//Componentes
	private JPanel panel;
	private JLabel lblTitulo;
	private JLabel lblCantidad;
	private JLabel lblProducto;
	private JLabel lblTotal;
	private JButton btnMas;
	private JButton btnNuevo;
	private JTextField txtCantidad;
	private JComboBox cbxMenu;
	private JTable tbMenu;
	public DefaultTableModel modelo;
	public JScrollPane barra;
	
	//Productos
	private String hm = "Hamburguesa";
	private String hq = "Hamburguesa con queso";
	private String hbd = "Hamburguesa doble";
	private String pp = "Ordenes de papa";
	private String ml = "Malteadas";
	private String rf = "Refrescos";
	private String cf = "Cafe";
	
	//Presio
	private int importe = 0;
	private int total = 0;
	private String cantidad = "0";
	
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
		
		
		
		//Lista desplegable
		String[] menu = {hm,hq,hbd,pp,ml,rf,cf};
		cbxMenu = new JComboBox(menu);
		cbxMenu.setBounds(90,60,150,20);
		panel.add(cbxMenu);
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
				cantidad = txtCantidad.getText();
				
				if(cbxMenu.getSelectedItem() == cf){
					importe = 5;
				}
				else if(cbxMenu.getSelectedItem() == hm){
					importe = 12;
				}
				else if(cbxMenu.getSelectedItem() == hq){
					importe = 15;
				}
				else if(cbxMenu.getSelectedItem() == hbd){
					importe = 17;
				}
				else if(cbxMenu.getSelectedItem() == pp){
					importe = 5;
				}
				else if(cbxMenu.getSelectedItem() == ml){
					importe = 6;
				}
				else if(cbxMenu.getSelectedItem() == rf){
					importe = 5;
				}
				 Object datos[]={cantidad,cbxMenu.getSelectedItem(),importe,cantidad};
				 modelo.addRow(datos);
			}	
		};
		
		btnMas.addActionListener(oyente);
	}
}
