/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BinaryTree
 * Author:   王小手
 * Date:     2019/11/21 17:08
 * Description: 二叉树
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sh.tree;

/**
 * 〈一句话功能简述〉<br> 
 * 〈二叉树〉
 *
 * @author
 * @create 2019/11/21
 * @since 1.0.0
 */
public class BinaryTree {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTrees binaryTree = new BinaryTrees();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrders();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

    }
}

//定义BinaryTree二叉树
class BinaryTrees{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除结点
    public void delNode(int no){
        if (root!=null){
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if (root.getNo()==no){
                root=null;
            }else{
                //递归删除
                root.delNode(no);
            }
        }else{
            System.out.println("空树，无法删除~~~");
        }
    }
    //前序遍历
    public void preOrders(){
        if (this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if(root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }
    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}

//先创建HeroNode结点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

    //编写前序遍历的方法
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //递归删除结点
    //1.如果删除的节点是叶子节点，则删除该节点
    //2.如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no){
        //思路
		/*
		 * 	1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
			2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
			3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
			4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
			5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.

		 */
		if (this.left!=null && this.left.no==no){
		    this.left=null;
		    return;
        }
		if (this.right!=null && this.right.no==no){
		    this.right=null;
		    return;
        }
		if (this.left!=null){
		    this.left.delNode(no);
        }
		if (this.right!=null){
		    this.right.delNode(no);
        }
    }

    //前序遍历查找
    /**
     *
     * @param no 查找no
     * @return 如果找到就返回该Node ,如果没有找到返回 null
     */
    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序遍历查找");
        if (this.no==no){
            return this;
        }
        //1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到结点，则返回
        HeroNode resNode=null;
        if (this.left!=null){
            resNode=this.left.preOrderSearch(no);
        }
        if (resNode!=null){//说明我们左子树找到
            return resNode;
        }
        //1.左递归前序查找，找到结点，则返回，否继续判断，
        //2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if (this.right!=null){
            resNode=this.right.preOrderSearch(no);
        }
        return resNode;
    }
    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode=null;
        if (this.left!=null){
            resNode=this.left.infixOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        System.out.println("进入中序遍历查找");
        //如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        if (this.no==no){
            return this;
        }
        //否则继续进行右递归的中序查找
        if (this.right!=null){
            resNode=this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode=null;
        if (this.left!=null){
            resNode=this.left.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode=this.right.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        System.out.println("进入后序遍历查找");
        //如果左右子树都没有找到，就比较当前结点是不是
        if (this.no==no){
            return this;
        }
        return resNode;
    }

}