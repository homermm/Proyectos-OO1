package test;
import java.time.LocalDate;
import java.time.LocalTime;

import modelo.*;

public class Test {

	public static void main(String[] args) {
		
		SistemaYPF sistema = new SistemaYPF();
		
		System.out.println("-1-");
		try {
			sistema.agregarTarjeta("ABCDEFG123456", "DNI11222333");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarTarjeta("ABCDE1234567", "DNI11222333");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarTarjeta("ABCDEFG12345", "DNI11222333");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("-2-");
		try {
			sistema.agregarTarjeta("ABCDEF123456", "DNI11222333");
			sistema.agregarTarjeta("GHIJKL987654", "DNI44555666");
			sistema.agregarTarjeta("MNOPQR456654", "DNI77888999");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(sistema.getTarjetas());
		
		System.out.println("-3.1-");
		Tarjeta aux = sistema.traerTarjeta("DNI11222333");
		aux.agregarCompra(LocalDate.of(2021, 9, 10), LocalTime.of(10, 30), 100, 25, 20);
		aux.agregarCompra(LocalDate.of(2021, 10, 1), LocalTime.of(20, 30), 200, 40, 50);
		aux.agregarCompra(LocalDate.of(2021, 9, 15), LocalTime.of(10, 30), 100, 30, "MODO", 500);
		aux.agregarCompra(LocalDate.of(2021, 10, 1), LocalTime.of(20, 30), 200, 20, "MODO", 500);
		System.out.println(aux.getCompras());
		System.out.println(aux.calcularPuntaje());
		
		System.out.println("-3.2-");
		sistema.traerTarjeta("DNI44555666").agregarCompra(LocalDate.of(2021, 9, 11), LocalTime.of(15, 00), 100, 20, 20);
		
		System.out.println("-3.3-");
		sistema.traerTarjeta("DNI44555666").agregarCompra(LocalDate.of(2021, 9, 16), LocalTime.of(15, 00), 100, 35, "MERCADO PAGO", 1000);
		
		System.out.println("-4-");
		System.out.println(sistema.traerTarjeta("DNI11222333").calcularPuntaje());
		
		System.out.println("-5-");
		System.out.println(sistema.traerTarjeta("DNI11222333").calcularPuntaje(LocalDate.of(2021, 10, 1)));
		
		System.out.println("-6-");
		System.out.println(sistema.traerTarjeta("DNI11222333").calcularPuntaje(2021, 9));
		
		System.out.println("-7-");
		System.out.println(sistema.traerTarjetasComprasEfectivo(LocalDate.of(2021, 8, 1), LocalDate.of(2021, 11, 1)));
		
		System.out.println("TARJETASDASDSA");
		System.out.println(sistema);
		
	}

}
