package tn.esprit.spring.DAO.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "Stock") 
public class Stock {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private long idStock;
	private Integer qteStock;
	private Integer qteMin;
	private String libelleStock;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private Set<Produit> produits;


	public Stock() {
		super();
	}
	public Stock(long idStock, Integer qteStock, Integer qteMin, String libelleStock) {
		super();
		this.idStock = idStock;
		this.qteStock = qteStock;
		this.qteMin = qteMin;
		this.libelleStock = libelleStock;
	}
	public long getIdStock() {
		return idStock;
	}
	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}
	public Integer getQteStock() {
		return qteStock;
	}
	public void setQteStock(Integer qteStock) {
		this.qteStock = qteStock;
	}
	public Integer getQteMin() {
		return qteMin;
	}
	public void setQteMin(Integer qteMin) {
		this.qteMin = qteMin;
	}
	public String getLibelleStock() {
		return libelleStock;
	}
	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}


}
