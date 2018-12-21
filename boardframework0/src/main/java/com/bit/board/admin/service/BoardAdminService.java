package com.bit.board.admin.service;

import java.util.List;

import com.bit.board.admin.model.BoardListDto;
import com.bit.board.admin.model.BoardTypeDto;
import com.bit.board.admin.model.CategoryDto;

public interface BoardAdminService {

	// 전체메뉴
	List<BoardListDto> getBoardMenu(); 
			
	// 카테고리 만들기 위한 메서드
	List<CategoryDto> getCategory(); 
	void makeCategory(CategoryDto categoryDto); 
	
	// 게시판 만들기
	List<BoardTypeDto> getBoardType(); //게시판 형식 정하기 위함
	void makeBoard(BoardListDto boardListDto); 
}
