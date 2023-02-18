package code.infra.databases.jdbc.postgreSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import code.infra.databases.IConnection;
import code.infra.env.EnvironmentVariables;

public class PostgreSQLConnection implements IConnection {

    private DriverManagerDataSource dataSource;
    private Connection connection;

    private static final int SUCCESS = 1;

    public PostgreSQLConnection() {
        this.dataSource = new DriverManagerDataSource();
        this.dataSource.setDriverClassName(EnvironmentVariables.get("POSTGRESQL_DRIVER"));
        this.dataSource.setUrl(EnvironmentVariables.get("POSTGRESQL_URL"));
        this.dataSource.setUsername(EnvironmentVariables.get("POSTGRESQL_USERNAME"));
        this.dataSource.setPassword(EnvironmentVariables.get("POSTGRESQL_PASSWORD"));
        openConnection();
    }

    private void openConnection() {
        try {
            this.connection = this.dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(String query, Object... args){
        try {
            PreparedStatement ps = _prepareStatement(query, args);
            int result = ps.executeUpdate();
            if (result != SUCCESS) {
                throw new RuntimeException("Error while executing query");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet query(String query, Object... args) {
        try {
            PreparedStatement ps = _prepareStatement(query, args);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Error while executing query");
    }

    @Override
    public void close() throws Exception {
        this.connection.close();
    }

    private PreparedStatement _prepareStatement(String query, Object... args) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement(query);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        return ps;
    }

}
