package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the linija database table.
 * 
 */
@Entity
@NamedQuery(name="Linija.findAll", query="SELECT l FROM Linija l")
public class Linija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_linija")
	private int idLinija;

	@Column(name="naziv_linije")
	private String nazivLinije;

	@Column(name="opis_linije")
	private String opisLinije;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="linija")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to RedVoznje
	@OneToMany(mappedBy="linija")
	private List<RedVoznje> redVoznjes;

	public Linija() {
	}

	public int getIdLinija() {
		return this.idLinija;
	}

	public void setIdLinija(int idLinija) {
		this.idLinija = idLinija;
	}

	public String getNazivLinije() {
		return this.nazivLinije;
	}

	public void setNazivLinije(String nazivLinije) {
		this.nazivLinije = nazivLinije;
	}

	public String getOpisLinije() {
		return this.opisLinije;
	}

	public void setOpisLinije(String opisLinije) {
		this.opisLinije = opisLinije;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setLinija(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setLinija(null);

		return komentar;
	}

	public List<RedVoznje> getRedVoznjes() {
		return this.redVoznjes;
	}

	public void setRedVoznjes(List<RedVoznje> redVoznjes) {
		this.redVoznjes = redVoznjes;
	}

	public RedVoznje addRedVoznje(RedVoznje redVoznje) {
		getRedVoznjes().add(redVoznje);
		redVoznje.setLinija(this);

		return redVoznje;
	}

	public RedVoznje removeRedVoznje(RedVoznje redVoznje) {
		getRedVoznjes().remove(redVoznje);
		redVoznje.setLinija(null);

		return redVoznje;
	}

	@Override
	public String toString() {
		return "Linija [idLinija=" + idLinija + ", nazivLinije=" + nazivLinije + ", opisLinije=" + opisLinije + "]";
	}
	

}