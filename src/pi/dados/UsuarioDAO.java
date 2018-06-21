package pi.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pi.entidades.Usuario;

public class UsuarioDAO implements IUsuarioDAO<Usuario> {

    @Override
    public void inserir(Usuario entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO USUARIO(LOGIN, SENHA) VALUES(?, ?)";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getLogin());
            comando.setString(2, entidade.getSenha());
            comando.execute();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir", ex);
        }
    }

    @Override
    public void alterar(Usuario entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE USUARIO SET LOGIN=?, SENHA=? WHERE ID_USUARIO=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getLogin());
            comando.setString(2, entidade.getSenha());
            comando.setInt(3, entidade.getId_usuario());
            comando.execute();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar", ex);
        }
    }

    @Override
    public void excluir(Usuario entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM USUARIO WHERE ID_USUARIO=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId_usuario());
            comando.execute();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao excluir", ex);
        }
    }

    @Override
    public Usuario consultar(int id) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO=?";
        Usuario usuario = new Usuario();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                usuario.setId_usuario(resultado.getInt(1));
                usuario.setLogin(resultado.getString(2));
                usuario.setSenha(resultado.getString(3));
            }
            
            conexao.close();
            return usuario;
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar", ex);
        }
    }

    @Override
    public boolean verificarLogin(String login, String senha) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT login FROM USUARIO WHERE login=? AND senha=?";
        boolean autenticado = false;
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, login);
            comando.setString(2, senha);
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {
                autenticado = true;
            }
            
            conexao.close();
            return autenticado;
        } catch (SQLException ex) {
            throw new DadosException("Erro na verificação de Login!", ex);
        }
    }

    @Override
    public List<Usuario> listar() throws DadosException {
        List<Usuario> lista = new ArrayList<Usuario>();
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM USUARIO";
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while(resultado.next()){
                Usuario usuario = new Usuario();
                usuario.setId_usuario(resultado.getInt(1));
                usuario.setLogin(resultado.getString(2));
                usuario.setSenha(resultado.getString(3));
                lista.add(usuario);
            }
            
            conexao.close();
            return lista;
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar", ex);
        }
    }
    
}
