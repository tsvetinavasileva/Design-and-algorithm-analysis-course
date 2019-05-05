import static java.lang.Integer.max;

public class Knapsack {

  static int unboundKnapsack(int W, int V, int [] value, int [] weight){
    int [] uk = new int[W + 1];

    for(int w = 0; w <= W; w++){
      for(int v = 0; v < V; v++){
          if(weight[v] <= w){
            uk[w] = max(uk[w], uk[w - weight[v]] + value[v]);
          }
      }
    }
    return uk[W];
  }

  public static void main(String[] args) {
    int W = 10;
    int value[] = {30,14,16,9};
    int weight[] = {6,3,4,2};
    int V = value.length;
    System.out.println(unboundKnapsack(W,V,value,weight));
  }
}
