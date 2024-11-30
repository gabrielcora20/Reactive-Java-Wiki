package com.reactive.wiki.reactivedemoproject.exemplos.mono;

import com.reactive.wiki.reactivedemoproject.ExemploBase;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MonoExemplo  extends ExemploBase {

    @Override
    public void executa() {
        Boolean entradaProcessoVerde = true;

        executaProcessoVerde()
                .doOnSuccess(resultadoProcessoVerde -> logTesteDeMesa("Resultado do processo verde", resultadoProcessoVerde, obtemNomeMetodoEmExecucao()))
                .doOnError(error -> logTesteDeMesa("Resultado do processo verde", error, obtemNomeMetodoEmExecucao()))
                .subscribe();
    }

    private Mono<Boolean> executaProcessoVerde() {
        return Mono.error(new Exception("Erro no processo verde"));
    }
}
