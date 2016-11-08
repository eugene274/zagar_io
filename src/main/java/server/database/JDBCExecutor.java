package server.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

/**
 * Created by eugene on 11/7/16.
 */
public class JDBCExecutor {

    public static void doQuery(PreparedStatement statement) throws SQLException {
        statement.executeUpdate();
        statement.getConnection().commit();
    }

    public static <T> T getQuery(PreparedStatement statement, Executor<T> operation) throws SQLException, DbError {
        ResultSet resultSet = statement.executeQuery();
        T result = operation.execute(resultSet);
        return result;
    }
}