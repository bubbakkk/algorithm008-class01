学习笔记
递归总结：
    步骤：1）找重复
               2）写出递推公式
               3）设定终止条件

递归模版：
    1）操作某一具体变量，例如要返回一个int型的变量：
        声明全局变量
            helper(    )
            return 全局变量
        helper(){}

树的递归：
    本质上在于如何去访问和操作每一个节点
    合并二叉树：
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            //处理当前节点
            if (t1 == null) return t2;
            if (t2 == null) return t1;
            t1.val+=t2.val;
            //对当前节点进行递归操作
            t1.left = mergeTrees(t1.left , t2.left);
            t1.right = mergeTrees(t1.right , t2.right);
            return t1;
        }
    }
    二叉树的直径（递归模版+利用递归访问每个结点）
    class Solution {
        int res = 0;//先声明全局变量，然后进行操作
        public int diameterOfBinaryTree(TreeNode root) {
            helper(root);//将需要处理的数据作为input放入递归
            return res;
        }
        public int helper(TreeNode node) {
            //递归终止条件
            if (node == null) {
                return 0;
            }
            //操作当前结点并取得左右子树直径
            int left = helper(node.left);
            int right = helper(node.right);
            res = Math.max(res , left + right);
            return Math.max(left , right) + 1; 
        }
    }
回溯：
    在我的理解中，回溯就是去尝试每一种可能的情况，如果正确继续进行，如果错误，尝试同层的其他情况
        N皇后（递归模版+回溯思想）
        class Solution {
            List<List<String>> res = new ArraryList<>();//作为output的全局变量
            public List<List<String>> solveNQueens(int n) {
                int [][] ans = int [n][n];
                dfs(n,0,ans);
                return res;
            }
            public void dfs(int n , int row, int[][]ans) {
                //终止条件
                if(n==row) {
                    res.add()
                }
                //for循环来对当前一行的每一列进行逐个测试
                for(int column=0; column<n-1; column++) {
                    //如果当前尝试符合结果，进入到下一row
                    if(isOk(row,column,ans)) {
                        ans[row][column]=1;
                        dfs(n,row+1,ans);//用递归进行row的改变
                    }
                    //当前情况不符合，置0，继续for循环当前row
                    ans[row][column]=0;
                }
            }
            public boolean isOk(int row, int column, int[][]ans) {
                int leftup=column-1;
                int rightup=column+1;
                for(int i = row-1; i>=0; i--) {
                    if(ans[i][leftup]==1&&leftup>=0) return false;
                    if(ans[i][rightup]==1&&rightup<=ans.length) return false;
                    if(ans[i][column]==1) return false;
                    leftup--;
                    rightup++;
                }
                return true;
            }
            


        }
