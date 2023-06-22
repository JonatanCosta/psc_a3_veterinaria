import Servico.AnimalServico;
import Servico.EnderecoServico;
import Servico.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main extends Utils {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));

        int operacao;

        // Criação de um loop para que o menu seja exibido durante toda a interação com o programa
        do {
            //Limpa a tela a cada interação
            limpaTela();

            //Exibir o menu ao usuario
            exibirMenu();

            operacao = Integer.parseInt(reader.readLine());

            switch(operacao) {
                /**
                 * Cadastrar Animal
                 */
                case 1:
                    AnimalServico animalServico = new AnimalServico();
                    animalServico.cadastrarAnimal();

                    break;
                /**
                 * Agendar Consulta
                 */
                case 2:

                    break;
            }
        } while(operacao != 0);
    }

    public static void exibirMenu() {
        System.out.println("\n\n========= CLINICA PET FELIZ =========");
        System.out.println("1 | Cadastrar Animal");

        System.out.println("2 | Agendar Consulta");
        System.out.println("3 | Buscar Consultas");
        System.out.println("4 | Reagendar Consulta");
        System.out.println("5 | Cancelar Consulta");

        System.out.println("0 | Sair da clininca");
        System.out.print("Digite a opção desejada: ");
    }
}