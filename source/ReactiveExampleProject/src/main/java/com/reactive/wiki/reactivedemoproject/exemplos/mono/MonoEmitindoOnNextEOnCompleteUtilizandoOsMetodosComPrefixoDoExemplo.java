package com.reactive.wiki.reactivedemoproject.exemplos.mono;

import com.reactive.wiki.reactivedemoproject.exemplos.ExemploBase;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MonoEmitindoOnNextEOnCompleteUtilizandoOsMetodosComPrefixoDoExemplo extends ExemploBase {

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
                .flatMap(resultadoProcessoVerde -> Mono.just(true))
                .doOnNext(resultadoSubProcessoVerde -> logTesteDeMesa("OnNext do sub processo verde disparado", resultadoSubProcessoVerde, obtemNomeMetodoEmExecucao()))
                .doOnSuccess(resultadoSubProcessoVerde -> logTesteDeMesa("OnComplete do sub processo verde disparado", resultadoSubProcessoVerde, obtemNomeMetodoEmExecucao()))
                .doOnError(erro -> logTesteDeMesa("OnError do sub processo verde disparado", erro, obtemNomeMetodoEmExecucao()));
    }
}
