class TreeNode {
    Books book;
    TreeNode left;
    TreeNode right;
    int height; // Altura do nó

    public TreeNode(Books book) {
        this.book = book;
        this.left = null;
        this.right = null;
        this.height = 1; // Novo nó tem altura 1
    }
}
