package org.example.ch04.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.ch04.dto.User3DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface User3DAO {

    public void insert(User3DTO dto);
    public User3DTO select(String userid);
    public List<User3DTO> selectAll() ;
    public void update(User3DTO dto);
    public void delete(String userid);
}
