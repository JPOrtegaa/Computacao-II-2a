package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Model;
import model.ModelMadeira;
import singleton.SingletonLog;
import java.awt.Toolkit;


public class ViewManterMadeira extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fieldIdMadeira;
	private JTextField fieldTipo;
	private Controller ctrl;
	private ModelMadeira model;
	private JButton btnExcluir;
	private JTextField fieldEspecie;
	private JTextField fieldDescricao;

	public void mostrar (Model model) {
		this.model = (ModelMadeira) model;

		if (this.model.getId()==null) {
			fieldIdMadeira.setText("");
			btnExcluir.setEnabled(false);
		} else {
			fieldIdMadeira.setText(this.model.getId().toString());
			btnExcluir.setEnabled(true);
		}
		fieldTipo.setText(this.model.getTipo());
		fieldEspecie.setText(this.model.getEspecie());
		fieldDescricao.setText(this.model.getDescricao());

		setVisible(true);
	}


	/**
	 * Create the dialog.
	 */
	public ViewManterMadeira( Controller ctrl ) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewManterMadeira.class.getResource("/resource/wood.png")));
		setTitle("Manter Madeira");
		this.ctrl = ctrl;
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{40, 40, 40, 40, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("ID:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			fieldIdMadeira = new JTextField();
			fieldIdMadeira.setEditable(false);
			GridBagConstraints gbc_fieldIdMadeira = new GridBagConstraints();
			gbc_fieldIdMadeira.insets = new Insets(0, 0, 5, 5);
			gbc_fieldIdMadeira.fill = GridBagConstraints.BOTH;
			gbc_fieldIdMadeira.gridx = 2;
			gbc_fieldIdMadeira.gridy = 0;
			contentPanel.add(fieldIdMadeira, gbc_fieldIdMadeira);
			fieldIdMadeira.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Tipo:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			fieldTipo = new JTextField();
			GridBagConstraints gbc_fieldTipo = new GridBagConstraints();
			gbc_fieldTipo.insets = new Insets(0, 0, 5, 5);
			gbc_fieldTipo.fill = GridBagConstraints.BOTH;
			gbc_fieldTipo.gridx = 2;
			gbc_fieldTipo.gridy = 1;
			contentPanel.add(fieldTipo, gbc_fieldTipo);
			fieldTipo.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Esp\u00E9cie:");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			fieldEspecie = new JTextField();
			GridBagConstraints gbc_fieldEspecie = new GridBagConstraints();
			gbc_fieldEspecie.insets = new Insets(0, 0, 5, 5);
			gbc_fieldEspecie.fill = GridBagConstraints.BOTH;
			gbc_fieldEspecie.gridx = 2;
			gbc_fieldEspecie.gridy = 2;
			contentPanel.add(fieldEspecie, gbc_fieldEspecie);
			fieldEspecie.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Descri\u00E7\u00E3o:");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			fieldDescricao = new JTextField();
			GridBagConstraints gbc_fieldDescricao = new GridBagConstraints();
			gbc_fieldDescricao.insets = new Insets(0, 0, 0, 5);
			gbc_fieldDescricao.fill = GridBagConstraints.BOTH;
			gbc_fieldDescricao.gridx = 2;
			gbc_fieldDescricao.gridy = 3;
			contentPanel.add(fieldDescricao, gbc_fieldDescricao);
			fieldDescricao.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.SOUTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JButton btnFechar = new JButton("");
				btnFechar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				panel.add(btnFechar, BorderLayout.EAST);
				btnFechar.setIcon(new ImageIcon(ViewManterMadeira.class.getResource("/resource/fechar.png")));
				btnFechar.setActionCommand("OK");
				getRootPane().setDefaultButton(btnFechar);
			}
			{
				JPanel buttonPane = new JPanel();
				panel.add(buttonPane, BorderLayout.WEST);
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					JButton btnSalvar = new JButton("");
					btnSalvar.setIcon(new ImageIcon(ViewManterMadeira.class.getResource("/resource/salvar.png")));
					btnSalvar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							model.setTipo(fieldTipo.getText());
							model.setEspecie(fieldEspecie.getText());
							model.setDescricao(fieldDescricao.getText());
							try {
								ctrl.salvar(model);
								setVisible(false);
							} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
									| IllegalAccessException | SQLException e1) {
								JOptionPane.showMessageDialog(getContentPane(), 
										e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
								SingletonLog.getInstance().doLog(e1.getMessage());
								e1.printStackTrace();
							}
						}
					});
					buttonPane.add(btnSalvar);
				}
				{
					btnExcluir = new JButton("");
					btnExcluir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								int response = JOptionPane.showConfirmDialog(getContentPane(),
							            "Confirmar", "Deletar Madeira",
							            JOptionPane.YES_NO_OPTION );
								if (response==JOptionPane.YES_OPTION) {
									ctrl.excluir(model);
									setVisible(false);
								}
							} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
									| IllegalAccessException | SQLException e1) {
								JOptionPane.showMessageDialog(getContentPane(), 
										e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

								SingletonLog.getInstance().doLog(e1.getMessage());
								e1.printStackTrace();
							}
						}
					});
					btnExcluir.setIcon(new ImageIcon(ViewManterMadeira.class.getResource("/resource/excluir.png")));
					btnExcluir.setActionCommand("Cancel");
					buttonPane.add(btnExcluir);
				}
			}
		}
	}

}
