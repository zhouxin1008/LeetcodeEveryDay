import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */
class No68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        Map<Integer, List<String>> lines = new HashMap<>();
        Map<Integer, Integer> lineCharCount = new HashMap<>();
        List<String> res = new ArrayList<>();
        int lineIndex = 0;
        int charCount = 0;
        List<String> line = new ArrayList<>();
        for(String word : words) {
            if(charCount + word.length() + line.size() > maxWidth) {
                lines.put(lineIndex, line);
                lineCharCount.put(lineIndex, charCount);
                lineIndex++;
                charCount = word.length();
                line = new ArrayList<>();
            } else {
                charCount = charCount + word.length();
            }
            line.add(word);
        }
        lines.put(lineIndex, line);
        lineCharCount.put(lineIndex, charCount);
        for(int i=0; i<=lineIndex; i++) {
            int wordsNum = lines.get(i).size();
            String[] wordsInLine = lines.get(i).toArray(new String[wordsNum]);
            int chars = lineCharCount.get(i);
            if(wordsNum == 1){
                res.add(wordsInLine[0]+getEmptyString(maxWidth-chars));
            }else if(i!=lineIndex){
                int space = maxWidth-chars;
                int p = 0;
                while(space > 0) {
                    space--;
                    wordsInLine[p] = wordsInLine[p] + " ";
                    p++;
                    if(p == wordsNum-1) p = 0;
                }
                res.add(Arrays.asList(wordsInLine).stream().reduce((a,b) -> a+b).get());
            } else {
                res.add(Arrays.asList(wordsInLine).stream().reduce((a,b) -> a+" "+b).get() + 
                getEmptyString(maxWidth-chars-wordsNum+1));
            }
        }
        return res;
    }

    private String getEmptyString(int len){
        StringBuffer sb = new StringBuffer();
        while(len > 0) {
            len--;
            sb.append(" ");
        }
        return sb.toString();
    }
}

