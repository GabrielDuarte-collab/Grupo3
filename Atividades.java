import java.util.*;

public class Atividades {

    static ArrayList<Map<String, Object>> alunos = new ArrayList<>();
    static Map<String, Integer> Matricula = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Buscar por matrícula");
            System.out.println("3 - Listar todos");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine().trim();

            if (opcao == 1) {
                cadastrarAluno();
            } else if (opcao == 2) {
                buscarAluno();
            } else if (opcao == 3) {
                listarAlunos();
            }else if (opcao == 4) {
                System.out.println("Programa encerrado.");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    static void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();

        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine().trim();

        System.out.print("Matrícula: ");
        String matricula = sc.nextLine().trim();

        if (Matricula.containsKey(matricula)) {
            System.out.println("Matrícula já cadastrada!");
            return;
        }

        Map<String, Object> aluno = new HashMap<>();
        aluno.put("nome", nome);
        aluno.put("idade", idade);
        aluno.put("matricula", matricula);

        alunos.add(aluno);
        Matricula.put(matricula, alunos.size() - 1);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    static void buscarAluno() {
        System.out.print("Informe a matrícula: ");
        String matricula = sc.nextLine().trim();

        if (!Matricula.containsKey(matricula)) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        int Mat = Matricula.get(matricula);
        Map<String, Object> aluno = alunos.get(Mat);

        System.out.println("Nome: " + aluno.get("nome"));
        System.out.println("Idade: " + aluno.get("idade"));
        System.out.println("Matrícula: " + aluno.get("matricula"));
    }

    static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\n=== LISTA DE ALUNOS ===");
        for (Map<String, Object> aluno : alunos) {
            System.out.println(" ");
            System.out.println("Nome: " + aluno.get("nome"));
            System.out.println("Idade: " + aluno.get("idade"));
            System.out.println("Matrícula: " + aluno.get("matricula"));
        }
    }
}
