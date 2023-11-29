package model;

import java.io.Serializable;

public class ModeloVersao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	final public static int TAM_CNPJ = 18;
	final public static int TAM_MAX_NOME_MODELO = 15;
	final public static int TAM_MIN_NOME_MODELO = 6;
	final public static int NUM_MAX_MODELOSVERSOES = 10;
	final public static int MIN_CILINDRADAS = 0;
	final public static int MAX_CILINDRADAS = 8000;
	final public static int MIN_NUMVALVULAS = 8;
	final public static int NUM_MAX_CNPJ = 17;
	

	private String 	nomeModelo;
	private String 	nomeVersao;
	private int cilindradas;
	private int numValvulas;
	private Marca minhaMarca;
	

	private static ModeloVersao[] listaModelosVersoes = new ModeloVersao[NUM_MAX_MODELOSVERSOES];
	private static int numModelosVersoes = 0;

	public ModeloVersao(String nm, String nv, int cl, int v, Marca d) throws Exception {
		this.setNomeModelo(nm);
		this.setNomeVersao(nv);
		this.setCilindradas(cl);
		this.setNumValvulas(v);
		this.setMinhaMarca(d);
		
		ModeloVersao.listaModelosVersoes[ ModeloVersao.numModelosVersoes++ ] = this;
	}
	
	public static ModeloVersao[] getListaModelosVersoes() {
		return ModeloVersao.listaModelosVersoes;
	}
	
	public static void setListaModelosVersoes(ModeloVersao[] novaLista) {
		ModeloVersao.listaModelosVersoes = novaLista;
		for(int i = 0; i < novaLista.length; i++) {
			if(novaLista[i] != null)
				System.out.println("Recuperei o objeto:" + novaLista[i]);
			else {
				ModeloVersao.numModelosVersoes = i;
				break;
			}
		}
	}
	
	public static int getNumModeloVersao() {
		return ModeloVersao.numModelosVersoes;
	}
	

	public String getNomeModelo() {
		return this.nomeModelo;
	}
	

	public void setNomeModelo(String nm) throws Exception {
		ModeloVersao.validarNomeModelo(nm);
		this.nomeModelo = nm;
	}
	

	public String getNomeVersao() {
		return this.nomeVersao;
	}
	

	public void setNomeVersao(String nv) throws Exception {
		ModeloVersao.validarNomeVersao(nv);
		this.nomeVersao = nv;
	}
	
	public int getCilindradas() {
		return this.cilindradas;
	}
	

	public void setCilindradas(int cl) throws Exception {
		ModeloVersao.validarCilindradas(cl);
		this.cilindradas = cl;
	}
	
	public int getNumValvulas() {
		return this.numValvulas;
	}
	

	public void setNumValvulas(int v) throws Exception {
		ModeloVersao.validarNumValvulas(v);
		this.numValvulas = v;
	}
	
	public Marca getMinhaMarca() {
		return this.minhaMarca;
	}
	
	public void setMinhaMarca(Marca d) throws Exception {
		ModeloVersao.validarMinhaMarca(d);
		this.minhaMarca = d;
	}
	
	
	public static void validarNomeModelo(String nomeModelo) throws Exception {
		if(nomeModelo == null)
			throw new Exception("O nome do modelo não pode ser nulo!");
		if(nomeModelo.length() < TAM_MIN_NOME_MODELO || nomeModelo.length() > TAM_MAX_NOME_MODELO)
			throw new Exception("O nome do modelo deve ter entre " + TAM_MIN_NOME_MODELO + " e " + TAM_MAX_NOME_MODELO + " caracteres!");
		for(int i = 0; i < nomeModelo.length(); i++) {
			char c = nomeModelo.charAt(i);
			if( ! Character.isAlphabetic(c) && !Character.isSpaceChar(c) && !Character.isDigit(c))
				throw new Exception("O nome do medelo deve ter conter somentes letras, numeros e espaço em branco!");
		}
	}
	
	public static void validarNomeVersao(String nomeVersao) throws Exception {
		if(nomeVersao == null)
			throw new Exception("O nome da versão não pode ser nulo!");
		if(nomeVersao.length() < TAM_MIN_NOME_MODELO || nomeVersao.length() > TAM_MAX_NOME_MODELO)
			throw new Exception("O nome da versâo deve ter entre " + TAM_MIN_NOME_MODELO + " e " + TAM_MAX_NOME_MODELO + " caracteres!");
		for(int i = 0; i < nomeVersao.length(); i++) {
			char c = nomeVersao.charAt(i);
			if( ! Character.isAlphabetic(c) && !Character.isSpaceChar(c) && !Character.isDigit(c))
				throw new Exception("O nome da versâo só deve ter conter somentes letras, numeros e espaço em branco!");
		}
	}
	
	public static void validarCilindradas(int cilindradas) throws Exception {
		if(cilindradas < MIN_CILINDRADAS || cilindradas > MAX_CILINDRADAS)
			throw new Exception("A cilindrada deve estar entre " + MIN_CILINDRADAS + " e " + MAX_CILINDRADAS + "!");
	}

	public static void validarNumValvulas(int numValvulas) throws Exception {
		if(numValvulas <= MIN_NUMVALVULAS && numValvulas % 2 == 0)
			throw new Exception("O número de valvulas deve ser maior que " + MIN_NUMVALVULAS + " e ser um número par!");
	}
	
	public static void validarMinhaMarca(Marca d) throws Exception {
		if(d == null)
			throw new Exception("A indicação de marca não pode ser nula!");
	}
	
}
