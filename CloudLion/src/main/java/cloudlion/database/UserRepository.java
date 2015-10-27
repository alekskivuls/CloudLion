package cloudlion.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	protected JdbcTemplate jdbc;

	public User getUser(long id) {
		return jdbc.queryForObject("SELECT * FROM users WHERE id=?", userMapper, id);
	}

	public List<User> getUsers(long[] ids) {
		String inIds = StringUtils.arrayToCommaDelimitedString(ObjectUtils.toObjectArray(ids));
		return jdbc.query("SELECT * FROM users WHERE id IN (" + inIds + ")", userMapper);
	}

	private static final RowMapper<User> userMapper = new RowMapper<User>() {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"),
					rs.getString("userName"), rs.getString("password"));
			// user.alias = rs.getString("alias");
			return user;
		}
	};

}