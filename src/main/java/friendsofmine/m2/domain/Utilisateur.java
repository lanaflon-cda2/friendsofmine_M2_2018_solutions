package friendsofmine.m2.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
}

