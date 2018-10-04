package friendsofmine.m2.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 256)
    private String titre ;

    private String descriptif ;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Utilisateur responsable ;

    public Activite(String titre, String descriptif, Utilisateur resp) {
        this.titre = titre;
        this.descriptif = descriptif;
        this.responsable = resp;
    }

    public Activite() {

    }

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public Utilisateur getResponsable() {
        return responsable;
    }

    public void setResponsable(Utilisateur responsable) {
        this.responsable = responsable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activite that = (Activite) o;

        if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;
        if (descriptif != null ? !descriptif.equals(that.descriptif) : that.descriptif != null) return false;
        return responsable != null ? responsable.equals(that.responsable) : that.responsable == null;

    }

}

