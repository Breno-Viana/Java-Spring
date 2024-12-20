package com.relacionamento02.relacionamento_entidade02.repository;

import com.relacionamento02.relacionamento_entidade02.model.Commentaries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaryRepository extends JpaRepository<Commentaries, Long> {
}
