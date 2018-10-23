package friendsofmine.m2;

import friendsofmine.m2.domain.Activite;
import friendsofmine.m2.domain.Inscription;
import friendsofmine.m2.domain.Utilisateur;
import friendsofmine.m2.services.ActiviteService;
import friendsofmine.m2.services.InscriptionService;
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
    private InscriptionService inscriptionService;
    private Utilisateur thom, ed, karen, suzy;
    private Activite guitare, muscu, poker, pingpong, jogging,
            procrastination, crossfit, echec, poterie, gym;
    private Inscription thomAuPingPong, thomAuPoker, edAuJogging, karenALaPoterie, karenAuPingPong;

    @Autowired
    public DataLoader(ActiviteService actS, UtilisateurService utilS, InscriptionService insS) {
        activiteService = actS;
        utilisateurService = utilS;
        inscriptionService = insS;
    }

    public void run(ApplicationArguments args) {
        initUtilisateurs();
        initActivites();
        initInscriptions();
    }

    public void initUtilisateurs() {
        initThom();
        initEd();
        initKaren();
        initSuzy();
    }

    private void initThom() {
        thom = new Utilisateur("Yorke", "Ed", "thom@rh.com", "M");
    }

    private void initEd() {
        ed = new Utilisateur("Obrien", "Ed", "ed@rh.com", "M");
    }

    private void initKaren() {
        karen = new Utilisateur("Orzolek", "Karen", "karen@yyy.com", "F");
    }

    private void initSuzy() {
        suzy = new Utilisateur("Lee", "Suzy", "suzy@yyy.com", "F");
    }

    public void initActivites() {
        initGuitare();
        initMuscu();
        initPoker();
        initPingpong();
        initJogging();
        initProcrastination();
        initCrossfit();
        initEchec();
        initPoterie();
        initGym();
    }

    private void initGuitare() {
        guitare = activiteService.saveActivite(new Activite("Guitare", "Matériel non fourni", thom));
    }

    private void initMuscu() {
        muscu = activiteService.saveActivite(new Activite("Muscu", "Créneau réservé le mardi", ed));
    }

    private void initPoker() {
        poker = activiteService.saveActivite(new Activite("Poker", "Petite blind à 1 euro", karen));
    }

    private void initPingpong() {
        pingpong = activiteService.saveActivite(new Activite("Ping Pong", "Matériel non fourni", ed));
    }

    private void initJogging() {
        jogging = activiteService.saveActivite(new Activite("Jogging", "Tous les midis", ed));
    }

    private void initProcrastination() {
        procrastination = activiteService.saveActivite(new Activite("Procrastination", "Tous les jours", thom));
    }

    private void initCrossfit() {
        crossfit = activiteService.saveActivite(new Activite("Crossfit", "Animé par John", suzy));
    }

    private void initEchec() {
        echec = activiteService.saveActivite(new Activite("Echec", "Pas de maériel à amener", ed));
    }

    private void initPoterie() {
        poterie = activiteService.saveActivite(new Activite("Poterie", "En salle B07 bis", thom));
    }

    private void initGym() {
        gym = activiteService.saveActivite(new Activite("Gym", "Tous niveaux", karen));
    }

    public void initInscriptions() {
        initThomAuPingPong();
        initThomAuPoker();
        initEdAuJogging();
        initKarenALaPoterie();
        initKarenAuPingPong();
    }

    private void initThomAuPingPong() {
        thomAuPingPong = inscriptionService.saveInscription(new Inscription(thom, pingpong));
    }

    private void initThomAuPoker() {
        thomAuPoker = inscriptionService.saveInscription(new Inscription(thom, poker));
    }

    private void initEdAuJogging() {
        edAuJogging = inscriptionService.saveInscription(new Inscription(ed, jogging));
    }

    private void initKarenALaPoterie() {
        karenALaPoterie = inscriptionService.saveInscription(new Inscription(karen, poterie));
    }

    private void initKarenAuPingPong() {
        karenAuPingPong = inscriptionService.saveInscription(new Inscription(karen, pingpong));
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

    public Utilisateur getThom() {
        return thom;
    }

    public Utilisateur getEd() {
        return ed;
    }

    public Utilisateur getKaren() {
        return karen;
    }

    public Utilisateur getSuzy() {
        return suzy;
    }

    public Activite getGuitare() {
        return guitare;
    }

    public Activite getMuscu() {
        return muscu;
    }

    public Activite getPoker() {
        return poker;
    }

    public Activite getPingpong() {
        return pingpong;
    }

    public Activite getJogging() {
        return jogging;
    }

    public Activite getProcrastination() {
        return procrastination;
    }

    public Activite getCrossfit() {
        return crossfit;
    }

    public Activite getEchec() {
        return echec;
    }

    public Activite getPoterie() {
        return poterie;
    }

    public Activite getGym() {
        return gym;
    }

    public InscriptionService getInscriptionService() {
        return inscriptionService;
    }

    public Inscription getThomAuPingPong() {
        return thomAuPingPong;
    }

    public Inscription getThomAuPoker() {
        return thomAuPoker;
    }

    public Inscription getEdAuJogging() {
        return edAuJogging;
    }

    public Inscription getKarenALaPoterie() {
        return karenALaPoterie;
    }

    public Inscription getKarenAuPingPong() {
        return karenAuPingPong;
    }
}
