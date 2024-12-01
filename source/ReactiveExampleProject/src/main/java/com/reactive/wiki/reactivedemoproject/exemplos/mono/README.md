# Mono

![](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/doc-files/marbles/mono.svg)

<p style="text-align:center"> Ilustração do fluxo de vida de uma execução reativa através do Mono </p>

## Demonstração

### Mono disparando o sinal `OnNext` e `OnComplete`

#### Código fonte:

```Java
public class MonoEmitindoOnNextEOnCompleteExemplo extends ExemploBase {

    @Override
    public void executa() {
        executaProcessoVerde()
                .subscribe(resultadoProcessoVerde -> logTesteDeMesa("OnNext do processo verde disparado", resultadoProcessoVerde, obtemNomeMetodoEmExecucao()),
                        erro -> logTesteDeMesa("OnError do processo verde disparado", erro, obtemNomeMetodoEmExecucao()),
                        () -> logTesteDeMesa("OnComplete do processo verde disparado", null, obtemNomeMetodoEmExecucao()));
    }

    private Mono<Boolean> executaProcessoVerde() {
        return Mono.just(true);
    }
}
```

### Mono disparando o sinal `OnError`

#### Código fonte:

```Java
public class MonoEmitindoOnErrorExemplo extends ExemploBase {

    @Override
    public void executa() {
        executaProcessoVerde()
                .subscribe(resultadoProcessoVerde -> logTesteDeMesa("OnNext do processo verde disparado", resultadoProcessoVerde, obtemNomeMetodoEmExecucao()),
                        erro -> logTesteDeMesa("OnError do processo verde disparado", erro, obtemNomeMetodoEmExecucao()),
                        () -> logTesteDeMesa("OnComplete do processo verde disparado", null, obtemNomeMetodoEmExecucao()));
    }

    private Mono<Boolean> executaProcessoVerde() {
        return Mono.error(new Exception("Erro no processo verde"));
    }
}
```

### Mono sem subscribe

#### Código fonte:

```Java
public class MonoSemSubscribeExemplo extends ExemploBase {

    @Override
    public void executa() {
        executaProcessoVerde();
    }

    private Mono<Boolean> executaProcessoVerde() {
        return Mono.just(true);
    }
}
```

### Mono disparando o sinal `OnNext` e `OnComplete` utilizando múltiplos operadores

#### Código fonte:

```Java
public class MonoEmitindoOnNextEOnCompleteComMultiplosOperadoresExemplo extends ExemploBase {

    @Override
    public void executa() {
        executaProcessoVerde()
                .subscribe(resultadoProcessoVerde -> logTesteDeMesa("OnNext do processo verde disparado", resultadoProcessoVerde, obtemNomeMetodoEmExecucao()),
                        erro -> logTesteDeMesa("OnError do processo verde disparado", erro, obtemNomeMetodoEmExecucao()),
                        () -> logTesteDeMesa("OnComplete do processo verde disparado", null, obtemNomeMetodoEmExecucao()));
    }

    private Mono<Boolean> executaProcessoVerde() {
        return Mono.just(true)
                .flatMap(resultadoProcessoVerde -> Mono.just(false))
                .flatMap(resultadoProcessoVerde -> Mono.just(true));
    }
}
```
