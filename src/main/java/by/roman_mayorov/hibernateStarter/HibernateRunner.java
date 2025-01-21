package by.roman_mayorov.hibernateStarter;

import by.roman_mayorov.entity.Role;
import by.roman_mayorov.entity.User;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        try(var sessionFactory = cfg.buildSessionFactory();
            var session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(User.builder()
                    .username("vasyapupkin@gmal.com")
                            .firstName("Vasya")
                            .lastName("Pupkin")
                            .birthDate(LocalDate.of(1998, 4, 26))
                            .age(26)
                            .role(Role.ADMIN)
                    .build());
            session.getTransaction().commit();
        }
    }
}
