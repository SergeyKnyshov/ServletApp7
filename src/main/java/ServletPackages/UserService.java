package ServletPackages;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class UserService {
    private static final Map<String, UserProfile> sessionIdToProfile = new HashMap<>();
    private static final UserDatabase userBD;
    static {
        try {
            userBD = new UserDatabase(ConnectionPro.getConnection());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    public UserService() {
    }

    public static boolean addNewUser(UserProfile user) {
        return
                userBD.saveUser(user);

    }

    public static UserProfile getUserByName(String name) throws SQLException {
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