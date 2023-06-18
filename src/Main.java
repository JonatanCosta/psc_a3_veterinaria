import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));

        int operacao;

        // Criação de um loop para que o menu seja exibido durante toda a interação com o programa
        do {
            System.out.println("\n\n========= CLINICA PET FELIZ =========");
            System.out.println("1 | Cadastrar Animal");

            System.out.println("2 | Agendar Consulta");
            System.out.println("3 | Buscar Consultas");
            System.out.println("4 | Reagendar Consulta");
            System.out.println("5 | Cancelar Consulta");

            System.out.println("0 | Sair da clininca");
            System.out.println("Digite a opção desejada: ");

            operacao = Integer.parseInt(reader.readLine());

            switch(operacao) {
                /**
                 * Cadastrar Animal
                 */
                case 1:

                    break;
                /**
                 * Agendar Consulta
                 */
                case 2:

                    break;
            }
        } while(operacao != 0);
    }
}