/**
 * 
 */
package hjj.jxc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 管理员信息实体
 * 
 * @author lch
 * @email 840446169@qq.com
 * @create 2013-10-26
 */
public class User {

	private int id; // 编号

	private String username; // 账号

	private String password; // 秘密

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void initFormRs(ResultSet rs) {
		try {
			setId(rs.getInt(1));
			setUsername(rs.getString(2));
			setPassword(rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
