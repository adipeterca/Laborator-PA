import compulsory.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Movie movie1 = new Movie(10, "Return of the Jedi", new Date(102L), 183, 9);
            Movie movie2 = new Movie(11, "Rise of the Empire", new Date(2151231L), 154, 7);

            MovieDao movieDao = new MovieDao(MyDatabaseConn.getInstance().getConnection());

            movieDao.deleteAll();
            movieDao.insert(movie1);
            movieDao.insert(movie2);

            Movie movie1received = movieDao.getById(10);
            Movie movie2received = movieDao.getById(11);

            if (movie1.equals(movie1received)) {
                System.out.println("Same movie!");
            }
            else {
                System.out.println("Not the same movie!");
            }

            if (movie1.equals(movie2received)) {
                System.out.println("Same movie!");
            }
            else {
                System.out.println("Not the same movie!");
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
