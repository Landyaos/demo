package com.utopia.demo.repository.migration;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utopia.demo.entity.view.CommentMigration;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentMigrationRepository extends JpaRepository<CommentMigration, Long> {

}
