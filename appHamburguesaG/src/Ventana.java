import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
public class Ventana  extends  JFrame{
	
	private JPanel panel;
	private JLabel lblTitulo;
	private JLabel lblCantidad;
	private JLabel lblProducto;
	private JLabel lblTotal;
	private JButton btnMas;
	private JButton btnNuevo;
	private JTextField txtCantidad;
	private JComboBox cbxMenu;
	public Ventana(){
		
		setTitle("Hamburguesa");
		setSize(500,500); //Tama�o de la ventana
		setLocationRelativeTo(null);//Muestra la ventana en el centro de la pantall
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Cerrar ventana
		
		componentes();
	}
	
	private  void componentes(){
		panel = new JPanel(); //Creacion de un pannel
		panel.setLayout(null);//Desactivar los dise�os por defecto
		panel.setBackground(Color.YELLOW);
		this.getContentPane().add(panel);//Agregamos el panel a la ventana
		
		//Agregamos etiqueta al panel
		
		lblTitulo = new JLabel();
		//lblTitulo.setOpaque(true); //Conceder permiso para intar
		lblTitulo.setText("Hamburguesa");//Establecemos el texto en la etiqueta
		lblTitulo.setBounds(190,10,150,25);//(x,y,ancho,alto)
		lblTitulo.setForeground(Color.RED); //Establecemos el color de la letra
		lblTitulo.setFont(new Font("arial",Font.BOLD,20));//Establecer fuente
		panel.add(lblTitulo);//A�adimos la etiqueta al panel
		
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
		
		//Cajas de texto
		txtCantidad = new JTextField();
		txtCantidad.setBounds(10,60,70,20);
		panel.add(txtCantidad);
		
		//Lista desplegable
		String[] menu = {"Hamburguesa","Hamburguesa con queso",};
		cbxMenu = new JComboBox(menu);
		cbxMenu.setBounds(90,60,150,20);
		panel.add(cbxMenu);
		
	}
	
	
}
