package com.example.memo;

import com.example.memo.repository.MemoRepository;
import com.example.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemoRepository memoRepository;

    @Autowired
    public SpringConfig(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Bean
    public MemoService memoService() {
        return new MemoService(memoRepository);
    }
}
