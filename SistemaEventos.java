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
            if (participanteLogado != null) menuParticipante(participanteLogado);
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
  // Variável para armazenar o participante logado!
  private static Participante participanteLogado = null;

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

  // Criando o método de login do participante!
  public static Participante loginParticipante() {
    System.out.println("\n--- Login Participante ---");
    System.out.print("Digite seu e-mail: ");
    String usuarioParticipante = scanner.nextLine();

    System.out.print("Digite sua senha: ");
    String senhaParticipante = scanner.nextLine();

    for (Participante p : participantes) {
      if (p.getEmail().equalsIgnoreCase(usuarioParticipante) && p.getSenha().equals(senhaParticipante)) {
        System.out.println("Login realizado com sucesso! Bem-vindo, " + p.getNome());
        return p; // Retornando o participante logado!
      }
   }

    System.out.println("E-mail ou senha incorretos.");
    return null;
  }



  // Criando o método do menu do Organizador Principal!
  public static void menuOrganizador() {
    while (true) {
      System.out.println("\n--- Menu Organizador ---");
      System.out.println("1. Dados do Evento");
      System.out.println("2. Dados do Cantor");
      System.out.println("3. Dados do Participante");
      System.out.println("4. Voltar ao menu principal");
      System.out.print("Escolha uma opção: ");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1: menuEvento(); break;
        case 2: menuCantor(); break;
        case 3: menuParticipanteOrg(); break;
        case 4: return;
        default: System.out.println("Opção inválida.");
      }
    }
  }

  // Criando o método do menu Organizador Evento!
  public static void menuEvento() {
    while (true) {
      System.out.println("\n--- Dados do Evento ---");
      System.out.println("1. Criar novo evento");
      System.out.println("2. Visualizar todos os eventos");
      System.out.println("3. Editar informações de um evento");
      System.out.println("4. Cancelar evento existente");
      System.out.println("5. Excluir evento");
      System.out.println("6. Voltar");
      System.out.print("Escolha uma opção: ");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1: criarEvento(); break;
        case 2: listarEventos(); break;
        case 3: editarEvento(); break;
        case 4: cancelarEvento(); break;
        case 5: excluirEvento(); break;
        case 6: return;
        default: System.out.println("Opção inválida.");
      }
    }
  }

  // Criando o método do menu Organizador Cantor!
  public static void menuCantor() {
    while (true) {
        System.out.println("\n--- Dados do Cantor ---");
        System.out.println("1. Cadastrar novo cantor");
        System.out.println("2. Visualizar lista de cantores");
        System.out.println("3. Editar informações de cantores");
        System.out.println("4. Excluir cantor");
        System.out.println("5. Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer!

        switch (opcao) {
            case 1: criarCantor(); break;
            case 2: listarCantores(); break;
            case 3: editarCantor(); break;
            case 4: excluirCantor(); break;
            case 5: return;
            default: System.out.println("Opção inválida.");
        }
    }
  }

  // Criando o método do menu Organizador Participante!
  public static void menuParticipanteOrg(){
    System.out.println("--- Dados dos usuários ---");
    System.out.println("1. Cadastrar participante");
    System.out.println("2. Visualizar lista de participante");
    System.out.println("3. Editar informações de participantes");
    System.out.println("4. Excluir Participante");
    System.out.println("5. Inscrever participante no evento");
    System.out.println("6. Cancelar inscrição de participante no evento");
    int opcao = scanner.nextInt();
    scanner.nextLine();

    switch (opcao){
      case 1: criarParticipante(); break;
      case 2: listarParticipantes(); break;
      case 3: editarParticipante(); break;
      case 4: excluirParticipante(); break;
      case 5: inscreverParticipanteEvento(); break;
      case 6: cancelarInscricaoParticipanteEvento(); break;
    }
  }

  // Criando o menu do participante!
  private static void menuParticipante(Participante participante) {
    while (true) {
      System.out.println("\n--- Menu Participante ---");
      // ATENÇÃO MUDANÇAS = Adicionar o método para cancelar inscrição nos eventos!
      System.out.println("1. Ver eventos disponíveis");
      System.out.println("2. Inscrever em eventos");
      System.out.println("3. Cancelar inscrição no evento");
      System.out.println("4. Editar meus dados");
      System.out.println("5. Voltar ao menu principal");
      System.out.print("Escolha uma opção: ");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1: listarEventos(); break;
        case 2: inscreverEvento(participante); break;
        case 3: cancelarMinhaInscricao(participante); break;
        case 4: editarMeusDados(participante); break;
        case 5: return;
        default: System.out.println("Opção inválida.");
      }
    }
  }

  // Método para o participante logado cancelar inscrição em eventos
  private static void cancelarMinhaInscricao(Participante participante) {
    System.out.println("\n--- Cancelar Inscrição em Evento ---");

    List<Evento> eventosInscritos = participante.getEventosEscolhidos();

    if (eventosInscritos.isEmpty()) {
      System.out.println("Você não está inscrito em nenhum evento.");
      return;
    }

    String resposta = "sim";
    while (resposta.equalsIgnoreCase("sim") && !eventosInscritos.isEmpty()) {
      System.out.println("Eventos nos quais você está inscrito:");
      for (int i = 0; i < eventosInscritos.size(); i++) {
        System.out.println((i + 1) + ". " + eventosInscritos.get(i).getNome());
      }

      System.out.print("Digite o número do evento que deseja cancelar: ");
      int idx = scanner.nextInt() - 1;
      scanner.nextLine(); // limpa o buffer

      if (idx < 0 || idx >= eventosInscritos.size()) {
        System.out.println("Número inválido.");
      } else {
        Evento eventoCancelado = eventosInscritos.remove(idx);
        System.out.println("Inscrição no evento \"" + eventoCancelado.getNome() + "\" cancelada com sucesso!");
      }

      // Se ainda houver eventos, perguntar se deseja cancelar mais
      if (!eventosInscritos.isEmpty()) {
        System.out.print("Deseja cancelar a inscrição em outro evento? (SIM/NAO): ");
        resposta = scanner.nextLine();
      } else {
        System.out.println("Você não está mais inscrito em nenhum evento.");
        break;
      }
    }
  }
 
  // Método para inscrever o participante logado em eventos!
  private static void inscreverEvento(Participante participante) {
    System.out.println("\n--- Inscrição em Eventos ---");

    if (eventos.isEmpty()) {
      System.out.println("Nenhum evento disponível no momento.");
      return;
    }

    String resposta = "sim";
    while (resposta.equalsIgnoreCase("sim")) {
      System.out.println("\nEventos disponíveis:");
      for (int i = 0; i < eventos.size(); i++) {
        System.out.println((i + 1) + ". " + eventos.get(i).getNome());
      }

      System.out.print("Digite o número do evento para se inscrever: ");
      int escolha = scanner.nextInt();
      scanner.nextLine(); // limpa buffer

      if (escolha < 1 || escolha > eventos.size()) {
        System.out.println("Evento inválido.");
      } 
      else {
        Evento eventoSelecionado = eventos.get(escolha - 1);

      if (participante.getEventosEscolhidos().contains(eventoSelecionado)) {
        System.out.println("Você já está inscrito neste evento.");
      } 
      else {
        participante.getEventosEscolhidos().add(eventoSelecionado);
        System.out.println("Inscrição no evento \"" + eventoSelecionado.getNome() + "\" realizada com sucesso!");
      }}

      System.out.print("Deseja se inscrever em outro evento? (SIM/NAO): ");
      resposta = scanner.nextLine();
    }
  }   
  
  // Método exclusivo para o ORGANIZADOR inscrever um participante em eventos
  private static void inscreverParticipanteEvento() {
    if (participantes.isEmpty()) {
      System.out.println("Nenhum participante cadastrado.");
      return;
    }

    listarParticipantes(); // Mostra todos os participantes
    System.out.print("Digite o número do participante a ser inscrito: ");
    int indiceParticipante = scanner.nextInt() - 1;
    scanner.nextLine(); // limpa buffer

    if (indiceParticipante < 0 || indiceParticipante >= participantes.size()) {
      System.out.println("Participante inválido.");
      return;
    }

    Participante participante = participantes.get(indiceParticipante);

    if (eventos.isEmpty()) {
      System.out.println("Nenhum evento disponível para inscrição.");
      return;
    }

    String resposta = "sim";
    while (resposta.equalsIgnoreCase("sim")) {
      listarEventos();
      System.out.print("Digite o número do evento para inscrever o participante: ");
      int escolhaEvento = scanner.nextInt();
      scanner.nextLine();

      if (escolhaEvento < 1 || escolhaEvento > eventos.size()) {
        System.out.println("Evento inválido.");
      } else {
        Evento eventoSelecionado = eventos.get(escolhaEvento - 1);

        if (participante.getEventosEscolhidos().contains(eventoSelecionado)) {
          System.out.println("O participante já está inscrito neste evento.");
        } else {
          participante.getEventosEscolhidos().add(eventoSelecionado);
          System.out.println("Participante \"" + participante.getNome() + "\" inscrito com sucesso no evento \"" + eventoSelecionado.getNome() + "\"!");
        }
      }

      System.out.print("Deseja inscrever o participante em outro evento? (SIM/NAO): ");
      resposta = scanner.nextLine();
    }
  }

  // Método exclusivo para o ORGANIZADOR cancelar a inscrição de um participante em eventos
  private static void cancelarInscricaoParticipanteEvento() {
    if (participantes.isEmpty()) {
      System.out.println("Nenhum participante cadastrado.");
      return;
    }

    listarParticipantes();
    System.out.print("Digite o número do participante para cancelar inscrição: ");
    int indiceParticipante = scanner.nextInt() - 1;
    scanner.nextLine(); // limpa buffer

    if (indiceParticipante < 0 || indiceParticipante >= participantes.size()) {
      System.out.println("Participante inválido.");
      return;
    }

    Participante participante = participantes.get(indiceParticipante);
    List<Evento> eventosInscritos = participante.getEventosEscolhidos();

    if (eventosInscritos.isEmpty()) {
      System.out.println("O participante \"" + participante.getNome() + "\" não está inscrito em nenhum evento.");
      return;
    }

    String resposta = "sim";
    while (resposta.equalsIgnoreCase("sim") && !eventosInscritos.isEmpty()) {
      System.out.println("\nEventos em que o participante está inscrito:");
      for (int i = 0; i < eventosInscritos.size(); i++) {
        System.out.println((i + 1) + ". " + eventosInscritos.get(i).getNome());
      }

      System.out.print("Digite o número do evento que deseja cancelar a inscrição: ");
      int escolha = scanner.nextInt();
      scanner.nextLine(); // limpa buffer

      if (escolha < 1 || escolha > eventosInscritos.size()) {
        System.out.println("Escolha inválida.");
      } else {
        Evento eventoRemovido = eventosInscritos.remove(escolha - 1);
        System.out.println("Inscrição no evento \"" + eventoRemovido.getNome() + "\" foi cancelada com sucesso.");
      }

      if (!eventosInscritos.isEmpty()) {
        System.out.print("Deseja cancelar outra inscrição para este participante? (SIM/NAO): ");
        resposta = scanner.nextLine();
      } else {
        System.out.println("O participante não está mais inscrito em nenhum evento.");
        break;
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
  
  // Método para excluir cadastro do participante!
  private static void excluirParticipante() {
    listarParticipantes(); // Mostra a lista de participantes com índices

    if (participantes.isEmpty()) {
      System.out.println("Nenhum participante para excluir.");
      return;
    }

    System.out.print("Informe o número do cantor a excluir: ");
    int idx = scanner.nextInt() - 1;
    scanner.nextLine(); // Limpa buffer!

    if (idx < 0 || idx >= participantes.size()) {
      System.out.println("Número inválido.");
      return;
    }

    Participante participanteRemovido = participantes.remove(idx);
    System.out.println("Participante \"" + participanteRemovido.getNome() + "\" removido com sucesso.");
  }

  // Método para exluir cadastro do evento!
  public static void excluirEvento(){
    listarEventos();

    if (eventos.isEmpty()) {
      System.out.println("Nenhum evento para excluir.");
    }

    System.out.println("Informe o número do evento para excluir ");
    int idx = scanner.nextInt() - 1;
    scanner.nextLine(); // Limpa buffer!

    if (idx < 0 || idx >= eventos.size()) {
      System.out.println("Número inválido.");
    }

    Evento eventoRemovido  = eventos.remove(idx);
    System.out.println("Evento \"" + eventoRemovido.getNome() + "\" removido com sucesso.");
  }

  // Método para editar apenas os dados do participante logado!
  private static void editarMeusDados(Participante participante) {
    System.out.println("\n--- Editar Meus Dados ---");

    System.out.print("Novo nome (" + participante.getNome() + "): ");
    String novoNome = scanner.nextLine();
    if (!novoNome.isEmpty()) participante.setNome(novoNome);

    System.out.print("Novo telefone: ");
    String novoTelefone = scanner.nextLine();
    if (!novoTelefone.isEmpty()) participante.setTelefone(novoTelefone);

    System.out.print("Nova senha: ");
    String novaSenha = scanner.nextLine();
    if (!novaSenha.isEmpty()) participante.setSenha(novaSenha);

    System.out.println("Dados atualizados com sucesso!");
  }  

  // Método para editar o participante!
  private static void editarParticipante(){
    listarParticipantes();
    System.out.println("Informe o código do participante a editar:");
    int idx = scanner.nextInt() - 1 ;
    scanner.nextLine(); // Limpa buffer!
    if (idx < 0 || idx >= participantes.size()) {
      System.out.println("Participante inválido.");
      return;
    }

    Participante participante = participantes.get(idx);

    System.out.println("Novo nome: ");
    String nomeParticipante  = scanner.nextLine();

    System.out.println("Nova senha: ");
    String senhaParticipante  = scanner.nextLine();

    System.out.println("Novo telefone: ");
    String telefoneParticipante = scanner.nextLine();

    System.out.println("Nova idade: ");
    int idadeParticipante = scanner.nextInt();
    scanner.nextLine(); // Limpa buffer!

    System.out.print("Nova data de nascimento (dd/mm/aaaa): ");
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

    // Salva as atualizações a tabela!
    participante.editarParticipante(nomeParticipante, senhaParticipante, telefoneParticipante, idadeParticipante, nascimentoParticipante);
    System.out.println("Participante atualizado");
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

  // Método para editar o cantor!
  public static void editarCantor(){
    listarCantores();
    System.out.print("Informe o código do cantor a editar: ");
    int idx = scanner.nextInt() - 1;
    scanner.nextLine();
    if (idx < 0 || idx >= eventos.size()) {
      System.out.println("Cantor inválido.");
      return;
    }
        
    Cantor cantor = cantores.get(idx);
        
    System.out.println("Novo nome: ");
    String nomeCantor = scanner.nextLine();
        
    System.out.println("Novo e-mail: ");
    String emailCantor = scanner.nextLine();
        
    System.out.println("Nova idade: ");
    int idadeCantor = scanner.nextInt();
    scanner.nextLine(); // Limpa buffer!
        
    System.out.println("Novo telefone: ");
    String telefoneCantor = scanner.nextLine();
        
    cantor.editarCantor(nomeCantor, emailCantor, idadeCantor, telefoneCantor);
    System.out.println("Cantor atualizado.");
  }

  // Método para listar os participantes!
  private static void listarParticipantes(){
    if (participantes.isEmpty()){
      System.out.println("Nenhum participante cadastrado.");
      return;
    }
    for (int i = 0; i < participantes.size(); i++){
      System.out.println("participante #" + (i + 1));
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
    scanner.nextLine(); // Limpa Buffer!
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
    scanner.nextLine(); // Limpa buffer!

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
    int idadeCantor = scanner.nextInt();
    scanner.nextLine(); // Limpa buffer!

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
      scanner.nextLine(); // Limpa Buffer! 

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
  
  // Adicionando o participante a tabela de participantes!
  Participante participante = new Participante(nomeParticipante, emailParticipante, senhaParticipante, telefoneParticipante, idadeParticipante, nascimentoParticipante, eventosEscolhidos);
  participantes.add(participante);
  System.out.println("Participante cadastrado com sucesso!");
  }                                                                      

  // Teste de login (Método para adicionar um cadastro teste na tabela participantes)!
  public static void prepararParticipantesTeste() {
    participantes.add(new Participante("Anderson Souza", "andersonsouzapcb@gmail.com", "1234","9999-9999", 20, LocalDate.of(2004, 1, 1), new ArrayList<Evento>()));
  }  
}
