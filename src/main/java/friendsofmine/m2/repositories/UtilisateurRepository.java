package friendsofmine.m2.repositories;

import friendsofmine.m2.domain.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>,
        QueryByExampleExecutor<Utilisateur> {

}