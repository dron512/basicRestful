package org.pmh.components;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AABBService {

    private final AA aa;
    private final BB bb;

//    public AABBService(AA aa, BB bb) {
//        this.aa = aa;
//        this.bb = bb;
//    }

    public void doPrint(){
        aa.doPrint();
        bb.doPrint();
    }
}
