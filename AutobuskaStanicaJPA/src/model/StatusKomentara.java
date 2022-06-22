package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status_komentara database table.
 * 
 */
@Entity
@Table(name="status_komentara")
@NamedQuery(name="StatusKomentara.findAll", query="SELECT s FROM StatusKomentara s")
public class StatusKomentara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_status_komentara")
	private int idStatusKomentara;

	@Column(name="naziv_statusa")
	private String nazivStatusa;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="statusKomentara")
	private List<Komentar> komentars;

	public StatusKomentara() {
	}

	public int getIdStatusKomentara() {
		return this.idStatusKomentara;
	}

	public void setIdStatusKomentara(int idStatusKomentara) {
		this.idStatusKomentara = idStatusKomentara;
	}

	public String getNazivStatusa() {
		return this.nazivStatusa;
	}

	public void setNazivStatusa(String nazivStatusa) {
		this.nazivStatusa = nazivStatusa;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setStatusKomentara(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setStatusKomentara(null);

		return komentar;
	}

}