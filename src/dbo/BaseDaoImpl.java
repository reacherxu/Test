package dbo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl implements BaseDao {



	public Connection connection() throws ClassNotFoundException {

		Connection connection = null;

		// System.out.println("init:"+init());
		String url = "jdbc:sqlserver://localhost:1433;databaseName=STOMS;user=sa;password=reacher";
		// String url=init();
		try {
			connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public int save(Object o) throws Exception {
		int reNumber = -1;
		String sql = "";
		Class<?> baseDao = o.getClass();
		List<Object> params = new ArrayList<Object>();
		Field[] fields = baseDao.getDeclaredFields();// 返回Field数组

		for (int i = 0; i < fields.length; i++) {
			Method m = (Method) o.getClass().getMethod(
					"get" + getMethodName(fields[i].getName()));
			Object val = m.invoke(o);// 调用get方法。
			if (val != null) {
				sql += fields[i].getName() + ",";
				params.add(val);
			}
		}
		if ((!sql.equals("")) && sql != "") {
			sql = sql.substring(0, sql.length() - 1);
			String table = o.getClass().getName();
			String parasStr = "";
			for (int i = 0; i < params.size(); i++) {
				parasStr += "?,";
			}
			parasStr = parasStr.substring(0, parasStr.length() - 1);
			sql = "insert into " + "STOMS.dbo."
					+ table.substring(table.indexOf(".") + 1, table.length())
					+ "(" + sql + ") values (" + parasStr + ")";
			System.out.println(sql);
			Connection conn = connection();
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i + 1, params.get(i));
			}
			reNumber=ps.executeUpdate();
			close(conn, ps, null);
		}
		return reNumber;

	}



	public int delete(Object o) throws Exception {

		int reNumber = -1;
		String sql = "";
		Class<?> baseDao = o.getClass();
		List<Object> params = new ArrayList<Object>();
		Field[] fields = baseDao.getDeclaredFields();// 返回Field数组

		for (int i = 0; i < fields.length; i++) {
			Method m = (Method) o.getClass().getMethod(
					"get" + getMethodName(fields[i].getName()));
			Object val = m.invoke(o);// 调用get方法。
			if (val != null) {
				sql += fields[i].getName() + "=?,";
				params.add(val);
			}
		}

		if ((!sql.equals("")) && sql != "") {
			sql = sql.substring(0, sql.length() - 1);
			String table = o.getClass().getName();
			sql = "delete from  " + "t_"
					+ table.substring(table.indexOf(".") + 1, table.length())
					+ " where " + sql ;
			System.out.println(sql);
			Connection conn = connection();
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i + 1, params.get(i));
			}
			reNumber=ps.executeUpdate();
			close(conn, ps, null);

		}
		return reNumber;

	}



	public int update(Object o,String whereStr) throws Exception {
		int reNumber = -1;
		String sql = "";
		Class<?> baseDao = o.getClass();
		List<Object> params = new ArrayList<Object>();
		Field[] fields = baseDao.getDeclaredFields();// 返回Field数组

		for (int i = 0; i < fields.length; i++) {
			Method m = (Method) o.getClass().getMethod(
					"get" + getMethodName(fields[i].getName()));
			Object val = m.invoke(o);// 调用get方法。
			if (val != null) {
				sql += fields[i].getName() + "=?,";
				params.add(val);
			}
		}

		if ((!sql.equals("")) && sql != "") {
			sql = sql.substring(0, sql.length() - 1);
			String table = o.getClass().getName();
			sql = "update " + "t_"
					+ table.substring(table.indexOf(".") + 1, table.length())
					+ " set " + sql +" where "+whereStr;
			System.out.println(sql);
			Connection conn = connection();
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i + 1, params.get(i));
			}
			reNumber=ps.executeUpdate();
			close(conn, ps, null);
		}
		return reNumber;

	}



	public Object query(Object o) throws Exception {
		String sql = "";
		String queryString="";
		Class<?> baseDao = o.getClass();
		List<Object> params = new ArrayList<Object>();
		Field[] fields = baseDao.getDeclaredFields();// 返回Field数组
		for (int i = 0; i < fields.length; i++) {
			Method m = (Method) o.getClass().getMethod(
					"get" + getMethodName(fields[i].getName()));
			Object val = m.invoke(o);// 调用get方法。
			queryString+=fields[i].getName()+",";
			if (val != null) {
				sql += fields[i].getName() + "=?,";
				params.add(val);
			}
		}

		if ((!sql.equals("")) && sql != "") {
			sql = sql.substring(0, sql.length() - 1);
			queryString=queryString.substring(0,queryString.length()-1);
			String table = o.getClass().getName();
			sql = "select  " +queryString+ " from t_"
					+ table.substring(table.indexOf(".") + 1, table.length())
					+  " where "+sql ;
			System.out.println(sql);
			Connection conn = connection();
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i + 1, params.get(i));
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				for (int i = 0; i < fields.length; i++) {
					Method m = (Method) o.getClass().getMethod(
							"set" + getMethodName(fields[i].getName()),fields[i].getType());
					m.invoke(o,rs.getObject(fields[i].getName()));// 调用get方法。
				}
			}
			close(conn, ps, rs);
		}
		return o;
	}



	// 把一个字符串的第一个字母大写、效率是最高的
	private static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);

	}



	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

}