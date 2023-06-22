package Servico;

public class Utils {
    public static void limpaTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mensagemSucesso(String msg) {
        try {
            System.out.println("============================================================");
            System.out.println("===============| "+msg+" |===============");
            System.out.println("============================================================");

            Thread.sleep(2000);
        } catch (Exception e) {

        }

    }
}
