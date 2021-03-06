package managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Linija;
import model.RedVoznje;

public class RedVoznjeManager {

	public static List<RedVoznje> findAllByLinija(String nazivLinije) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT rv FROM RedVoznje rv WHERE rv.linija.nazivLinije =:nazivLinije")
					.setParameter("nazivLinije", nazivLinije).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static List<Date> findAllPolzakByLinija(String nazivLinije) {
		// <Date> vracam vreme polaska, to sam selektovao
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT rv.polazakVreme FROM RedVoznje rv WHERE rv.linja.nazivLinije =:nazivLinije")
					.setParameter("nazivLinije", nazivLinije).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static List<RedVoznje> findAllByRadniDan(int idLinija) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT rv FROM RedVoznje rv WHERE rv.linija.idLinija =:idLinija AND rv.radniDan = 1 "
					+ "ORDER BY rv.polazakVreme")
					.setParameter("idLinija", idLinija).getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static List<RedVoznje> findAllBySubota(int idLinija) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT rv FROM RedVoznje rv WHERE rv.linija.idLinija =:idLinija AND rv.subota = 1 "
					+ "ORDER BY rv.polazakVreme")
					.setParameter("idLinija", idLinija).getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	public static List<RedVoznje> findAllByNedelja(int idLinija) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT rv FROM RedVoznje rv WHERE rv.linija.idLinija =:idLinija AND rv.nedelja = 1 "
					+ "ORDER BY rv.polazakVreme")
					.setParameter("idLinija", idLinija).getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static boolean createRedVoznjeRadniDan(Date dolazakVreme, Date polazakVreme, int idLinija) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin();
			RedVoznje rv = new RedVoznje();
			if (rv != null) {
				rv.setNedelja((byte) 0);
				rv.setRadniDan((byte) 1);
				rv.setSubota((byte) 0);
				rv.setPolazakVreme(polazakVreme);
				rv.setDolazakVreme(dolazakVreme);
				Linija l = em.find(Linija.class, idLinija);
				rv.setLinija(l);
				em.persist(rv);
				em.getTransaction().commit();
				return true;
			}
			return false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	public static boolean createRedVoznjeNedelja(Date dolazakVreme, Date polazakVreme, int idLinija) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin();
			RedVoznje rv = new RedVoznje();
			if (rv != null) {
				rv.setNedelja((byte) 1);
				rv.setRadniDan((byte) 0);
				rv.setSubota((byte) 0);
				rv.setPolazakVreme(polazakVreme);
				rv.setDolazakVreme(dolazakVreme);
				Linija l = em.find(Linija.class, idLinija);
				rv.setLinija(l);
				em.persist(rv);
				em.getTransaction().commit();
				return true;
			}
			return false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	public static boolean createRedVoznjeSubota(Date dolazakVreme, Date polazakVreme, int idLinija) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin();
			RedVoznje rv = new RedVoznje();
			if (rv != null) {
				rv.setSubota((byte) 1);
				rv.setRadniDan((byte) 0);
				rv.setNedelja((byte) 0);
				rv.setPolazakVreme(polazakVreme);
				rv.setDolazakVreme(dolazakVreme);
				Linija l = em.find(Linija.class, idLinija);
				rv.setLinija(l);
				em.persist(rv);
				em.getTransaction().commit();
				return true;
			}
			return false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	// Delete metodu
	public static boolean deleteVoznja(int idRedVoznje) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin();
			RedVoznje rv = em.find(RedVoznje.class, idRedVoznje);
			if (rv != null) {
				em.remove(rv);
				em.persist(rv);
				em.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) {
			}
}