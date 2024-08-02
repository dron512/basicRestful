package com.pmh.ex04.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @GetMapping("selectall")
    public ResponseEntity<List<User>> selectall(){
        List<User> list = userService.findAll();
        if(list != null && !list.isEmpty())
            return ResponseEntity.ok(list);
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("select/{id}")
    public ResponseEntity<User> select(@PathVariable Long id){
        User user = userService.findById(id);
        if(user!=null)
            return ResponseEntity.ok(user);
        else {
            return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).;
        }
    }

    @PostMapping("insert")
    public ResponseEntity<String> insert(@Valid @RequestBody UserRequestDto userRequestDto){
        userService.saveUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("저장하였습니다.");
    }

    @PutMapping("update")
    public ResponseEntity<User> update(@Valid @RequestBody UserRequestDto userRequestDto){
        User dbUser = userService.saveUser(userRequestDto);
        return ResponseEntity.ok(dbUser);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
