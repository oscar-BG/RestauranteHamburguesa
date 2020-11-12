import javax.swing.JFrame;

public class Ventana  extends  JFrame{
	
	public Ventana(){
		setTitle("Hamburguesa");
		setSize(500,500); //Tamaño de la ventana
		//setLocation(500,200); //(x,y)Punto inicial de la ventana
		//setBounds(500,200,500,500); //(x,y,w,h)
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Cerrar ventana
		
	}
	
	
}
