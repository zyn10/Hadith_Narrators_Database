package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import to.Hadees;

public class HadithDAO implements Idal {
	private Connection con;

	public HadithDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/dummyFour?useSSL=false";
		String user = "root";
		String password = "";
		con = DriverManager.getConnection(url, user, password);
	}

	public HadithDAO(Connection con) {
		this.con = con;
	}
	/**
	 * 
	 * @author zain
	 *
	 */
	// create
	public boolean insertHadith(Hadees obj_TO) {

		if (obj_TO != null) {
			try {
				String query = "INSERT INTO `hadith_test` (Hadith, Book, hadithNum, Matn, Sanad, SanadLen, Id ) VALUES (?,?, ?, ?, ?, ?, ?)";
				PreparedStatement st = con.prepareStatement(query);
				st.setString(1, obj_TO.getHadithDesc());
				st.setString(2, obj_TO.getBook());
				st.setInt(3, obj_TO.gethadithNum());
				st.setString(4, obj_TO.getMatn());
				st.setString(5, obj_TO.getSanad());
				st.setInt(6, obj_TO.getsanad_Length());
				st.setInt(7,obj_TO.getUid());
				int rowsInserted = st.executeUpdate();

				return rowsInserted > 0;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		return false;
	}
	/**
	 * 
	 * @author zain
	 *
	 */
	// Read
	public ArrayList<String> getHadiths() {
		ArrayList<String> rows = new ArrayList<String>();
		try {
			String query = "SELECT Sanad FROM `hadith_test`";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String s = rs.getString("Sanad");
				rows.add(s);

			}
		} catch (SQLException e) {
			System.out.print("Error Connection with database"); // Handle the exception
		}
		return rows;
	}

	/**
	 * 
	 * @author danish
	 *
	 */
	public boolean updateHadith(Hadees obj_TO) {
		if (obj_TO != null) {
			try {

				String query = "UPDATE `hadith_test` SET Hadith = ?, Book = ?, hadithNum = ?, Matn = ?, Sanad = ?, SanadLen = ? WHERE Id = ?";
				PreparedStatement st = con.prepareStatement(query);
				st.setString(1, obj_TO.getHadithDesc());
				st.setString(2, obj_TO.getBook());
				st.setInt(3, obj_TO.gethadithNum());
				st.setString(4, obj_TO.getMatn());
				st.setString(5, obj_TO.getSanad());
				st.setInt(6, obj_TO.getsanad_Length());
				st.setInt(7, obj_TO.getUid());
				int rowsUpdated = st.executeUpdate();
				return rowsUpdated > 0;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	/**
	 * 
	 * @author danish
	 *
	 */
	//Delete
	@Override
	public boolean deleteHadith(Hadees obj_TO) {
		if (obj_TO != null) {
			try {
					String query = "DELETE FROM `hadith_test` WHERE `Id` = ?";;
					PreparedStatement st = con.prepareStatement(query);
					st.setInt(1, obj_TO.getUid());
					int rowsDeleted = st.executeUpdate();
					return rowsDeleted > 0;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @author talha
	 *
	 */
	public List<Hadees> getDataByBook(String book) {
		List<Hadees> dataList = new ArrayList<>();
		try {
			String query = "SELECT * FROM `hadith_test` WHERE `Book` = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, book);
			ResultSet resultSet = st.executeQuery();
			while (resultSet.next()) {
				Hadees obj_TO = new Hadees(query, query, 0, query, query, 0);
				obj_TO.setHadithDesc(resultSet.getString("Hadith"));
				obj_TO.setBook(resultSet.getString("Book"));
				obj_TO.sethadithNum(resultSet.getInt("hadithNum"));
				obj_TO.setText(resultSet.getString("Matn"));
				obj_TO.setSanad(resultSet.getString("Sanad"));
				obj_TO.setsanad_Length(resultSet.getInt("SanadLen"));
				dataList.add(obj_TO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.print(dataList);
		return dataList;
	}

}