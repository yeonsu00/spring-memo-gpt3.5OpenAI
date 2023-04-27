package com.example.memo.service;

import com.example.memo.domain.Memo;
import com.example.memo.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
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

}
