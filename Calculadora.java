import java.util.Scanner;

public class Calculadora {
  public void calc(){
    int escolha;
    Scanner scan = new Scanner(System.in);
    double num1, num2, num3 = 0;
    char sinal;
    do{
      System.out.println("1 - aritmetica\n2 - trigonometrica");
      escolha = scan.nextInt();
      if(escolha==1){
        System.out.println("1 Numero, 1 Operação (+,-,*,/,^,r), outro num");
        num1 = scan.nextDouble();
        sinal = scan.next().charAt(0);
        num2 = scan.nextDouble();
        if(sinal == '+' || sinal == '-') num3 = Calc.sd(num1, num2, sinal);
        else if(sinal == '*') num3 = Calc.mult(num1, num2);
        else if(sinal == '/') num3 = Calc.div(num1, num2);
        else if(sinal == '^') num3 = Calc.pote(num1, num2);
        else if(sinal == 'r') num3 = Calc.sqrt(num1, num2);
        System.out.println("= "+(num3));
      }
      else{
        System.out.println("escolha:s - seno\nc - cosseno\nt - tangente");
        sinal = scan.next().charAt(0);
        System.out.println("insira o valor do ângulo");
        num1 = scan.nextInt();
        if(sinal == 's') num3 = Calc.sin(num1);
        else if(sinal == 'c') num3 = Calc.cos(num1);
        else if(sinal == 't') num3 = Calc.tan(num1);
        System.out.println("resultado= "+num3);
      }
    }while(escolha!=0);
  }
}
