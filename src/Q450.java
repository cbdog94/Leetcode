

public class Q450 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode tmp=root,found=null,prev=null,next=null,prev2=null;
            boolean left=false,left2=false;
            while(tmp!=null){
                if(key==tmp.val) {
                    found = tmp;
                    break;
                }else if(key<tmp.val){
                    prev=tmp;
                    left=true;
                    tmp=tmp.left;
                }else {
                    prev=tmp;
                    left=false;
                    tmp=tmp.right;
                }
            }
            if(found==null){
                return root;
            }
            if(found.left==null){
                next=found.right;
            }else if(found.right==null){
                next=found.left;
            }else{
                next=found.right;
                tmp=found.right;
                while (tmp!=null){
                    prev2=tmp;
                    if(found.left.val<tmp.val){
                        left2=true;
                        tmp=tmp.left;
                    }else{
                        left2=false;
                        tmp=tmp.right;
                    }
                }
                if(left2){
                    prev2.left=found.left;
                }else{
                    prev2.right=found.left;
                }
            }
            if(prev==null){
                return next;
            }else {
                if(left){
                    prev.left=next;
                }else{
                    prev.right=next;
                }
                return root;
            }
        }
    }
}
