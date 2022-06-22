package managers;

import java.util.List;

import javax.persistence.EntityManager;

import model.Linija;
import model.RedVoznje;

public class LinijaManager {
	
	public static List<Linija> findAllLinija(){
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT l FROM Linija l").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public static Linija findLinijaByName(String nazivLinije) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			return (Linija) em.createQuery("SELECT l FROM Linija l WHERE l.nazivLinije =:nazivLinije")
					.setParameter("nazivLinije", nazivLinije).getSingleResult();
			// quey puca ako imam dva ista naziva za liniju
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean createLinija(String nazivLinije, String opisLinije) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin();
			// provera da li linija postoji
			List<Linija> pronadjiLiniju = em.createQuery("SELECT l FROM Linija l WHERE l.nazivLinije =:nazivLinije")
					.setParameter("nazivLinije", nazivLinije).getResultList();
			if(pronadjiLiniju.size() > 0) {
				return false;
			}
			Linija l = new Linija();
			if(l != null) {
				l.setNazivLinije(nazivLinije);
				l.setOpisLinije(opisLinije);
				em.persist(l);
				em.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
	public static boolean updateLinija(int idLinija, String nazivLinije, String opisLinije) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			
			em.getTransaction().begin();
			Linija l = em.find(Linija.class, idLinija);
			if(l != null) {
			l.setNazivLinije(nazivLinije);
			l.setOpisLinije(opisLinije);
			em.persist(l);
			em.getTransaction().commit();
			return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
	// uradi update
	// uradi sumu polazaka po liniji Chart.js   desc u mySql
	public static void main(String[] args) {
		List<Linija> lista = findAllLinija();
		for (Linija linija : lista) {
			System.out.println(linija.toString());
		}
	}

}
