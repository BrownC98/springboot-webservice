package com.kal.book.springboot.web;

import com.kal.book.springboot.service.PostService;
import com.kal.book.springboot.web.dto.PostSaveRequestDto;
import com.kal.book.springboot.web.dto.PostsResponseDto;
import com.kal.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // bean 주입용
@RestController
public class PostApiController { // 기능 실행용 컨트롤러

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto postSaveRequestDto){
        return postService.save(postSaveRequestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }
    
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postService.delete(id);
        return id;
    }
}
