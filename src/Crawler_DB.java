
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	 
	 class Crawler_DB {
	 
		public Connection conn = null;
	 
		public Crawler_DB() {		
						//Constructor establishing connection with database
			try {
				 Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/crawler";
				conn = DriverManager.getConnection(url,"root","sumit");
				System.out.println("conn built with Database");
				} catch (SQLException e) {
					e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
		}
		
		
	 
		public ResultSet runSql(String sql) throws SQLException {		//to get a table or view
			Statement sta = conn.createStatement();
			return sta.executeQuery(sql);
		}
	 
		public boolean runSql2(String sql) throws SQLException {		//create table
			Statement sta = conn.createStatement();
			return sta.execute(sql);
		}
	 
		@Override
		protected void finalize() throws Throwable {				//close the connection
			if (conn != null || !conn.isClosed()) {
				conn.close();
			}
		}
	}
