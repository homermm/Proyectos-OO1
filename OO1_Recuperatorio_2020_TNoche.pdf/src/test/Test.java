package test;
import java.time.LocalDate;
import java.time.LocalTime;

import modelo.*;

public class Test {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		System.out.println("1-1");
		try {
			sistema.agregarTrabajoPresencial(LocalDate.of(2020, 10, 15), "1578", LocalTime.of(9, 0), LocalTime.of(17, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("1-2");
		try {
			sistema.agregarTeletrabajo(LocalDate.of(2020, 10, 15), "3782", "Pandemia", 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("1-3");
		try {
			sistema.agregarTrabajoPresencial(LocalDate.of(2020, 10, 15), "1578", LocalTime.of(10, 0), LocalTime.of(18, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarTeletrabajo(LocalDate.of(2020, 10, 16), "3724", "Pandemia", 9);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("3");
		try {
			sistema.agregarTrabajoPresencial(LocalDate.of(2020, 10, 15), "2839", LocalTime.of(9, 0), LocalTime.of(17, 0));
			sistema.agregarTeletrabajo(LocalDate.of(2020, 10, 16), "3452", "Pandemia", 5);
			sistema.agregarTeletrabajo(LocalDate.of(2020, 10, 16), "5243", "Pandemia", 7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("-4.1-");
		System.out.println(sistema.traerAsistencia(LocalDate.of(2020, 10, 15)));
		
		System.out.println("-4.2-");
		System.out.println(sistema.traerAsistencia(false));
	}

}
