package com.pmh.ex05.user;

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

    public String saveUser(UserReq userReq){
        User user = null;
        if(userReq.getId()==0) {
            user = User.builder()
                    .name(userReq.getName())
                    .email(userReq.getEmail())
                    .build();
        }else{
            user = User.builder()
                    .id(userReq.getId())
                    .name(userReq.getName())
                    .email(userReq.getEmail())
                    .build();
        }

        User dBUser = userRepository.save(user);
        System.out.println(dBUser);
        return "success";
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
