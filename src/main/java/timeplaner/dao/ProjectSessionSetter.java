package timeplaner.dao;


public class ProjectSessionSetter {

    protected SessionFactory sessionFactory;

    public ProjectSessionSetter(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
}
