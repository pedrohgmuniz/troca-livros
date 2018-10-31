package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Troca")
@Table(name = "T_TROCA")
public class Troca {
	
	@Id // É preciso de um ID e de um COD para Troca?
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_TROCA", nullable=false, unique=true) // Todos os nomes de colunas em caixa alta
	private int codTroca;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_TROCA_LIVRO"), name = "COD_LIVRO", insertable = false, updatable = false)
	private Livro livro = new Livro();

}
