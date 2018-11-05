package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "InfosTecnicas")
@Table(name = "T_INFOSTECNICAS")
public class InfosTecnicas {

	@Id // É preciso de um ID e de um COD para InfosTecnicas?
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_INFOS_TECNICAS", nullable=false, unique=true) // Todos os nomes de colunas em caixa alta
	private int codInfosTecnicas;
	
	@Column(name = "ISBN_LIVRO")
	private int isbnLivro;
	
	@Column(name="TITULO")
	private String titulo;
		
	@Column(name="ANO_EDICAO")
	private int anoEdicao;
			
	@Column(name="EDITORA")
	private String editora; // Até aqui, na ordem do site http://www.isbn.bn.br/website/consulta/cadastro
							// "AUTOR" substitui "PARTICIPAÇÕES" no site, e "GÊNERO" é uma coluna extra
	@Column(name="AUTOR")
	private String autor;
	
	@Column(name="GENERO")
	private String genero;
	
//	@OneToMany(mappedBy="infosTecnicas") 
//	private Set<Livro> livro;

}
