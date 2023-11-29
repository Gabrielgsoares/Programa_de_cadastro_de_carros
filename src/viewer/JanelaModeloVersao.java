package viewer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Marca;
import model.ModeloVersao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class JanelaModeloVersao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeModelo;
	private JTextField tfNomeVersao;
	private JTextField tfCilindradas;
	private JTextField tfValvulas;
	private JComboBox<Marca> cbMarca;
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
	public JanelaModeloVersao() {
		setTitle("Modelo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(40, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfNomeModelo = new JTextField();
		tfNomeModelo.setBounds(111, 40, 140, 20);
		contentPane.add(tfNomeModelo);
		tfNomeModelo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Versão:");
		lblNewLabel_1.setBounds(40, 81, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfNomeVersao = new JTextField();
		tfNomeVersao.setBounds(111, 78, 140, 20);
		contentPane.add(tfNomeVersao);
		tfNomeVersao.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cilindradas:");
		lblNewLabel_2.setBounds(40, 126, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfCilindradas = new JTextField();
		tfCilindradas.setBounds(111, 123, 140, 20);
		contentPane.add(tfCilindradas);
		tfCilindradas.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Válvulas");
		lblNewLabel_3.setBounds(40, 161, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfValvulas = new JTextField();
		tfValvulas.setBounds(111, 158, 140, 20);
		contentPane.add(tfValvulas);
		tfValvulas.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Marca");
		lblNewLabel_4.setBounds(290, 43, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		cbMarca = new JComboBox<Marca>();
		cbMarca.setBounds(346, 39, 78, 22);
		contentPane.add(cbMarca);
		
		Marca[] lista1 = Marca.getListaMarcas();
		for(int i = 0; i < Marca.getNumMarcas(); i++) {
			cbMarca.addItem(lista1[i]);			
		}
		
		final JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String auxCili = tfCilindradas.getText();
				String auxNumVal = tfValvulas.getText();
				Marca  minhaMarca = (Marca)cbMarca.getSelectedItem();
				String nomeModelo = tfNomeModelo.getText();
				String nomeVersao = tfNomeVersao.getText();
				int cilindrada;
				int numValvula;
				
				
				try {
					cilindrada = Integer.parseInt(auxCili);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(btOk, "O campo código deve conter números!");
					return;
				}
				
				try {
					numValvula = Integer.parseInt(auxNumVal);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(btOk, "O campo ano deve conter números!");
					return;
				}
				
								
				try {
					ModeloVersao mv = new ModeloVersao(nomeModelo, nomeVersao, cilindrada, numValvula, minhaMarca);
					JOptionPane.showMessageDialog(btOk, "Ok! " + mv );
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
