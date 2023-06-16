package com.example.memo.service;

import com.example.memo.domain.Memo;
import com.example.memo.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo createMemo(Memo memo) {
        return memoRepository.save(memo);
    }

    public List<Memo> findAllMemo() {
        return memoRepository.findAll();
    }

    public boolean deleteMemo(String memoId) {
        Optional<Memo> deleteMemo = memoRepository.findById(memoId);
        deleteMemo.ifPresent(memoRepository::delete);
        return true;
    }

    public Memo findMemoById(String id) {
        return memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid memo Id:" + id));
    }

    public boolean update(Memo memo) {
        memoRepository.save(memo);
        return true;
    }
}
