package modelo;

import java.time.LocalDate;

public abstract class Servicio {
	protected int idServicio;
	protected String codIngreso;
	protected LocalDate fechaIngreso;
	protected boolean checkOut;
	protected Persona responsable;
	public Servicio(int idServicio, String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable) throws Exception {
		super();
		this.idServicio = idServicio;
		this.setCodIngreso(codIngreso);
		this.fechaIngreso = fechaIngreso;
		this.checkOut = checkOut;
		this.responsable = responsable;
	}
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getCodIngreso() {
		return codIngreso;
	}
	public void setCodIngreso(String codIngreso) throws Exception {
		if (!esValidoDigitoControl(codIngreso)) throw new Exception("El codigo no es valido");
		this.codIngreso = codIngreso;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public boolean isCheckOut() {
		return checkOut;
	}
	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}
	public Persona getResponsable() {
		return responsable;
	}
	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}
	@Override
	public String toString() {
		return "\nServicio [idServicio=" + idServicio + ", codIngreso=" + codIngreso + ", fechaIngreso=" + fechaIngreso
				+ ", checkOut=" + checkOut + ", responsable=" + responsable + "]\n";
	}
	
	//********************
	public boolean esValidoDigitoControl(String codIngreso) {
	double suma=0;
	for (int i=0;i<6;i++) {
		suma+= Character.getNumericValue(codIngreso.charAt(i));
	}
	
	return ((suma%10)==Character.getNumericValue(codIngreso.charAt(6)));
	}
	
	//CU7
	public abstract double calcularPrecioFinal();
	
}
