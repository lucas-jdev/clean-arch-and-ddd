package code.infra.databases;

import java.sql.ResultSet;

public interface IConnection extends AutoCloseable {

    void insert(String query, Object... args);

    ResultSet query(String query, Object... args);

    @Override
    void close() throws Exception;

}
