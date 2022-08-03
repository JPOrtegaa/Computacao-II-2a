package model;

public class ModelMadeira extends Model {
	
	protected Integer idmadeira;
	protected String tipo;
	protected String especie;
	protected String descricao;
	
	public ModelMadeira() {
		super("madeira", "tipo ASC");
	}
	
	@Override
	public Model getNewInstance() {
		return new ModelMadeira();
	}

	public Integer getIdMadeira() {
		return idmadeira;
	}

	public void setIdMadeira(Integer idMadeira) {
		this.idmadeira = idMadeira;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
