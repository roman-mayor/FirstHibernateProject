package by.roman_mayorov.hibernateStarter;

import by.roman_mayorov.entity.Company;
import by.roman_mayorov.entity.Role;
import by.roman_mayorov.entity.User;
import by.roman_mayorov.utils.HibernateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class HibernateRunner {

    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class);

    public static void main(String[] args) {

        Company company = Company.builder().
                name("Yandex")
                .build();
        User user = User.builder()
                .username("ivan@gmal.com")
                .firstName("Ivan")
                .lastName("Ivanov")
                .birthDate(LocalDate.of(1967, 4, 26))
                .age(30)
                .role(Role.USER)
                .company(company)
                .build();
        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (var session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.getTransaction().commit();
            }
        }catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
