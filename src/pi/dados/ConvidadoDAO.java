
package pi.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.entidades.Convidado;

public class ConvidadoDAO implements IConvidadoDAO<Convidado>{

    @Override
    public void inserir(Convidado entidade) throws DadosException {
        
    }

    @Override
    public void alterar(Convidado entidade) throws DadosException {
        
    }

    @Override
    public void excluir(Convidado entidade) throws DadosException {
        
    }

    @Override
    public Convidado consultar(int id) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM CONVIDADO WHERE ID=?";
        Convidado convidado = new Convidado();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                convidado.setId_convidado(resultado.getInt(1));
                convidado.setNome(resultado.getString(2));
            }
            conexao.close();
            return convidado;
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar", ex);
        }
    }

    @Override
    public List<Convidado> listar() throws DadosException {
        List<Convidado> lista = new ArrayList<Convidado>();
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM CONVIDADO";
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while(resultado.next()){
                Convidado convidado = new Convidado();
                convidado.setId_convidado(resultado.getInt(1));
                convidado.setNome(resultado.getString(2));
                lista.add(convidado);
            }
            conexao.close();
            return lista;
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar", ex);
        }
    }
    
}
