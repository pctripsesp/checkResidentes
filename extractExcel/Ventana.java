package extractExcel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Box;


/**
 * Este programa pretende administrar consultas de un listado de residentes 
 * almacenando los datos en una hoja Excel protegida con contraseña
 * @author pctripsesp
 */


public class Ventana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MiMarco();
		
	}
}



//Marco
class MiMarco extends JFrame{
	
	//Constructor
	public MiMarco(){
		
		setVisible(true);
		setTitle("BUSCAR RESIDENTE");
		setSize(800,600);
		//Con esto lo hacemos centrado
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//creamos y agregamos la lámina personal
		LaminaPersonal laminaPersonal = new LaminaPersonal();
		getContentPane().add(laminaPersonal, BorderLayout.CENTER);
		setVisible(true);
		
	}
}


//Lámina con el botón de búsqueda 
/**
 * IMPLEMENTA ACTIONLISTENER PORQUE VA A SER EL OYENTE DE LA ACCIÓN
 */
class LaminasBotones extends JPanel implements ActionListener{
	
	//Constructor
	public LaminasBotones(){
		
	setLayout(new BorderLayout());
	//Definimos la posición del Layout. TIPOS --> https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html 
		//BoxLayout, BorderLayout, FlowLayout, GridLayout...
		
	//Creamos una lámina dentro de esta para que el botón no ocupe todo el BorderLayout.SOUTH
	JPanel laminaBotonCentrado = new JPanel();
	add(laminaBotonCentrado);
	
	//Creamos y añadimos el botón
	JButton botonEnviar = new JButton("Buscar");
	laminaBotonCentrado.add(botonEnviar);
	
	/**
	 * Añadimos el oyente para la acción del botón (que va a ser esta lámina que es donde está el método actionPerformed.
	 * Como estamos en la misma clase donde está el método, pondremos this
	 */
	
	botonEnviar.addActionListener(this);
	
	}

