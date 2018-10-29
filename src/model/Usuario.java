package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

@Entity(name = "Usuario")
@Table(name = "T_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_usuario", nullable=false, unique=true)
	private int codUsuario;
	
	@Column(name="user_name", nullable=false, unique=true)
	private String userName;
	
	@Column(name="senha", nullable=false, unique=false)
	private String senha;
	
	@Column(name="ultimo_acesso")
	@Temporal(TemporalType.DATE)
	private Date ultimoAcesso;
	
	@Column(name="data_nascimento")
	private String dataNascimento;
	
	@Column(name="cidade")
	private String cidade;
        
        @Column(name="email")
        private String email;
        

   
	
	
	@OneToMany(mappedBy = "usuario") 
	private Set<Livro> livros;

	// GETTERS AND SETTERS:
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}
	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
        public String getEmail() {
        return email;
        }

        public void setEmail(String email) {
        this.email = email;
        }

}
