package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public interface MemberDao {
  
  Member findByEmailPassword(String email, String password)
  throws Exception;
  
    
}
