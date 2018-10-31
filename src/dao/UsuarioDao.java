package dao;

public interface UsuarioDao {

	public void inserir(Usuario obj);

	public void alterar(Usuario obj);

	public void deletar(Usuario obj);

	public List<Usuario> listar(Usuario obj);

}
