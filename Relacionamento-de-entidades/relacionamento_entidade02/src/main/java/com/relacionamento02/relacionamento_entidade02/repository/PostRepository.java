package com.relacionamento02.relacionamento_entidade02.repository;

import com.relacionamento02.relacionamento_entidade02.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {
}
