package pi.dados;

import java.util.List;

public interface IAtaDAO<T> {

    void inserir(T entidade) throws DadosException;

    void alterar(T entidade) throws DadosException;

    void excluir(T entidade) throws DadosException;

    T consultar(int id) throws DadosException;

    List<T> listar() throws DadosException;

}
