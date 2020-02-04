package graficos;
import javax.swing.*;


public class SintaxisRadio {
	 public static void main(String [] args) {
		 MarcoRadioSintaxis miMarco = new MarcoRadioSintaxis();
		 miMarco.setVisible(true);
	 }
}

class MarcoRadioSintaxis extends JFrame{
	public MarcoRadioSintaxis() {
		setTitle("Componentes Swing. Botones de Radio. Video 93");
		setBounds(450,200,500,300);
		LaminaRadio miLamina=new LaminaRadio();
		add(miLamina);
	}
}

class LaminaRadio extends JPanel{
	public LaminaRadio() {
		ButtonGroup miGrupo1=new ButtonGroup();
		ButtonGroup miGrupo2=new ButtonGroup();
		
		JRadioButton boton1=new JRadioButton("Azul",false);
		JRadioButton boton2=new JRadioButton("Rojo",true);
		JRadioButton boton3=new JRadioButton("Verde",false);
		JRadioButton boton4=new JRadioButton("Masculino",false);
		JRadioButton boton5=new JRadioButton("Femenino",false);
		//ahora quiero decir que los tres botones, pertecenen
		//a la instancia de la clase ButtonGroup
		miGrupo1.add(boton1);
		miGrupo1.add(boton2);
		miGrupo1.add(boton3);
		
		miGrupo2.add(boton4);
		miGrupo2.add(boton5);
		/*para agregar los botones a la lamina debo agregar los botones a la 
		 * lamina uno a uno */
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
	}
}