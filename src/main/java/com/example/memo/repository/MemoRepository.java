package com.example.memo.repository;

import com.example.memo.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemoRepository extends JpaRepository<Memo, String> {
    Memo findByTitle(String title);
    Optional<Memo> findByMemoId(Long memoId);
}
