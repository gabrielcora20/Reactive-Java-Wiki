# Mono

![](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/doc-files/marbles/mono.svg)

<p style="text-align:center"> Ilustração do fluxo de vida de uma execução reativa através do Mono </p>

# Demonstração

```Java
import com.reactive.wiki.reactivedemoproject.ExemploBase;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MonoExemplo  extends ExemploBase {

    @Override
    public void executa() {
        Mono.just(executaProcessoVerde())
                .doOnSuccess(resultadoProcessoVerde -> logTesteDeMesa("Resultado do processo verde", resultadoProcessoVerde, obtemNomeMetodoEmExecucao()))
                .doOnError(error -> logTesteDeMesa("Resultado do processo verde", error, obtemNomeMetodoEmExecucao()))
                .subscribe();
    }

    private Mono<Boolean> executaProcessoVerde() {
        return Mono.error(new Exception("Erro no processo verde"));
    }
}
```

# Resultado da execução do exemplo

| Identificador               | Valor                                       |
| --------------------------- | ------------------------------------------- |
| Resultado do processo verde | java.lang.Exception: Erro no processo verde |
