package com.pgm.backend1.controller;

import com.pgm.backend1.domain.Board;
import com.pgm.backend1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/register")
    public void register() {
    }
    @PostMapping("/register")
    public String registerPost(Board board, Model model){
        boardService.insert(board);
        return "redirect:/board/list";
    }
    @GetMapping("/list")
    public void list(Model model)
    {model.addAttribute("boards", boardService.list()); //게시글 목록을 보여주는 메서드

    }
    @GetMapping("/read/{id}")
    public String read(@PathVariable("id") Long id, Model model){ // {id}붙이면 read, modify 따로 만들어야 하고
                                                                    //void->String으로 바꿔야함. @PathVariable 붙여야함

        model.addAttribute("board",boardService.findById(id));
        return "/board/read";
    }
    @GetMapping("/modify/{id}")
    public String modify(@PathVariable("id") Long id, Model model){ //게시글을 읽는 메서드

        model.addAttribute("board",boardService.findById(id));
        return "/board/modify";
    }
    @PostMapping("/modify")
    public String modifyPost(Board board, Model model){
        boardService.update(board);
        return "redirect:/board/read/"+board.getId();
    }
    @GetMapping("/remove")
    public String remove(Long id){
        boardService.delete(id);
        return "redirect:/board/list";
    }
}
