package server.dao;

import model.data.Token;
import server.dao.exceptions.DaoException;

import java.util.List;

/**
 * Created by eugene on 11/4/16.
 */
public interface TokenDAO extends DAO<Token> {
    Token getTokenByTokenString(String tokenString);
    void removeByTokenString(String tokenString) throws DaoException;
    List<Token> getAll();
}
