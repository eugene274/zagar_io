package server.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by eugene on 11/7/16.
 */
public interface Executor<T> {
    T execute(ResultSet resultSet) throws SQLException;
}
