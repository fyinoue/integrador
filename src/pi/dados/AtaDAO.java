package pi.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pi.entidades.Ata;

public class AtaDAO implements IAtaDAO<Ata>{

    @Override
    public void inserir(Ata entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "INSERT INTO DOCUMENTO(TITULO, LOCAL, DATA, HORÁRIO, "
                + "ASSUNTO, CLASSIFICAÇÃO, ENCAMINHAMENTO, MODELO, APONTAMENTO,"
                + "TIPO, DECISOES) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            comando.setString(9, entidade.getApontamento());
            comando.setInt(10, entidade.getTipo());
            comando.setString(11, entidade.getDecisoes());
            System.out.println(comando);
            comando.execute();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao inserir", ex);
        }
    }

    @Override
    public void alterar(Ata entidade) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "UPDATE DOCUMENTO SET TITULO=?, LOCAL=?, DATA=?, HORÁRIO=?, "
                + "ASSUNTO=?, CLASSIFICAÇÃO=?, ENCAMINHAMENTO=?, "
                + "APONTAMENTO=?, TIPO=?, DECISOES=? WHERE ID_DOCUMENTO=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, entidade.getTitulo());
            comando.setString(2, entidade.getLocal());
            comando.setString(3, entidade.getData());
            comando.setString(4, entidade.getHorario());
            comando.setString(5, entidade.getAssunto());
            comando.setInt(6, entidade.getClassificacao());
            comando.setString(7, entidade.getEncaminhamento());
            comando.setString(8, entidade.getApontamento());
            comando.setInt(9, entidade.getTipo());
            comando.setString(10, entidade.getDecisoes());
            comando.setInt(11, entidade.getId_documento());
            comando.execute();
            conexao.close();
        } catch (SQLException ex) {
            throw new DadosException("Erro ao alterar", ex);
        }
    }

    @Override
    public void excluir(Ata entidade) throws DadosException {
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
    public Ata consultar(int id) throws DadosException {
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT TITULO, LOCAL, DATA, HORÁRIO, ASSUNTO,"
                + " CLASSIFICAÇÃO, ENCAMINHAMENTO, APONTAMENTO, TIPO,"
                + " DECISOES FROM DOCUMENTO WHERE ID_DOCUMENTO=?";
        Ata ata = new Ata();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                ata.setTitulo(resultado.getString(1));
                ata.setLocal(resultado.getString(2));
                ata.setData(resultado.getString(3));
                ata.setHorario(resultado.getString(4));
                ata.setAssunto(resultado.getString(5));
                ata.setClassificacao(resultado.getInt(6));
                ata.setEncaminhamento(resultado.getString(7));
                ata.setApontamento(resultado.getString(8));
                ata.setTipo(resultado.getInt(9));
                ata.setDecisoes(resultado.getString(10));
            }

            conexao.close();
            return ata;
        } catch (SQLException ex) {
            throw new DadosException("Erro ao consultar", ex);
        }
    }

    @Override
    public List<Ata> listar() throws DadosException {
        List<Ata> lista = new ArrayList<Ata>();
        Connection conexao = ConexaoBD.getConexao();
        String sql = "SELECT * FROM DOCUMENTO WHERE MODELO=?";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, "Ata");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Ata ata = new Ata();
                ata.setId_documento(resultado.getInt(1));
                ata.setTitulo(resultado.getString(2));
                ata.setLocal(resultado.getString(3));
                ata.setData(resultado.getString(4));
                ata.setHorario(resultado.getString(5));
                ata.setAssunto(resultado.getString(6));
                ata.setClassificacao(resultado.getInt(7));
                ata.setEncaminhamento(resultado.getString(8));
                ata.setApontamento(resultado.getString(10));
                lista.add(ata);
            }

            conexao.close();
            return lista;
        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar", ex);
        }
    }
    
}
