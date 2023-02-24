package com.projecte.main;
import com.projecte.jorge.Jorge;
import com.projecte.daniel.Daniel;
import com.projecte.angel.Angel;
import com.projecte.maikol.Maikol;


public class ProgramaPrincipal {

	public static void main(String[] args) {
		Jorge p1 = new Jorge();
		Daniel p2 = new Daniel();
		Angel p3 = new Angel();
		Maikol p4 = new Maikol();
		
		p1.MostrarNom();
		p2.MostrarNom();
		p3.MostrarNom();
		p4.MostrarNom();
		p1.MostrarNom();
	}

}
