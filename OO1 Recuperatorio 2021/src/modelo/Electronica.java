package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Electronica extends Compra{
	private String medio;
	private double puntosDeRegalo;
	
	public Electronica(int idCompra, LocalDate fecha, LocalTime hora, double puntosPorLitro, double litrosComprados,
			String medio, double puntosDeRegalo) {
		super(idCompra, fecha, hora, puntosPorLitro, litrosComprados);
		this.medio = medio;
		this.puntosDeRegalo = puntosDeRegalo;
	}
	public String getMedio() {
		return medio;
	}
	public void setMedio(String medio) {
		this.medio = medio;
	}
	public double getPuntosDeRegalo() {
		return puntosDeRegalo;
	}
	public void setPuntosDeRegalo(double puntosDeRegalo) {
		this.puntosDeRegalo = puntosDeRegalo;
	}
	@Override
	public String toString() {
		return super.toString()+"Electronica [medio=" + medio + ", puntosDeRegalo=" + puntosDeRegalo + "]";
	}
	@Override
	public double calcularPuntajeFinal() {
		// TODO Auto-generated method stub
		return (puntosPorLitro*litrosComprados)+puntosDeRegalo;
	}
	
}
