
package pi.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pi.entidades.Ato;


public class AtoDAO implements IAtoDAO<Ato>{

    @Override
    public void inserir(Ato entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO DOCUMENTO(TITULO, LOCAL, DATA, HORÁRIO, "
                + "ASSUNTO, CLASSIFICAÇÃO, ENCAMINHAMENTO, MODELO, TIPO) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getTitulo());
            comando.setString(2, entidade.getLocal());
            comando.setString(3, entidade.getData());
            comando.setString(4, entidade.getHorario());
            comando.setString(5, entidade.getAssunto());
            comando.setInt(6, entidade.getClassificacao());
            comando.setString(7, entidade.getEncaminhamento());
            comando.setString(8, entidade.getModelo());
            comando.setInt(9, entidade.getTipo());
            comando.execute();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir", ex);
        }
    }

    @Override
    public void alterar(Ato entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE DOCUMENTO SET TITULO=?, LOCAL=?, DATA=?,"
                + " HORÁRIO=?, ASSUNTO=?, CLASSIFICAÇÃO=?, ENCAMINHAMENTO=?,"
                + " TIPO=? WHERE ID_DOCUMENTO=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getTitulo());
            comando.setString(2, entidade.getLocal());
            comando.setString(3, entidade.getData());
            comando.setString(4, entidade.getHorario());
            comando.setString(5, entidade.getAssunto());
            comando.setInt(6, entidade.getClassificacao());
            comando.setString(7, entidade.getEncaminhamento());
            comando.setInt(8, entidade.getTipo());
            comando.setInt(9, entidade.getId_documento());
            comando.execute();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar", ex);
        }
    }

    @Override
    public void excluir(Ato entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "DELETE FROM DOCUMENTO WHERE ID_DOCUMENTO=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, entidade.getId_documento());
            comando.execute();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao excluir", ex);
        }
    }

    @Override
    public Ato consultar(int id) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT TITULO, LOCAL, DATA, HORÁRIO, ASSUNTO,"
                + " CLASSIFICAÇÃO, ENCAMINHAMENTO, TIPO"
                + " FROM DOCUMENTO WHERE ID_DOCUMENTO=?";
        Ato ato = new Ato();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                ato.setTitulo(resultado.getString(1));
                ato.setLocal(resultado.getString(2));
                ato.setData(resultado.getString(3));
                ato.setHorario(resultado.getString(4));
                ato.setAssunto(resultado.getString(5));
                ato.setClassificacao(resultado.getInt(6));
                ato.setEncaminhamento(resultado.getString(7));
                ato.setTipo(resultado.getInt(8));
            }

            conexao.close();
            return ato;
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar", ex);
        }
    }

    @Override
    public List<Ato> listar() throws DadosException {
        List<Ato> lista = new ArrayList<Ato>();
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM DOCUMENTO WHERE MODELO=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, "Ato");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Ato ato = new Ato();
                ato.setId_documento(resultado.getInt(1));
                ato.setTitulo(resultado.getString(2));
                ato.setLocal(resultado.getString(3));
                ato.setData(resultado.getString(4));
                ato.setHorario(resultado.getString(5));
                ato.setAssunto(resultado.getString(6));
                ato.setClassificacao(resultado.getInt(7));
                ato.setEncaminhamento(resultado.getString(8));
                lista.add(ato);
            }

            conexao.close();
            return lista;
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar", ex);
        }
    }
    
}
