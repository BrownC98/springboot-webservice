package com.kal.book.springboot.web;

import com.kal.book.springboot.service.PostService;
import com.kal.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController { // 화면뿌리기용 컨트롤러

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model){
        // model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음
        // 여기서는 postService.findAllDesc() 로 가져온 결과를 posts 란 이름의 model 에 담아 index.mustache 에 전달한다.
        model.addAttribute("posts", postService.findAllDesc());

                                                        //.mustache
        return "index"; // 머스테치 스타터 덕분에 앞의 경로와 파일확장자는 자동으로 지정된다.
    }                               //src/main/resources/templates  // return 값은 view resolver 가 처리한다.

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}") // 화면만 띄우는 것이라 get 이 맞다
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }


}
