import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Color;
public class Ventana  extends  JFrame{
	
	private JPanel panel;
	private JLabel lblTitulo;
	
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
		lblTitulo.setBounds(200,10,100,10);//(x,y,ancho,alto)
		lblTitulo.setForeground(Color.RED); //Establecemos el color de la letra
		//lblTitulo.setBackground(Color.WHITE); //Cambiamos el color de fotdo
		panel.add(lblTitulo);//Añadimos la etiqueta al panel
	}
	
	
}
