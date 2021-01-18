package com.acazia.travelreview.controllers;

import com.acazia.travelreview.models.Comment;
import com.acazia.travelreview.models.CommentReply;
import com.acazia.travelreview.models.TravelPlace;
import com.acazia.travelreview.repository.CommentReplyRepository;
import com.acazia.travelreview.repository.CommentRepository;
import com.acazia.travelreview.repository.TravelPlaceRepository;
import com.acazia.travelreview.security.services.TravelPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	TravelPlaceRepository travelPlaceRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	CommentReplyRepository commentReplyRepository;
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}
	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

	@GetMapping("/travelplaces")
	public List<TravelPlace> getAllTravelPlaces(){
		return travelPlaceRepository.findAll();
	}
	@GetMapping("/comments")
	public List<Comment> getAllComment(){
		return commentRepository.findAll();
	}
	@GetMapping("/commentReplies")
	public List<CommentReply> getAllCommentReply(){
		return commentReplyRepository.findAll();
	}

	// tim kiem theo ten
	@GetMapping("/travelplaces/name/{name}")
	public TravelPlace findByName(@PathVariable("name") String name){
		return travelPlaceRepository.findByName(name);
	}
   //	tao moi

	@PostMapping("/travelplaces")
	public TravelPlace travelPlace(@RequestBody TravelPlace travelPlace) {
		return travelPlaceRepository.save(travelPlace);
	}
	@PostMapping("/comments")
	public Comment comment(@RequestBody Comment comment) {
		return commentRepository.save(comment);
	}
	@PostMapping("/commentReplies")
	public CommentReply commentReply(@RequestBody CommentReply commentReply) {
		return commentReplyRepository.save(commentReply);
	}
}
