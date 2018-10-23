package friendsofmine.m2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull @Size(min = 1)
    private String nom ;

    @NotNull @Size(min = 1)
    private String prenom ;

    @NotNull @Email
    private String email ;

    @NotNull @Pattern(regexp = "^[MF]{1}$")
    private String sexe;

    @OneToMany(mappedBy = "responsable") @JsonIgnore
    private Collection<Activite> activites = new ArrayList<Activite>();

    public Utilisateur(String unNom, String unPrenom, String unEmail,
                       String unSexe) {
        nom = unNom;
        prenom = unPrenom;
        email = unEmail;
        sexe = unSexe;
    }

    public Utilisateur() {

    }

    public Long getId() {
        return id;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Collection<Activite> getActivites() {
        return activites;
    }

    public void setActivites(Collection<Activite> activites) {
        this.activites = activites;
    }

    public void addActivite(Activite activite) {
        if (!activites.contains(activite))
            activites.add(activite);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return sexe != null ? sexe.equals(that.sexe) : that.sexe == null;
    }
}

