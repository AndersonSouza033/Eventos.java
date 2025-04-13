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
    prepararParticipantesTeste(); // Chamando o método teste para adicionar 1 cadastro na tabela Participante para efetuar o login!
    // Criando o menu principal!
    while (true) {
      System.out.println("\n--- Bem-vindo ao Rolézinho Eventos ---");
      System.out.println("1. Entrar como Organizador");
      System.out.println("2. Entrar como Participante");
      System.out.println("3. Cadastrar Participante");
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
            criarParticipante(); break;
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
        
    // Conferindo se os dados digitados estão corretos!
    if (USUARIO_ORGANIZADOR.equals(usuarioOrganizador) && SENHA_ORGANIZADOR.equals(senhaOrganizador)) {
      System.out.println("Login realizado com sucesso!");
        return true;
    } 
    else {
      System.out.println("Usuário ou senha incorretos.");
        return false;
    }
  }

  // Teste de login (Método para adicionar um cadastro teste na tabela participantes)!
  public static void prepararParticipantesTeste() {
    participantes.add(new Participante("Anderson Souza", "andersonsouzapcb@gmail.com", "1234","9999-9999", 20, LocalDate.of(2004, 1, 1), new ArrayList<Evento>()));
  }   

  // Criando o método de login do participante!
  // ATENÇÂO --> Testar esse novo login se está funcionando corretamente!
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
  // ATENÇÂO MUDANÇAS --> Organizar melhor as opções pois precisar adicionar mais métodos para a classe Cantor e Participante!
  public static void menuOrganizador(){
    while (true) {
      System.out.println("\n--- Menu Organizador ---");
      System.out.println("1. Criar novo evento");
      System.out.println("2. Visualizar todos os eventos");
      System.out.println("3. Editar informações de um evento");
      System.out.println("4. Cancelar evento existente");
      System.out.println(" . Excluir evento"); // ATENÇÂO!! Criar o método
          
      System.out.println("--------------------------");
            
      System.out.println("5. Cadastrar novo cantor");
      System.out.println("6. Visualizar lista de cantores");  // Método criado OBS: Testar
      System.out.println("7. Editar informações de cantores"); // Método criado OBS: Testar
      System.out.println("8. Excluir cantor"); // Método criado OBS: Testar
            
      System.out.println("--------------------------");
            
      System.out.println("9. Cadastrar novo participante");
      System.out.println("10. Visualizar lista de participantes"); // Método criado OBS: Testar
      System.out.println(" . Editar dados de um participante"); // ATENÇÂO!! Criar método
      System.out.println(" . Inscrever participante em evento"); // ATENÇÂO!! Criar método
      System.out.println(" . Cancelar inscrição de participante"); // ATENÇÂO!! Criar método
      System.out.println("14. Excluir participante"); // Método criado OBS: Testar
            
      System.out.println("9. Voltar ao menu principal");
      System.out.print("Escolha uma opção: ");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1: criarEvento(); break;
        case 2: listarEventos(); break;
        case 3: editarEvento(); break;
        case 4: cancelarEvento(); break;
        case 5: criarCantor(); break;
        case 6: listarCantores(); break;
        case 7; editarCantor(); break;
        case 8: criarParticipante(); break;
        case 9: listarParticipantes(); break;
        case 10: return;
        default: System.out.println("Opção inválida.");
      }
    }
  }

  // Criando o menu do participante!
  private static void menuParticipante() {
    while (true) {
      System.out.println("\n--- Menu Participante ---");
      // ATENÇÃO MUDANÇAS = Adicionar o método para se inscrever nos eventos!
      // ATENÇÃO MUDANÇAS = Adicionar o método para editar participante!
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
  
  // Método para excluir cadastro do cantor!
  private static void excluirCantor() {
    listarCantores(); // Mostra a lista de cantores com índices

    if (cantores.isEmpty()) {
      System.out.println("Nenhum cantor para excluir.");
      return;
    }

    System.out.print("Informe o número do cantor a excluir: ");
    int idx = scanner.nextInt() - 1;
    scanner.nextLine();

    if (idx < 0 || idx >= cantores.size()) {
      System.out.println("Número inválido.");
      return;
    }
    Cantor cantorRemovido = cantores.remove(idx);
    System.out.println("Cantor \"" + cantorRemovido.getNome() + "\" removido com sucesso.");
  }
  
  // Método para exclui cadastro do participante!
  private static void excluirParticipante() {
    listarParticipantes(); // Mostra a lista de participantes com índices

    if (participantes.isEmpty()) {
      System.out.println("Nenhum participante para excluir.");
      return;
    }

    System.out.print("Informe o número do cantor a excluir: ");
    int idx = scanner.nextInt() - 1;
    scanner.nextLine();

    if (idx < 0 || idx >= participantes.size()) {
      System.out.println("Número inválido.");
      return;
    }

    Participante participanteRemovido = participantes.remove(idx);
    System.out.println("Participante \"" + participanteRemovido.getNome() + "\" removido com sucesso.");
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
    evento.editarEvento(nomeEvento, codigoEvento, descricaoEvento, dataEvento, localEvento, capacidadeEvento);
    System.out.println("Evento atualizado.");
  }
    
  // Método para editar cantor!
  public static void editarCantor(){
    listarCantores(); // Criar esse método//
    System.out.print("Informe o código do cantor a editar: ");
    int idx = scanner.nextInt() - 1;
    scanner.nextLine();
    if (idx < 0 || idx >= eventos.size()) {
      System.out.println("Cantor inválido.");
        return;
    }
        
    Cantor cantor = cantores.get(idx);
        
    System.out.println("Novo nome: ");
    nomeCantor = scanner.nextLine();
        
    System.out.println("Novo e-mail: ");
    emailCantor = scanner.nextLine();
        
    System.out.println("Nova idade: ");
    idadeCantor = scanner.nextLine();
        
    System.out.println("Novo telefone: ");
    telefoneCantor = scanner.nextLine();
        
    cantor.editarCantor(nomeCantor, emailCantor, idadeCantor, telefoneCantor);
    System.out.println("Cantor atualizado.");
  }
  
  // Método para listar os participantes!
  private static void listarParticipantes(){
    if (participantes.isEmpty()){
      System.out.println("Nenhum participante cadastrado.");
      return;
    }
    for (int i = 0, i < participantes.size(), i++){
      System.out.println("participante #"(i + 1));
      System.out.println(participantes.get(i));
    }
  }
  
  // Método para listar os cantores!
  private static void listarCantores(){
    if (cantores.isEmpty()){
      System.out.println("Nenhum cantor cadastrado.");
      return;
    }
    for (int i = 0; i < cantores.size(); i++){
      System.out.println("Cantor #" + (i + 1));
      System.out.println(cantores.get(i));
    }
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
    String dataTexto = scanner.nextLine();

    LocalDate nascimentoParticipante;
    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      nascimentoParticipante = LocalDate.parse(dataTexto, formatter);
    } 
    catch (DateTimeParseException e) {
      System.out.println("Data inválida. Use o formato dd/mm/aaaa.");
      return;
    }

    List<Evento> eventosEscolhidos = new ArrayList<>();

    System.out.println("Deseja se inscrever em algum evento/show? (SIM/NAO)");
    String resposta = scanner.nextLine();

    while (resposta.equalsIgnoreCase("sim")) {
      System.out.println("\nEventos disponíveis:");
      for (int i = 0; i < eventos.size(); i++) {
        System.out.println((i + 1) + ". " + eventos.get(i).getNome());
      }

      System.out.print("Digite o número do evento para se inscrever: ");
      int escolhaEvento = scanner.nextInt();
      scanner.nextLine();

      if (escolhaEvento < 1 || escolhaEvento > eventos.size()) {
        System.out.println("Evento inválido.");
      } 
      else {
        Evento evento = eventos.get(escolhaEvento - 1);
        if (eventosEscolhidos.contains(evento)) {
          System.out.println("Você já se inscreveu neste evento.");
        } 
        else {
          eventosEscolhidos.add(evento);
          System.out.println("Inscrição realizada com sucesso!");
        }
      }

      System.out.println("Deseja se inscrever em outro evento? (SIM/NAO)");
      resposta = scanner.nextLine();
    }

  Participante participante = new Participante(nomeParticipante, emailParticipante, senhaParticipante, telefoneParticipante, idadeParticipante, nascimentoParticipante, eventosEscolhidos);

  participantes.add(participante);
  System.out.println("Participante cadastrado com sucesso!");
  }                                                                      
}
