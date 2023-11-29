package viewer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Marca;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JanelaMarca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCnpj;
	private JTextField tfNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaMarca frame = new JanelaMarca();
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
	public JanelaMarca() {
		setTitle("Marca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CNPJ:");
		lblNewLabel.setBounds(21, 38, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfCnpj = new JTextField();
		tfCnpj.setBounds(77, 35, 134, 20);
		contentPane.add(tfCnpj);
		tfCnpj.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(21, 91, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(77, 88, 203, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btOk = new JButton("OK");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj = tfCnpj.getText();
				String nome = tfNome.getText();
								
				try {
					Marca m = new Marca(cnpj, nome);
					JOptionPane.showMessageDialog(btOk, "Ok! " + m );
					setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btOk, e1.getMessage() );
				}
			}
		});
		btOk.setBounds(85, 174, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(261, 174, 89, 23);
		contentPane.add(btCancelar);
	}
}
