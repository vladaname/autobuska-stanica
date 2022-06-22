package managers;

import java.util.List;

import javax.persistence.EntityManager;

import model.Komentar;
import model.Korisnik;
import model.Linija;

public class KomentarManager {
	
	public static List<Komentar> findAll(){
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT ko FROM Komentar ko").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static List<Komentar> findAllByKorisnik(int idKorisnik){
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT ko FROM Komentar ko WHERE ko.korisnik.idKorisnik =:idKorisnik")
					.setParameter("idKorisnik", idKorisnik).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static List<Komentar> findAllByLinija(int idLinija){
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT ko FROM Komentar ko WHERE ko.linija.idLinija =:idLinija")
					.setParameter("idLinija", idLinija).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public static boolean createKomentar(int idKorisnik, int idLinija, String komentar) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin();
			Komentar ko = new Komentar();
		//	if(ko != null) {
			ko.setKomentar(komentar);
			ko.setObrisan(0);
//			Korisnik k = em.createQuery("SELECT k FROM Korisnik k WHERE k.idKorisnik =:idKorisnik")
			Korisnik k = em.find(Korisnik.class, idKorisnik);
			ko.setKorisnik(k);
			Linija l = em.find(Linija.class, idLinija);
			ko.setLinija(l);
			em.persist(ko);
			em.getTransaction().commit();
			return true;
//			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
	
	public static boolean deleteComentar(int idKomentar) {
		EntityManager em = JPAUtil.getentityManager();
		
		try {
			em.getTransaction().begin();
			Komentar ko = em.find(Komentar.class, idKomentar);
			if(ko != null) {
			em.remove(ko);
			em.persist(ko);
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

}

