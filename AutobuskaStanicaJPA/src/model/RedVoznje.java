package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the red_voznje database table.
 * 
 */
@Entity
@Table(name="red_voznje")
@NamedQuery(name="RedVoznje.findAll", query="SELECT r FROM RedVoznje r")
public class RedVoznje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_red_voznje")
	private int idRedVoznje;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dolazak_vreme")
	private Date dolazakVreme;

	private byte nedelja;

	private int obrisan;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="polazak_vreme")
	private Date polazakVreme;

	@Column(name="radni_dan")
	private byte radniDan;

	private byte subota;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ukupno_vreme_voznje")
	private Date ukupnoVremeVoznje;

	//bi-directional many-to-one association to Linija
	@ManyToOne
	private Linija linija;

	public RedVoznje() {
	}

	public int getIdRedVoznje() {
		return this.idRedVoznje;
	}

	public void setIdRedVoznje(int idRedVoznje) {
		this.idRedVoznje = idRedVoznje;
	}

	public Date getDolazakVreme() {
		return this.dolazakVreme;
	}

	public void setDolazakVreme(Date dolazakVreme) {
		this.dolazakVreme = dolazakVreme;
	}

	public byte getNedelja() {
		return this.nedelja;
	}

	public void setNedelja(byte nedelja) {
		this.nedelja = nedelja;
	}

	public int getObrisan() {
		return this.obrisan;
	}

	public void setObrisan(int obrisan) {
		this.obrisan = obrisan;
	}

	public Date getPolazakVreme() {
		return this.polazakVreme;
	}

	public void setPolazakVreme(Date polazakVreme) {
		this.polazakVreme = polazakVreme;
	}

	public byte getRadniDan() {
		return this.radniDan;
	}

	public void setRadniDan(byte radniDan) {
		this.radniDan = radniDan;
	}

	public byte getSubota() {
		return this.subota;
	}

	public void setSubota(byte subota) {
		this.subota = subota;
	}

	public Date getUkupnoVremeVoznje() {
		return this.ukupnoVremeVoznje;
	}

	public void setUkupnoVremeVoznje(Date ukupnoVremeVoznje) {
		this.ukupnoVremeVoznje = ukupnoVremeVoznje;
	}

	public Linija getLinija() {
		return this.linija;
	}

	public void setLinija(Linija linija) {
		this.linija = linija;
	}

}