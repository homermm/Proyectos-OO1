package test;

import java.time.LocalDate;
import java.time.LocalTime;
import Modelo.*;

import Modelo.Supermercado;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Supermercado minisuper = new Supermercado();
			minisuper.agregarProducto("coca", 120);
			minisuper.agregarProducto("agua", 100);
			minisuper.agregarProducto("pepsi", 90);
//			System.out.println(minisuper.traerProducto(2));
			minisuper.modificarProducto(2, "xD", 90);
//			System.out.println(minisuper.traerProducto(2));
			minisuper.eliminarProducto(2);
			System.out.println(minisuper);
			
			Cliente user= new Cliente(1,"homer",43981363,"callefalsa");
			Carrito car= new Carrito(1,LocalDate.now(),LocalTime.now(), user);
			
			car.agregarItem(minisuper.traerProducto(1), 4);
			
			
			car.eliminarItem(minisuper.traerProducto(1), 4);
			System.out.println(car);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
