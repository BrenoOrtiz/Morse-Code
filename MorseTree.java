import java.util.Scanner;

public class MorseTree {
    private No raiz;

    public MorseTree() {
        raiz = new No('\0');
        construirArvore();
    }


    public void inserir(String codigoMorse, char caractere) {
        No atual = raiz;
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new No('\0');
                }
                atual = atual.esquerda;
            } else if (simbolo == '-') {
                if (atual.direita == null) {
                    atual.direita = new No('\0');
                }
                atual = atual.direita;
            }
        }
        atual.valor = caractere;
    }
    private void construirArvore() {

        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');
    }

    public String decodificar(String codigoMorse) {
        StringBuilder resultado = new StringBuilder();
        String[] letrasMorse = codigoMorse.split(" ");
        for (String letra : letrasMorse) {
            resultado.append(decodificarLetra(letra));
        }
        return resultado.toString();
    }

    private char decodificarLetra(String codigoMorse) {
        No atual = raiz;
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                atual = atual.esquerda;
            } else if (simbolo == '-') {
                atual = atual.direita;
            }
            if (atual == null) {
                return '?';
            }
        }
        return atual.valor;
    }


    public void imprimirArvore() {
        imprimirArvore(raiz, 0);
    }


    private void imprimirArvore(No no, int profundidade) {
        if (no != null) {
            imprimirArvore(no.direita, profundidade + 1);
            if (no.valor != '\0') {
                System.out.println(" ".repeat(profundidade * 4) + no.valor);
            } else {
                System.out.println(" ".repeat(profundidade * 4) + "*");
            }
            imprimirArvore(no.esquerda, profundidade + 1);
        }
    }

    public static void main(String[] args) {
        MorseTree morseTree = new MorseTree();


        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira a palavra em código Morse (separado por espaços): ");
        String codigoMorse = scanner.nextLine();

        String resultado = morseTree.decodificar(codigoMorse);
        System.out.println("Palavra decodificada: " + resultado);


        System.out.println("Árvore Binária de Código Morse:");
        morseTree.imprimirArvore();

        scanner.close();
    }
}
