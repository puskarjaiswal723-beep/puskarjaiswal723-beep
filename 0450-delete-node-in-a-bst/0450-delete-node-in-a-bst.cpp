/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* del(TreeNode* root,int key){
        if(root==nullptr){
            return root;
        }
        if(root->val>key){
            root->left=del(root->left,key);
            return root;
        }
        else if(root->val<key){
            root->right=del(root->right,key);
            return root;
        }
        else{
            if(root->left==nullptr && root->right==nullptr){
                return nullptr;
            }
            else if(root->left==nullptr){
                return root->right;
            }
            else if(root->right==nullptr){
                return root->left;
            }
            else{
                TreeNode* curr=root->right;
                while(curr->left!=nullptr){
                    curr=curr->left;
                }
                root->val=curr->val;
                root->right=del(root->right,curr->val);
                return root;
            }
        }
    return root;}
    TreeNode* deleteNode(TreeNode* root, int key) {
         return del(root,key);
         
    }
};