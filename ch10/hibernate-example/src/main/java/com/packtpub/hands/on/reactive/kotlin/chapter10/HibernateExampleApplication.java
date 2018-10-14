package com.packtpub.hands.on.reactive.kotlin.chapter10;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class HibernateExampleApplication {
  public static void main(String[] args) {
    System.out.println("hibernate example");
    final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    save(sessionFactory);
    load(sessionFactory);
    sessionFactory.close();
  }

  private static void save(final SessionFactory sessionFactory) {
    System.out.println("saving customers");
    final Session session = sessionFactory.openSession();

    session.beginTransaction();

    session.save(new Customer("Peter", "Parker"));
    session.save(new Customer("Steve", "Rogers"));
    session.save(new Customer("Red", "Richards"));

    session.getTransaction().commit();
  }

  private static void load(final SessionFactory sessionFactory) {
    System.out.println("loading customers");

    final Session session = sessionFactory.openSession();

    final Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
    final List<Customer> list = query.list();
    list.forEach(System.out::println);

    session.close();
  }
}
