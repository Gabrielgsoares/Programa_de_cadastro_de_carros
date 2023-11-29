package viewer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Programa;

public class JanelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
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
	public JanelaPrincipal() {
		setTitle("Janela Principal do Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMarca = new JButton("Marca");
		btnMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaMarca jm = new JanelaMarca();
				jm.setVisible(true);
			}
		});
		btnMarca.setBounds(65, 74, 89, 23);
		contentPane.add(btnMarca);
		
		JButton btnModeloVersao = new JButton("Modelo Versão");
		btnModeloVersao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaModeloVersao jmv = new JanelaModeloVersao();
				jmv.setVisible(true);
			}
		});
		btnModeloVersao.setBounds(263, 73, 89, 23);
		contentPane.add(btnModeloVersao);
		
		JButton btnAutomovel = new JButton("Automóvel");
		btnAutomovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaAutomovel ja = new JanelaAutomovel();
				ja.setVisible(true);
			}
		});
		btnAutomovel.setBounds(68, 140, 89, 23);
		contentPane.add(btnAutomovel);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Programa.salvarObjetos();
				System.exit(0);
			}
		});
		btSair.setBounds(265, 143, 89, 23);
		contentPane.add(btSair);
	}
}
