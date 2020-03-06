package com.utopia.demo.repository;

import com.utopia.demo.entity.Comment;
import com.utopia.demo.entity.view.CommentMigration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
