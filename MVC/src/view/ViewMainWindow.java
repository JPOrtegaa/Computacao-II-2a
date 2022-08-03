package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import controller.ControllerMadeira;
import java.awt.Font;

public class ViewMainWindow {

	private JFrame frmSistemaDeControle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMainWindow window = new ViewMainWindow();
					window.frmSistemaDeControle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeControle = new JFrame();
		frmSistemaDeControle.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewMainWindow.class.getResource("/resource/lumberJack.png")));
		frmSistemaDeControle.setTitle("Sistema de Controle de Madeira");
		frmSistemaDeControle.setBounds(100, 100, 801, 549);
		frmSistemaDeControle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeControle.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeControle.setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		mnSistema.setIcon(new ImageIcon(ViewMainWindow.class.getResource("/resource/sistema.png")));
		mnSistema.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnSistema.setMnemonic('S');
		menuBar.add(mnSistema);
		
		JMenuItem consultarMadeira = new JMenuItem("Consultar Madeira");
		consultarMadeira.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
		consultarMadeira.setIcon(new ImageIcon(ViewMainWindow.class.getResource("/resource/woodHomePage.png")));
		consultarMadeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(new ControllerMadeira()).mostrar();
			}
		});
		mnSistema.add(consultarMadeira);
		
		JSeparator separator = new JSeparator();
		mnSistema.add(separator);
		
		JMenuItem fecharAplicacao = new JMenuItem("Fechar aplica\u00E7\u00E3o");
		fecharAplicacao.setIcon(new ImageIcon(ViewMainWindow.class.getResource("/resource/fechar.png")));
		fecharAplicacao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
		fecharAplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSistemaDeControle.setVisible ( false );
				frmSistemaDeControle.dispose();
			}
		});
		
		mnSistema.add(fecharAplicacao);
	}

}
