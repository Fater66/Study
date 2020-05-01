package Amazon;

import java.util.*;

public class TopNBuzzwords {
    public static void main(String[] args) {
        System.out.println(
                topToys(6, 2, new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"}, 6,
                        new String[]{
                                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                                "The new Elmo dolls are super high quality",
                                "Expect the Elsa dolls to be very popular this year, Elsa!",
                                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                                "For parents of older kids, look into buying them a drone",
                                "Warcraft is slowly rising in popularity ahead of the holiday season"
                        }));
    }

    public static List<String> topToys(int numToys, int topToys, String[] toys, int numQuotes,
                                       String[] quotes) {
        Map<String, int[]> freq = new HashMap<>();
        for (String toy : toys) {
            freq.put(toy, new int[]{0, 0});
        }

        for (String quote : quotes) {
            //used 代表当前行有过了 如果没有 nums[1]++也就是代表这个词在多少行quote中出现的.
            Set<String> used = new HashSet<>();

            String[] words = quote.split("\\W+");
            for (String word : words) {
                String wordLc = word.toLowerCase();
                if (!freq.containsKey(wordLc)) {
                    continue;
                }

                int[] nums = freq.get(wordLc);

                nums[0]++;
                if (!used.contains(wordLc)) {
                    nums[1]++;
                }

                used.add(wordLc);
            }
        }

        //利用pq，排序方法是优先排列次数 次数一样则比较在多少quote中出现
        PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) -> {
            if (freq.get(t1)[0] != freq.get(t2)[0]) {
                return freq.get(t1)[0] - freq.get(t2)[0];
            }

            if (freq.get(t1)[1] != freq.get(t2)[1]) {
                return freq.get(t1)[1] - freq.get(t2)[1];
            }

            return t2.compareTo(t1);
        });

        if (topToys > numToys) {
            for (String toy : freq.keySet()) {
                if (freq.get(toy)[0] > 0) {
                    pq.add(toy);
                }
            }
        } else {
            for (String toy : toys) {
                pq.add(toy);

                if (pq.size() > topToys) {
                    pq.poll();
                }
            }
        }

        List<String> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            output.add(pq.poll());
        }

        Collections.reverse(output);

        return output;
    }
}
