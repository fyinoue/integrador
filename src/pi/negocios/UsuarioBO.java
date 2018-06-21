
package pi.negocios;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.dados.DadosException;
import pi.dados.UsuarioDAO;
import pi.entidades.Usuario;

public class UsuarioBO implements IUsuarioBO<Usuario>{

    @Override
    public void validar(Usuario entidade) throws NegocioException {
        if(entidade.getLogin().isEmpty()){
            throw new NegocioException("O campo LOGIN é obrigatório!");
        }
        if(entidade.getSenha().isEmpty()){
            throw new NegocioException("O campo SENHA é obrigatório!");
        } 
    }

    @Override
    public void inserir(Usuario entidade) throws NegocioException {
        validar(entidade);
        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public void alterar(Usuario entidade) throws NegocioException {
        consultar(entidade.getId_usuario());
        validar(entidade);
        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.alterar(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public void excluir(Usuario entidade) throws NegocioException {
        consultar(entidade.getId_usuario());
        validar(entidade);
        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.excluir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public Usuario consultar(int id) throws NegocioException {
        UsuarioDAO dao = new UsuarioDAO();
        try {
            Usuario usuario = dao.consultar(id);
            if(usuario.getId_usuario() == 0){
                throw new NegocioException("Usuário não encontrado");
            }
            else {
                return usuario;
            }
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    @Override
    public boolean verificarLogin(Usuario entidade) throws NegocioException {
        validar(entidade);
        UsuarioDAO dao = new UsuarioDAO();
        boolean autenticado;
        try {
            autenticado = dao.verificarLogin(entidade.getLogin(), entidade.getSenha());
            if(autenticado == false){
                throw new NegocioException("Usuário/Senha incorretos");
            } else {
                return autenticado;
            }
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }
    
    @Override
    public List<Usuario> listar() throws NegocioException {
        UsuarioDAO dao = new UsuarioDAO();
        try {
            List<Usuario> lista = dao.listar();
            if(lista.isEmpty()){
                throw new NegocioException("Nenhum usuário cadastrado");
            }
            return lista;
        } catch (DadosException ex) {
            throw new NegocioException("Falha na operação", ex);
        }
    }

    
}
