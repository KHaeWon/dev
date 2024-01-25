package com.example.hr.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.hr.board.model.BoardUploadFileVO;
import com.example.hr.board.model.BoardVO;

@Repository
@Mapper
public interface IBoardRepository {

	int selectMaxArticleNo();
	int selectMaxFileId();
	
//	void insertArticle(BoardVO board);
//	void insertFileData(BoardUploadFileVO file);
//	
//	List<BoardVO> selectArticleListByCategory(@Param("categoryId") int categoryId, @Param("start") int start, @Param("end") int end);
//	
//	BoardVO selectArticle(int boardId);
//	BoardUploadFileVO getFile(int fileId);
//		
//	void updateReadCount(int boardId);
//
//	void updateReplyNumber(@Param("masterId") int masterId, @Param("replyNumber") int replyNumber);
//	void replyArticle(BoardVO boardId);
//	
//	String getPassword(int boardId);
//	
//	void updateArticle(BoardVO board);
//	void updateFileData(BoardUploadFileVO file);
//	
//	void deleteFileData(int boardId);
//	void deleteReplyFileData(int boardId);
//	BoardVO selectDeleteArticle(int boardId);
//	void deleteArticleByBoardId(int boardId);
//	void deleteArticleByMasterId(int boardId);
//	
//	int selectTotalArticleCount();
//	int selectTotalArticleCountByCategoryId(int categoryId);
//
//	int selectTotalArticleCountByKeyword(String keyword);
//	List<BoardVO> searchListByContentKeyword(@Param("keyword") String keyword, @Param("start") int start, @Param("end") int end);
//	
}
