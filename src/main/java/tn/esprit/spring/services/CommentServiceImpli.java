package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.repository.CommentRepository;
@Service
public class CommentServiceImpli implements ICommentService {
@Autowired 
CommentRepository commentRepository; 


	@Override
	public List<Comment> retrieveAllComment() {
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public Comment addComment(Comment S) {
 return commentRepository.save(S);
	}

	@Override
	public void deleteComment(int id) {
		commentRepository.deleteById(id);		
	}

	@Override
	public Comment updateComment(Comment S) {
		return 	commentRepository.save(S);
	}

	@Override
	public Comment retrieveComment(int id) {
			return commentRepository.findById(id).orElse(null);
	}
	
	
}

