package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Model;
import util.Parameter;

public interface Controller {
	ArrayList<Model>  consultar ( Parameter... params ) 
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, 
			IllegalAccessException, SQLException;
	
	void manter  ( Model model ) ;	
    void salvar  ( Model model ) 
    		throws NoSuchFieldException, SecurityException, IllegalArgumentException, 
    		IllegalAccessException, SQLException; 
    void excluir ( Model model ) 
    		throws NoSuchFieldException, SecurityException, IllegalArgumentException, 
    		IllegalAccessException, SQLException;
}
