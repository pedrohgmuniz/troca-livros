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
	@Column(name="COD_USUARIO", nullable=false, unique=true) // Todos os nomes de colunas em caixa alta
	private int codUsuario;

	@Column(name="NOME_USUARIO", nullable=false, unique=true)
	private String nomeUsuario;

	@Column(name="SENHA", nullable=false, unique=false)
	private String senha;

	@Column(name="ULTIMO_ACESSO")
	@Temporal(TemporalType.DATE)
	private Date ultimoAcesso;

	@Column(name="DATA_NASCIMENTO")
	private String dataNascimento;

	@Column(name="CIDADE")
	private String cidade;

	@Column(name="EMAIL")
	private String email;

	@OneToMany(mappedBy="usuario") 
	private Set<Livro> livros;
	
	// GETTERS and SETTERS:
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

	public Set<Livro> getLivros() {
		return livros;
	}
	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

}
