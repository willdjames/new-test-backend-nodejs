package testbackend;

public class CategoriaRequest {
    public String titulo;
    public String descricao;
    public String donoID;
    
    public CategoriaRequest() {
    }

    public CategoriaRequest(String titulo, String descricao, String donoID) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.donoID = donoID;
    }

    @Override
    public String toString() {
        return "CategoriaRequest [titulo=" + titulo + ", descricao=" + descricao + ", donoID=" + donoID + "]";
    }
    
}
