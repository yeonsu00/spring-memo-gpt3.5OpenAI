package com.example.memo.service;

import com.example.memo.domain.Memo;
import com.example.memo.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional //test 끝나면 rollback
public class MemoServiceTest {

    @Mock
    private MemoRepository memoRepository;

    @InjectMocks
    private MemoService memoService;

    @Test
    public void testCreateMemo() {
        // Create a sample Memo object
        Memo memo = new Memo();
        memo.setTitle("Test Memo");
        memo.setContent("This is a test memo");

        // Mock the save method of the memoRepository
        when(memoRepository.save(memo)).thenReturn(memo);

        // Call the create method of the memoService
        Memo createdMemo = memoService.create(memo);

        // Assert that the createdMemo object is not null
        assertEquals(memo, createdMemo);
    }

    @Test
    public void testFindAllMemo() {
        List<Memo> memoList = new ArrayList<>();
        memoList.add(new Memo("Test Memo 1", "Test content 1"));
        memoList.add(new Memo("Test Memo 2", "Test content 2"));
        memoList.add(new Memo("Test Memo 3", "Test content 3"));
        Mockito.when(memoRepository.findAll()).thenReturn(memoList);
        List<Memo> result = memoService.findAllMemo();
        assertEquals(3, result.size());
        assertEquals("Test Memo 1", result.get(0).getTitle());
        assertEquals("Test content 2", result.get(1).getContent());
        assertEquals("Test Memo 3", result.get(2).getTitle());
    }

}
