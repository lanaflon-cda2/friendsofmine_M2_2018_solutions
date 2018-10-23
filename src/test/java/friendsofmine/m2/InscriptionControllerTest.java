package friendsofmine.m2;

import friendsofmine.m2.controllers.InscriptionController;
import friendsofmine.m2.domain.Inscription;
import friendsofmine.m2.services.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class InscriptionControllerTest {

    private InscriptionController inscriptionController;

    @MockBean
    private UtilisateurService utilisateurService;

    @MockBean
    private ActiviteService activiteService;

    @MockBean
    private InscriptionService inscriptionService;

    @Before
    public void setUp() throws Exception {
        inscriptionController = new InscriptionController();
        inscriptionController.setActiviteService(activiteService);
        inscriptionController.setUtilisateurService(utilisateurService);
        inscriptionController.setInscriptionService(inscriptionService);
    }

    @Test
    public void testAddInscription() {
        // when: add request is triggered
        inscriptionController.addInscription(1L,2L);

        // then: several collaborations are triggered
        verify(utilisateurService).findUtilisateurById(1L);
        verify(activiteService).findActiviteById(2L);
        verify(inscriptionService).saveInscription(any(Inscription.class));
    }

    @Test
    public void testRemoveInscription() {
        // when: add request is triggered
        inscriptionController.deleteInscription(1L);

        // then: a delete collaboration is triggered
        verify(inscriptionService).deleteInscription(1L);
    }

}
