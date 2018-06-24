
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
import pi.entidades.Aprovador;

public class AprovadorDAO implements IAprovadorDAO<Aprovador>{

    @Override
    public void inserir(Aprovador entidade) throws DadosException {
        
    }

    @Override
    public void alterar(Aprovador entidade) throws DadosException {
        
    }

    @Override
    public void excluir(Aprovador entidade) throws DadosException {
        
    }

    @Override
    public Aprovador consultar(int id) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM APROVADOR WHERE ID=?";
        Aprovador aprovador = new Aprovador();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            
            if(resultado.next()){
                aprovador.setId_aprovador(resultado.getInt(1));
                aprovador.setNivel_aprovador(resultado.getInt(2));
                aprovador.setNome(resultado.getString(3));
            }
            conexao.close();
            return aprovador;
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar", ex);
        }
    }

    @Override
    public List<Aprovador> listar() throws DadosException {
        List<Aprovador> lista = new ArrayList<Aprovador>();
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM APROVADOR";
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while(resultado.next()){
                Aprovador aprovador = new Aprovador();
                aprovador.setId_aprovador(resultado.getInt(1));
                aprovador.setNivel_aprovador(resultado.getInt(2));
                aprovador.setNome(resultado.getString(3));
                lista.add(aprovador);
            }
            conexao.close();
            return lista;
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar", ex);
        }
    }
    
}
