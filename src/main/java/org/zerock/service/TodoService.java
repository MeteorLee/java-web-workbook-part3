package org.zerock.service;

import org.zerock.dto.PageRequestDTO;
import org.zerock.dto.PageResponseDTO;
import org.zerock.dto.TodoDTO;

import javax.transaction.Transactional;

@Transactional
public interface TodoService {

    Long register(TodoDTO todoDTO);

    TodoDTO read(Long tno);

    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);
}
