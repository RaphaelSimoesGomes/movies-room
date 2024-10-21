package Cinema;

import java.util.ArrayList;
import java.time.LocalTime;

public class Sessao {
    private String nomeDoFilme;
    private LocalTime horarioDaSessao;
    private double preco;
    private ArrayList<Sessao> sessoesCadastradas = new ArrayList<>();
    private Assento mapaDeAssentos;

    public Sessao(String nomeDoFilme, LocalTime horarioDaSessao, double preco) {
        this.nomeDoFilme = nomeDoFilme;
        this.horarioDaSessao = horarioDaSessao;
        this.preco = preco;
        this.mapaDeAssentos = new Assento();
    }

    public String getMapaDeAssentos() {
        return mapaDeAssentos.mostraLugares();
    }

    public String ocuparLugar(int col, int fil) {
        return mapaDeAssentos.ocuparLugar(col, fil);
    }

    @Override
    public String toString() {
        return "Filme: " + nomeDoFilme + ", Horário: " + horarioDaSessao + ", Preço: R$" + preco;
    }
}
