public class word_ladder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || !wordList.contains(endWord)) return 0;
            int count = 0;
            boolean [] visited = new boolean[wordList.size()];
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            while (!queue.isEmpty()) {
                int size = queue.size();
                count++;
                for (int i = 0 ; i < size ; i++) {
                    String poll = queue.poll();
                    for (int j = 0 ; j < wordList.size() ; j++) {
                        if (visited[j]) {
                            continue;
                        }
                        if (!canConvert(poll , wordList.get(j))) {
                            continue;
                        }
                        if (endWord.equals(wordList.get(j))) {
                            return count + 1;
                        }
                        visited[j] = true;
                        queue.add(wordList.get(j));
                    }
                }
            }
            return 0;
        }
        public boolean canConvert(String poll , String s) {
            int count = 0;
            for (int i = 0 ; i < poll.length() ; i++) {
                if (poll.charAt(i) != s.charAt(i)) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
            return count == 1;
        }
    }
}
