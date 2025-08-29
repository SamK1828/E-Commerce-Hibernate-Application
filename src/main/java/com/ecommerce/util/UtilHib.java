package com.ecommerce.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilHib {
	private static SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("SessionFactory created successfully");
        }
        catch(Exception e){
            System.out.println("SessionFactory creation failed: " + e.getMessage());
        }
    }

    public static SessionFactory getFactory(){
        return sessionFactory;
    }

}
