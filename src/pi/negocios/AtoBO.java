package pi.negocios;

import java.util.List;
import pi.dados.AtoDAO;
import pi.dados.DadosException;
import pi.entidades.Ato;

public class AtoBO implements IAtoBO<Ato>{

    @Override
    public void validar(Ato entidade) throws NegocioException {
        if (entidade.getTitulo().isEmpty()) {
            throw new NegocioException("O campo TITULO é obrigatório!");
        }
        if (entidade.getLocal().isEmpty()) {
            throw new NegocioException("O campo LOCAL é obrigatório!");
        }
        if (entidade.getData().isEmpty()) {
            throw new NegocioException("O campo DATA é obrigatório!");
        }
        if (entidade.getHorario().isEmpty()) {
            throw new NegocioException("O campo HORARIO é obrigatório!");
        }
        if (entidade.getEncaminhamento().isEmpty()) {
            throw new NegocioException("O campo ENCAMINHAMENTO é obrigatório!");
        }
        if (entidade.getAssunto().isEmpty()) {
            throw new NegocioException("O campo ASSUNTO é obrigatório!");
        }
    }

    @Override
    public void validarCriacao(Ato entidade) throws NegocioException {
        if (entidade.getTitulo().isEmpty()) {
            throw new NegocioException("O campo TITULO é obrigatório!");
        }
    }

    @Override
    public void inserir(Ato entidade) throws NegocioException {
        validar(entidade);
        AtoDAO dao = new AtoDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public void alterar(Ato entidade) throws NegocioException {
        validar(entidade);
        AtoDAO dao = new AtoDAO();
        try {
            dao.alterar(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public void excluir(Ato entidade) throws NegocioException {
        AtoDAO dao = new AtoDAO();
        try {
            dao.excluir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public Ato consultar(int id) throws NegocioException {
        AtoDAO dao = new AtoDAO();
        try {
            Ato ato = dao.consultar(id);
            if (ato.getTitulo() == null) {
                throw new NegocioException("Documento não encontrado");
            }
            return ato;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public List<Ato> listar() throws NegocioException {
        AtoDAO dao = new AtoDAO();
        try {
            List<Ato> lista = dao.listar();
            if (lista.isEmpty()) {
                throw new NegocioException("Nenhum documento cadastrado");
            }
            return lista;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }
    
}
