package tao;

public class Morris {
    public static void morris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode mr = cur.left;
                while (mr.right != null && mr.right != cur) {
                    mr = mr.right;
                }
                if (mr.right == cur) {
                    cur = cur.right;
                    mr.right = null;
                } else {
                    mr.right = cur;
                    cur = cur.left;
                }
            } else {
                cur = cur.right;
            }
        }
    }

    public static void morrisPre(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode mr = cur.left;
                while (mr.right != null && mr.right != cur) {
                    mr = mr.right;
                }
                if (mr.right == cur) {
                    cur = cur.right;
                    mr.right = null;
                } else {
                    mr.right = cur;
                    System.out.println(cur.value);
                    cur = cur.left;
                }
            } else {
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }

    public static void morrisIn(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode mr = cur.left;
                while (mr.right != null && mr.right != cur) {
                    mr = mr.right;
                }
                if (mr.right == cur) {
                    System.out.println(cur.value);
                    cur = cur.right;
                    mr.right = null;
                } else {
                    mr.right = cur;
                    cur = cur.left;
                }
            } else {
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }

    public static void morrisAfter(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode mr = cur.left;
                while (mr.right != null && mr.right != cur) {
                    mr = mr.right;
                }
                if (mr.right == null) {
                    mr.right = cur;
                    cur = cur.left;
                } else {
                    mr.right = null;
                    niPrintLeftTreeRight(cur.left);
                    cur = cur.right;
                }
            } else {
                cur = cur.right;
            }
        }
        niPrintLeftTreeRight(root);
    }

    private static void niPrintLeftTreeRight(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode head = reversePrintTree(root);
        TreeNode cur = head;
        while (cur != null) {
            System.out.print(cur.value+"\t");
            cur = cur.right;
        }
        reversePrintTree(head);
    }

    private static TreeNode reversePrintTree(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        TreeNode pre = null;
        TreeNode cur = root;
        TreeNode temp = null;
        while (cur != null) {
            temp = cur.right;
            cur.right = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        n5.left = n6;
        n6.left = n9;
        n6.right = n10;
        n5.right = n8;
        n8.left = n11;
        TreeOperation.show(n5);
        morrisAfter(n5);
//        niPrintLeftTreeRight(n5);
    }
}
