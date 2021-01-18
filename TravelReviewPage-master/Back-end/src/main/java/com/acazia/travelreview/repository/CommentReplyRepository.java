package com.acazia.travelreview.repository;

import com.acazia.travelreview.models.CommentReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentReplyRepository extends JpaRepository<CommentReply, Long> {
}
