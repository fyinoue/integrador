package pi.negocios;

import pi.dados.DadosException;
import java.util.List;

public interface IUsuarioBO<T> {

    void validar(T entidade) throws NegocioException;

    void inserir(T entidade) throws NegocioException;

    void alterar(T entidade) throws NegocioException;

    void excluir(T entidade) throws NegocioException;

    T consultar(int id) throws NegocioException;
    
    boolean verificarLogin(T entidade) throws NegocioException;

    List<T> listar() throws NegocioException;
}
