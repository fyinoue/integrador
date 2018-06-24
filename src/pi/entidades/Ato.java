
package pi.entidades;

public class Ato {
    private int id_documento;
    private String titulo;
    private int classificacao;
    private String modelo;
    private String local;
    private String data;
    private String horario;
    private int tipo;
    private String encaminhamento;
    private String assunto;

    @Override
    public String toString() {
        return "Ato{" + "id_documento=" + id_documento +
                ", titulo=" + titulo + 
                ", classificacao=" + classificacao + 
                ", modelo=" + modelo +
                ", local=" + local +
                ", data=" + data +
                ", horario=" + horario + 
                ", tipo=" + tipo +
                ", encaminhamento=" + encaminhamento +
                ", assunto=" + assunto + '}';
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    
}
