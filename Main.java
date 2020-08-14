import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcao1;
    System.out.println("1 - Calculadora\n2 - Banco\n3 - testes");
    opcao1 = scanner.nextInt();
    if(opcao1 == 1){
      Calculadora c1 = new Calculadora();
      c1.calc();
    }
    else if(opcao1 == 2){
      Banco b1 = new Banco();
      b1.bancointer();
    }
    else if(opcao1 == 3){
      System.out.println("Escolha a opção desejada:\n 1) Testa Claculadora\n 2) Testa Conta \n 3) Testa Banco");
      int opcao = scanner.nextInt();
      switch(opcao) {
        case 1: testaCalculadora();
                break;
                
        case 2: testaConta();
              break;
              
        case 3: testaBanco();
              break;
              
        default: System.out.println("Opção inexistente!");
              break;
      }
    }
    
  }
  public static void testaCalculadora() {
    System.out.println("Teste de soma e diminuicao");
    double num = Calc.sd(10, 5, '+');
    if(num == 15) System.out.println("Soma: positivo");
    num = Calc.sd(10, 5, '-');
    if(num == 5) System.out.println("diminuicao: positivo");
    System.out.println("Teste multiplicacao");
    num = Calc.mult(10, 5);
    if(num == 50) System.out.println("multiplicacao: positivo");
    num = Calc.div(10, 5);
    if(num == 2) System.out.println("divisao: positivo");
    num = Calc.div(10, 0);
    if(num == 0) System.out.println("divisao por zero: positivo");
    num = Calc.pote(10, 2);
    if(num == 100) System.out.println("potencia: positivo");
    num = Calc.sqrt(100, 2);
    if(num == 10) System.out.println("raiz: positivo");
    num = Calc.sin(45);
    if(num == 0.8509035245341184) System.out.println("seno: positivo");
    num = Calc.cos(45);
    if(num == 0.5253219888177297) System.out.println("cosseno: positivo");
    num = Calc.tan(45);
    if(num == 1.6197751905438615) System.out.println("Tangente: positivo");
  }

  public static void testaConta() {
    Conta c = new Conta();
    c.numero = "123";
    c.saldo = 5000;
    c.creditar(1000);
    c.debitar(3000);
    System.out.println("O teste foi um sucesso!");
  }
  
  public static void testaBanco() {
    Conta c[] = new Conta[2];
    Banco b = new Banco();
    boolean sla = b.cadastrar("123", c, 0);
    if(sla == true) System.out.println("Conta cadastrada com sucesso!");
    sla = b.cadastrar("456", c, 1);
    b.creditar("123", c, 1000, 2);
    b.creditar("456", c, 500, 2);
    System.out.println("Teste em depositar sucesso!");
    b.transferir("456", "123", 250, c, 2);
    System.out.println("Teste em transferir sucesso!");
    b.debitar("123", c, 150, 2);
    System.out.println("Teste em debitar sucesso!");
    b.saldo("123", c, 2);
    System.out.println("Saldo final da conta 1");
    b.saldo("456", c, 2);
    System.out.println("Saldo final da conta 2");
    System.out.println("O teste foi um sucesso!");
  }
}
