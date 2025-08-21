package com.ecommerce.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilHib {
	private static SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static SessionFactory getFactory(){
        return sessionFactory;
    }

}
