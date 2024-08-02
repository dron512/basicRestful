package com.pmh.ex04.user;

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
        if(userRequestDto.getId()==0) {
            user = User.builder()
                    .name(userRequestDto.getName())
                    .email(userRequestDto.getEmail())
                    .build();
        }else{
            user = User.builder()
                    .id(userRequestDto.getId())
                    .name(userRequestDto.getName())
                    .email(userRequestDto.getEmail())
                    .build();
        }
        User dBUser = userRepository.save(user);
        return dBUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
