package modelo;

import java.time.LocalDate;
import java.time.Period;

public class Empleado extends Persona {
	private int sueldoBase;

	public Empleado(int idPersona, String nombre, String apellido, long dni, LocalDate fechaDeAlta, int sueldoBase) {
		super(idPersona, nombre, apellido, dni, fechaDeAlta);
		this.sueldoBase = sueldoBase;
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	@Override
	public String toString() {
		return super.toString()+"Empleado [sueldoBase=" + sueldoBase + "]";
	}

	@Override
	public int antiguedadEnAnios() {
		// TODO Auto-generated method stub
		
		LocalDate primerDiaHabil= primerDiaHabil();
//		System.out.println(primerDiaHabil);
//		System.out.println(Period.between(fechaDeAlta, primerDiaHabil).getYears());

		return Period.between(fechaDeAlta, primerDiaHabil).getYears();
	}
	public LocalDate primerDiaHabil() {
		LocalDate i = LocalDate.now().plusMonths(1).withDayOfMonth(1);
		LocalDate diaHabil = null;
		while (diaHabil==null) {
			if(Funciones.esDiaHabil(i)) diaHabil = i;
			i=i.plusDays(1);
		}
		return diaHabil;
	}
	
}
