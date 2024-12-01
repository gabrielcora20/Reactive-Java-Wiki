package com.reactive.wiki.reactivedemoproject.exemplos.mono;

import com.reactive.wiki.reactivedemoproject.exemplos.ExemploBase;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MonoEmitindoOnNextEOnCompleteComMultiplosOperadoresEmOutrasFuncoesExemplo extends ExemploBase {

    @Override
    public void executa() {
        executaProcessoVerde()
                .subscribe(resultadoProcessoVerde -> logTesteDeMesa("OnNext do processo verde disparado", resultadoProcessoVerde, obtemNomeMetodoEmExecucao()),
                        erro -> logTesteDeMesa("OnError do processo verde disparado", erro, obtemNomeMetodoEmExecucao()),
                        () -> logTesteDeMesa("OnComplete do processo verde disparado", null, obtemNomeMetodoEmExecucao()));
    }

    private Mono<Boolean> executaProcessoVerde() {
        return executaSubProcessoVerde()
                .flatMap(resultadoProcessoVerde -> Mono.just(false));
    }

    private Mono<Boolean> executaSubProcessoVerde(){
        return Mono.just(true)
                .flatMap(resultadoProcessoVerde -> Mono.just(false))
                .flatMap(resultadoProcessoVerde -> Mono.just(true));
    }
}
