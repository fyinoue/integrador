/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.negocios;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.dados.ConvidadoDAO;
import pi.dados.DadosException;
import pi.entidades.Convidado;

/**
 *
 * @author Desktop
 */
public class ConvidadoBO implements IConvidadoBO<Convidado>{

    @Override
    public void validar(Convidado entidade) throws NegocioException {
        
    }

    @Override
    public void inserir(Convidado entidade) throws NegocioException {
        
    }

    @Override
    public void alterar(Convidado entidade) throws NegocioException {
        
    }

    @Override
    public void excluir(Convidado entidade) throws NegocioException {
        
    }

    @Override
    public Convidado consultar(int id) throws NegocioException {
        ConvidadoDAO dao = new ConvidadoDAO();
        try {
            Convidado convidado = dao.consultar(id);
            if(convidado.getId_convidado() == 0){
                throw new NegocioException("Convidado não encontrado");
            }
            return convidado;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
        
    }

    @Override
    public List<Convidado> listar() throws NegocioException {
        ConvidadoDAO dao = new ConvidadoDAO();
        try {
            List<Convidado> lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenhum convidado cadastrado");
            }
            return lista;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }
    
}
