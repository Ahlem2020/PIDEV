
package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Chat;
@Repository
public interface ChatRepository extends CrudRepository<Chat, Integer> {

}
