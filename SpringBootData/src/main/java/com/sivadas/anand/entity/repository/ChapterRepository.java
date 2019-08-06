package com.sivadas.anand.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivadas.anand.entity.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

}
