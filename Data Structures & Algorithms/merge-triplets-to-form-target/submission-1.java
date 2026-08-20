class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        for (int i = 0, n = target.length; i < n; i++) {
            boolean found = false;

            if (i == 0) {
                for (int[] triplet : triplets) {
                    if (triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                        found = true;
                    }
                }
            }

            else if (i == 1) {
                for (int[] triplet : triplets) {
                    if (triplet[0] <= target[0] && triplet[1] == target[1] && triplet[2] <= target[2]) {
                        found = true;
                    }
                }
            }

            else {
                for (int[] triplet : triplets) {
                    if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] == target[2]) {
                        found = true;
                    }
                }
            }

            if (!found) return false;
        }

        return true;
    }
}
