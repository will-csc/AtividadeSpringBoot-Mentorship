package br.com.fecaf.model;

public class LivroDeTerror {
    private Long id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String genero;
    private Integer paginas;
    private String editora;
    private String idioma;
    private Double classificacao;
    private String sinopse;

    public LivroDeTerror() {}

    public LivroDeTerror(Long id, String titulo, String autor, Integer anoPublicacao,
                         String genero, Integer paginas, String editora, String idioma,
                         Double classificacao, String sinopse) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.paginas = paginas;
        this.editora = editora;
        this.idioma = idioma;
        this.classificacao = classificacao;
        this.sinopse = sinopse;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Integer getPaginas() { return paginas; }
    public void setPaginas(Integer paginas) { this.paginas = paginas; }

    public String getEditora() { return editora; }
    public void setEditora(String editora) { this.editora = editora; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public Double getClassificacao() { return classificacao; }
    public void setClassificacao(Double classificacao) { this.classificacao = classificacao; }

    public String getSinopse() { return sinopse; }
    public void setSinopse(String sinopse) { this.sinopse = sinopse; }

    @Override
    public String toString() {
        return "LivroDeTerror{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", genero='" + genero + '\'' +
                ", paginas=" + paginas +
                ", editora='" + editora + '\'' +
                ", idioma='" + idioma + '\'' +
                ", classificacao=" + classificacao +
                ", sinopse='" + sinopse + '\'' +
                '}';
    }
}