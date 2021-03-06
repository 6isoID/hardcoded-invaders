package com.epam.game.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epam.game.domain.Authority;
import com.epam.game.domain.User;

import javax.sql.DataSource;

/**
 * @author Roman_Spiridonov
 */
@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("ID"));
            user.setUserName(rs.getString("USER_NAME"));
            user.setLogin(rs.getString("LOGIN"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setToken(rs.getString("TOKEN"));
            user.setEmail(rs.getString("EMAIL"));
            user.setAuthorities(getUserAuthorities(user.getId()));
            return user;
        }
    };

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUserWith(String login, String password) {
        return DataAccessUtils.singleResult(jdbcTemplate.query("SELECT * FROM \"USERS\" WHERE \"LOGIN\" = ? AND \"PASSWORD\" = ?", rowMapper, login, password));
    }

    public User getUserWith(Long userId) {
        return DataAccessUtils.singleResult(jdbcTemplate.query("SELECT * FROM \"USERS\" WHERE \"ID\" = ?", rowMapper, userId));
    }

    public User getUserWith(String login) {
        return DataAccessUtils.singleResult(jdbcTemplate.query("SELECT * FROM \"USERS\" WHERE \"LOGIN\" = ?", rowMapper, login));
    }

    public void addAuthorityToUser(Long userId, Authority authority) {
        jdbcTemplate.update("INSERT INTO \"AUTHORITIES\" (\"USER_ID\", \"AUTHORITY\") VALUES(?, ?)", userId, authority.getAuthority());
    }

    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO \"USERS\" (\"USER_NAME\", \"LOGIN\", \"PASSWORD\",  \"TOKEN\", \"EMAIL\") VALUES(?, ?, ?, ?, ?)",
                user.getUserName(), user.getLogin(), user.getPassword(), user.getToken(), user.getEmail());
        User userFromDB = getUserWith(user.getLogin(), user.getPassword());
        if (userFromDB != null) {
            for (Authority authority : user.getAuthorities()) {
                addAuthorityToUser(userFromDB.getId(), authority);
            }
        }
    }

    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE \"USERS\" SET \"USER_NAME\" = ?, \"LOGIN\" = ?, \"PASSWORD\" = ?, \"TOKEN\" = ?, \"EMAIL\" = ? WHERE \"ID\" = ?",
                user.getUserName(), user.getLogin(), user.getPassword(), user.getToken(), user.getEmail(), user.getId());
    }

    private List<Authority> getUserAuthorities(Long userId) {
        return jdbcTemplate.query("SELECT * FROM \"AUTHORITIES\" WHERE \"USER_ID\" = ?", new RowMapper<Authority>() {
            @Override
            public Authority mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Authority.valueOf(rs.getString("AUTHORITY"));
            }
        }, userId);
    }
}
