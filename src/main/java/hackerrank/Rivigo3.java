package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by vivek.pathak on 31/05/16.
 */
public class Rivigo3 {

    public static void main(String[] args) {

    }


    public class Vertex {
        List<Edge> edges;

        @Override
        public boolean equals(final Object object) {
            if (this == object) {
                return true;
            }

            if (object == null || getClass() != object.getClass()) {
                return false;
            }

            final Vertex vertex = (Vertex) object;

            return edges.equals(vertex.edges);
        }

        @Override
        public int hashCode() {
            return edges.hashCode();
        }

        protected Vertex clone() throws CloneNotSupportedException {
            final Vertex vertex = (Vertex) super.clone();
            final List<Edge> edges = new ArrayList<>();
            for (final Edge edge : edges) {
                edges.add(edge.clone());
            }
            vertex.edges = edges;
            return vertex;
        }
    }

    public class Edge {
        Vertex v1;
        Vertex v2;
        int weight;

        protected Edge clone() throws CloneNotSupportedException {
            final Edge edge = (Edge) super.clone();
            edge.v1 = v1.clone();
            edge.v2 = v2.clone();
            return edge;
        }
    }

    public class Graph {

        List<Vertex> vertices;

        int totalVertices() {
            final Set<Vertex> vertexSet = new HashSet<>(vertices);
            return vertexSet.size();
        }

        int totalEdges() {
            final Map<Vertex, List<Vertex>> vertexConnectedMap = new HashMap<>();
            for (final Vertex vertex : vertices) {
                for (final Edge edge : vertex.edges) {
                    if (vertexConnectedMap.containsKey(edge.v1)) {
                        final List<Vertex> list = vertexConnectedMap.get(edge.v1);
                        list.add(edge.v2);
                        vertexConnectedMap.put(edge.v1, list);
                        continue;
                    }

                    final List<Vertex> list = new ArrayList<>();
                    list.add(edge.v2);
                    vertexConnectedMap.put(edge.v1, list);
                }
            }

            int res = 0;
            for (final List<Vertex> list : vertexConnectedMap.values()) {
                res += list.size();
            }

            return res;
        }

        protected Graph clone() throws CloneNotSupportedException {
            final List<Vertex> vertexes = new ArrayList<>();
            for (final Vertex vertex : vertices) {
                final Vertex newVertex = vertex.clone();
                vertexes.add(newVertex);
            }

            final Graph clonedGraph = new Graph();
            clonedGraph.vertices = vertexes;
            return clonedGraph;
        }
    }
}
