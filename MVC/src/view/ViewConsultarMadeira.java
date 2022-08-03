package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.Controller;
import model.ModelMadeira;
import util.Parameter;
import util.Parameter.Operation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class ViewConsultarMadeira extends JDialog {
	private JTextField fieldIdMadeira;
	private JTextField fieldTipo;
	private JTable table;
	private TableModelMadeira model;
	private Controller ctrl;
	private JTextField fieldEspecie;
	private JTextField fieldDescricao;

	public void mostrar () {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void update() {
		try {
			model.setData(ctrl.consultar(
					new Parameter("idMadeira", fieldIdMadeira.getText(), Operation.EQUAL),
					new Parameter("tipo", fieldTipo.getText()),
					new Parameter("especie", fieldEspecie.getText()),
					new Parameter("descricao", fieldDescricao.getText())));
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
	}

	/**
	 * Create the dialog.
	 */
	public ViewConsultarMadeira(Controller ctrl) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewConsultarMadeira.class.getResource("/resource/woodHomePage.png")));
		setTitle("Consultar Madeira");
		this.ctrl = ctrl;
		setBounds(100, 100, 759, 537);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JButton btnIncluir = new JButton("Incluir");
				btnIncluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ctrl.manter(new ModelMadeira());
					}
				});
				btnIncluir.setIcon(new ImageIcon(ViewConsultarMadeira.class.getResource("/resource/inserir.png")));
				buttonPane.add(btnIncluir, BorderLayout.WEST);
			}
			{
				JButton btnFechar = new JButton("Fechar");
				btnFechar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btnFechar.setIcon(new ImageIcon(ViewConsultarMadeira.class.getResource("/resource/fechar.png")));
				buttonPane.add(btnFechar, BorderLayout.EAST);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnProcurar = new JButton("");
				btnProcurar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						update();
					}
				});
				btnProcurar.setIcon(new ImageIcon(ViewConsultarMadeira.class.getResource("/resource/lupa.png")));
				panel.add(btnProcurar, BorderLayout.EAST);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{15, 0, 333, 0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{5, 30, 30, 30, 30, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel lblNewLabel = new JLabel("ID:");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
					GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
					gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
					gbc_lblNewLabel.gridx = 1;
					gbc_lblNewLabel.gridy = 1;
					panel_1.add(lblNewLabel, gbc_lblNewLabel);
				}
				{
					fieldIdMadeira = new JTextField();
					GridBagConstraints gbc_fieldIdMadeira = new GridBagConstraints();
					gbc_fieldIdMadeira.insets = new Insets(0, 0, 5, 5);
					gbc_fieldIdMadeira.fill = GridBagConstraints.BOTH;
					gbc_fieldIdMadeira.gridx = 2;
					gbc_fieldIdMadeira.gridy = 1;
					panel_1.add(fieldIdMadeira, gbc_fieldIdMadeira);
					fieldIdMadeira.setColumns(10);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Tipo:");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
					GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
					gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
					gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_1.gridx = 1;
					gbc_lblNewLabel_1.gridy = 2;
					panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
				}
				{
					fieldTipo = new JTextField();
					GridBagConstraints gbc_fieldTipo = new GridBagConstraints();
					gbc_fieldTipo.gridwidth = 2;
					gbc_fieldTipo.insets = new Insets(0, 0, 5, 5);
					gbc_fieldTipo.fill = GridBagConstraints.BOTH;
					gbc_fieldTipo.gridx = 2;
					gbc_fieldTipo.gridy = 2;
					panel_1.add(fieldTipo, gbc_fieldTipo);
					fieldTipo.setColumns(10);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Esp\u00E9cie:");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
					GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
					gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
					gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_2.gridx = 1;
					gbc_lblNewLabel_2.gridy = 3;
					panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
				}
				{
					fieldEspecie = new JTextField();
					GridBagConstraints gbc_fieldEspecie = new GridBagConstraints();
					gbc_fieldEspecie.gridwidth = 2;
					gbc_fieldEspecie.insets = new Insets(0, 0, 5, 5);
					gbc_fieldEspecie.fill = GridBagConstraints.BOTH;
					gbc_fieldEspecie.gridx = 2;
					gbc_fieldEspecie.gridy = 3;
					panel_1.add(fieldEspecie, gbc_fieldEspecie);
					fieldEspecie.setColumns(10);
				}
				{
					JLabel lblNewLabel_3 = new JLabel("Descri\u00E7\u00E3o:");
					lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
					GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
					gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
					gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_3.gridx = 1;
					gbc_lblNewLabel_3.gridy = 4;
					panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
				}
				{
					fieldDescricao = new JTextField();
					GridBagConstraints gbc_fieldDescricao = new GridBagConstraints();
					gbc_fieldDescricao.gridwidth = 2;
					gbc_fieldDescricao.insets = new Insets(0, 0, 5, 5);
					gbc_fieldDescricao.fill = GridBagConstraints.BOTH;
					gbc_fieldDescricao.gridx = 2;
					gbc_fieldDescricao.gridy = 4;
					panel_1.add(fieldDescricao, gbc_fieldDescricao);
					fieldDescricao.setColumns(10);
				}
				{
					JSeparator separator = new JSeparator();
					GridBagConstraints gbc_separator = new GridBagConstraints();
					gbc_separator.insets = new Insets(0, 0, 0, 5);
					gbc_separator.gridx = 2;
					gbc_separator.gridy = 5;
					panel_1.add(separator, gbc_separator);
				}
			}
			{
				JSeparator separator = new JSeparator();
				panel.add(separator, BorderLayout.SOUTH);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				model = new TableModelMadeira();
				table = new JTable(model);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount()==2) {
							ctrl.manter( 
									model.getModel(table.getSelectedRow()));
						}
					}
				});
				scrollPane.setViewportView(table);
			}
		}
		this.update();
	}

}
