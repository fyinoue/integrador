
package pi.negocios;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.dados.AprovadorDAO;
import pi.dados.DadosException;
import pi.entidades.Aprovador;

public class AprovadorBO implements IAprovadorBO<Aprovador>{

    @Override
    public void validar(Aprovador entidade) throws NegocioException {
        
    }

    @Override
    public void inserir(Aprovador entidade) throws NegocioException {
        
    }

    @Override
    public void alterar(Aprovador entidade) throws NegocioException {
        
    }

    @Override
    public void excluir(Aprovador entidade) throws NegocioException {
        
    }

    @Override
    public Aprovador consultar(int id) throws NegocioException {
        AprovadorDAO dao = new AprovadorDAO();
        try {
            Aprovador aprovador = dao.consultar(id);
            if(aprovador.getId_aprovador() == 0){
                throw new NegocioException("Aprovador não encontrado");
            }
            return aprovador;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
        
    }

    @Override
    public List<Aprovador> listar() throws NegocioException {
        AprovadorDAO dao = new AprovadorDAO();
        try {
            List<Aprovador> lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenhum aprovador cadastrado");
            }
            return lista;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }
    
}
