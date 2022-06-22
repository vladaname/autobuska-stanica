package managers;

import java.util.List;

import javax.persistence.EntityManager;

import org.jasypt.util.password.StrongPasswordEncryptor;

import model.Korisnik;
import model.Uloga;

public class KorisnikManager {

	public static List<Korisnik> findAllKorisnik() {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin();
			return em.createQuery("SELECT k FROM Korisnik k").getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	public static Korisnik findByTel(String telefon) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin();
			// unikue
			return (Korisnik) em.createQuery("SELECT k FROM Korisnik k WHERE k.telefon =:telefon")
					.setParameter("telefon", telefon).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static Korisnik findByEmail(String email) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			return (Korisnik) em.createQuery("SELECT k FROM Korisnik k WHERE k.email =:email")
					.setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static List<Korisnik> findAllByIme(String ime) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT k FROM Korisnik k WHERE k.ime =:ime").setParameter("ime", ime)
					.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static List<Korisnik> findAllByPrezime(String prezime) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			return em.createQuery("SELECT k FROM Korisnik k WHERE k.prezime =:prezime").setParameter("prezime", prezime)
					.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static boolean createKorisnik(String ime, String prezime, String telefon, String email, String username,
			String pass) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin();
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			Korisnik k = new Korisnik();
			k.setIme(ime);
			k.setPrezime(prezime);
			k.setTelefon(telefon);
			k.setEmail(email);
			k.setUsername(username);
			k.setPass(passwordEncryptor.encryptPassword(pass));
			Uloga u = (Uloga) em.createQuery("SELECT u FROM Uloga u WHERE u.idUloga = 1").getSingleResult();
			k.setUloga(u);
			em.persist(k);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	public static boolean updateKorisnik(int idKorisnik, String ime, String prezime, String telefon, String email,
			String username, String pass) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin();
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			Korisnik k = em.find(Korisnik.class, idKorisnik);
			if (k != null) {
				k.setIme(ime);
				k.setPrezime(prezime);
				k.setTelefon(telefon);
				k.setEmail(email);
				k.setUsername(username);
				k.setPass(passwordEncryptor.encryptPassword(pass));
				Uloga u = (Uloga) em.createQuery("SELECT u FROM Uloga u WHERE u.idUloga = 1");
				k.setUloga(u);
				em.persist(k);
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

	public static Korisnik login(String username, String pass) {
		EntityManager em = JPAUtil.getentityManager();
		try {
			em.getTransaction().begin(); // da li je transakcija dobra?
			Korisnik k = (Korisnik) em.createQuery("SELECT k FROM Korisnik k WHERE k.username =:username")
					.setParameter("username", username).getSingleResult();
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			String encryptedPass = k.getPass();
			if (pass.equals(k.getPass()) || passwordEncryptor.checkPassword(pass, encryptedPass)) {
				return k;
			} else {
				return null;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}
