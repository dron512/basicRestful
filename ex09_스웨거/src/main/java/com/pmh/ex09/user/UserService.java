package com.pmh.ex09.user;

import com.pmh.ex09.error.BizException;
import com.pmh.ex09.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(long id){
        return userRepository.findById(id).orElse(null);
    }


    public User saveUser(UserRequestDto userRequestDto){
        User user = null;
        User dbUser = null;
        if(userRequestDto.getId()==0) {
            user = User.builder()
                    .name(userRequestDto.getName())
                    .email(userRequestDto.getEmail())
                    .build();
            dbUser = userRepository.save(user);
        }else{
            dbUser = userRepository.findById(userRequestDto.getId()).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND, userRequestDto.getId()));
            dbUser.setEmail(userRequestDto.getEmail());
            dbUser.setName(userRequestDto.getName());
            dbUser = userRepository.save(dbUser);
        }
        return dbUser;
    }

    public void deleteUser(Long id) {
        User dbUser = userRepository.findById(id).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND, id));
        userRepository.delete(dbUser);
    }
}