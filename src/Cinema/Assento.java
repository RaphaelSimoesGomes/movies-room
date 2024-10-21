package Cinema;

public class Assento {
    private boolean[][] disponivel = new boolean[5][4];

    //true = livre
    //false = ocupado

    public Assento() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                disponivel[i][j] = true;
            }
        }

    }

    public Assento( int col, int fil){

        disponivel = new boolean[col][fil];

        // Inicializa todos os assentos como disponíveis (true)
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < fil; j++) {
                disponivel[i][j] = true;
            }
        }
    }

    public String mostraLugares() {
        String mapaDeAssentos = "Mapa de Assentos:\n";
        mapaDeAssentos += "   ";
        for (int j = 0; j < 4; j++) {
            mapaDeAssentos += "  " + (j) + "  ";
        }

        mapaDeAssentos += "\n";

        for (int i = 0; i < 5; i++) {
            mapaDeAssentos += (i) + "  ";


            for (int j = 0; j < 4; j++) {
                if (disponivel[i][j]) {
                    mapaDeAssentos += "|   |";

                } else {
                    mapaDeAssentos += "| X |";
                }
            }


            mapaDeAssentos += "\n";
        }

        return mapaDeAssentos;
    }


    public String ocuparLugar(int col, int fil) {
        if (col < disponivel.length && fil < disponivel[0].length && disponivel[col][fil]) {
            disponivel[col][fil] = false;
            return "Assento na coluna " + col + " e fileira " + fil + " foi ocupado com sucesso!";
        } else {
            return "Assento indisponível ou inválido!";
        }

    }
}
