package model;

import java.io.Serializable;

public class Marca implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	final public static int TAM_CNPJ = 18;
	final public static int TAM_MAX_NOME = 20;
	final public static int TAM_MIN_NOME = 3;
	final public static int NUM_MAX_MARCAS = 10;
	

	private String 	cnpj;
	private String 	nome;
	

	private static Marca[] listaMarcas = new Marca[NUM_MAX_MARCAS];
	private static int numMarcas = 0;

	public Marca(String c, String n) throws Exception {
		this.setCnpj(c);
		this.setNome(n);

		Marca.listaMarcas[ Marca.numMarcas++ ] = this;
	}
	
	public static Marca[] getListaMarcas() {
		return Marca.listaMarcas;
	}
	
	public static void setListaMarcas(Marca[] novaLista) {
		Marca.listaMarcas = novaLista;
		for(int i = 0; i < novaLista.length; i++) {
			if(novaLista[i] != null)
				System.out.println("Recuperei o objeto:" + novaLista[i]);
			else {
				Marca.numMarcas = i;
				break;
			}
		}
	}
	
	public static int getNumMarcas() {
		return Marca.numMarcas;
	}
	
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String c) throws Exception {
		Marca.validarCnpj(c);
		this.cnpj = c;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String n) throws Exception {
		Marca.validarNome(n);
		this.nome = n;
	}
	
	public static void validarCnpj(String cnpj) throws Exception {
		if(cnpj == null)
			throw new Exception("O cnpj não pode ser nulo!");
		if(cnpj.length() != TAM_CNPJ)
			throw new Exception("O cnpj deve ter " + TAM_CNPJ + " caracteres!");
		for(int i = 0; i < TAM_CNPJ; i++) {
			char c = cnpj.charAt(i);
			switch(i) {
				case 2:
				case 6: 
					if(c != '.')
						throw new Exception("Na posição " + i + " deve aparecer um '.' no cnpj!");
					break;
				case 10:
					if(c != '/')
						throw new Exception("Na posição " + i + " deve aparecer um '/' no cnpj!");
					break;
				case 11:
				case 12:
				case 13:
					if(c != '0')
						throw new Exception("Na posição " + i + " deve aparecer um '0' no cnpj!");
					break;
				case 14:
					if(c != '1' && c != '2')
						throw new Exception("Na posição " + i + " deve aparecer um '1' ou '2' no cnpj!");
					break;
				case 15:
				if(c != '-')
						throw new Exception("Na posição " + i + " deve aparecer um '0' no cnpj!");
					break;
				default: 
					if(!Character.isDigit(c))
						throw new Exception("Na posição " + i + " deve aparecer '-' !");;
			}
		}
	}
	
	public static void validarNome(String nome) throws Exception {
		if(nome == null)
			throw new Exception("O nome não pode ser nulo!");
		if(nome.length() < TAM_MIN_NOME || nome.length() > TAM_MAX_NOME)
			throw new Exception("O nome deve ter entre " + TAM_MIN_NOME + " e " + TAM_MAX_NOME + " caracteres!");
		for(int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if( ! Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new Exception("O nome deve ter conter somentes letras e espaço em branco!");
		}
	}


}
