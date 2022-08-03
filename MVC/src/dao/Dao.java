package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Model;
import singleton.SingletonDataBase;
import singleton.SingletonMySQL;
import util.Parameter;

import java.lang.reflect.Field;

public class Dao {

	protected Model model;
	protected ResultSet resultado;

	public  Dao( Model model) {
		this.model = model;
	}

	protected ArrayList<Model> getResultado ( ) throws SQLException  {
		ArrayList<Model> list = new ArrayList<Model>();
		Model m;
		while (this.resultado.next()) {
			Field[] fl = this.model.getAttributes();
			m = this.model.getNewInstance();
			for (Field field : fl) {
				m.set(field.getName(), 
						resultado.getObject(field.getName()));
			}
			list.add(m);
		}
		return list;
	}
		
	protected void executar (String sql) throws SQLException {
		SingletonDataBase.getInstance().getStatement().execute(sql);
		this.resultado = SingletonDataBase.getInstance().
				getStatement().getResultSet();
	}

	public ArrayList<Model> consultar (Parameter... params) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = SingletonMySQL.getInstance().getSelect(model, params);

		System.out.println(sql);
		executar ( sql );
		return getResultado();
	}

	public void salvar ( Model m ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "";
		if (m.getId()==null) {
			sql = SingletonMySQL.getInstance().getInsert(m);
		} else {
			sql = SingletonMySQL.getInstance().getUpdate(m);
		}
		System.out.println(sql);
		executar ( sql );
	}

	public void excluir ( Model m ) throws SQLException {
		String sql = SingletonMySQL.getInstance().getDelete(m);
		System.out.println(sql);
		executar ( sql );
	}

}
