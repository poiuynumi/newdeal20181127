package com.eomcs.lms.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;

@Component
public class MariaDBLessonDao implements LessonDao {
  SqlSessionFactory sqlSessionFactory;

}
