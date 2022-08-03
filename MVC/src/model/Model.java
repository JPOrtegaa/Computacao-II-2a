package model;

import java.lang.reflect.Field;

public abstract class Model {

	private String table_name;
	private String order_by;

	public Model( String table_name, String order_by) {
		this.table_name = table_name;
		this.order_by   = order_by;
	}

	public abstract Model getNewInstance();

	public Object getId () {
		try {
			return get("id"+table_name);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getTablename() {
		return table_name;
	}

	public String getIdtable () {
		return "id"+table_name;
	}
	
	public void setId ( Integer id ) {
		set ("id"+table_name, id );
	}

	public Object get( String attrName ) 
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field=null;
		
		field = this.getClass().getDeclaredField(attrName);
		return field.get(this);
	}

	public void set( String attrName, Object attrValue ) {
		Field field=null;
		
		try {
			field = this.getClass().getDeclaredField(attrName);
			field.set(this, attrValue);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}		
	}

	public Field[] getAttributes ( ) {
		return this.getClass().getDeclaredFields();
	}

	public int compareTo ( Model other ) {
		if (this.getId()==other.getId()) {
			return 0;
		}
		if (Integer.valueOf(getId().toString())<
				Integer.valueOf(getId().toString())) {
			return -1;
		}
		return 1;
	}

	public boolean equals ( Model other ) {
		return this.getId()==other.getId();
	}
	
	public String getOrderBy () {
		return this.order_by;
	}

	public Model clone() {
		Model model = this.getNewInstance();
		Field[] fl = getAttributes();
		for (Field field : fl) {
			try {
				model.set( field.getName(), this.get(field.getName()) );
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public boolean replace ( Model other ) {
		Field[] fl = getAttributes();
		for (Field field : fl) {
			try {
				this.set( field.getName(), other.get(field.getName()) );
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void show () {
		String s = "";
	    Field[] fl = getAttributes();
	    for (Field field : fl) {
	        try {
				s +=  field.getName() + ": " + get(field.getName()) + "\n";
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
	    }
	    System.out.println(s);	             
	}
}
