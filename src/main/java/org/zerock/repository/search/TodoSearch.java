package org.zerock.repository.search;

import org.springframework.data.domain.Page;
import org.zerock.dto.PageRequestDTO;
import org.zerock.dto.TodoDTO;

public interface TodoSearch {

    Page<TodoDTO> list(PageRequestDTO pageRequestDTO);
}
