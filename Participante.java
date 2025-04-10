// Importando bibliotecas necessárias!
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SistemaEventos {
    // Criando o Scanner para ler os dados!
    private static Scanner scanner = new Scanner(System.in);

    // Criando as listas necessárias para armazenar os dados de cada classe!
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Cantor> cantores = new ArrayList<>();
    private static List<Participante> participantes = new ArrayList<>();
    
    // Iniciando o programa!
    public static void main(String[] args) {
        prepararParticipantesTeste(); // Chamando o método para adicionar 1 cadastro na tabela Participante para efetuar o login!
        // Criando o menu principal!
        // ATENÇÃO MUNDANÇAS = Adicionar a opção de se cadastrar como participante!
        while (true) {
            System.out.println("\n--- Bem-vindo ao Rolézinho Eventos ---");
            System.out.println("1. Entrar como Organizador");
            System.out.println("2. Entrar como Participante");
            System.out.println("3. Cadastrar participante");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (loginOrganizador()) menuOrganizador();
                    break;
                case 2:
                    if (loginParticipante()) menuParticipante();
                    break;
                case 3:
                    criarParticipante();
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Dados fixos para login de organizador
    private static final String USUARIO_ORGANIZADOR = "admin";
    private static final String SENHA_ORGANIZADOR = "1234";

    // Criando o método de login do organizador!
    public static boolean loginOrganizador(){
        System.out.println("\n--- Login Organizador ---");
        System.out.print("Usuário: ");
        String usuarioOrganizador = scanner.nextLine();
        System.out.print("Senha: ");
        String senhaOrganizador = scanner.nextLine();
    
        if (USUARIO_ORGANIZADOR.equals(usuarioOrganizador) && SENHA_ORGANIZADOR.equals(senhaOrganizador)) {
            System.out.println("Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("Usuário ou senha incorretos.");
            return false;
        }
    }

    // Teste de login (Método para adicionar um cadastro teste na tabela participantes)!
    public static void prepararParticipantesTeste() {
        participantes.add(new Participante("Anderson", "andersonsouzapcb@gmail.com", "1234","9999-9999", 20, LocalDate.of(2004, 1, 1)));
    }   

    // Criando o método de login do participante!
    public static boolean loginParticipante(){
        System.out.println("\n--- Login Participante ---");
        
        System.out.print("Digite seu e-mail: ");
        String usuarioParticipante = scanner.nextLine();

        System.out.println("Digite sua senha: ");
        String senhaParticipante = scanner.nextLine();
    
        for (Participante p : participantes) {
            if (p.getEmail().equalsIgnoreCase(usuarioParticipante) && p.getSenha().equalsIgnoreCase(senhaParticipante)) {
                System.out.println("Login realizado com sucesso! Bem-vindo, " + p.getNome());
                return true;
            }
        }
    
        System.out.println("E-mail não encontrado. Cadastre-se primeiro.");
        return false;
    }

    // Criando o método do menu do organizador!
    public static void menuOrganizador(){
        while (true) {
            System.out.println("\n--- Menu Organizador ---");
            System.out.println("1. Criar novo evento");
            System.out.println("2. Listar eventos");
            System.out.println("3. Editar evento");
            System.out.println("4. Cancelar evento");
            System.out.println("5. Cadastrar cantor");
            System.out.println("6. Cadastrar participante");
            System.out.println("7. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: criarEvento(); break;
                case 2: listarEventos(); break;
                case 3: editarEvento(); break;
                case 4: cancelarEvento(); break;
                case 5: criarCantor(); break;
                case 6: criarParticipante(); break;
                case 7: return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

     // Criando o menu do participante!
    private static void menuParticipante() {
        while (true) {
            System.out.println("\n--- Menu Participante ---");
            //  ATENÇÃO MUNDANÇAS = Trocar para outro método de se inscrever no evento!
            System.out.println("1. Ver eventos disponíveis");
            System.out.println("2. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: listarEventos(); break;
                case 2: return;
                default: System.out.println("Opção inválida.");
            }
        }
    }
    // Método para editar o evento!
    private static void editarEvento() {
        listarEventos();
        System.out.print("Informe o código do evento a editar: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx < 0 || idx >= eventos.size()) {
            System.out.println("Evento inválido.");
            return;
        }

        Evento evento = eventos.get(idx);

        System.out.print("Novo nome: ");
        String nomeEvento = scanner.nextLine();
        
        System.out.print("Novo código: ");
        String codigoEvento = scanner.nextLine();

        System.out.print("Nova descrição: ");
        String descricaoEvento = scanner.nextLine();

        System.out.print("Nova data: ");
        String dataEvento = scanner.nextLine();

        System.out.print("Novo local: ");
        String localEvento = scanner.nextLine();

        System.out.print("Nova capacidade: ");
        int capacidadeEvento = scanner.nextInt();
        scanner.nextLine();
        
        // Salva as atualizações a tabela!
        evento.editar(nomeEvento, codigoEvento, descricaoEvento, dataEvento, localEvento, capacidadeEvento);
        System.out.println("Evento atualizado.");
    }
    
    // Método para listar os eventos!
    private static void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }

        for (int i = 0; i < eventos.size(); i++) {
            System.out.println("Evento #" + (i + 1));
            System.out.println(eventos.get(i));
        }
    }
    
    // Método para escolher o evento a ser cancelado!
    private static void cancelarEvento() {
        listarEventos();
        System.out.print("Informe o número do evento a cancelar: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx < 0 || idx >= eventos.size()) {
            System.out.println("Evento inválido.");
            return;
        }
        eventos.get(idx).cancelarEvento(); // Método para cancelar o evento feito na classe Evento!
        System.out.println("Evento cancelado.");
    }
    
    // Método para criar o evento!
    private static void criarEvento() {
        System.out.print("Nome: ");
        String nomeEvento = scanner.nextLine();

        System.out.print("Código: ");
        String codigoEvento = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricaoEvento = scanner.nextLine();

        System.out.print("Data: ");
        String dataEvento = scanner.nextLine();

        System.out.print("Local: ");
        String localEvento = scanner.nextLine();

        System.out.print("Capacidade: ");
        int capacidadeEvento = scanner.nextInt();
        scanner.nextLine();

        boolean ativoEvento = true;
        
        // Adicionando o evento a tabela de Eventos!
        Evento evento = new Evento(nomeEvento, codigoEvento, descricaoEvento, dataEvento, localEvento, capacidadeEvento, ativoEvento);
        eventos.add(evento);
        System.out.println("Evento criado com sucesso!");
    }
    
    // Método para criar cantor!
    private static void criarCantor() {
        System.out.println("Preencha os dados do cantor ou banda!");

        System.out.print("Nome: ");
        String nomeCantor = scanner.nextLine();

        System.out.print("E-mail: ");
        String emailCantor = scanner.nextLine();

        System.out.print("Idade: ");
        String idadeCantor = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefoneCantor = scanner.nextLine();

        boolean ativoCantor = true;
        
        // Adicionando cantor a tabela cantores!
        Cantor cantor = new Cantor(nomeCantor, emailCantor, idadeCantor, telefoneCantor, ativoCantor);
        cantores.add(cantor);
        System.out.println("Cantor criado com sucesso!");
    }
    
    // Método para criar o participante!
    private static void criarParticipante() {
        System.out.println("Preencha os dados do participante!");

        System.out.print("Nome: ");
        String nomeParticipante = scanner.nextLine();

        System.out.print("E-mail: ");
        String emailParticipante = scanner.nextLine();

        System.out.print("Senha: ");
        String senhaParticipante = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefoneParticipante = scanner.nextLine();

        System.out.print("Idade: ");
        int idadeParticipante = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        // Convertendo a data de nascimento em LocalDate e fazendo o catch!
        try {
            String dataTexto = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate nascimentoParticipante = LocalDate.parse(dataTexto, formatter);
            // Adicionando o participantes a tabela Participante!
            Participante participante = new Participante(nomeParticipante, emailParticipante, senhaParticipante, telefoneParticipante, idadeParticipante, nascimentoParticipante);
            participantes.add(participante);
            System.out.println("Participante cadastrado com sucesso!");
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Use o formato dd/mm/aaaa.");
        }
    }
    public static List<Participante> getParticipantes() {
        return participantes;
    }                                                                        
}
