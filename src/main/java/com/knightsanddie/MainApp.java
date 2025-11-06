package com.knightsanddie;

import com.knightsanddie.util.HibernateUtil;

/**
 * Minimal entry point for the skeleton project. This intentionally does not use JavaFX so
 * the project can compile/run without extra platform-specific JavaFX setup. Replace or
 * reintroduce a JavaFX main when you want to add a GUI.
 */
public class MainApp {

    public static void main(String[] args) {
        System.out.println("Knights & Die - skeleton starting");
        // Initialize Hibernate (this will create the schema configured for H2)
        HibernateUtil.getSessionFactory();
        System.out.println("Hibernate initialized.");
        // Shutdown immediately (this keeps the example minimal)
        HibernateUtil.shutdown();
        System.out.println("Shutdown complete.");
    }
}
