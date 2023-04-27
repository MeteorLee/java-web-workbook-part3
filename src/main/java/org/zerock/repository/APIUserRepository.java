package org.zerock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.domain.APIUser;

public interface APIUserRepository extends JpaRepository<APIUser, String> {


}
