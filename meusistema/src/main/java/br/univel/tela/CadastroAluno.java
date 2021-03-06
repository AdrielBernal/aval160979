package br.univel.tela;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CadastroAluno extends JPanel {

	protected static final String CARREGADO_PARA_ALTERACAO = "Carregado para alterašao";
	protected JTextField txfId;
	protected JTextField txfNome;
	protected JTextField txfDataNascimento;
	protected JTable table;
	protected JButton btnNovo;
	protected JButton btnSalvar;
	protected JButton btnExcluir;
	protected JLabel labelAlerta;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	protected JMenuItem mntmImprimir;
	protected JMenuItem mntmExportarPdf;
	protected JLabel lblRa;
	protected JTextField textField;

	/**
	 * Create the panel.
	 */
	public CadastroAluno() {
		setBounds(100, 100, 450, 300);

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		this.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);

		txfId = new JTextField();
		GridBagConstraints gbc_txfId = new GridBagConstraints();
		gbc_txfId.anchor = GridBagConstraints.WEST;
		gbc_txfId.insets = new Insets(0, 0, 5, 5);
		gbc_txfId.gridx = 1;
		gbc_txfId.gridy = 0;
		panel.add(txfId, gbc_txfId);
		txfId.setColumns(5);

		labelAlerta = new JLabel(CARREGADO_PARA_ALTERACAO);
		labelAlerta.setForeground(Color.RED);
		GridBagConstraints gbc_labelAlerta = new GridBagConstraints();
		gbc_labelAlerta.anchor = GridBagConstraints.WEST;
		gbc_labelAlerta.insets = new Insets(0, 0, 5, 0);
		gbc_labelAlerta.gridx = 2;
		gbc_labelAlerta.gridy = 0;
		panel.add(labelAlerta, gbc_labelAlerta);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		panel.add(lblNome, gbc_lblNome);

		txfNome = new JTextField();
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.gridwidth = 2;
		gbc_txfNome.insets = new Insets(0, 0, 5, 0);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 1;
		gbc_txfNome.gridy = 1;
		panel.add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);

		JLabel lblDataNascimento = new JLabel("Telefone");
		GridBagConstraints gbc_lblDataNascimento = new GridBagConstraints();
		gbc_lblDataNascimento.anchor = GridBagConstraints.EAST;
		gbc_lblDataNascimento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataNascimento.gridx = 0;
		gbc_lblDataNascimento.gridy = 2;
		panel.add(lblDataNascimento, gbc_lblDataNascimento);

		txfDataNascimento = new JTextField();
		GridBagConstraints gbc_txfDataNascimento = new GridBagConstraints();
		gbc_txfDataNascimento.insets = new Insets(0, 0, 5, 0);
		gbc_txfDataNascimento.gridwidth = 2;
		gbc_txfDataNascimento.anchor = GridBagConstraints.WEST;
		gbc_txfDataNascimento.gridx = 1;
		gbc_txfDataNascimento.gridy = 2;
		panel.add(txfDataNascimento, gbc_txfDataNascimento);
		txfDataNascimento.setColumns(15);

		lblRa = new JLabel("RA");
		GridBagConstraints gbc_lblRa = new GridBagConstraints();
		gbc_lblRa.anchor = GridBagConstraints.EAST;
		gbc_lblRa.insets = new Insets(0, 0, 0, 5);
		gbc_lblRa.gridx = 0;
		gbc_lblRa.gridy = 3;
		panel.add(lblRa, gbc_lblRa);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		this.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		btnNovo = new JButton("Novo");
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.anchor = GridBagConstraints.EAST;
		gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovo.gridx = 0;
		gbc_btnNovo.gridy = 0;
		panel_1.add(btnNovo, gbc_btnNovo);

		btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 0;
		panel_1.add(btnSalvar, gbc_btnSalvar);

		btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 0;
		panel_1.add(btnExcluir, gbc_btnExcluir);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		this.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

	}

}
