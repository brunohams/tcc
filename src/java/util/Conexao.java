package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe para gerênciar as conexões com o banco. Também possui os métodos
 * basicos para: inclusão, alteração, exclusão e consulta de qualquer tipo de
 * objeto
 *
 * @author Matheus Henrique
 */
public class Conexao {

    private EntityManagerFactory emf;
    private EntityManager em;
    private boolean conectou = false;
    private static final String PU = "TCCPU";

    public Conexao() {
        conectar();
    }

    private boolean conectar() {
        if (!conectou) {
            try {
                emf = Persistence.createEntityManagerFactory(PU);
                em = emf.createEntityManager();
                conectou = true;
            } catch (Exception e) {
                System.out.println("Não foi possivel conectar:" + e.getMessage());
            }
        }
        return conectou;
    }

    public void desconectar() {
        em.close();
        emf.close();
        conectou = false;
    }

    //Grava novos objetos no banco
    public void incluir(Object o) {
        if (conectar()) {
            try {
                em.getTransaction().begin();
                em.persist(o);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                desconectar();
            }
        }
    }

    //Alterar objetos no banco
    public void alterar(Object o) {
        if (conectar()) {
            try {
                em.getTransaction().begin();
                em.merge(o);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                desconectar();
            }
        }
    }

    //Exclui objetos no banco
    public void excluir(Object o) {
        if (conectar()) {
            try {
                em.getTransaction().begin();
                em.remove(em.merge(o));
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                desconectar();
            }
        }
    }

    //retorna o entitymanager
    public EntityManager getEm() {
        if (!conectou) {
            conectar();
        }
        return em;
    }
}
