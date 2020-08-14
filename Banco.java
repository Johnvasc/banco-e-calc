import java.util.Scanner;
import java.lang.String;

public class Banco{
  int contador = 0; int Nconta, ok;
  Conta ct[] = new Conta[30];
  Scanner scan = new Scanner(System.in);
  public void bancointer(){
    int escolha; String NumeroDaConta;
    do{
      System.out.println("escolha uma opção:\n1 - cadastrar\n2 - creditar\n3 - debitar\n4 - saldo\n5 - transferir\n0 - sair");
      escolha = scan.nextInt();
      if(escolha==1){
        System.out.println("Insira o numero da conta nova");
        NumeroDaConta = scan.next();
        boolean sentinel = cadastrar(NumeroDaConta, ct, contador);
        if(sentinel == true) contador++;
      }
      else if(escolha==2){
        System.out.println("Insira o numero da conta");
        NumeroDaConta = scan.next();
        System.out.println("Insira o valor a creditar");
        double nn = scan.nextDouble();
        creditar(NumeroDaConta, ct, nn, contador);
      }
      else if(escolha==3){
        System.out.println("Insira o numero da conta");
        NumeroDaConta = scan.next();
        System.out.println("Insira o numero a debitar");
        double nn = scan.nextDouble();
        creditar(NumeroDaConta, ct, nn, contador);
        }
      else if(escolha==4){
        System.out.println("Insira o numero da conta");
        String numero = scan.next();
        saldo(numero, ct, contador);
      }
      else if(escolha==5){
        System.out.println("1: conta que vai receber.\n2: conta que vai transferir");
        String receber = scan.next();
        String transf = scan.next();
        if(receber.equals(transf)) System.out.println("Erro: contas iguais!");
        else{
          System.out.println("insira a quantia a transferir");
          double valor = scan.nextDouble();
          transferir(receber, transf, valor, ct, contador);
        }
      }
    }while(escolha != 0);
  }
  public boolean cadastrar(String numero, Conta ct[], int contador){
    boolean ok = buscar(numero, contador, ct);
    if(!ok){
      ct[contador] = new Conta();
      ct[contador].numero = numero;
      return true;
    }
    else return false;
  }
  public boolean buscar(String numero, int contador, Conta ct[]){
    for(int i=0; i<contador; i++){
      if(numero.equals(ct[i].numero)) return true;
    }
    return false;
  }
  public int buscar_posi(String numero, Conta ct[], int contador){
    for(int i=0; i<contador; i++){
      if(numero.equals(ct[i].numero)) return i;
    }
    return -1;
  }
  public void saldo(String numero, Conta ct[], int contador){
    int nn = buscar_posi(numero, ct, contador);
    if(nn!=-1) System.out.println("saldo eh de: "+ct[nn].saldo);
  }
  public void procurar(String numero, int contador, Conta ct[]){
    for(int i=0; i<contador; i++){
      if(numero.equals(ct[i].numero)) System.out.println("a conta procurada existe!");
    }
  }
  public void creditar(String numero, Conta ct[], double valor, int contador){
    int posicao = buscar_posi(numero, ct, contador);
    if(posicao!=-1) ct[posicao].saldo += valor;
  }
  public void debitar(String numero, Conta ct[], double valor, int contador){
    int posicao = buscar_posi(numero, ct, contador);
    if(posicao!=-1) ct[posicao].saldo -= valor;
  }
  public void transferir(String receptor, String enviador, double valor, Conta ct[], int contador){
    int env = buscar_posi(enviador, ct, contador);
    int recep = buscar_posi(receptor, ct, contador);
    if(valor>ct[env].saldo) System.out.println("saldo insuficiente para transferir");
    else{
      ct[env].saldo -= valor;
      ct[recep].saldo += valor;
      System.out.println("o valor foi transferido com sucesso!");
    }
  }
}
