package me.dvsgn.test;

import java.util.*;

class FlightOptimizer {
    public static List<Long> getOptimalFlightRates(int flightNodes, List<Integer> flightFrom, List<Integer> flightTo,
                                                   List<Integer> flightWeight, List<List<Integer>> queries) {
        // 1. 그래프 생성
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < flightFrom.size(); i++) {
            int from = flightFrom.get(i);
            int to = flightTo.get(i);
            int weight = flightWeight.get(i);
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, weight});
        }

        // 2. 각 쿼리에 대해 최단 경로 계산
        List<Long> results = new ArrayList<>();
        System.out.println(results);
        for (List<Integer> query : queries) {
            int start = query.get(0);
            int end = query.get(1);
            int maxStops = query.get(2); // 경유 제한 횟수
            long shortestPath = bfsWithMaxStops(flightNodes, graph, start, end, maxStops);
            results.add(shortestPath);
        }

        return results;
    }

    private static long bfsWithMaxStops(int flightNodes, Map<Integer, List<int[]>> graph, int start, int end, int maxStops) {
        // BFS 초기화
        Queue<int[]> queue = new LinkedList<>(); // {currentNode, currentCost, stopsUsed}
        queue.offer(new int[]{start, 0, 0});

        long[] minCost = new long[flightNodes];
        Arrays.fill(minCost, Long.MAX_VALUE);
        minCost[start] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int cost = current[1];
            int stops = current[2];

            // 경유 제한을 초과한 경우 무시
            if (stops > maxStops) continue;

            // 인접 노드 탐색
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int edgeWeight = neighbor[1];
                    long newCost = cost + edgeWeight;

                    // 최소 비용 업데이트
                    if (newCost < minCost[nextNode] && stops <= maxStops) {
                        minCost[nextNode] = newCost;
                        queue.offer(new int[]{nextNode, (int) newCost, stops + 1});
                    }
                }
            }
        }

        return minCost[end] == Long.MAX_VALUE ? -1 : minCost[end];
    }

    public static void main(String[] args) {
        // 예제 입력
        int flightNodes = 5;
        List<Integer> flightFrom = Arrays.asList(0, 1, 2, 2, 0, 2, 4);
        List<Integer> flightTo = Arrays.asList(1, 2, 3, 0, 2, 4, 2);
        List<Integer> flightWeight = Arrays.asList(100, 150, 70, 300, 400, 200, 120);
        List<List<Integer>> queries = Arrays.asList(
                Arrays.asList(0, 4, 2), // 최대 2회 경유
                Arrays.asList(0, 3, 1), // 최대 1회 경유
                Arrays.asList(1, 3, 0)  // 경유 불가
        );

        List<Long> results = getOptimalFlightRates(flightNodes, flightFrom, flightTo, flightWeight, queries);
        System.out.println(results); // [450, 470, -1]
    }
}