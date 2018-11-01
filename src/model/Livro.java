package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Livro")
@Table(name = "T_LIVRO")
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_LIVRO", nullable=false, unique=true) // Todos os nomes de colunas em caixa alta
	private int codLivro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_LIVRO_USUARIO"), name = "cod_usuario", insertable = false, updatable = false)
	private Usuario usuario = new Usuario(); // Este cod_usuario não tem que ser igual a variável codUsuario da classe Usuario?
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_LIVRO_INFOS_TECNICAS"), name = "COD_INFOS_TECNICAS", insertable = false, updatable = false)
	private InfosTecnicas infosTecnicas = new InfosTecnicas();
	
	@Column(name="DSC_LIVRO")
	private String dscLivro;
	
	@OneToOne(mappedBy="livro") 
	private Troca troca;

}
