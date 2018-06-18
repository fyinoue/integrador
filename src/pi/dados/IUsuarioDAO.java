package pi.dados;

import java.util.List;

public interface IUsuarioDAO<T> {

    void inserir(T entidade) throws DadosException;

    void alterar(T entidade) throws DadosException;

    void excluir(T entidade) throws DadosException;

    T consultar(int id) throws DadosException;
    
    boolean verificarLogin(String login, String senha) throws DadosException;

    List<T> listar() throws DadosException;
}
