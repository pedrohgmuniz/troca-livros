/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario_DAO;

import java.util.List;
import model.Usuario;

public interface UsuarioDAO {
    public void inserir(Usuario obj);

    public void alterar(Usuario obj);

    public void deletar(Usuario obj);

    public List<Usuario> listar(Usuario obj);
    
}
