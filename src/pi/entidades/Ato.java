
package pi.entidades;

public class Ato {
    private int id_documento;
    private String titulo;
    private String local;
    private String data;
    private String horario;
    private String assunto;
    private int classificacao;
    private String encaminhamento;
    private String modelo;

    @Override
    public String toString() {
        return "Ato{" + "id_documento=" + id_documento + ", titulo=" + titulo + 
                ", local=" + local + ", data=" + data + ", horario=" + horario + 
                ", assunto=" + assunto + ", classificacao=" + classificacao + 
                ", encaminhamento=" + encaminhamento + ", modelo=" + modelo + '}';
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

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
