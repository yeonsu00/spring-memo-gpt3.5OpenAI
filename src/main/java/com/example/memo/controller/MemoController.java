package com.example.memo.controller;

import com.example.memo.domain.Memo;
import com.example.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping("/memo/create")
    public boolean createMemo(@RequestBody Map<String, String> memo) {
        String title = memo.get("title");
        String content = memo.get("content");
        LocalDateTime dateTime = LocalDateTime.now(); // 현재 날짜와 시간을 가져옴
        System.out.println(dateTime);
        Memo newMemo = new Memo(title, content, dateTime);
        memoService.createMemo(newMemo);
        return true;
    }

    @PostMapping("/memo/read")
    public List<Memo> readMemo() {
        return memoService.findAllMemo();
//        return "read";
    }

    @PostMapping("/memo/update")
    public boolean updateMemo(@RequestBody Map<String, String> memo) {
        String id = memo.get("id");
        String updateTitle = memo.get("updateTitle");
        String updateContent = memo.get("updateContent");

        // 기존 메모를 가져와서 업데이트
        Memo existingMemo = memoService.findMemoById(id);
        existingMemo.setTitle(updateTitle);
        existingMemo.setContent(updateContent);

        // 업데이트된 메모 저장
        return memoService.update(existingMemo);
    }

    @PostMapping("/memo/delete")
    public boolean deleteMemo(@RequestBody Map<String, String> memo) {
        String memoId = memo.get("memoId");
        return memoService.deleteMemo(memoId);
    }
}
