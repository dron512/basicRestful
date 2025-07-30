package com.pmh.ex13.freeboard;

import com.pmh.ex13.error.BizException;
import com.pmh.ex13.error.ErrorCode;
import com.pmh.ex13.user.User;
import com.pmh.ex13.user.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

    @PersistenceContext
    private final EntityManager entityManager;

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
        FreeBoard dbFreeBoard = freeBoardRepository.findById(id).orElseThrow(
                () -> new BizException(ErrorCode.NOT_FOUND, id)
        );

        if (dbFreeBoard.getUser() != null) {
            dbFreeBoard.getUser().getList().remove(dbFreeBoard);
            dbFreeBoard.setUser(null);
        }

        freeBoardRepository.delete(dbFreeBoard);
    }
}
