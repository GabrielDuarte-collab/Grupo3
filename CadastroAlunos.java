import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CadastroAlunos {

static Scanner sc = new Scanner(System.in);

// Lista que guarda os alunos
static ArrayList<Map> alunos = new ArrayList<>();

// Map para ligar matrícula à posição na lista
static Map indice = new HashMap();

public static void main(String[] args) {

    int opcao = 0;

    do {
        System.out.println("\n=== MENU ===");
        System.out.println("\n1 - Cadastrar");
        System.out.println("2 - Buscar");
        System.out.println("3 - Listar");
        System.out.println("4 - Remover");
        System.out.println("5 - Sair");

        System.out.println();
        System.out.print("Opção: ");
        opcao = Integer.parseInt(sc.nextLine());

        if (opcao == 1) cadastrar();
        if (opcao == 2) buscar();
        if (opcao == 3) listar();
        if (opcao == 4) remover();
        if (opcao == 5) System.out.println("Programa encerrado");

    } while (opcao != 5);
}

// FUNÇÕES

static void cadastrar() {
    System.out.print("Matrícula: ");
    String mat = sc.nextLine();

    if (indice.containsKey(mat)) {
        System.out.println("Matrícula já existe");
        return;
    }

    System.out.print("Nome: ");
    String nome = sc.nextLine();

    System.out.print("Idade: ");
    String idade = sc.nextLine();

    Map aluno = new HashMap();
    aluno.put("mat", mat);
    aluno.put("nome", nome);
    aluno.put("idade", idade);

    alunos.add(aluno);
    indice.put(mat, alunos.size() - 1);

    System.out.println("Aluno cadastrado");
}

static void buscar() {
    System.out.print("Matrícula: ");
    String mat = sc.nextLine();

    if (!indice.containsKey(mat)) {
        System.out.println("Aluno não encontrado");
        return;
    }

    int pos = (int) indice.get(mat);
    Map aluno = alunos.get(pos);

    System.out.println("Nome: " + aluno.get("nome"));
    System.out.println("Idade: " + aluno.get("idade"));
}

static void listar() {
    for (int i = 0; i < alunos.size(); i++) {
        Map aluno = alunos.get(i);

        System.out.println("Matrícula: " + aluno.get("mat"));
        System.out.println("Nome: " + aluno.get("nome"));
        System.out.println("Idade: " + aluno.get("idade"));
        System.out.println("-----");
    }
}

static void remover() {
    System.out.print("Matrícula: ");
    String mat = sc.nextLine();

    if (!indice.containsKey(mat)) {
        System.out.println("Aluno não encontrado");
        return;
    }

    int pos = (int) indice.get(mat);

    alunos.remove(pos);
    indice.remove(mat);

    for (int i = pos; i < alunos.size(); i++) {
        Map aluno = alunos.get(i);
        indice.put(aluno.get("mat"), i);
    }

    System.out.println("Aluno removido");
}
}  
    

