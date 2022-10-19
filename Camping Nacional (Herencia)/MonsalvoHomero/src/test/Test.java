package test;
import modelo.Persona;

import java.time.LocalDate;

import modelo.Campamento;
import modelo.Servicio;
import modelo.Recreo;
import modelo.CampingNacional;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CampingNacional camping= new CampingNacional();
		
		System.out.println("-1-");
		try {
			camping.agregarPersona("Lopez", "Sergio", 11111111);
			System.out.println(camping.traerPersona(11111111));
			camping.agregarPersona("Rodriguez", "Juan", 22222222);
			System.out.println(camping.traerPersona(22222222));
			camping.agregarPersona("Fernandez", "Maria", 33333333);
			System.out.println(camping.traerPersona(33333333));
			camping.agregarPersona("Vazquez", "Juan",44444444);
			System.out.println(camping.traerPersona(44444444));
			camping.agregarPersona("Martinez","Ana",55555555);
			System.out.println(camping.traerPersona(55555555));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("-2-");
		try {
			camping.agregarRecreo("7358902",LocalDate.of(2022, 9, 2),false,camping.traerPersona(11111111),5,300);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			camping.agregarCampamento("6573540", LocalDate.of(2022, 9, 3), false,camping.traerPersona(22222222),null,1,1500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			camping.agregarRecreo("3571398", LocalDate.of(2022, 9, 3), false,camping.traerPersona(33333333),10,300);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			camping.agregarCampamento("2583941",LocalDate.of(2022, 9, 3) , true, camping.traerPersona(44444444), LocalDate.of(2022, 9, 8), 2, 1500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			camping.agregarRecreo("5243925", LocalDate.of(2022, 9, 3), true, camping.traerPersona(55555555), 8, 300);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(camping.getLstServicios());
		
		System.out.println("-3-");
		System.out.println(camping.traerServiciosPorPrecioFinal(100));
	
		
		System.out.print("-4-");
		System.out.println(camping.traerCampamentosPorDias(5));
		
		System.out.println("-5-");
		try {
			camping.agregarPersona("Fernandez", "Maria", 33333333);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("-6-");
		try {
			System.out.println(camping.agregarRecreo("5732927", LocalDate.of(2022, 10, 2), false, camping.traerPersona(11111111), 5, 300));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
