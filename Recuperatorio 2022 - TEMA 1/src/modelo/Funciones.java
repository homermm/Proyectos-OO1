package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funciones {

	public static boolean esBisiesto(int anio) {
		return (anio % 4==0 || anio % 100==0 && anio % 400 != 0);
	}
	public static boolean esFechaValida(LocalDate fecha) {	
		boolean valida= false;
		switch(fecha.getMonthValue()) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				if (fecha.getDayOfMonth()<31 || fecha.getDayOfMonth()>1) {
					valida= true;
					break;
				}
			case 4: case 6: case 9: case 11:
				if (fecha.getDayOfMonth()<30 || fecha.getDayOfMonth()>1) {
					valida= true;
					break;
				}
			case 2:
				if(fecha.getDayOfMonth()<29 || fecha.getDayOfMonth()>1) {
					if (fecha.getDayOfMonth()==29 && esBisiesto(fecha.getYear())==true) {
						valida=true;
						break;
					}
				}
		}
		return valida;
	}
	public static String traerFechaCorta(LocalDate fecha) {
		return (fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear());
	}
	public static String traerHoraCorta(LocalTime hora) {
		return (hora.getHour()+":"+hora.getMinute()+":"+hora.getSecond());
	}
	public static boolean esDiaHabil(LocalDate fecha) {
		return ((fecha.getDayOfWeek().getValue()>=1)&& (fecha.getDayOfWeek().getValue()<=5));
	}
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		String dia= "ERROR";
		switch(fecha.getDayOfWeek().getValue()) {
		case 1: dia= "Lunes";break;
		case 2: dia= "Martes";break;
		case 3: dia= "Miercoles";break;
		case 4: dia= "Jueves";break;
		case 5: dia= "Viernes";break;
		case 6: dia= "Sabado";break;
		case 7: dia= "Domingo";break;
		}
		return dia;
	}
	public static String traerMesEnLetras(LocalDate fecha) {
		String mes= "ERROR";
		switch(fecha.getMonthValue()) {
		case 1: mes= "Enero";break;
		case 2: mes= "Febrero";break;
		case 3: mes= "Marzo";break;
		case 4: mes= "Abril";break;
		case 5: mes= "Mayo";break;
		case 6: mes= "Junio";break;
		case 7: mes= "Julio";break;
		case 8: mes= "Agosto";break;
		case 9: mes= "Septiembre";break;
		case 10: mes= "Octubre";break;
		case 11: mes= "Noviembre";break;
		case 12: mes= "Diciembre";break;
		}
		return mes;
	}
	public static String traerFechaLarga(LocalDate fecha) {
		return traerDiaDeLaSemana(fecha)+" "+fecha.getDayOfMonth()+ " de "+traerMesEnLetras(fecha)+" del "+fecha.getYear();
	}
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int dias=0;
		switch(mes) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: dias=31;break;
		case 4: case 6: case 9: case 11: dias=30;break;
		case 2:
				if (esBisiesto(anio) == true) {
					dias=29;
				}
				else {
					dias=28;
				}
		}
		return dias;
	}
	public static double aproximar2Decimal(double valor) {
		return Math.round(valor*100.0)/100.0;
	}
	public static boolean esNumero(char c) {
		return Character.isDigit(c);
	}
	public static boolean esLetra(char c) {
		return Character.isLetter(c);
	}
	public static boolean esCadenaNros(String cadena) {
		boolean numero= true;
		for (int i=0;i<cadena.length();i++) {
			if (esNumero(cadena.charAt(i))==false) {
				numero=false;
				i=cadena.length();
			}
		}
		return numero;
	}
	public static boolean esCandenaLetras(String cadena) {
		boolean letras= true;
		for (int i=0;i<cadena.length();i++) {
			if (esLetra(cadena.charAt(i))==false) {
				letras=false;
				i=cadena.length();
			}
		}
		return letras;
	}
}