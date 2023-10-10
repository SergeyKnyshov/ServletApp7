package ServletPackages;

import org.hibernate.Criteria;
import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
public class UserDatabase {

    private Session session;

    public UserDatabase(Session session) {this.session = session;};


    public UserProfile getUser(String login) {

        session = HibernateUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        UserProfile user = getBy("login",login);

        transaction.commit();
        session.close();
        return user;
    }
    public UserProfile getBy(String variable, String value){
        Criteria criteria = session.createCriteria(UserProfile.class);
        return (UserProfile) criteria.add(Restrictions.eq(variable, value)).uniqueResult();
    }


    public boolean delete(UserProfile user) {


        boolean delete = true;
        Session session = HibernateUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.delete(user);
        }catch (PersistentObjectException e){
            delete = false;
        }


        transaction.commit();
        session.close();
        return delete;
    }

    public static UserProfile findById(int id) {
        return (UserProfile) HibernateUtil.sessionFactory.openSession().get(UserProfile.class, id);
    }

    public boolean saveUser(UserProfile user){
        boolean save = true;
        session = HibernateUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.persist(user);

        }catch (PersistentObjectException e){
            save = false;
        }

        transaction.commit();
        session.close();

        return save;
    }

    public boolean update(UserProfile user) {

            boolean update = true;
            Session session = HibernateUtil.sessionFactory.openSession();
            Transaction tx1 = session.beginTransaction();
            try {
                session.merge(user);
            } catch (PersistentObjectException e) {
                update = false;
            }

            tx1.commit();
            session.close();
            return update;
        }
    }


