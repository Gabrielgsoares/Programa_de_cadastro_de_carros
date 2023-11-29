package model;

import java.io.Serializable;

public class Automovel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	final public static int TAM_PLACA = 7;
	final public static int TAM_MAX_COR= 15;
	final public static int TAM_MIN_COR= 4;
	final public static int NUM_MAX_AUTOMOVEIS = 10;
	final public static int MIN_ANO = 1900;
	final public static int MAX_ANO = 2024;
	final public static int MIN_KILOMETRAGEM = 0;
	

	private String 	placa;
	private String 	cor;
	private String combustivel;
	private int ano;
	private int kilometragem;
	private ModeloVersao meuMV;
	

	private static Automovel[] listaAutomoveis = new Automovel[NUM_MAX_AUTOMOVEIS];
	private static int numAutomoveis = 0;

	public Automovel(String p, String cr, String co, int a, int k, ModeloVersao d) throws Exception {
		this.setPlaca(p);
		this.setCor(cr);
		this.setCombustivel(co);
		this.setAno(a);
		this.setKilometragem(k);
		this.setMeuMV(d);
		

		Automovel.listaAutomoveis[ Automovel.numAutomoveis++ ] = this;
	}
	
	public static Automovel[] getListaAutomoveis() {
		return Automovel.listaAutomoveis;
	}
	
	public static void setListaAutomoveis(Automovel[] novaLista) {
		Automovel.listaAutomoveis = novaLista;
		for(int i = 0; i < novaLista.length; i++) {
			if(novaLista[i] != null)
				System.out.println("Recuperei o objeto:" + novaLista[i]);
			else {
				Automovel.numAutomoveis = i;
				break;
			}
		}
	}
	
	public static int getNumAutomoveis() {
		return Automovel.numAutomoveis;
	}
	

	public String getPlaca() {
		return this.placa;
	}
	

	public void setPlaca(String p) throws Exception {
		Automovel.validarPlaca(p);
		this.placa = p;
	}
	
	public String getCor() {
		return this.cor;
	}
	
void setCor(String cr) throws Exception {
		Automovel.validarCor(cr);
		this.cor = cr;
	}
	
	public String getCombustivel() {
		return this.combustivel;
	}
	
	public void setCombustivel(String co) throws Exception {
		Automovel.validarCombustivel(co);
		this.combustivel = co;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public void setAno(int a) throws Exception {
		Automovel.validarAno(a);
		this.ano = a;
	}
	
	public int getKilometragem() {
		return this.kilometragem;
	}
	
	public void setKilometragem(int k) throws Exception {
		Automovel.validarKilometragem(k);
		this.ano = k;
	}
	
	public ModeloVersao getMeuMV() {
		return this.meuMV;
	}
	
	public void setMeuMV(ModeloVersao d) throws Exception {
		Automovel.validarMeuMV(d);
		this.meuMV = d;
	}
	
	
	public static void validarPlaca(String placa) throws Exception {
		if(placa == null)
			throw new Exception("O cpf não pode ser nulo!");
		if(placa.length() != TAM_PLACA)
			throw new Exception("A placa deve ter " + TAM_PLACA + " caracteres!");
		for(int i = 0; i < TAM_PLACA; i++) {
			char c = placa.charAt(i);
			switch(i) {
				case 0:
				case 1:
				case 2: 
					if(!Character.isUpperCase(c))
						throw new Exception("Na posição " + i + " deve aparecer uma maiuscula!");
					break;
				case 5:
				case 6:
					if(!Character.isDigit(c))
						throw new Exception("Na posição " + i + " deve aparecer um um número!");;
					break;
				default: 
					if( !Character.isUpperCase(c) && !Character.isDigit(c))
						throw new Exception("Na posição " + i + " deve aparecer uma letra maiuscula ou número!");;
			}
		}
	}
	
	public static void validarCor(String cor) throws Exception {
		if(cor == null)
			throw new Exception("O nome da cor não pode ser nulo!");
		if(cor.length() < TAM_MIN_COR || cor.length() > TAM_MAX_COR)
			throw new Exception("O nome da cor deve ter entre " + TAM_MIN_COR + " e " + TAM_MAX_COR + " caracteres!");
		for(int i = 0; i < cor.length(); i++) {
			char c = cor.charAt(i);
			if( ! Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new Exception("O nome da cor só deve ter conter somentes letras e espaço em branco!");
		}
	}
	
	public static void validarCombustivel(String combustivel) throws Exception {
		if(combustivel == null)
			throw new Exception("O tipo de combustivel não pode ser nulo!");
		if(combustivel != "Gasolina"  && combustivel != "Alcool" && combustivel != "Flex" && combustivel != "Disel")
			throw new Exception("O tipo de combustivel deve ser: 'Gasolina', 'Alcool', 'Flex' ou 'Disel'!");
	}
	
	public static void validarAno(int ano) throws Exception {
		if(ano < MIN_ANO || ano > MAX_ANO)
			throw new Exception("O ano deve estar entre " + MIN_ANO + " e " + MAX_ANO + "!");
	}

	public static void validarKilometragem(int numValvulas) throws Exception {
		if(numValvulas < MIN_KILOMETRAGEM)
			throw new Exception("O número de valvulas deve ser maior que " + MIN_KILOMETRAGEM + "!");
	}
	
	public static void validarMeuMV(ModeloVersao d) throws Exception {
		if(d == null)
			throw new Exception("A indicação de modelo de versão não pode ser nula!");
	}
	
}
