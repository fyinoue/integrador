
package pi.entidades;

public class Aprovador {
    private int id_aprovador;
    private int nivel_aprovador;
    private String nome;

    @Override
    public String toString() {
        return "Aprovador{" + "id_aprovador=" + id_aprovador + ", nivel_aprovador=" + nivel_aprovador + ", nome=" + nome + '}';
    }

    public int getId_aprovador() {
        return id_aprovador;
    }

    public void setId_aprovador(int id_aprovador) {
        this.id_aprovador = id_aprovador;
    }

    public int getNivel_aprovador() {
        return nivel_aprovador;
    }

    public void setNivel_aprovador(int nivel_aprovador) {
        this.nivel_aprovador = nivel_aprovador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
