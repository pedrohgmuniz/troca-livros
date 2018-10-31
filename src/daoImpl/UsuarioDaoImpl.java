package daoImpl;

public class UsuarioDaoImpl {

	@Override
	public void inserir(Usuario obj) {
		EntityManager em = ResourcePersistence.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			System.out.println("Usuario inserido com sucesso");
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
			System.out.println("Usuario alterado com sucesso");
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
			System.out.println("Usuario deletado com sucesso");
		} catch (Exception e) {
			System.err.println("erro" + e.getMessage());
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
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
