package dbo;

public class UserDaoImpl implements UserDao {

	@Override
	public int save(Object o) throws Exception {
		return new BaseDaoImpl().save(o);
	}

	@Override
	public int delete(Object o) throws Exception {
		return new BaseDaoImpl().delete(o);
	}

	@Override
	public int update(Object o, String whereStr) throws Exception {
		return new BaseDaoImpl().update(o, whereStr);
	}

	@Override
	public Object query(Object o) throws Exception {
		return new BaseDaoImpl().query(o);
	}
	
	public static void main(String[] args) {
		 Users u=new Users();
         UserDaoImpl user=new UserDaoImpl();
         try {
        	 u.setName("111");

             u.setPassword("222");
             user.save(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
