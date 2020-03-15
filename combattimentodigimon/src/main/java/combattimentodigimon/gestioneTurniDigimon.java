package combattimentodigimon;

import java.util.ArrayList;
import java.util.List;

public class gestioneTurniDigimon {
private List<Digimon> listaDigimonCreatore;
private List<Digimon> listaDigimonSfidante;

public gestioneTurniDigimon() {
	this.listaDigimonCreatore = new ArrayList<>();
	this.listaDigimonSfidante = new ArrayList<>();
}



public List<Digimon> getListaDigimonCreatore() {
	return listaDigimonCreatore;
}



public void setListaDigimonCreatore(List<Digimon> listaDigimonCreatore) {
	this.listaDigimonCreatore = listaDigimonCreatore;
}



public List<Digimon> getListaDigimonSfidante() {
	return listaDigimonSfidante;
}



public void setListaDigimonSfidante(List<Digimon> listaDigimonSfidante) {
	this.listaDigimonSfidante = listaDigimonSfidante;
}



public void attaccoDigimon() { 
	// acqua  DANNI NORMALI terra acqua  DANNI SFAVOREVOLI aria   DANNI FAVOREVOLI fuoco
	// fuoco  DANNI NORMALI aria fuoco   DANNI SFAVOREVOLI acqua  DANNI FAVOREVOLI terra
	// aria   DANNI NORMALI fuoco aria   DANNI SFAVOREVOLI terra  DANNI FAVOREVOLI acqua
	// terra  DANNI NORMALI acqua terra  DANNI SFAVOREVOLI fuoco  DANNI FAVOREVOLI aria
	
	
}


}
