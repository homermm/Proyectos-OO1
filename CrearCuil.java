public String crearCuil() {
		String cuilAux= "20"+String.valueOf(dni);
		String nroAMultiplicar= "5432765432";
		int suma=0;
		
		if(sexo=='f') {
			cuilAux.replace('0', '7');
		}
		for (int i=0;i<nroAMultiplicar.length();i++) {
			suma += Character.getNumericValue(cuilAux.charAt(i))*Character.getNumericValue(nroAMultiplicar.charAt(i));
		}
		switch(suma%11) {
		case 0:cuilAux+='0';break;
		case 1:if(sexo=='m') {
			cuilAux+='9';
			cuilAux.replaceFirst("0", "3");
		}
		else {
			cuilAux+='4';
			cuilAux.replaceFirst("0", "3");
		}break;
		default:cuilAux+=11-suma%11;break;
		}
		System.out.println(cuilAux);
		return cuilAux;
	}
	
	public boolean validarCuil(String cuil) {
		boolean valido=false;
		if(crearCuil().contains(cuil)) {
			System.out.println(crearCuil());
			System.out.println(cuil);
			valido=true;
		}
		return valido;
	}