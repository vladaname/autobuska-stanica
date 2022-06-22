package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the komentar database table.
 * 
 */
@Entity
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_komentar")
	private int idKomentar;

	private String komentar;

	private int obrisan;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Linija
	@ManyToOne
	private Linija linija;

	//bi-directional many-to-one association to StatusKomentara
	@ManyToOne
	@JoinColumn(name="status_komentara_id_status_komentara")
	private StatusKomentara statusKomentara;

	public Komentar() {
	}

	public int getIdKomentar() {
		return this.idKomentar;
	}

	public void setIdKomentar(int idKomentar) {
		this.idKomentar = idKomentar;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public int getObrisan() {
		return this.obrisan;
	}

	public void setObrisan(int obrisan) {
		this.obrisan = obrisan;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Linija getLinija() {
		return this.linija;
	}

	public void setLinija(Linija linija) {
		this.linija = linija;
	}

	public StatusKomentara getStatusKomentara() {
		return this.statusKomentara;
	}

	public void setStatusKomentara(StatusKomentara statusKomentara) {
		this.statusKomentara = statusKomentara;
	}

}