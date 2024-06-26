import java.util.ArrayList;
import java.util.List;

class Solution {
    List<TreeNode> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        dfs(root);

        return build(0, list.size() - 1);
    }

    TreeNode build(int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode root = list.get(mid);
        root.left = build(l, mid - 1);
        root.right = build(mid + 1, r);

        return root;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
        root.left = null;
        root.right = null;
    }
}