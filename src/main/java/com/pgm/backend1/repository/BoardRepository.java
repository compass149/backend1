package com.pgm.backend1.repository;

import com.pgm.backend1.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}