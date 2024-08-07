package com.pmh.ex11.freeboard;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("freeboards")
public class FreeBoardController {

    private final FreeBoardService freeBoardService;

    @GetMapping
    public ResponseEntity<List<FreeBoard>> getFreeBoards(){
        List<FreeBoard> list = freeBoardService.findAll();

        if(list.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<FreeBoard> getFreeBoard(@PathVariable(name = "id") Long id){
        FreeBoard freeBoard = freeBoardService.findById(id);
        return ResponseEntity.ok(freeBoard);
    }

    @PostMapping
    public ResponseEntity<String> postFreeBoards(@RequestBody FreeBoardRequestDto freeBoardRequestDto){
        freeBoardService.saveFreeBaord(freeBoardRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("저장하였습니다.");

    }

    @PutMapping
    public ResponseEntity<String> putFreeBoards(@RequestBody FreeBoardRequestDto freeBoardRequestDto){
        freeBoardService.saveFreeBaord(freeBoardRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("수정하였습니다.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFreeBoards(@PathVariable(name = "id") Long id){
        freeBoardService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
