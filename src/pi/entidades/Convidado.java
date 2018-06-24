package pi.entidades;

public class Convidado {
    private int id_convidado;
    private String nome;

    @Override
    public String toString() {
        return "Convidado{" + "id_convidado=" + id_convidado + ", nome=" + nome + '}';
    }

    public int getId_convidado() {
        return id_convidado;
    }

    public void setId_convidado(int id_convidado) {
        this.id_convidado = id_convidado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
