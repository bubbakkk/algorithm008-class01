
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root,res);
            return res;

        }
        public void helper(TreeNode node,List<Integer> res) {
            if(node==null) return;
            helper(node.left,res);
            res.add(node.val);
            helper(node.right,res);
        }
    }

