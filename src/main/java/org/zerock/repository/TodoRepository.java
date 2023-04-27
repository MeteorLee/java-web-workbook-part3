package org.zerock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.domain.Todo;
import org.zerock.repository.search.TodoSearch;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {



}
