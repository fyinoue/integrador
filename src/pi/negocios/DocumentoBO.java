package pi.negocios;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.dados.DadosException;
import pi.dados.DocumentoDAO;
import pi.entidades.Documento;

public class DocumentoBO implements IDocumentoBO<Documento>{

    @Override
    public void validar(Documento entidade) throws NegocioException {
        
    }

    @Override
    public void validarCriacao(Documento entidade) throws NegocioException {
        if(entidade.getTitulo().isEmpty()){
            throw new NegocioException("O campo TITULO é obrigatório!");
        }
    }
    
    @Override
    public void inserir(Documento entidade) throws NegocioException {
        if(entidade.getTitulo().isEmpty()) {
            throw new NegocioException("O campo TITULO é obrigatório!");
        }
        if(entidade.getLocal().isEmpty()) {
            throw new NegocioException("O campo LOCAL é obrigatório!");
        }
        if(entidade.getData().isEmpty()) {
            throw new NegocioException("O campo DATA é obrigatório!");
        }
        if(entidade.getHorario().isEmpty()) {
            throw new NegocioException("O campo HORARIO é obrigatório!");
        }
        if(entidade.getAssunto().isEmpty()) {
            throw new NegocioException("O campo ASSUNTO é obrigatório!");
        }
        if(entidade.getClassificacao() == 0) {
            throw new NegocioException("O campo CLASSIFICAÇÃO é obrigatório!");
        }
        if(entidade.getEncaminhamento().isEmpty()) {
            throw new NegocioException("O campo ENCAMINHAMENTO é obrigatório!");
        }
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
