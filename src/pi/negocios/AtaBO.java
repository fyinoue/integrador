package pi.negocios;

import java.util.List;
import pi.dados.AtaDAO;
import pi.dados.DadosException;
import pi.entidades.Ata;


public class AtaBO implements IAtaBO<Ata>{

    @Override
    public void validar(Ata entidade) throws NegocioException {
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
            throw new NegocioException("O campo ASSUNTOS é obrigatório!");
        }
    }

    @Override
    public void validarCriacao(Ata entidade) throws NegocioException {
        if (entidade.getTitulo().isEmpty()) {
            throw new NegocioException("O campo TITULO é obrigatório!");
        }
    }

    @Override
    public void inserir(Ata entidade) throws NegocioException {
        validar(entidade);
        AtaDAO dao = new AtaDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public void alterar(Ata entidade) throws NegocioException {
        validar(entidade);
        AtaDAO dao = new AtaDAO();
        try {
            dao.alterar(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public void excluir(Ata entidade) throws NegocioException {
        AtaDAO dao = new AtaDAO();
        try {
            dao.excluir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public Ata consultar(int id) throws NegocioException {
        AtaDAO dao = new AtaDAO();
        try {
            Ata ata = dao.consultar(id);
            if (ata.getTitulo() == null) {
                throw new NegocioException("Documento não encontrado");
            }
            return ata;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public List<Ata> listar() throws NegocioException {
        AtaDAO dao = new AtaDAO();
        try {
            List<Ata> lista = dao.listar();
            if (lista.isEmpty()) {
                throw new NegocioException("Nenhum documento cadastrado");
            }
            return lista;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }
    
}
