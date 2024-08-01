package org.pmh.components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
@ToString
@Component
public class Engine {

    private final String type="V8";

}
