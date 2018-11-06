package view;

import com.google.gson.Gson;
import java.awt.Container;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.jsoup.Jsoup;

@ManagedBean(name = "livro")
@ViewScoped
public class LivroView {
	private String isbn;
	private String autor;
	private String titulo;
        private String editora;
        private String anoPublicacao;
	// Private String name;

	public String getIsbn() { 
		return isbn;
	}

	// O método
	public void pegarDados() throws IOException{
		org.jsoup.nodes.Document   docKb = Jsoup.connect("https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn).ignoreContentType(true).get();
		String json = docKb.body().text();
		Container fullJsonObject = new Gson().fromJson(json, Container.class);
		for (Item i : fullJsonObject.items) {
			autor =i.volumeInfo.authors[0] ;
			titulo =  i.volumeInfo.title;
                        editora = i.volumeInfo.publisher;
                        anoPublicacao = i.volumeInfo.publishedDate;
		}
	}

	public void setIsbn(String isbn) throws IOException { 
		this.isbn = isbn;
		if(this.isbn.length() == 13){
			pegarDados();
		}
		else
		{
			autor = "procurando";
			titulo = "procurando";
                        editora = "procurando";
                        anoPublicacao = "procurando";
		}
	}

	// Getters & Setters
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
        
        

	//Classes auxiliares
	private class Container {        
		String kind;
		int totalItems;
		Item[] items;
	}

	private class Item {
		String kind;
		String id;
		String etag;        
		VolumeInfo volumeInfo;
		String publisher;
		String publishedDate;
	}

	private class VolumeInfo {
		String title;
		String[] authors;
		String publisher;
		String publishedDate;
	}

	
}