	/**
	 * Sobreescribimos el método de la interfaz ActionLister
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//ponemos lo que queremos que haga al recibir el evento del botón
		
		System.out.println("Bienvenido");
		
	}
}



class LaminaPersonal extends JPanel implements ActionListener{

	private JLabel etiquetaTitulo, etiquetaNombre,etiquetaDNI ,etiquetaDireccion, etiquetaTelefono, etiquetaVehiculo, etiquetaObservaciones,etiquetaDerechos;
	private JTextField nombre,DNI,direccion,telefono,vehiculo;
	private JTextArea observaciones;
	private Box cajaTitulo, cajaFondo, cajaNombre,cajaDNI,cajaDir,cajaTelf,cajaBotones,cajaVehiculo, cajaObservaciones, cajaDerechos;
	private JButton botonBuscar,botonGuardar;
	
	public LaminaPersonal(){
		
		//Cajas contenedoras
		cajaFondo = Box.createVerticalBox();
		cajaTitulo = Box.createHorizontalBox();
		cajaNombre = Box.createHorizontalBox();
		cajaDNI = Box.createHorizontalBox();
		cajaDir = Box.createHorizontalBox();
		cajaTelf = Box.createHorizontalBox();
		cajaVehiculo = Box.createHorizontalBox();
		cajaObservaciones = Box.createHorizontalBox();
		cajaBotones = Box.createHorizontalBox();
		cajaDerechos = Box.createHorizontalBox();
				
		add(cajaFondo,BorderLayout.CENTER);
		
		//Añadimos espacios verticales entre las cajas
		cajaFondo.add(Box.createVerticalStrut(10));
		cajaFondo.add(cajaTitulo);
		cajaFondo.add(Box.createVerticalStrut(30));
		cajaFondo.add(cajaNombre);
		cajaFondo.add(Box.createVerticalStrut(30));
		cajaFondo.add(cajaDNI);
		cajaFondo.add(Box.createVerticalStrut(40));
		cajaFondo.add(cajaTelf);
		cajaFondo.add(Box.createVerticalStrut(40));
		cajaFondo.add(cajaDir);
		cajaFondo.add(Box.createVerticalStrut(40));
		cajaFondo.add(cajaVehiculo);
		cajaFondo.add(Box.createVerticalStrut(40));
		cajaFondo.add(cajaObservaciones);		
		cajaFondo.add(Box.createVerticalStrut(60));
		cajaFondo.add(cajaBotones);
		cajaFondo.add(Box.createVerticalStrut(60));
		cajaFondo.add(cajaDerechos);
		
		//Botones
		botonBuscar = new JButton("Buscar");
		botonBuscar.setBackground(java.awt.Color.green);
		botonGuardar = new JButton("Guardar");
		botonGuardar.setBackground(java.awt.Color.yellow);
		
		//Etiquetas
		etiquetaTitulo = new JLabel("COMPROBAR RESIDENTE");
		etiquetaNombre = new JLabel("Nombre: ");
		etiquetaDNI = new JLabel("Documento de Identidad: ");
		etiquetaDireccion = new JLabel("Dirección: ");
		etiquetaTelefono = new JLabel("Teléfono: ");
		etiquetaVehiculo = new JLabel("Vehículo: ");
		etiquetaObservaciones = new JLabel("Observaciones: ");
		etiquetaDerechos = new JLabel("pctripsesp@gmail.com");
		etiquetaDerechos.setFont(new Font("Serif", Font.PLAIN, 12));
		
		//TextField
		nombre = new JTextField();
		DNI = new JTextField();
		direccion = new JTextField();
		telefono = new JTextField();
		vehiculo = new JTextField();
		observaciones = new JTextArea(5,10);

		//Añadimos elementos a las cajas
		cajaTitulo.add(etiquetaTitulo);
		cajaNombre.add(etiquetaNombre);
		cajaNombre.add(nombre);
		cajaDNI.add(etiquetaDNI);
		cajaDNI.add(DNI);
		cajaTelf.add(etiquetaTelefono);
		cajaTelf.add(telefono);
		cajaDir.add(etiquetaDireccion);
		cajaDir.add(direccion);
		cajaVehiculo.add(etiquetaVehiculo);
		cajaVehiculo.add(vehiculo);
		cajaObservaciones.add(etiquetaObservaciones);
		cajaObservaciones.add(observaciones);
		cajaBotones.add(botonGuardar);
		cajaBotones.add(Box.createRigidArea(new Dimension(100,0)));
		cajaBotones.add(botonBuscar);
		cajaDerechos.add(etiquetaDerechos);
		
		//Añadimos eventos botones
		botonGuardar.addActionListener(this);
		botonGuardar.setActionCommand("Guardar Personal");
		botonBuscar.addActionListener(this);
		botonBuscar.setActionCommand("Buscar Personal");
		
	}
	
	
	//Con esta función recogemos los datos del formulario, los almacenamos
	public void buscarDatosPersonal(){
		
		//Comprobamos si se introduce pabellón (NO PERMITIREMOS BÚSQUEDA POR DIRECCIÓN
		if (direccion.getText().length()>0){
			JOptionPane.showMessageDialog(this,"El campo DIRECCIÓN debe estar vacío");
			direccion.setText("");
			
		}else{
			
			//Recogemos los datos del textfield
			String name = nombre.getText();
			String dni = DNI.getText();
			String telf = telefono.getText();
			String pabellon = direccion.getText();
			String vehic = vehiculo.getText();
			String obser = observaciones.getText();
			
			//Creamos el array con los datos
			ArrayDatos bDatos = new ArrayDatos(name, dni, telf, pabellon, vehic, obser);
			
			//Reseteamos el textfield
			nombre.setText("");
			DNI.setText("");
			telefono.setText("");
			direccion.setText("");
			vehiculo.setText("");
			observaciones.setText("");
			
			//BUSCAMOS COINCIDENCIAS EN LA FUNCION getterData
			try {
				ArrayList<String[]> datosExtraidos = extractData.getterData(bDatos);
				String resultado = "";
				for (String[] fila : datosExtraidos){
					for (String celda : fila){
						String fil = celda+"    ";
						resultado+=fil;
					}		
					resultado+="\n";
					//System.out.println();
				}
			if (resultado == ""){
				JOptionPane.showMessageDialog(this, "No se han encontrado coincidencias");
			}else{
				JOptionPane.showMessageDialog(this, resultado);
			}
			
			
			 }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
		}		
	}
	
	
	
	//Con esta función buscamos los datos del personal
	public void guardarDatosPersonal(){
					
		String name = nombre.getText();
		String dni = DNI.getText();
		String telf = telefono.getText();
		String pabellon = direccion.getText();
		String vehic = vehiculo.getText();
		String obser = observaciones.getText();
		
		ArrayDatos gDatos = new ArrayDatos(name, dni, telf, pabellon, vehic, obser);
			
		//Reseteamos el textfield
		nombre.setText("");
		DNI.setText("");
		telefono.setText("");
		direccion.setText("");
		vehiculo.setText("");
		observaciones.setText("");
				
	}		
			
		
	
	
	/**
	 * EVENTOS LÁMINA
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		//Recogemos la fuente del evento
		String comando = arg0.getActionCommand();
		
		switch (comando) {
				
		case "Guardar Personal":
			
			guardarDatosPersonal();
			System.out.println("GUARDAR");
			JOptionPane.showMessageDialog(this,"Esta función está deshabilitada");
			break;
			
		case "Buscar Personal":
			
			buscarDatosPersonal();
			System.out.println("BUSCAR");
			//cambioLamina(1);
			break;
			
		default:
			break;
		}
	}
	
}





//Creamos la clase del ArrayDatos para pasarlos a la funcion extractData
class ArrayDatos {

  public String nombre, telefono, pabellon, vehiculo, dni, observaciones;
  
  // Constructor de la clase
  public ArrayDatos(String nombre, String dni, String telefono, String pabellon, String vehiculo, String observaciones) {
      this.nombre = nombre;
      this.dni = dni;
      this.telefono = telefono;
      this.pabellon = pabellon;
      this.vehiculo = vehiculo;
      this.observaciones = observaciones;
      
  }

}
