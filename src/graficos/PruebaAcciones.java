package graficos;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/*con este programa se hace una practica de la interface Acction 
 * que permite que un mismi componete este a la escucha de 
 * modos distintos de activacion. El ejemplo en concreto
 * busca que tres botones cambien el lolor del panel al presio
 * narlos, pero que tambien se pueda hacer desde el teclado
 * 
 * La segunda parte del problema debe seguir una serie de pasos
 * 1.- Crear un mapa de entrada(indicar cual va a ser 
 * el objeto en el cual tiene que insidir la combinacion de teclas).
 * -quien tiene el foco? Clases(ImputMap,JComponent->getImputMap(int condicion)
 * 2.-Crear combinacion de teclas 
 * Guardar descripcion de las teclas. Clase(KeyStroke->staticgetkeystroke(String s)
 * 3.-Asignar combinacion de teclas a objeto 
 * Clase(InputMap-> put(KeyStroke,Objet))
 * 4.-Asignar objeto a accion
 * Class(ActionMap->put(Objet,action))
 * */
public class PruebaAcciones {
	public static void main(String [] args) {
		MarcoAccion miMarco=new MarcoAccion();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class MarcoAccion extends JFrame{
	public MarcoAccion(){
		setTitle("Prueba Acciones");
		setBounds(450,150,400,400);
		PanelAccion miLamina=new PanelAccion();
		add(miLamina);
		setVisible(true);
	}
}

class PanelAccion extends JPanel{//Clase oyente
	
	public PanelAccion() {
		/*Instancias correspondientes de la clase oyente 
		 * AccionColor, una para cada color. Con lo cual cuando
		 * invoco al constructor todos estos parametros viajan
		 * y se almacenan correspondientemente donde deben 
		 *  y luego el putValue ahce su trabajo, para cuando
		 *  se cree el objeto se almacenen de forma Clave:Valor*/
		
		AccionColor accionAmarillo=new AccionColor("Amarillo",new ImageIcon("src/graficos/bolaAmarilla .jpg"),Color.YELLOW);
		AccionColor accionRojo=new AccionColor("Rojo",new ImageIcon("src/graficos/bolaRoja.gif"),Color.RED);
		AccionColor accionAzul=new AccionColor("Azul",new ImageIcon("src/graficos/bolaAzul.gif"),Color.blue);
	
		//otra forma de crear botones(constructor diferente objeto tipo Accion)

		//JButton botonAmarillo=new JButton(accionAmarillo);
		//add(botonAmiarillo);
		//mas simple aun es instanciando directamete dentro del constructor
		
		/*Esto de debe a que existe en la api un constructor
		 * de la clase JButton que puede recibir como parametro
		 * un objeto de tipo Accion(es este caso instancias 
		 * de la clase AcionColor)*/
		add(new JButton(accionAmarillo));
		add(new JButton(accionRojo));
		add(new JButton(accionAzul));
		
		
 /*//1.creando las instancias de los botones con la clase JButton
	JButton botonAmarillo=new JButton("Amarillo");
	JButton botonRojo=new JButton("Rojo");
	JButton botonAzul=new JButton("Azul");
//2.Agregando los botones a la lamina que es la clase donde estoy JPanel
	add(botonAmarillo);
	add(botonRojo);
	add(botonAzul);*/
		
	//Parte de escucha a teclado
		//paso1 Crear Mapa..ImputMap vincula un evento con una combinacion de teclas; getInputMap me devuelve un objeto de este tipo
	InputMap mapaEntrada =getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//paso2 Crear convinacion de teclas 
//	KeyStroke teclaAmarillo= KeyStroke.getKeyStroke("ctrl A");
		//paso3 Asignar la convinacion de techas a un objeto
	mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondoAmarillo");//fondoAmarillo, fondoAzul o fondoRojo son nombre arbitrarios para identificar los objetos accion de tecla
	mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondoAzul");// los dos argumentros que debe llevar ese metodo son: la combinacion de teclas (crtl a por ejemplo) y el identicicador de objetos ("fondoAmarillo" por ejemplo)
	mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondoRojo");//
		//paso4 Asignar el objeto a la accion
	ActionMap mapaAccion=getActionMap();
	mapaAccion.put("fondoAmarillo", accionAmarillo);//este metodo put crea un vinculo entre la clave de la accion con la ACCION EN SI MISMA
	mapaAccion.put("fondoAzul", accionAzul);
	mapaAccion.put("fondoRojo", accionRojo);
	}
	//3. Poner la lamina a la escucha, esto se
	//hace o bien implementado interface Acction o bien herede
	//de la clase  Abstrac Acction
private	class AccionColor extends AbstractAction{
		
		public AccionColor(String nombre,Icon icono, Color colorBoton) {
			/*para almacenar informacion en el objeto evento
			 * se usa uno de los metodos pertenecientes a la 
			 * interface Action (putValue())en cual permite 
			 * almecenar la informacion deseada de la fuente del
			 * evento en el formato de Clave: valor*/
			putValue(Action.NAME,nombre);
			putValue(Action.SMALL_ICON,icono);
			putValue(Action.SHORT_DESCRIPTION,"poner la lamina de color"+nombre);//mensaje emergente
			/*toda esta informacion se almacena automaticamente 
			 * en el objeto evento actionPerformed(ActionEvent e)*/
			
			/*ahora la accion del boton, aca en vez de utilizar 
			 * un campo estatico de la interface Action para crear
			 * la pareja de clave:valor, las defino yo. la Clave 
			 * va a ser Color_de_Fondo(inventada por mi)y el valor
			 * de esa clave sera colorBoton, es decir el tercer 
			 * parametro que le estoy pasando al constructor.
			 * Con todo esto he conseguido es crear un objeto de 
			 * tipo evento y se almacenara en el estas 4 caractereisticas
			 *  */
			putValue("Color_de_Fondo",colorBoton);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			//Color c=getValue("Color_de_Fondo");
			
			/* Aca estoy rescatando del
			objeto del evento el valor correspondiente a una clave
			pero estoy intentando almacenar un texto que correes
			ponde al valor de esta clave dentro de una variable 
			de tipo color, por tanto debo hacer un casting*/
			Color c=(Color)getValue("Color_de_Fondo");
			
			/*luego podemos intentar usar el metodo setBackground()
			 * para poner el color de fondo de una lamina pero eso
			 * daria un error ya ese metodo pertenece a la clases
			 * JPalenk, por tanto una solucion es hacer esta clase
			 * interna al la clase PanelAction que extiende de 
			 * de JPanel*/
			
			setBackground(c);
			
			System.out.println("Nombre "+getValue(Action.NAME)+
					" Descripcion "+getValue(Action.SHORT_DESCRIPTION));
			
		}
		
	}
}


