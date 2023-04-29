package com.example.memo.controller;

import com.example.memo.domain.Memo;
import com.example.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Controller
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping("/memo/create")
    public String createMemo(@RequestBody Map<String, String> memo) {
        String title = memo.get("title");
        String content = memo.get("content");
        Memo newMemo = new Memo(title, content);
        memoService.create(newMemo);
        return "create";
    }

    @PostMapping("/memo/read")
    public List<Memo> readMemo() {
        return memoService.findAllMemo();
//        return "read";
    }

    @PostMapping("/memo/update")
    public String updateMemo() {

        return "update";
    }

    @PostMapping("/memo/delete")
    public String deleteMemo() {

        return "delete";
    }
}
