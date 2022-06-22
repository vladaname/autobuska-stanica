package managers;

import java.util.List;

import javax.persistence.EntityManager;

public class StatistikaManager {
	
	public List<Object[]> statistikaRedVoznje(){
		EntityManager em = JPAUtil.getentityManager();
		try {
			List<Object[]> podaci = em.createNativeQuery("select count(r.polazak_vreme) as brojPolazaka, l.naziv_linije as nazivLinije from red_voznje as r " + 
					"inner join linija as l on r.linija_id_linija = l.id_linija " + 
					"group by nazivLinije order by brojPolazaka desc").getResultList();
			// kako da uradim da mi prikazuje bez limita? da automatski prosiruje dijagram
			return podaci;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}

