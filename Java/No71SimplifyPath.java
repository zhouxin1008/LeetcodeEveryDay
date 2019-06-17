import java.util.Stack;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */
class No71SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] sub = path.split("/");
        for(int i=0; i<sub.length; i++){
            String subPath = sub[i];
            if(subPath.equals(".")){
                continue;
            }
            if(subPath.equals("..")){
                if(!stack.isEmpty()) stack.pop();
                continue;
            }
            if(subPath.length()>0){
                stack.push(subPath);
            }
            
        }
        if(stack.isEmpty()) return "/";
        String res = "/"+stack.pop();
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}

