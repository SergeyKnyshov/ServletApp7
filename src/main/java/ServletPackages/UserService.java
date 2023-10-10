package ServletPackages;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static ServletPackages.HibernateUtil.sessionFactory;
import org.hibernate.Session;


public class UserService {
    private static final Map<String, UserProfile> sessionIdToProfile = new HashMap<>();


    
    public UserService() {
    }

    public static boolean addNewUser(UserProfile user) {
        Session session = sessionFactory.openSession();
        UserDatabase userBD = new UserDatabase(session);
        return
                userBD.saveUser(user);

    }

    public static UserProfile getUserByName(String name) throws SQLException {
        Session session = sessionFactory.openSession();
        UserDatabase userBD = new UserDatabase(session);
        return userBD.getUser(name);
    }

    public static UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public static void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public static void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}