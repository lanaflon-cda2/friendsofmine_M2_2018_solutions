package friendsofmine.m2.controllers;

import friendsofmine.m2.domain.*;
import friendsofmine.m2.exceptions.InscriptionNotFoundException;
import friendsofmine.m2.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InscriptionController {

    @Autowired
    private ActiviteService activiteService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    InscriptionService inscriptionService;

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/inscription")
    public Inscription addInscription(@RequestParam(value = "utilisateur_id") Long utilisateurId, @RequestParam(value = "activite_id") Long activiteId) {
        Activite activite = activiteService.findActiviteById(activiteId);
        Utilisateur utilisateur = utilisateurService.findUtilisateurById(utilisateurId);
        Inscription inscription = new Inscription(utilisateur, activite);
        return inscriptionService.saveInscription(inscription);
    }

    @GetMapping("api/inscription/{id}")
    public Inscription showInscription(@PathVariable Long id){
        Inscription ins = inscriptionService.findInscriptionById(id);
        if (ins == null)
            throw new InscriptionNotFoundException(id);
        return ins;
    }

    @DeleteMapping(value = "/api/inscription/{id}")
    public void deleteInscription(@PathVariable("id") Long inscriptionId) {
        inscriptionService.deleteInscription(inscriptionId);
    }

    @GetMapping(value = "/api/inscription/search")
    public Page<Inscription> searchInscriptions(@RequestParam(value = "nom_utilisateur",required = false)String nomUtilisateur,
                                                @RequestParam(value = "titre_activite",required = false)String titreActivite,
                                                Pageable pageable) {
        if (nomUtilisateur == null && titreActivite == null)
            return inscriptionService.findAllInscription(pageable);
        return inscriptionService.findAll(nomUtilisateur, titreActivite, pageable);
    }

    public ActiviteService getActiviteService() {
        return activiteService;
    }

    public void setActiviteService(ActiviteService activiteService) {
        this.activiteService = activiteService;
    }

    public UtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    public InscriptionService getInscriptionService() {
        return inscriptionService;
    }

    public void setInscriptionService(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }
}
