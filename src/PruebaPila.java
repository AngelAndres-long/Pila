public class PruebaPila {
    public static void main(String[] args) {

        Pila<Integer> pila = new Pila<>();

        // Prueba básica de push/pop
        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println(pila.pop()); // 30
        System.out.println(pila.pop()); // 20
        System.out.println(pila.pop()); // 10
        System.out.println(pila.vacia()); // true

        // 3. Invertir cadena
        System.out.println(pila.invierteCadena("Hola")); // aloH

        // 4. Revisar sintaxis
        System.out.println(pila.revisarSintaxis("{7+[4*(x-y)]}")); // true
        System.out.println(pila.revisarSintaxis("{[()]}"));         // true
        System.out.println(pila.revisarSintaxis("{ [ ( ] } ]"));    // false

        // 5. Ordenar vector
        int[] numeros = {5, 2, 8, 1, 9, 3};
        Pila<Integer> ordenada = pila.ordenar(numeros);

        System.out.print("Pila ordenada (menor a mayor, sacando con pop): ");
        while (!ordenada.vacia()) {
            System.out.print(ordenada.pop() + " ");
        }
        // Imprime: 1 2 3 5 8 9
    }
}