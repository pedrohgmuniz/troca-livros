/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario_DAO;

import controller.ResourcePersistence;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.Usuario;

/**
 *
 * @author Nil
 */
public class UsuarioDaoImpl implements UsuarioDAO {
     @Override
    public void inserir(Usuario obj) {
        EntityManager em = ResourcePersistence.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            System.out.println("REGISTRO INSERIDO COM SUCESSO");
        } catch (Exception e) {
            System.err.println("erro" + e.getMessage());
        } finally {
            em.close();
        }

    }

    @Override
    public void alterar(Usuario obj) {
        EntityManager em = ResourcePersistence.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            System.out.println("REGISTRO ALTERADO COM SUCESSO");
        } catch (Exception e) {
            System.err.println("erro" + e.getMessage());
        } finally {
            em.close();
        }

    }

    @Override
    public void deletar(Usuario obj) {
        EntityManager em = ResourcePersistence.getEntityManager();
        try {
            em.getTransaction().begin();
            Usuario contato = em.find(Usuario.class, obj.getCodUsuario());
            em.remove(contato);
            em.getTransaction().commit();
            System.out.println("REGISTRO EXCLUÍDO COM SUCESSO");
        } catch (Exception e) {
            System.err.println("erro" + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public List<Usuario> listar(Usuario obj) {
        EntityManager em = ResourcePersistence.getEntityManager();
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("SELECT c FROM Usuario c  ").getResultList();
            em.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            System.err.println("erro" + e.getMessage());
        } finally {
            em.close();
        }
        return lista;
    }


    
}
