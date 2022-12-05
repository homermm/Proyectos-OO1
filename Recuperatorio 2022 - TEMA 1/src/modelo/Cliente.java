package modelo;

import java.time.LocalDate;
import java.time.Period;

public class Cliente extends Persona {
	private boolean activo;

	public Cliente(int idPersona, String nombre, String apellido, long dni, LocalDate fechaDeAlta, boolean activo) {
		super(idPersona, nombre, apellido, dni, fechaDeAlta);
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return super.toString()+"Cliente [activo=" + activo + "]";
	}

	@Override
	public int antiguedadEnAnios() {
		// TODO Auto-generated method stub
		int antiguedad = Period.between(fechaDeAlta, LocalDate.now()).getYears();
		if(!activo) antiguedad=0;
		return antiguedad;
	}
	
}
