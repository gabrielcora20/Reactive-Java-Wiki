package com.reactive.wiki.reactivedemoproject.exemplos.mono;

import com.reactive.wiki.reactivedemoproject.exemplos.ExemploBase;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MonoSemSubscribeExemplo extends ExemploBase {

    @Override
    public void executa() {
        executaProcessoVerde();
    }

    private Mono<Boolean> executaProcessoVerde() {
        return Mono.just(true);
    }
}
