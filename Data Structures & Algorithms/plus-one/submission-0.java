class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 1;

        List<Integer> temp = new ArrayList<>();

        for (int i = digits.length - 1; i >= 0; i--) {
            
            if (carry == 1) {
                carry--;
                int sum = digits[i] + 1;

                if (sum == 10) {
                    carry++;
                }

                temp.add(0, sum % 10);
                continue;
            }

            temp.add(0, digits[i]);
        }

        if (carry == 1) {
            temp.add(0, 1);
        }

        int[] res = new int[temp.size()];

        for (int i = 0, n = res.length; i < n; i++) {
            res[i] = temp.get(i);
        }

        return res;
    }
}
