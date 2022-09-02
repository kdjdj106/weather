package zerobase.weather;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JpaMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {
    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo memo = new Memo(10, "this is jpa memo");
        //when
        jpaMemoRepository.save(memo);
        //then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findById() {
        //given
        Memo memo = new Memo(11, "jpa");
        //when
        Memo memo1 = jpaMemoRepository.save(memo);
        System.out.println(memo1.getId());
        //then
        Optional<Memo> optionalMemo = jpaMemoRepository.findById(memo1.getId());
        assertEquals(optionalMemo.get().getText(), "jpa");
    }
}
