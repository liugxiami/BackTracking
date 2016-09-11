package com.ccsi;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        List<List<TreeNode>> bag=new ArrayList<>();
        Stack<TreeNode> path=new Stack<>();
        TreeNode root=buildTree();
        BT(bag,path,root);
        for (int i = 0; i < bag.size(); i++) {
            for (int j = 0; j < bag.get(i).size(); j++) {
                System.out.println(bag.get(i).get(j).val);
            }
            System.out.println("========");
        }
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        return root;
    }

    public static void BT(List<List<TreeNode>> bag,Stack<TreeNode> path,TreeNode curr){
        path.push(curr);
            if(curr.left==null&&curr.right==null){
                List<TreeNode> list=new ArrayList<>(path);
                bag.add(list);
            }else{
                if(curr.left!=null)BT(bag,path,curr.left);
                if(curr.right!=null)BT(bag,path,curr.right);
            }
        path.pop();
    }
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
