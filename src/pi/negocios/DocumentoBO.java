package pi.negocios;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.dados.DadosException;
import pi.dados.DocumentoDAO;
import pi.entidades.Documento;

public class DocumentoBO implements BO<Documento>{

    @Override
    public void validar(Documento entidade) throws NegocioException {
        
    }

    @Override
    public void inserir(Documento entidade) throws NegocioException {
        
    }

    @Override
    public void alterar(Documento entidade) throws NegocioException {
        
    }

    @Override
    public void excluir(Documento entidade) throws NegocioException {
        
    }

    @Override
    public Documento consultar(int id) throws NegocioException {
        DocumentoDAO dao = new DocumentoDAO();
        try {
            Documento documento = dao.consultar(id);
            if(documento.getId_documento() == 0){
                throw new NegocioException("Documento não encontrado");
            }
            return documento;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public List<Documento> listar() throws NegocioException {
        DocumentoDAO dao = new DocumentoDAO();
        try {
            List<Documento> lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenhum documento cadastrado");
            }
            return lista;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }
    
}
