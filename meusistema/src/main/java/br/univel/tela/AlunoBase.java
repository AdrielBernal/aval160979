package br.univel.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import br.univel.pojo.Aluno;
import br.univel.pojo.AlunoDAO;
import br.univel.pojo.AlunoModel;
import br.univel.report.ReportManager;

public class AlunoBase extends CadastroAluno {
	private Aluno AlunoSelecionado;

	private AlunoModel modelo;

	public AlunoBase() {
		super();
		limparCampos();
		configurarBotoes();
		configuraTabela();
	}

	private void configuraTabela() {

		AlunoDAO DAO = new AlunoDAO();
		List<Aluno> lista = DAO.getTodos();

		this.modelo = new AlunoModel(lista);
		// this.modelo = new AlunoModel();
		super.table.setModel(modelo);

		super.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int idx = table.getSelectedRow();
					if (idx < 0) {
						System.out.println("Não há linha selecionada");
					} else {
						System.out.println("Linha " + idx);
						carregarLinha(idx);
					}
				}
			}
		});

	}

	protected void carregarLinha(int idx) {
		Aluno c = this.modelo.getAluno(idx);
		this.AlunoSelecionado = c;
		this.labelAlerta.setText(CARREGADO_PARA_ALTERACAO);

		super.txfId.setText(String.valueOf(c.getId()));
		super.txfNome.setText(c.getNome());
		super.txfDataNascimento.setText(c.getDataNascimento());
		super.textField.setText(c.getRa());

		super.btnExcluir.setEnabled(true);

	}

	private void configurarBotoes() {
		super.btnNovo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Novo");
				novo();
			}
		});
		super.btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Salvar");
				salvar();
			}
		});
		super.btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Excluir");
				excluir();
			}
		});
	}

	protected void excluir() {
		this.modelo.remover(this.AlunoSelecionado);
		limparCampos();
	}

	protected void salvar() {
		if (AlunoSelecionado == null) {
			Aluno c = new Aluno();

			String strNome = txfNome.getText().trim();
			String strDataNascimento = txfDataNascimento.getText().trim();
			String strRa = textField.getText().trim();

			c.setNome(strNome);
			c.setDataNascimento(strDataNascimento);
			c.setRa(strRa);

			this.modelo.adicionar(c);
			

			limparCampos();

		} else {

			String strNome = txfNome.getText().trim();
			String strDataNascimento = txfDataNascimento.getText().trim();
			String strRa = textField.getText().trim();

			this.AlunoSelecionado.setNome(strNome);
			this.AlunoSelecionado.setDataNascimento(strDataNascimento);
			this.AlunoSelecionado.setRa(strRa);

			limparCampos();
			this.modelo.fireTableDataChanged();
		}

	}

	protected void novo() {
		this.AlunoSelecionado = null;
		limparCampos();
	}

	private void limparCampos() {
		super.labelAlerta.setText("");
		super.txfId.setText("");
		super.txfNome.setText("");
		super.txfDataNascimento.setText("");
		super.textField.setText("");

		super.btnExcluir.setEnabled(false);
	}
}
