package com.pmh.ex09.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Tag(name = "UserController",description = "사용자 조회 추가 등록 삭제 등을 할 수 있습니다.")
@SecurityRequirement(name="Bearer Authentication")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("selectall")
    @Operation(summary = "사용자 정보 리스트를 가지고 올 수 있습니다.")
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
        }
    }

    @PostMapping("insert")
    @Operation(summary = "사용자 추가 할 수 있습니다.")
    public ResponseEntity<String> insert(@Valid @RequestBody UserRequestDto userRequestDto){
        userService.saveUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("저장하였습니다.");
    }

    @PutMapping("update")
    @Operation(summary = "사용자 수정 할 수 있습니다.")
    public ResponseEntity<UserResponseDto> update(@Valid @RequestBody UserRequestDto userRequestDto){
        User dbUser = userService.saveUser(userRequestDto);
        UserResponseDto userResponseDto = modelMapper.map(dbUser,UserResponseDto.class);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "사용자 삭제 할 수 있습니다.")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
