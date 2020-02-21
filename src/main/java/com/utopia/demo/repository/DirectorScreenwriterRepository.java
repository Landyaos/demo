package com.utopia.demo.repository;

import com.utopia.demo.entity.DirectorScreenwriter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorScreenwriterRepository extends JpaRepository<DirectorScreenwriter, Long> {

    DirectorScreenwriter findById(long id);

}
