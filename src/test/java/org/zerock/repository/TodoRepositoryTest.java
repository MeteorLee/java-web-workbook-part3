package org.zerock.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.zerock.domain.Todo;
import org.zerock.dto.PageRequestDTO;
import org.zerock.dto.TodoDTO;

import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {

            Todo todo = Todo.builder()
                    .title("Todo..." + i)
                    .dueDate(LocalDate.of(2023, (i % 12) + 1, (i % 30) + 1))
                    .writer("user" + (i % 10))
                    .completed(false)
                    .build();

            todoRepository.save(todo);

        });
    }

    @Test
    void testSearch() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .from(LocalDate.of(2023, 10, 01))
                .to(LocalDate.of(2023, 12, 31))
                .build();

        Page<TodoDTO> result = todoRepository.list(pageRequestDTO);

        result.forEach(todoDTO -> log.info(todoDTO));
    }

}