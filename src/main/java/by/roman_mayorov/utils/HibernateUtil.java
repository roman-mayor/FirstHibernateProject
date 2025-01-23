package by.roman_mayorov.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory(){
        Configuration cfg = new Configuration().configure();
        return cfg.buildSessionFactory();
    }
}
