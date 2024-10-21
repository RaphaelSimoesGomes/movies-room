import Cinema.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Sessao> sessoes = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("""
                    
                    
                    ======================================================
                                            MENU
                    ======================================================
                    1- Cadastrar;
                    2- Venda;
                    3- Sair;
                    
                    >>> """);
            int opc = sc.nextInt();
            if (opc == 1) {
                cadastrarSessao();
            } else if (opc == 2) {
                realizarVenda();
            } else if (opc == 3) {
                System.exit(0);
            } else {
                System.out.println("Opção incorreta. Tente novamente.");
            }
        }
    }

    private static void cadastrarSessao() {
        sc.nextLine();
        System.out.print("Digite o nome da sessão\n>>> ");
        try {
            String nome = sc.nextLine();

            System.out.print("Digite o horário da sessão (no formato HH:mm, ex: 13:45)\n>>> ");
            String horario = sc.next();
            System.out.print("Digite o preço da sessão\n>>> ");
            double preco = sc.nextDouble();

            try {
                LocalTime horarioTime = LocalTime.parse(horario);
                Sessao novaSessao = new Sessao(nome, horarioTime, preco);
                sessoes.add(novaSessao);
                System.out.println("Sessão cadastrada com sucesso!\n");

            } catch (Exception e) {
                Exception res = new Exception("""
                        
                        
                        ======================================================
                        
                                O numero tem que ser no formato HH:mm
                        
                        ======================================================
                        
                        """);
                throw new RuntimeException(res);
            }
        } catch (Exception e) {
            Exception res = new Exception("""
                    
                    
                    ======================================================
                    
                                    Digite um nome mais curto
                    
                    ======================================================
                    """);
            throw new RuntimeException(res);
        }


    }

    private static void realizarVenda() {
        if (sessoes.isEmpty()) {
            System.out.println("Nenhuma sessão cadastrada!");
            return;
        }

        System.out.println("Escolha uma sessão:");
        for (int i = 0; i < sessoes.size(); i++) {
            System.out.println(i + " - " + sessoes.get(i).toString());
        }
        try {
            System.out.print(">>> ");
            int sessaoEscolhida = sc.nextInt();
            Sessao sessao = sessoes.get(sessaoEscolhida);
            System.out.println("\n" + sessao.getMapaDeAssentos());

            System.out.print("Digite a coluna do assento: ");
            int col = sc.nextInt();
            System.out.print("Digite a fileira do assento: ");
            int fil = sc.nextInt();

            String resultado = sessao.ocuparLugar(col, fil);
            System.out.println(resultado);
        } catch (Exception e) {
            Exception res = new Exception("""
                    
                    
                    ============================================================================================================
                    
                                        Voce precisa colocar um número valido, numero referente as suas sessões
                    
                    ============================================================================================================
                    """);
            throw new RuntimeException(res);
        }
    }
}
