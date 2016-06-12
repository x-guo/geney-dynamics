package com.ufenqi.mall.dal.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


@SuppressWarnings("deprecation")
public class HibernateTest {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        session.createSQLQuery("select count(*) from ac_auth_offline");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
    }
}
