package br.com.moveon.entites;

import java.time.Instant;

public class Log {
    private Long id;
    private String tipo;
    private String descricao;
    private Instant dataCriacao;

    public Log() {
    }

    public Log(String tipo, String descricao, Instant dataCriacao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
// O Código Java gera a mensagem com foco em:
// 1. Dizer o que é o relatório (Header)
// 2. Dar o resumo rápido (Section com Fields)
// 3. Fornecer uma opção de aprofundamento (Actions)

// Exemplo da estrutura visual no Slack:

/*
*Relatório de Processamento Batch - JobID: 12345* 🛑 Falha Crítica
--------------------------------------
*Métricas* *Detalhes*
Transações: 50.000  Status: ❌ FALHA
Erros: 15.000      Tempo Total: 3 min

*Erros Principais:*
• Erro de Conexão com DB (12.000 ocorrências)
• Dados Inválidos (3.000 ocorrências)

[ Botão: Ver Dashboard Completo ]  [ Botão: Acionar Suporte N2 ]
*/
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        /*
         * As cores ANSI em Java são uma forma de adicionar cor e
         * formatação ao texto impresso no console ou terminal,
         * utilizando sequências de caracteres especiais chamadas
         * "códigos de escape ANSI".*/

        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";

        String ANSI_COLOR = switch (this.tipo) {
            case "WARN" -> ANSI_YELLOW;
            case "ERROR", "FATAL" -> ANSI_RED;
            default -> ANSI_GREEN;
        };


        String templateLog = "%s %s --- [moveon] : %s";
        return templateLog.formatted(this.dataCriacao, ANSI_COLOR.concat(this.tipo).concat(ANSI_RESET), this.descricao);
    }
}
