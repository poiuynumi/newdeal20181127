package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class MariaDBBoardDao implements BoardDao {
  
  SqlSessionFactory sqlSessionFactory;
  public MariaDBBoardDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public List<Board> findAll() throws Exception {
     //객체를 만들어주는 메서드 : Factory메서드
      
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.selectOne("BoardDao.findByNo", no);
      
  
  public int insert(Board board) throws Exception {
    
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      
      return sqlSession.insert("BoardDao.insert", board);
    }
  }
  
  public int update(Board board) throws Exception {
 try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      
      return sqlSession.update("BoardDao.update", board);
    
    }
  }
  
  public int delete(Board board) throws Exception {
   
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
  
      return sqlSession.update("BoardDao.update", board);
   
  }
}
}














