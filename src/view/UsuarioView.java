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
    private Usuario usuario = new Usuario();
    private String confirmaSenha = null;
    
    
    
    
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

        //submissão 
    public String envia() {
        String retorno = null;
        List<Usuario> lst = action.listar(usuario);
        if (lst.isEmpty()) {
            adicionarMensagem("USUARIO N�O ENCONTRADO", null, null);
        } else {
            retorno = "/main";
        }
        return retorno;
    }
     public String inserir() {
        String retorno = null;
        if (!usuario.getSenha().equalsIgnoreCase(this.getConfirmaSenha())) {
            adicionarMensagem("CONFIRME A SENHA.", null, null);
        } else {
            action.inserir(usuario);
            adicionarMensagem("REGISTRO INSERIDO COM SUCESSO.", null, null);
            usuario = new Usuario();
        }
        return retorno;
     }

     
     
     
    //getters and setters
    
   
    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
     
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

   //Outros
     public void adicionarMensagem(String sumario, String detalhe, String pagina) {
        FacesMessage mensagem = new FacesMessage(sumario, detalhe);
        FacesContext.getCurrentInstance().addMessage(pagina, mensagem);
    }

    
}
