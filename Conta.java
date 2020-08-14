public class Conta{
  String numero;
  double saldo = 0;
  public void creditar(double valor){
    this.saldo += valor;
  }
  public void debitar(double valor){
    if(valor > this.saldo) System.out.println("saldo insuficiente para debitar");
    else{
      this.saldo = this.saldo - valor;
      System.out.println("o valor:" +valor); System.out.print("foi removido com sucesso!");
    }
  }
  public String getNumero(){return this.numero;}
  public double getSaldo(){return this.saldo;}
}
