package test;

import java.time.LocalDate;

import modelo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaDistribuidora sistema = new SistemaDistribuidora();
		
		System.out.println("Test 1");
		sistema.agregarCliente(4483979, "Juan", "Perez", 11111111, 500);
		sistema.agregarCliente(4971920, "Marcela", "Rodriguez", 22222222, 0);
		sistema.agregarCliente(7324211, 333333333, "UTT");
		sistema.agregarCliente(7329827, 444444444, "Cooperativa El Grito Sagrado");
		
		System.out.println(sistema.getLstCliente());
		
		System.out.println("Test 2");
		sistema.agregarTarifa(0, 50, 300, 2);
		sistema.agregarTarifa(51, 100, 350, 2.1);
		sistema.agregarTarifa(101, 200, 450, 2.5);
		sistema.agregarTarifa(201, 400, 500, 3);
		sistema.agregarTarifa(401, 2000, 1000, 4);
		System.out.println(sistema.getLstTarifa());
		
		
		System.out.println("Test 3");
		sistema.agregarLectura(LocalDate.of(2021, 12, 25), sistema.traerCliente(4483979), 180);
		sistema.agregarLectura(LocalDate.of(2022, 1, 25), sistema.traerCliente(4483979), 255);
		sistema.agregarLectura(LocalDate.of(2021, 12, 25), sistema.traerCliente(4971920), 100);
		sistema.agregarLectura(LocalDate.of(2022, 1, 25), sistema.traerCliente(4971920), 165);
		sistema.agregarLectura(LocalDate.of(2021, 12, 25), sistema.traerCliente(7324211), 3526);
		sistema.agregarLectura(LocalDate.of(2022, 1, 25), sistema.traerCliente(7324211), 4385);
		sistema.agregarLectura(LocalDate.of(2021, 12, 25), sistema.traerCliente(7329827), 10862);
		sistema.agregarLectura(LocalDate.of(2022, 1, 25), sistema.traerCliente(7329827), 11981);
		
		System.out.println(sistema.getLstLectura());
		
		System.out.println("Test 4");
//		System.out.println(sistema.traerLectura(1, 2022, sistema.traerCliente(4483979)));
		Lectura l1 =sistema.traerLectura(1, 2022, sistema.traerCliente(4483979));
		System.out.println(l1);
		
		System.out.println("Test 5");
		Lectura l2=sistema.traerLectura(12, 2021, sistema.traerCliente(4483979));
		System.out.println(l2);
		
		System.out.println("Test 6");
		System.out.println(l1.calcularConsumo(l2));
		
		System.out.println("Test 7");
		System.out.println(sistema.traerTarifa(l1.calcularConsumo(l2)));
		
		System.out.println("Test 8");
		System.out.println(sistema.calcularTotalACobrar(1, 2022, sistema.traerCliente(4483979)));
		
	}

}
