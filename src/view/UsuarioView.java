/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Usuario;

@ManagedBean(name = "user")
@ViewScoped
public class UsuarioView {
    private Usuario tabela_usuario = new Usuario();
    private UsuarioDao action = new UsuarioDaoImpl();
    
    
    
    
    //talvez tenha que ajeitar. (tem que se correlacionar user e password e não pelo tamanho da lista.)

     
    
     //Botões de navegação
        public String retornarLogin() {
        String retorno = null;
        retorno = "/login";
        return retorno;
    }
        public String irParaCadastro () {
        String retorno = null;
        retorno = "/cadastro";
        return retorno;
    }

    public String envia() {
        String retorno = null;
        List<Usuario> lst = action.listar();
        if (lst.size() == 0) {
            adicionarMensagem("USUARIO N�O ENCONTRADO", null, null);
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

    public UsuarioDao getAction() {
        return action;
    }

    public void setAction(UsuarioDaoImpl action) {
        this.action = action;
    }

   //Outros
     public void adicionarMensagem(String sumario, String detalhe, String pagina) {
        FacesMessage mensagem = new FacesMessage(sumario, detalhe);
        FacesContext.getCurrentInstance().addMessage(pagina, mensagem);
    }

    
}
