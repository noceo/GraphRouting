package src;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

class Main {
  public static void main(String[] args) {
    int vertexCount = 5000;
    int randomSTCount = 5;
    long startTime;
    long estimatedTime;
    startTime  = System.nanoTime();
    List<List<Vertex>> graph1 = RGG.averageDegree(vertexCount, 6, 1, 10);
    estimatedTime = System.nanoTime() - startTime;
    System.out.println("Milliseconds elsapsed for average degree 6: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS));
    
    // startTime  = System.nanoTime();
    // List<List<Vertex>> graph2 = RGG.averagePercentage(vertexCount, 0.2f, 1, 10);
    // estimatedTime = System.nanoTime() - startTime;
    // System.out.println("Milliseconds elsapsed for average percentage 20%: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS));
    int[] randSTPair = Utils.randomPair(0, vertexCount);
    Routing.dijkstra_naive(graph1, randSTPair[0], randSTPair[1]);


    // MaxHeap heap = new MaxHeap(9);

    // Inserting nodes
    // Custom inputs
    // for (int i = 0; i < heap.getMaxSize(); i++) {
    //   int rand = ThreadLocalRandom.current().nextInt(0, 100);
    //   heap.insert(i, rand);
    // }
    // heap.print();
    
    // Generate random graph pairs
  //   List<List<List<List<Vertex>>>> graphPairs = new ArrayList<>();
  //   for (int i = 0; i < 5; i++) {
  //     List<List<Vertex>> averageDegreeGraph = RGG.averageDegree(5000, 6, 1, 10);
  //     List<List<Vertex>> averagePercentageGraph = RGG.averagePercentage(5000, 0.2f, 0, 10);
  //     List<List<List<Vertex>>> graphPair = new ArrayList<>();
  //     graphPair.add(averageDegreeGraph);
  //     graphPair.add(averagePercentageGraph);
  //     graphPairs.add(graphPair);
  //   }

  //   // Run routing algorithms on the random graph pairs 
  //   // (each graph five times with randomly selected start and endf vertices)
  //   System.out.println(graphPairs.size());
  //   int[] randSTPair;
  //   for (int i = 0; i < graphPairs.size(); i++) {
  //     List<List<List<Vertex>>> pair = graphPairs.get(i);
  //     List<List<Vertex>> averageDegreeGraph = pair.get(0);
  //     List<List<Vertex>> averagePercentageGraph = pair.get(1);
  //     System.out.println(String.format("---------------- Graph Pair %d ----------------", i+1));

  //     // for (int j = 0; j < randomSTCount; j++) {
  //     //   randSTPair= Utils.randomPair(0, vertexCount);
        
  //     //   startTime  = System.nanoTime();
  //     //   Routing.dijkstra_naive(averageDegreeGraph, randSTPair[0], randSTPair[1]);
  //     //   estimatedTime = System.nanoTime() - startTime;
  //     //   System.out.println("Milliseconds elsapsed for DIJKSTRA_NAIVE on average degree graph: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS));
    
  //     //   startTime  = System.nanoTime();
  //     //   Routing.dijkstra_heap(averageDegreeGraph, randSTPair[0], randSTPair[1]);
  //     //   estimatedTime = System.nanoTime() - startTime;
  //     //   System.out.println("Milliseconds elsapsed for DIJKSTRA_HEAP on average degree graph: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS));
    
  //     //   startTime  = System.nanoTime();
  //     //   Routing.kruskal(averageDegreeGraph, randSTPair[0], randSTPair[1]);
  //     //   estimatedTime = System.nanoTime() - startTime;
  //     //   System.out.println("Milliseconds elsapsed for KRUSKAL on average degree graph: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS));
  //     // }

  //     // for (int j = 0; j < randomSTCount; j++) {
  //     //   randSTPair= Utils.randomPair(0, vertexCount);
        
  //     //   startTime  = System.nanoTime();
  //     //   Routing.dijkstra_naive(averagePercentageGraph, randSTPair[0], randSTPair[1]);
  //     //   estimatedTime = System.nanoTime() - startTime;
  //     //   System.out.println("Milliseconds elsapsed for DIJKSTRA_NAIVE on average percentage graph: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS));
    
  //     //   startTime  = System.nanoTime();
  //     //   Routing.dijkstra_heap(averagePercentageGraph, randSTPair[0], randSTPair[1]);
  //     //   estimatedTime = System.nanoTime() - startTime;
  //     //   System.out.println("Milliseconds elsapsed for DIJKSTRA_HEAP on average percentage graph: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS));
    
  //     //   startTime  = System.nanoTime();
  //     //   Routing.kruskal(averagePercentageGraph, randSTPair[0], randSTPair[1]);
  //     //   estimatedTime = System.nanoTime() - startTime;
  //     //   System.out.println("Milliseconds elsapsed for KRUSKAL on average percentage graph: " + TimeUnit.MILLISECONDS.convert(estimatedTime, TimeUnit.NANOSECONDS));
  //     // }
  //     System.out.println(String.format("------------------ Graph Pair %d End ----------------", i+1));
  //   }
  // }
}