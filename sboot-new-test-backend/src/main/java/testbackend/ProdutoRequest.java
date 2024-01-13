package testbackend;

public class ProdutoRequest {
    public String titulo;
    public String descricao;
    public String preco;
    public String donoID;
    public CategoriaRequest categoria;
    
    public ProdutoRequest() {
    }

    public ProdutoRequest(String titulo, String descricao, String preco, CategoriaRequest categoria, String donoID) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.donoID = donoID;
    }

    @Override
    public String toString() {
        return "ProdutoRequest [titulo=" + titulo + ", descricao=" + descricao + ", preco=" + preco + ", categoria="
                + categoria + ", donoID=" + donoID + "]";
    }
    
}
