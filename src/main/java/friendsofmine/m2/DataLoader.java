package friendsofmine.m2;

import friendsofmine.m2.domain.Activite;
import friendsofmine.m2.domain.Utilisateur;
import friendsofmine.m2.services.ActiviteService;
import friendsofmine.m2.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DataLoader implements ApplicationRunner {

    private ActiviteService activiteService;
    private UtilisateurService utilisateurService;
    private Utilisateur thom, ed, karen;
    private Activite guitare, muscu, poker, pingpong, jogging;

    @Autowired
    public DataLoader(ActiviteService actS, UtilisateurService utilS) {
        activiteService = actS;
        utilisateurService = utilS;
    }

    public void run(ApplicationArguments args) {
        initUtilisateurs();
        initActivites();
    }

    public void initUtilisateurs() {
        initThom();
        initEd();
        initKaren();
    }

    private void initThom() {
        thom = new Utilisateur("Yorke", "Ed", "thom@rh.com", "M");
        utilisateurService.saveUtilisateur(thom);
    }

    private void initEd() {
        ed = new Utilisateur("Obrien", "Ed", "ed@rh.com", "M");
        utilisateurService.saveUtilisateur(ed);
    }

    private void initKaren() {
        karen = new Utilisateur("Orzolek ", "Karen", "karen@yyy.com", "F");
        utilisateurService.saveUtilisateur(karen);
    }

    public void initActivites() {
        initGuitare();
        initMuscu();
        initPoker();
        initPingpong();
        initJogging();
    }

    private void initGuitare() {
        guitare = new Activite("Guitare", "Matériel non fourni");
        activiteService.saveActivite(guitare);
    }

    private void initMuscu() {
        muscu = new Activite("Muscu", "Créneau réservé le mardi");
        activiteService.saveActivite(muscu);
    }

    private void initPoker() {
        poker = new Activite("Poker", "Petite blind à 1 euro");
        activiteService.saveActivite(poker);
    }

    private void initPingpong() {
        pingpong = new Activite("Ping Pong", "Matériel non fourni");
        activiteService.saveActivite(pingpong);
    }

    private void initJogging() {
        jogging = new Activite("Jogging", "Tous les midis");
        activiteService.saveActivite(jogging);
    }

}
