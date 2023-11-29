package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Marca;
import model.ModeloVersao;
import model.Automovel;
import viewer.JanelaPrincipal;

public class Programa {
	public static void main(String[] args) {
		Programa.recuperarObjetos();
		JanelaPrincipal janela = new JanelaPrincipal();
		janela.setVisible(true);
	}
	

	public static void salvarObjetos() {
		try {
			FileOutputStream arquivo = new FileOutputStream("C:/Temp/Objetos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(arquivo);
			oos.writeObject( Marca.getListaMarcas() );
			oos.writeObject( ModeloVersao.getListaModelosVersoes() );
			oos.writeObject( Automovel.getListaAutomoveis() );
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}


	public static void recuperarObjetos() {
		try {
			FileInputStream arquivo = new FileInputStream("C:/Temp/Objetos.bin");
			ObjectInputStream ois = new ObjectInputStream(arquivo);
			Marca.setListaMarcas(  (Marca[])ois.readObject() );
			ModeloVersao.setListaModelosVersoes(  (ModeloVersao[])ois.readObject() );
			Automovel.setListaAutomoveis(  (Automovel[])ois.readObject() );
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());			
		} catch (ClassNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());			
		}
	}
}