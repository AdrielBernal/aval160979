package br.univel.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AlunoModel extends AbstractTableModel {

	private List<Aluno> lista;

	public AlunoModel() {
		this((List<Aluno>) null);

		for (int i = 0; i < 10; i++) {
			Aluno c = new Aluno();
			c.setId((long) (i + 1));
			c.setNome("Aluno " + (i + 1));
			c.setDataNascimento("26/12/199" + i);
			c.setRa("" + i + 1);
			this.lista.add(c);
		}
	}

	public AlunoModel(List<Aluno> _lista) {
		if (_lista == null) {
			this.lista = new ArrayList<>();
		} else {
			this.lista = _lista;
		}
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Data de nascimento";
		case 3:
			return "RA";
		}
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {

		Aluno c = this.lista.get(row);

		switch (column) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getDataNascimento();
		case 3:
			return c.getRa();
		}

		throw new RuntimeException("azedou");
	}

	public void adicionar(Aluno c) {
		this.lista.add(c);
		super.fireTableDataChanged();
	}

	public Aluno getAluno(int idx) {
		return lista.get(idx);
	}

	public void remover(Aluno AlunoSelecionado) {
		this.lista.remove(AlunoSelecionado);
		super.fireTableDataChanged();
	}

}
