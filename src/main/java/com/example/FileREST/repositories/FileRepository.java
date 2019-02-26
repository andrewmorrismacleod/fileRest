package com.example.FileREST.repositories;

import com.example.FileREST.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
