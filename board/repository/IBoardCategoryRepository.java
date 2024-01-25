package com.example.hr.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.hr.board.model.BoardCategoryVO;

@Repository
@Mapper
public interface IBoardCategoryRepository {
	int selectMaxCategoryId();
	List<BoardCategoryVO> selectAllCategory();
	void insertNewCategory(BoardCategoryVO boardCategory);
	void updateCategory(BoardCategoryVO boardCategory);
	void deleteCategory(int categoryId);
}