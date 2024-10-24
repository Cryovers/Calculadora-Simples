package org.calculadora;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] operacoes = {"soma", "subtração", "multiplicação", "divisão"};

        do {
            try {
                System.out.println("Digite o PRIMEIRO número:");
                double numero1 = scanner.nextDouble();

                System.out.println("Digite um SEGUNDO número:");
                double numero2 = scanner.nextDouble();

                scanner.nextLine();
                System.out.println("Digite o nome da operação que deseja fazer entre:");
                for (String operacao : operacoes) {
                    System.out.println(operacao);
                }

                String operacao = scanner.nextLine();

                double resultado;

                switch (operacao.toLowerCase()) {
                    case "soma":
                        resultado = numero1 + numero2;
                        break;
                    case "subtracao":
                    case "subtração":
                        resultado = numero1 - numero2;
                        break;
                    case "multiplicacao":
                    case "multiplicaçao":
                        resultado = numero1 * numero2;
                        break;
                    case "divisao":
                    case "divisão":
                        resultado = numero1 / numero2;
                        break;
                    default:
                        System.out.println("ERRO: Voce deve escolher uma operacao!");
                        continue;
                }


                if(resultado == (int) resultado) {
                    System.out.println("O resultado é: " + (int) resultado);
                } else {
                    System.out.println("O resultado é: " + resultado);
                }

                System.out.print("Deseja fazer outro cálculo ? (sim ou não): ");
                String opcao = scanner.nextLine();

                if(opcao.equals("sim")) {
                    continue;
                }  if (opcao.equals("nao") || opcao.equals("não")) {
                    break;
                } else {
                    System.out.println("Digite uma opção válida!");
                }

            } catch (InputMismatchException e) {
                System.out.println("ERRO: Voce deve digitar o tipo de dado pedido!");
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("ERRO: Nenhum dado foi digitado, favor digitar o dado pedido");
                scanner.nextLine();
            } catch (IllegalStateException e) {
                System.out.println("ERRO: Scanner Fechado");
                scanner.nextLine();
            }
        } while (true);

        scanner.close();
        System.out.println("Calculadora Encerrada");
    }
}