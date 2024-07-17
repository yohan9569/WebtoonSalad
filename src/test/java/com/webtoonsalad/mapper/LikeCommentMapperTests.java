package com.webtoonsalad.mapper;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LikeCommentMapperTests {
	
	@Autowired
    private LikeCommentMapper mapper;
	
	@Test
    public void getCLikeCount() throws SQLException {
		int commentId = 45;
		int likeCount = mapper.getCLikeCount(commentId);
		log.info(likeCount);
	}

	@Test
    public void insertCLike() throws SQLException {
		String userId = "test2";
		int commentId = 45;
        mapper.insertCLike(userId, commentId);
        log.info("좋아요 삽입 성공");
	
    }
	
	@Test
    public void deleteCLike() throws SQLException {
		String userId = "test4";
		int commentId = 5;
        mapper.deleteCLike(userId, commentId);
        log.info("좋아요 삭제 성공");
    }
	
	@Test
    public void checkCLikeExists() throws SQLException {
		String userId = "test2";
		int commentId = 45;
		boolean likeExists = mapper.checkCLikeExists(userId, commentId);
	    
	    // 결과 로그 출력
	    if (likeExists) {
	        log.info("좋아요 있음");
	    } else {
	        log.info("좋아요 없음");
	    }
    }

}
