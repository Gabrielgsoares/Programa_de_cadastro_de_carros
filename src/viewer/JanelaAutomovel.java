package viewer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Automovel;
import model.ModeloVersao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class JanelaAutomovel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPlaca;
	private JTextField tfCor;
	private JTextField tfAno;
	private JTextField tfKilometragem;
	private JTextField tfCombustivel;
	private JComboBox<ModeloVersao> cbModeloVersao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaModeloVersao frame = new JanelaModeloVersao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaAutomovel() {
		setTitle("Automovel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setBounds(40, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfPlaca = new JTextField();
		tfPlaca.setBounds(111, 40, 140, 20);
		contentPane.add(tfPlaca);
		tfPlaca.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cor:");
		lblNewLabel_1.setBounds(40, 81, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfCor = new JTextField();
		tfCor.setBounds(111, 78, 140, 20);
		contentPane.add(tfCor);
		tfCor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ano:");
		lblNewLabel_2.setBounds(40, 126, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfAno = new JTextField();
		tfAno.setBounds(111, 123, 140, 20);
		contentPane.add(tfAno);
		tfAno.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Kilometragem:");
		lblNewLabel_3.setBounds(40, 161, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfKilometragem = new JTextField();
		tfKilometragem.setBounds(111, 158, 140, 20);
		contentPane.add(tfKilometragem);
		tfKilometragem.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Combustivel:");
		lblNewLabel_5.setBounds(40, 11, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		tfCombustivel = new JTextField();
		tfCombustivel.setBounds(111, 8, 140, 20);
		contentPane.add(tfCombustivel);
		tfCombustivel.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Modelo:");
		lblNewLabel_4.setBounds(290, 43, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		cbModeloVersao = new JComboBox<ModeloVersao>();
		cbModeloVersao.setBounds(346, 39, 78, 22);
		contentPane.add(cbModeloVersao);
		
		ModeloVersao[] lista1 = ModeloVersao.getListaModelosVersoes();
		for(int i = 0; i < ModeloVersao.getNumModeloVersao(); i++) {
			cbModeloVersao.addItem(lista1[i]);			
		}
		
		final JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String auxkilo = tfKilometragem.getText();
				String auxano = tfAno.getText();
				ModeloVersao  meuModelo = (ModeloVersao)cbModeloVersao.getSelectedItem();
				String placa = tfPlaca.getText();
				String cor = tfCor.getText();
				String combus = tfCombustivel.getText();
				int ano;
				int kilometragem;
				
				
				try {
					ano = Integer.parseInt(auxkilo);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(btOk, "O campo código deve conter números!");
					return;
				}
				
				try {
					kilometragem = Integer.parseInt(auxano);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(btOk, "O campo ano deve conter números!");
					return;
				}
				
								
				try {
					Automovel at = new Automovel(placa, cor, combus, ano, kilometragem, meuModelo);
					JOptionPane.showMessageDialog(btOk, "Ok! " + at );
					setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btOk, e1.getMessage() );
				}
			}
		});
		btOk.setBounds(71, 208, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(247, 208, 89, 23);
		contentPane.add(btCancelar);
		
		
	}
}
