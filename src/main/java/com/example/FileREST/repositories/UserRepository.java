package com.example.FileREST.repositories;

import com.example.FileREST.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
