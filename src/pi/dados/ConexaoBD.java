
package pi.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public static Connection getConexao() throws DadosException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/sistemaAtoAta", "root", "");
        } catch (ClassNotFoundException ex) {
            throw new DadosException("Erro ao carregar driver JDBC", ex);
        } catch (SQLException ex) {
            throw new DadosException("Erro ao conectar no MYSQL", ex);
        }
    }
}
