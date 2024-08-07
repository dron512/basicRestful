package org.pmh.components;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@RequiredArgsConstructor
public class Car {

    private final Engine engine;

}
