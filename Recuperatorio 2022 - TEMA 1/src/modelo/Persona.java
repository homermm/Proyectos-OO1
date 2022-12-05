package modelo;

import java.time.LocalDate;

public abstract class Persona {
	protected int idPersona;
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected LocalDate fechaDeAlta;
	public Persona(int idPersona, String nombre, String apellido, long dni, LocalDate fechaDeAlta) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeAlta = fechaDeAlta;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}
	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
	@Override
	public String toString() {
		return "\nPersona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaDeAlta=" + fechaDeAlta + "]";
	}
	//*****
	public abstract int antiguedadEnAnios();
}
