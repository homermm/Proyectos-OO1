package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemasCallCenter sistema = new SistemasCallCenter();
		
		System.out.println("-1-");
		try {
			sistema.agregarCliente("Luis", "Perez", 11111111, LocalDate.of(2020, 1, 1), true);
			sistema.agregarCliente("Lucas", "Pereyra", 22222222, LocalDate.of(2020, 2, 1), false);
			sistema.agregarEmpleado("Pedro", "Gomez", 33333333, LocalDate.of(2020, 2, 11), 10000);
			sistema.agregarEmpleado("Pablo", "Lopez", 44444444, LocalDate.of(2022, 3, 15), 9000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println(sistema.getLstPersonas());
		
		System.out.println("-2-");
		//agregarLlamada(LocalDate fecha, LocalTime hora, Cliente cliente, Empleado empleado, int nivelDeSatisfaccion) throws Exception {

		try {
			sistema.agregarLlamada(LocalDate.of(2022, 11, 6), LocalTime.of(10, 10), (Cliente)sistema.traerPersona(11111111), (Empleado)sistema.traerPersona(33333333),5);
			sistema.agregarLlamada(LocalDate.of(2022, 11, 7), LocalTime.of(10, 10), (Cliente)sistema.traerPersona(11111111), (Empleado)sistema.traerPersona(33333333), 5);
			sistema.agregarLlamada(LocalDate.of(2022, 11, 7), LocalTime.of(10, 15), (Cliente)sistema.traerPersona(22222222), (Empleado)sistema.traerPersona(33333333), 5);
			sistema.agregarLlamada(LocalDate.of(2022, 11, 7), LocalTime.of(10, 20), (Cliente)sistema.traerPersona(11111111), (Empleado)sistema.traerPersona(44444444), 3);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		System.out.println(sistema.getLstLlamadas());
		
		System.out.println("-3-");
		System.out.println(sistema.traerClientes(true));
		
		System.out.println("-4-");
		System.out.println(sistema.traerPersonasAntiguedad(2));
		
		System.out.println("-5-");
		System.out.println(sistema.traerllamadas(LocalDate.of(2022, 11, 7), LocalTime.of(10, 10), LocalTime.of(10, 18)));
		
		System.out.println("-6-");
		try {
			sistema.agregarCliente("Marcos", "Rios", 22222222, LocalDate.of(2020, 2, 1), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("-7-");
		try {
			sistema.agregarEmpleado("Miguel", "Martinez", 44444444, LocalDate.of(2020, 2, 1), 9500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("-8-");
		try {
			sistema.agregarLlamada(LocalDate.of(2022, 11, 7), LocalTime.of(10, 30), (Cliente)sistema.traerPersona(11111111), (Empleado)sistema.traerPersona(33333333), 8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

}
