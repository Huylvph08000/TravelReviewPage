package com.acazia.travelreview.repository;

import com.acazia.travelreview.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
