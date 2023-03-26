package ServletPackages;
import java.sql.*;
public class UserDatabase {

    Connection con ;

    public UserDatabase(Connection con) {
        this.con = con;
    }
    public UserProfile getUser(String login) {

        if(con != null){
            String sqlGet = "select * from users where username = ?";
            try(PreparedStatement preparedStatement = con.prepareStatement(sqlGet)){
                preparedStatement.setString(1, login);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    if(resultSet.next()){
                        return new UserProfile(resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getString("email"));
                    }
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean saveUser(UserProfile user){
        boolean set = false;
        try{
            String query = "insert into users (username, password, email) values (?, ?, ?)";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getLogin());
            pt.setString(2, user.getPass());
            pt.setString(3, user.getEmail());


            pt.executeUpdate();
            set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
}
