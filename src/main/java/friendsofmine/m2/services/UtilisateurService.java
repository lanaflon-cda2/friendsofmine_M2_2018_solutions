package friendsofmine.m2.services;

import friendsofmine.m2.domain.Utilisateur;
import friendsofmine.m2.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository ;

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        if (utilisateur == null)
            throw new IllegalArgumentException();
        return utilisateurRepository.save(utilisateur) ;
    }

    public Utilisateur findUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public long countUtilisateur() {
        return utilisateurRepository.count();
    }

    public ArrayList<Utilisateur> findAllUtilisateurs() {
        Iterable<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        ArrayList<Utilisateur> utilisateurList = convert(utilisateurs);
        utilisateurList.sort(Comparator.comparing(Utilisateur::getNom));
        return utilisateurList;
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }

    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public ArrayList<Utilisateur> findUtilisateursM() {
        Utilisateur homme = new Utilisateur();
        homme.setSexe("M");
        Example<Utilisateur> example = Example.of(homme);

        return convert(utilisateurRepository.findAll(example));
    }

    public ArrayList<Utilisateur> findUtilisateursF() {
        Utilisateur femme = new Utilisateur();
        femme.setSexe("F");
        Example<Utilisateur> example = Example.of(femme);

        return convert(utilisateurRepository.findAll(example));
    }

    // convert from Iterable<Utilisateur> to AraryList<Utilisateur>
    private ArrayList<Utilisateur> convert(Iterable<Utilisateur> utilisateurs) {
        ArrayList<Utilisateur> utilisateurList = new ArrayList<>();
        utilisateurs.forEach(utilisateurList::add);
        return utilisateurList;
    }

}
