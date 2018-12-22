package com.bit.board.admin.service;

import java.util.List;

import com.bit.board.admin.model.BoardListDto;
import com.bit.board.admin.model.BoardTypeDto;
import com.bit.board.admin.model.CategoryDto;

public interface BoardAdminService {

	// ��ü�޴�
	List<BoardListDto> getBoardMenu(); 
			
	// ī�װ� ����� ���� �޼���
	List<CategoryDto> getCategory(); 
	void makeCategory(CategoryDto categoryDto); 
	
	// �Խ��� �����
	List<BoardTypeDto> getBoardType(); //�Խ��� ���� ���ϱ� ����
	void makeBoard(BoardListDto boardListDto); 
}
