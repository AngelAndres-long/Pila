public class Pila<T> {
    private T[] pila;
    private int tope;

    // Constructor vacío con capacidad de 10
    public Pila() {
        pila = (T[]) new Object[10];
        tope = -1;
    }

    // Constructor que recibe la capacidad
    public Pila(int capacidad) {
        if (capacidad < 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }
        pila = (T[]) new Object[Math.max(capacidad, 1)];
        tope = -1;
    }

    public void push(T dato) {
        if (llena()) {
            System.out.println("Desbordamiento");
        } else {
            tope++;
            pila[tope] = dato;
        }
    }

    public T pop() {
        if (vacia()) {
            System.out.println("SubDesbordamiento");
            return null;
        } else {
            T dato = pila[tope];
            tope--;
            return dato;
        }
    }

    public T cima() {
        if (vacia()) {
            return null;
        }
        return pila[tope];
    }

    public boolean llena() {
        return tope == pila.length - 1;
    }

    public boolean vacia() {
        return tope == -1;
    }

    // 3. Invertir cadena
    public String invierteCadena(String cadena) {
        Pila<Character> pila = new Pila<>(cadena.length());

        for (int i = 0; i < cadena.length(); i++) {
            pila.push(cadena.charAt(i));
        }

        String inversa = "";
        while (!pila.vacia()) {
            inversa += pila.pop();
        }
        return inversa;
    }

    // 4. Revisar sintaxis de {[()]} (ahora ignora números, operadores, etc.)
    public boolean revisarSintaxis(String cadena) {
        Pila<Character> pila = new Pila<>(cadena.length());

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);

            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pila.push(caracter);
            } else if (caracter == ')' || caracter == ']' || caracter == '}') {
                if (pila.vacia()) {
                    return false;
                }
                char abierto = pila.pop();

                if (caracter == ')' && abierto != '(') return false;
                if (caracter == ']' && abierto != '[') return false;
                if (caracter == '}' && abierto != '{') return false;
            }
            // cualquier otro carácter se ignora
        }
        return pila.vacia();
    }

    // 5. Ordenar un vector de enteros usando pilas
    public Pila<Integer> ordenar(int[] vector) {
        Pila<Integer> entrada = new Pila<>(vector.length);
        Pila<Integer> auxiliar = new Pila<>(vector.length);

        // Cargar el vector en la pila de entrada
        for (int num : vector) {
            entrada.push(num);
        }

        // Ordenamiento con pila auxiliar
        while (!entrada.vacia()) {
            Integer temp = entrada.pop();

            // Mover de auxiliar a entrada mientras el tope de auxiliar sea menor
            while (!auxiliar.vacia() && auxiliar.cima() < temp) {
                entrada.push(auxiliar.pop());
            }
            auxiliar.push(temp);
        }

        // La pila auxiliar queda ordenada: el menor está en la cima
        return auxiliar;
    }
}