package com.webtoonsalad.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webtoonsalad.service.LikeCommentService;

@RestController
@RequestMapping("comments/likes")
public class LikeCommentController {

	@Autowired
	private LikeCommentService likeCommentService;

	@GetMapping("/count")
	public ResponseEntity<Integer> getLikeCount(@RequestParam int commentId) {
		try {
			Integer count = likeCommentService.getCLikeCount(commentId);
			return ResponseEntity.ok(count);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
		}
	}

	@PostMapping("/toggle")
	public ResponseEntity<Map<String, String>> toggleLike(@RequestParam String userId, @RequestParam int commentId) {
		Map<String, String> response = new HashMap<>();
		try {
			boolean exists = likeCommentService.checkCLikeExists(userId, commentId);
			if (exists) {
				likeCommentService.deleteCLike(userId, commentId);
				response.put("message", "좋아요 삭제");
				response.put("status", "unliked");
			} else {
				likeCommentService.insertCLike(userId, commentId);
				response.put("message", "좋아요 추가");
				response.put("status", "liked");
			}
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("message", "Failed to toggle like: " + e.getMessage());
			response.put("status", "error");
			return ResponseEntity.status(500).body(response);
		}
	}

}
