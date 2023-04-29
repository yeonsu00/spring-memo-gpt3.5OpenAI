package com.example.memo.service;

import com.example.memo.domain.Memo;
import com.example.memo.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    /**
     * Create Memo
     * @param memo
     */
    public Memo create(Memo memo) {
        return memoRepository.save(memo);
    }

    public Memo findOneMemo(String title) {
        return memoRepository.findByTitle(title);
    }

    public List<Memo> findAllMemo() {
        return memoRepository.findAll();
    }
}
