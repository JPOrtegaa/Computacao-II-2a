package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.Dao;
import model.Model;
import model.ModelMadeira;
import util.Parameter;
import view.ViewConsultarMadeira;
import view.ViewManterMadeira;

public class ControllerMadeira implements Controller {

	private Dao dao = new Dao(new ModelMadeira());
	private ViewConsultarMadeira view_consultar = new ViewConsultarMadeira(this);
	private ViewManterMadeira view_manter = new ViewManterMadeira(this);

	public void mostrar() {
		view_consultar.mostrar();
	}
	
	@Override
	public ArrayList<Model> consultar(Parameter... params) throws NoSuchFieldException, SecurityException, IllegalArgumentException, 
	IllegalAccessException, SQLException {
		return dao.consultar(params);
	}

	@Override
	public void manter(Model model) {
		view_manter.mostrar(model);
	}

	@Override
	public void salvar(Model model) 
			throws NoSuchFieldException, SecurityException, 
			IllegalArgumentException, IllegalAccessException, SQLException {
		dao.salvar(model);	
		view_consultar.update();
	}

	@Override
	public void excluir(Model model) 
			throws NoSuchFieldException, SecurityException, 
			IllegalArgumentException, IllegalAccessException, SQLException{
		dao.excluir(model);	
		view_consultar.update ();
	}

}
