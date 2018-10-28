/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import usuario_DAO.UsuarioDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Usuario;
import usuario_DAO.UsuarioDAO;

@ManagedBean(name = "user")
@ViewScoped
public class UsuarioView {
    private Usuario tabela_usuario = new Usuario();
    private UsuarioDAO action = new UsuarioDaoImpl();
    
    
     public String envia() {
     String retorno = null;
        List<Usuario> lst = action.listar(tabela_usuario);
        if (lst.size() == 0) {
            adicionarMensagem("Usuario nao cadastrado", null, null);
        } else {
            retorno = "/main";
        }
        return retorno;
    
     }
     
    
    //getters and setters

    public Usuario getTabela_usuario() {
        return tabela_usuario;
    }

    public void setTabela_usuario(Usuario tabela_usuario) {
        this.tabela_usuario = tabela_usuario;
    }
   //Outros
     public void adicionarMensagem(String sumario, String detalhe, String pagina) {
        FacesMessage mensagem = new FacesMessage(sumario, detalhe);
        FacesContext.getCurrentInstance().addMessage(pagina, mensagem);
    }

    
}
