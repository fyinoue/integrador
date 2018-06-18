package pi.entidades;

public class Usuario {
    private int id_usuario;
    private String login;
    private String senha;

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", login=" + login + ", senha=" + senha + '}';
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
