package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column; import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table( name = "Client") // pour modifier nom de la table 
public class Client implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idClient") // tbadel esm l column
	private Long idClient; // Clé primaire
	private String nom;
	private String prenom;
	private String email;
	private String password;
	@Temporal(TemporalType.DATE) // indiquer que le champs est de type date n'importiw java.utile
	private Date dateNaissance;
	@Enumerated(EnumType.STRING)
	private Role profession;
	@Enumerated(EnumType.STRING)
	private CategorieClient catClient;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="cl")
	private Set<Facture> factures;

	public Client() {
		super();
	}
	public Client(Long idClient, String nom, String prenom, String email, String password, Date dateNaissance) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
	}

	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", dateNaissance=" + dateNaissance + ", profession=" + profession + ", catClient=" + catClient
				+ ", factures=" + factures + "]";
	}
}
