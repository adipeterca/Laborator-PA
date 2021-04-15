package compulsory;

import java.io.IOException;
import java.sql.*;

public class GenresDao {

    private final PreparedStatement getByIdStmt;
    private final PreparedStatement insertStmt;
    private final PreparedStatement deleteAllStmt;

    public GenresDao(Connection connection) throws SQLException {
        getByIdStmt = connection.prepareStatement("select * from genres where id = ?");
        insertStmt = connection.prepareStatement("insert into genres values (?, ?)");
        deleteAllStmt = connection.prepareStatement("delete from genres");
    }

    public Genres getById(int id) throws SQLException {
        getByIdStmt.setInt(1, id);

        ResultSet result = getByIdStmt.executeQuery();

        Genres returnGenres = null;
        while (result.next()) {
            returnGenres = new Genres();
            returnGenres.setId(result.getInt(1));
            returnGenres.setName(result.getString(2));
        }
        return returnGenres;
    }

    public boolean insert(Genres genres) throws SQLException {
        if (genres == null) {
            System.out.println("Cannot insert a null genre!");
            return false;
        }

        insertStmt.setInt(1, genres.getId());
        insertStmt.setString(2, genres.getName());

        return insertStmt.execute();
    }

    public boolean deleteAll() throws SQLException {
        return deleteAllStmt.execute();
    }
}
