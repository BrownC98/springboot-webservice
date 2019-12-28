package com.kal.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("select p from Posts p order by p.id desc") // springDataJpa 에서 제공하지 않는 메소드는 쿼리작성으로 해결한다.
    List<Posts> findAllDesc();
    // 이처럼 조회같이 복잡한 작업은 별도의 쿼리매퍼를 사용하기도 한다. 마이바티스, querydsl 같은 거
}

