package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Model;
import model.ModelMadeira;

public class TableModelMadeira extends AbstractTableModel {

	private String header[] = {"ID", "Tipo", "Espécie", "Descrição"};
	private ArrayList<Model> array = new ArrayList<Model>();
	
	public void setData (ArrayList<Model> array) {
		this.array = array;
		fireTableDataChanged();
	}
	
	public Model getModel (int row) {
		return this.array.get(row);
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}
	
	@Override
	public int getRowCount() {
		return array.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ModelMadeira model = (ModelMadeira) array.get(rowIndex);
		switch (columnIndex) {
		case 0 :
			return model.getIdMadeira();
		case 1 :
			return model.getTipo();
		case 2:
			return model.getEspecie();
		case 3:
			return model.getDescricao();
		default:
			return null;
		}
	}

}
