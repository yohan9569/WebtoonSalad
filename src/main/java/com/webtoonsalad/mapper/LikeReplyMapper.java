package com.webtoonsalad.mapper;

import java.sql.SQLException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.webtoonsalad.dto.LikeReplyDTO;

@Mapper
public interface LikeReplyMapper {
    int isLiked(@Param("tbl_user_id") String tbl_user_id, @Param("tbl_reply_id") Long tbl_reply_id);
    void addLike(LikeReplyDTO dto) throws SQLException;
    void deleteLike(LikeReplyDTO dto) throws SQLException;
    int getRecommendCount(@Param("tbl_reply_id") Long tbl_reply_id);
}
