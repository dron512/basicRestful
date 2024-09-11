package com.pmh.ex06.util;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //Todo JWT 작성자 들어가야함
        return Optional.of("박명회");
    }
}