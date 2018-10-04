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
    private Utilisateur thom, ed, karen, suzy;
    private Activite guitare, muscu, poker, pingpong, jogging,
            procrastination, crossfit, echec, poterie, gym;

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
        guitare = new Activite("Guitare", "Matériel non fourni", thom);
        activiteService.saveActivite(guitare);
    }

    private void initMuscu() {
        muscu = new Activite("Muscu", "Créneau réservé le mardi", ed);
        activiteService.saveActivite(muscu);
    }

    private void initPoker() {
        poker = new Activite("Poker", "Petite blind à 1 euro", karen);
        activiteService.saveActivite(poker);
    }

    private void initPingpong() {
        pingpong = new Activite("Ping Pong", "Matériel non fourni", ed);
        activiteService.saveActivite(pingpong);
    }

    private void initJogging() {
        jogging = new Activite("Jogging", "Tous les midis", ed);
        activiteService.saveActivite(jogging);
    }

    private void initProcrastination() {
        procrastination = new Activite("Procrastination", "Tous les jours", thom);
        activiteService.saveActivite(procrastination);
    }

    private void initCrossfit() {
        crossfit = new Activite("Crossfit", "Animé par John", suzy);
        activiteService.saveActivite(crossfit);
    }

    private void initEchec() {
        echec = new Activite("Echec", "Pas de maériel à amener", ed);
        activiteService.saveActivite(echec);
    }

    private void initPoterie() {
        poterie = new Activite("Poterie", "En salle B07 bis", thom);
        activiteService.saveActivite(poterie);
    }

    private void initGym() {
        gym = new Activite("Gym", "Tous niveaux", karen);
        activiteService.saveActivite(gym);
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
}
