package com.pmh.ex12.freeboard;

import com.pmh.ex12.common.TokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("freeboards")
@SecurityRequirement(name="Bearer Authentication")
public class FreeBoardController {

    private final FreeBoardService freeBoardService;
    private final TokenManager tokenManager;

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
    public ResponseEntity<String> postFreeBoards(@RequestBody FreeBoardRequestDto freeBoardRequestDto,
                                                 HttpServletRequest request){
        String token = request.getHeader(HttpHeaders.AUTHORIZATION).split(" ")[1];
        Jws<Claims> jws = tokenManager.validateToken(token);
        freeBoardService.saveFreeBaord(freeBoardRequestDto,
                                        jws.getPayload().get("name").toString(),
                                        jws.getPayload().get("email").toString());
        return ResponseEntity.status(HttpStatus.CREATED).body("저장하였습니다.");

    }

    @PutMapping
    public ResponseEntity<String> putFreeBoards(@RequestBody FreeBoardRequestDto freeBoardRequestDto,
                                                HttpServletRequest request){
        String token = request.getHeader(HttpHeaders.AUTHORIZATION).split(" ")[1];
        Jws<Claims> jws = tokenManager.validateToken(token);
        freeBoardService.saveFreeBaord(freeBoardRequestDto,
                            jws.getPayload().get("name").toString(),
                            jws.getPayload().get("email").toString());
        return ResponseEntity.status(HttpStatus.CREATED).body("수정하였습니다.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFreeBoards(@PathVariable(name = "id") Long id){
        freeBoardService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
