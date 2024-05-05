package FinalProject;

import java.util.*;

public class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indexes1 = map.get(word1);
        List<Integer> indexes2 = map.get(word2);
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i < indexes1.size() && j < indexes2.size();) {
            int index1 = indexes1.get(i), index2 = indexes2.get(j);
            minDistance = Math.min(minDistance, Math.abs(index1 - index2));

            if (index1 < index2) {
                i++;
            } else {
                j++;
            }
        }
        return minDistance;
    }
}

