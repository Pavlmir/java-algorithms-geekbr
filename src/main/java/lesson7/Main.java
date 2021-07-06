package lesson7;

public class Main {
    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {
        Graph graph = new Graph();

        task71(); // Приведите пример графа.
        task72(graph); // Реализуйте базовые методы графа.
        task73(graph); // добавьте реализацию метода обхода в глубину
        task74(graph); // добавьте метод обхода в ширину.
    }

    private static void task71() {
        /*
        Схемы путей
        Генеалогическое древо
        Карты дорог
        Планирование строительства
         */
    }

    private static void task72(Graph graph) {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");

        for (int i = 0; i < graph.getSize(); i++) {
            System.out.print(i + ":");
            graph.displayVertex(i);
        }
        System.out.println("*****************");

        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(6, 7);
    }

    private static void task73(Graph graph) {
        startTime = System.nanoTime();
        graph.depthFirstTraversal(0);
        endTime = System.nanoTime() - startTime;
        System.out.println("Обход графа в глубину занял " + endTime + " нс");
        System.out.println("*****************");
    }

    private static void task74(Graph graph) {
        startTime = System.nanoTime();
        graph.widthFirstTraversal(0);
        endTime = System.nanoTime() - startTime;
        System.out.println("Обход графа в ширину занял " + endTime + " нс");
    }
}
