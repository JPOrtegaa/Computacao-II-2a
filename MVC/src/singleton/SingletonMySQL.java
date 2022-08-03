package singleton;

import java.lang.reflect.Field;

import model.Model;
import util.Parameter;

public class SingletonMySQL {

	private static SingletonMySQL instance = null;

	private SingletonMySQL() {
	}

	public static SingletonMySQL getInstance() {
		if (instance==null) 
			instance = new SingletonMySQL();
		return instance;
	}

	public String getFields(Model m) {
		String s = "";
		Field[] f = m.getAttributes();
		Boolean first=true;
		for (Field field : f) {
			if (!first) 
				s += ",";
			s += field.getName();
			first = false;
		}
		return s;
	}

	public String getValues(Model m) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String s = "";
		Field[] f = m.getAttributes();
		Boolean first=true;
		Object value;
		for (Field field : f) {
			if (!first) {
				s += ",";
			}
			value = m.get(field.getName());
			if(value==null) {
				s += value;				
			} else {
				s += "'" + value +"'";
			}
			first = false;
		}
		return s;
	}

	public String getFieldsValues(Model m) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String s = "";
		Field[] f = m.getAttributes();
		Boolean first=true;
		for (Field field : f) {
			if (!first) {
				s += ",";
			}
			s += field.getName() + "=" + "'" + m.get(field.getName()) +"'";
			first = false;
		}
		return s;
	}

	public String getWHERE(Parameter... params) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String s = "";
		Boolean first=true;
		for (Parameter param : params) {
			if (!param.getValue().equals("")) {
				if (!first) {
					s += " AND ";
				}
				switch (param.getOperation()) {
				case EQUAL: s += param.getName() + "=" + "'" + param.getValue() +"'";
				break;
				case LIKE:  s += param.getName() + " LIKE " + "'%" + param.getValue() +"%'";
				break;

				}
				first = false;
			} 
		}
		return (s.equals("") ? "" : " WHERE " + s);
	}

	public String getSelect(Model m, Parameter... params) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		return "SELECT " + getFields (m) +
				" FROM " + m.getTablename() +
				getWHERE(params) +
				" ORDER BY " + m.getOrderBy();
	}

	public String getInsert(Model m) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		return "INSERT INTO " + m.getTablename() +
				" ("+ getFields(m)+") " +
				" VALUES ("+getValues(m)+")";
	}

	public String getUpdate(Model m) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		return "UPDATE " + m.getTablename() +
				" SET "+ getFieldsValues(m)+
				" WHERE "+m.getIdtable() + "=" + m.getId();
	}

	public String getDelete(Model m) {
		return "DELETE " +
				" FROM " + m.getTablename() +
				" WHERE " + m.getIdtable() + "=" + m.getId();
	}

}
