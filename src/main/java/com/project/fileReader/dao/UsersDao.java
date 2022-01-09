package com.project.fileReader.dao;

import com.project.fileReader.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users,Integer> {

}
