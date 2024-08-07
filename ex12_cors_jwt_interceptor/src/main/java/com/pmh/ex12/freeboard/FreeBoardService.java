package com.pmh.ex12.freeboard;

import com.pmh.ex12.error.BizException;
import com.pmh.ex12.error.ErrorCode;
import com.pmh.ex12.user.User;
import com.pmh.ex12.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<FreeBoard> findAll() {
        List<FreeBoard> list = freeBoardRepository.findAll();
        return list;
    }

    public FreeBoard findById(long id) {
        FreeBoard freeBoard = freeBoardRepository.findById(id).orElseThrow(()-> new BizException(ErrorCode.NOT_FOUND,id));
        return freeBoard;
    }

    public void saveFreeBaord(FreeBoardRequestDto freeBoardRequestDto,String name,String email) {
        User user = userRepository.findByNameAndEmail(name,email).orElseThrow(() -> new BizException(ErrorCode.INCORRECT_NAME_AND_EMAIL));
        if(freeBoardRequestDto.getId() == null ){
            FreeBoard freeBoard = modelMapper.map(freeBoardRequestDto,FreeBoard.class);
            freeBoard.setUser(user);
            freeBoardRepository.save(freeBoard);
        }
        else{
            freeBoardRepository.findById(freeBoardRequestDto.getId()).orElseThrow(
                    ()->new BizException(ErrorCode.NOT_FOUND, freeBoardRequestDto.getId())
            );
            FreeBoard freeBoard = modelMapper.map(freeBoardRequestDto, FreeBoard.class);
            freeBoard.setUser(user);
            freeBoardRepository.save(freeBoard);
        }
    }

    public void deleteById(Long id) {
        freeBoardRepository.findById(id).orElseThrow(
                ()->new BizException(ErrorCode.NOT_FOUND, id)
        );
        freeBoardRepository.deleteById(id);
    }
}
