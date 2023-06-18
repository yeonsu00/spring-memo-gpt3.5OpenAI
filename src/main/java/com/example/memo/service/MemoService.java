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

    public String deleteMemo(Long memoId) {
        try {
            Optional<Memo> deleteMemo = memoRepository.findByMemoId(memoId);
            deleteMemo.ifPresent(memoRepository::delete);
            return "delete";
        } catch (Exception e) {
            e.printStackTrace();
            return "delete 오류 메시지: " + e.getMessage();
        }
    }

    public Memo findMemoById(Long memoId) {
        return memoRepository.findByMemoId(memoId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid memo Id:" + memoId));
    }

    public String update(Memo memo) {
        try {
            memoRepository.save(memo);
            return "update";
        } catch (Exception e) {
            e.printStackTrace();
            return "update 오류 메시지: " + e.getMessage();
        }
    }
}
