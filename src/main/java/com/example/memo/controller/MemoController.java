package com.example.memo.controller;

import com.example.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/memo/create")
    public String createMemo() {

        return "create";
    }

    @GetMapping("/memo/read")
    public String readMemo() {

        return "read";
    }

    @GetMapping("/memo/update")
    public String updateMemo() {

        return "update";
    }

    @GetMapping("/memo/delete")
    public String deleteMemo() {

        return "delete";
    }
}
