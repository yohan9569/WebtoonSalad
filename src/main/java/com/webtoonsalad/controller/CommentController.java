package com.webtoonsalad.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webtoonsalad.dto.CommentDTO;
import com.webtoonsalad.service.CommentService;
import com.webtoonsalad.service.LikeCommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private LikeCommentService likecommentService;

	@PostMapping("/write")
	public ResponseEntity<String> writeComment(@RequestParam String content, @RequestParam String userId,
			@RequestParam("webtoonId") String webtoonId) {
		try {
			commentService.writeComment(content, userId, webtoonId);
			return ResponseEntity.ok("Comment added successfully");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to add comment: " + e.getMessage());
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<String> deleteComment(@RequestParam("userId") String userId,
			@RequestParam("webtoonId") String webtoonId) {
		try {
			commentService.deleteComment(userId, webtoonId);
			return ResponseEntity.ok("Comment deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to delete comment: " + e.getMessage());
		}
	}

	@PostMapping("/edit")
	public ResponseEntity<String> editComment(@RequestParam("content") String content,
			@RequestParam("userId") String userId, @RequestParam("webtoonId") String webtoonId) {
		try {
			commentService.editComment(content, userId, webtoonId);
			return ResponseEntity.ok("Comment edited successfully");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to edit comment: " + e.getMessage());
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<CommentDTO>> getCommentList(@RequestParam("userId") String userId,
			@RequestParam("webtoonId") String webtoonId) {
		try {
			System.out.println(userId);
			System.out.println(webtoonId);
			List<CommentDTO> comments = commentService.getCommentList(userId, webtoonId);
	         System.out.println("코멘트들 "+ comments);
	        
			for (CommentDTO comment : comments) {
	            boolean exists = likecommentService.checkCLikeExists(userId, comment.getId());
	            comment.setExists(exists);
	        }
			return ResponseEntity.ok(comments);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/mycomment")
	public ResponseEntity<CommentDTO> getMyComment(@RequestParam("userId") String userId,
			@RequestParam("webtoonId") String webtoonId) {
		try {
			System.out.println(userId);
			System.out.println(webtoonId);
			CommentDTO content = commentService.getMyComment(userId, webtoonId);
	        System.out.println("??????"+content);
//			boolean exists = likecommentService.checkCLikeExists(userId, content.getId());
//	        content.setExists(exists);
//            System.out.println("getMyComment response: " + content);
	        if (content != null) {
	            boolean exists = likecommentService.checkCLikeExists(userId, content.getId());
	            content.setExists(exists);
	            System.out.println("getMyComment response: " + content);
	            return ResponseEntity.ok(content);
	        } else {
	            System.out.println("No comment found for userId: " + userId + " and webtoonId: " + webtoonId);
	            return ResponseEntity.ok(null); // null 응답 반환
	        }
//			return ResponseEntity.ok(content);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}
}
