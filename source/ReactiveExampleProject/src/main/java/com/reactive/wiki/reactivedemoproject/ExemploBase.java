package com.reactive.wiki.reactivedemoproject;

import com.reactive.wiki.reactivedemoproject.debug.DebugLogger;

public abstract class ExemploBase {
    public abstract void executa();

    protected void logTesteDeMesa(String nome, Object valor, String metodo){
        DebugLogger.log(this.getClass().getPackageName(), nome, valor, metodo); //logTesteDeMesa("a", a, obtemNomeMetodoEmExecucao());
    }

    protected String obtemNomeMetodoEmExecucao()
    {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[2].getMethodName();
    }
}
