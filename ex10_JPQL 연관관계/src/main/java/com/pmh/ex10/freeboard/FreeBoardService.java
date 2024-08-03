package com.pmh.ex10.freeboard;

import com.pmh.ex10.error.BizException;
import com.pmh.ex10.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;
    private final ModelMapper modelMapper;

    public List<FreeBoard> findAll() {
        List<FreeBoard> list = freeBoardRepository.findAll();
        return list;
    }

    public FreeBoard findById(long id) {
        FreeBoard freeBoard = freeBoardRepository.findById(id).orElseThrow(()-> new BizException(ErrorCode.NOT_FOUND,id));
        return freeBoard;
    }

    public void saveFreeBaord(FreeBoardRequestDto freeBoardRequestDto) {
        if(freeBoardRequestDto.getId() == null ){
            FreeBoard freeBoard = modelMapper.map(freeBoardRequestDto,FreeBoard.class);
            freeBoardRepository.save(freeBoard);
        }
        else{
            freeBoardRepository.findById(freeBoardRequestDto.getId()).orElseThrow(
                    ()->new BizException(ErrorCode.NOT_FOUND, freeBoardRequestDto.getId())
            );
            FreeBoard freeBoard = modelMapper.map(freeBoardRequestDto, FreeBoard.class);
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
