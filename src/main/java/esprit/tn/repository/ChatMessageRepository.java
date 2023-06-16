package esprit.tn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esprit.tn.entity.ChatMessage;



@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

}
