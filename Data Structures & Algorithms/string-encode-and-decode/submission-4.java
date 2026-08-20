class Solution {

    public String encode(List<String> strs) {
        if (strs.size() != 0) {
            String result = "";

            for (int i = 0, n = strs.size(); i < n - 1; i++) {
                String s = strs.get(i);
                for (char c : s.toCharArray()) {
                    result += String.format("%03d", (int) c);
                }

                result += " ";
            }

            for (char c : strs.get(strs.size() - 1).toCharArray()) {
                result += String.format("%03d", (int) c);
            }

            return result;
        }
        else {
            return null;
        }
    }

    public List<String> decode(String str) {
        if (str != null) {
            List<String> result = new ArrayList<>();
            for (String s : str.split(" ", -1)) {
                String element = "";

                for (int i = 0, n = s.length() - 2; i < n; i+=3) {
                    String asciiString = s.substring(i, i + 3);;
                    int ascii = Integer.parseInt(asciiString);
                    element += (char) ascii;
                }

                result.add(element);
            }

            return result;
        } else {
            return new ArrayList<>();
        }
    }
}
