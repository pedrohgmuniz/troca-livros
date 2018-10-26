package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.org.utd.model.Segurado;

@Entity(name = "Livro")
@Table(name = "T_LIVRO")

public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_livro", nullable=false, unique=true)
	private int codLivro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_LIVRO_USUARIO"), name = "cod_usuario", insertable = false, updatable = false)
	private Usuario usuario = new Usuario();
	
	@Column(name="dsc_livro")
	private String dscLivro;

}
