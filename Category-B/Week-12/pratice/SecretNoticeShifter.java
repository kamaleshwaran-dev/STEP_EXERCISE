
class SecretNoticeShifter {
    static String shiftNotice(String text, int k) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' + k) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + k) % 26 + 'A');
            }

            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String text = "Lab at 5 PM";
        int k = 3;

        System.out.println(shiftNotice(text, k));
    }
}

//Complexity:
// Time: O(n)
// Space: O(n)