package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TCCPU");
        EntityManager em = emf.createEntityManager();
        
        em.close();
        emf.close();
        
    }
    
}