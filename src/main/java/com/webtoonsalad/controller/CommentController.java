package com.webtoonsalad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webtoonsalad.dto.CommentDTO;
import com.webtoonsalad.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/write")
    public ResponseEntity<String> writeComment(@RequestParam String content, @RequestParam("userId") String userId, 
                                               @RequestParam String webtoonId) {
        try {
//        	String userId = "test2"; 
            commentService.writeComment(content, userId, webtoonId);
            return ResponseEntity.ok("Comment added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to add comment: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteComment(@RequestParam("userId") String userId, @RequestParam String webtoonId) {
        try {
//        	String userId = "test2";
            commentService.deleteComment(userId, webtoonId);
            return ResponseEntity.ok("Comment deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to delete comment: " + e.getMessage());
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editComment(@RequestParam String content, @RequestParam("userId") String userId,
                                              @RequestParam String webtoonId) {
        try {
//        	String userId = "test2";
            commentService.editComment(content, userId, webtoonId);
            return ResponseEntity.ok("Comment edited successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to edit comment: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CommentDTO>> getCommentList(@RequestParam("userId") String userId, @RequestParam String webtoonId) {
        try {
//        	String userId = "test2";
            List<CommentDTO> comments = commentService.getCommentList(userId, webtoonId);
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/mycomment")
    public ResponseEntity<CommentDTO> getMyComment(@RequestParam("userId") String userId, @RequestParam String webtoonId) {
        try {
//        	String userId = "test2";
            CommentDTO content = commentService.getMyComment(userId, webtoonId);
            return ResponseEntity.ok(content);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
