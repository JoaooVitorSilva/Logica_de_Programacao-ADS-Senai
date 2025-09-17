package br.com.senai.Modulo3;

import java.util.Arrays;
import java.util.Random;

public class AlgoritmosOrdenacao {
    public static void main(String[] args) {
        // Criar array aleatório para testes
        int[] numeros = gerarArrayAleatorio(10);

        System.out.println("Array original:");
        mostrarArray(numeros);

        // Teste Bubble Sort
        int[] arrayBubble = Arrays.copyOf(numeros, numeros.length);
        long inicio = System.nanoTime();
        bubbleSort(arrayBubble);
        long fim = System.nanoTime();
        System.out.println("\nBubble Sort:");
        mostrarArray(arrayBubble);
        System.out.println("Tempo: " + (fim - inicio) / 1000000.0 + " ms");

        // Teste Selection Sort
        int[] arraySelection = Arrays.copyOf(numeros, numeros.length);
        inicio = System.nanoTime();
        selectionSort(arraySelection);
        fim = System.nanoTime();
        System.out.println("\nSelection Sort:");
        mostrarArray(arraySelection);
        System.out.println("Tempo: " + (fim - inicio) / 1000000.0 + " ms");

        // Teste com array nativo do Java
        int[] arrayNativo = Arrays.copyOf(numeros, numeros.length);
        inicio = System.nanoTime();
        Arrays.sort(arrayNativo);
        fim = System.nanoTime();
        System.out.println("\nArrays.sort() nativo:");
        mostrarArray(arrayNativo);
        System.out.println("Tempo: " + (fim - inicio) / 1000000.0 + " ms");
    }

    private static int[] gerarArrayAleatorio(int tamanho) {
        Random random = new Random();
        int[] array = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    private static void mostrarArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Bubble Sort - O(n²)
    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean houveTroca;

        for (int i = 0; i < n - 1; i++) {
            houveTroca = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    houveTroca = true;
                }
            }

            // Se não houve troca, o array já está ordenado
            if (!houveTroca) {
                break;
            }
        }
    }

    // Selection Sort - O(n²)
    private static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int menorIndice = i;

            // Encontrar o menor elemento no restante do array
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[menorIndice]) {
                    menorIndice = j;
                }
            }

            // Trocar o menor elemento com o primeiro elemento não ordenado
            if (menorIndice != i) {
                int temp = array[i];
                array[i] = array[menorIndice];
                array[menorIndice] = temp;
            }
        }
    }
}