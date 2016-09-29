
import java.io.BufferedReader;
import java.io.CharConversionException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    

    public TreeNode(int val) {
        this.val = val;

    }

	public TreeNode() {
		// TODO Auto-generated constructor stub
	}

}
public class Main {
	
	
	//@SuppressWarnings("finally")
	//两个堆栈实现队列
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	int node=0;
    	while(!stack1.empty())
    	{
    		stack2.push(stack1.pop());
    	}
    	node=stack2.pop();
    	while(!stack2.empty())
    	{
    		stack1.push(stack2.pop());
    	}
    	return node;
    }
    
    
    //翻转二叉树
    public void Mirror(TreeNode root) {
    	TreeNode temp;
        if(root==null)
        	return;
        else
        {
        	temp=root.left;
        	root.left=root.right;
        	root.right=temp;
        	Mirror(root.left);
        	Mirror(root.right);
        }
    }
    
    public boolean IsBalanced_Solution(TreeNode root) {
        boolean[] balanced={true};
        if(root==null)
        {
            
        }
        else
            {
            GetDepth(root,balanced);
            
        }
        return balanced[0];
    }
    
    public int GetDepth(TreeNode root,boolean [] balanced)
        {
         int left=0;
         int right=0;
         //int height=0;
         if(root==null)
         {
        	 balanced[0]=true;
        	 return 0;
         }
             
        else
            {
            left=GetDepth(root.left,balanced)+1;
            if(balanced[0]==false)
                return 0;
            right=GetDepth(root.right,balanced)+1;
            if(balanced[0]==false)
                return 0;
            if(left-right>1 || right-left>1)
                {
                balanced[0]=false;
                return 0;
            }
            else
                {
                return Math.max(left,right);
            }
            
        }
    }
    //
   //
        public int Sum_Solution(int n) {
            int sum=0;
            sum=(int)(Math.pow(n, 2)+1);
            sum=sum>>1;
            return sum;
        }
        
        
        class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }
        // 找出两个链表中的第一个公共节点
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        	//使用HashMap解决
        	Map<ListNode,Integer> Find=new HashMap<ListNode,Integer>();
        	ListNode cur=pHead1;
        	while(cur!=null)
        	{
        		Find.put(cur, cur.val);
        		cur=cur.next;
        	}
        	cur=pHead2;
        	while(cur!=null)
        	{
        		if(Find.containsValue(cur.val))
        		{
        			return cur;
        		}
        		else
        		{
        			cur=cur.next;
        		}
        	}
    		return null;
        }
    
	public int ReverseString(String filename) throws Exception
	{	
		//文件名
		File file=new File(filename);
		//存放读取到的所有word
		String [] str=new String[100];
		//存放单个的长度，便于筛选
		int [] wlen=new int[100];
		//判断有无访问，便于筛选
		boolean [] visited=new boolean[100];
		//存放临时word
		String temp="";
		int i=0;
		int n=0;//计数
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(file));//读取文件
			while((temp=reader.readLine())!=null)
			{
				
				str[i]=temp;
				wlen[i]=temp.length();
				visited[i]=false;
				i++;
				if(i>=100)
				{
					reader.close();
					throw new Exception("Error: Limited Str[] Size!");
				}	
			}
			//数组中数量为i
			for(int j=0;j<i;j++)
			{
				for(int k=j+1;k<i;k++)
				{
					//当且仅当后面未访问且长度相等时比较
					if(visited[k]==false && (str[k].length()==str[j].length()))
					{
						//进行比较
						if(check(str[j].toCharArray(),str[k].toCharArray()))
						{
							visited[j]=true;
							visited[k]=true;
							n++;
						}
					}
				}
			}
			System.out.println("the number is "+n);
			//reader.close();
			//return n;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			//
			System.out.println(""+e.getMessage());
			e.printStackTrace();
		} finally
		{
			reader.close();
			//return n;
		}
		return n;
		
	}
	
	//判断单个是否为逆序
	boolean check(char [] str1,char [] str2)
	{
		//boolean flag=false;
		int len=str1.length;
		for(int i=0;i<str1.length;i++)
		{
			if(str1[i]!=str2[len-1-i])
			{
				return false;
			}
		}
		return true;
	}
	
	//二叉树链表的打印
	 class Solution {
	    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
	    		//采用队列链表的方式依次进行层次遍历
	    		//需要使用对应的Queue队列来实现
	    		ArrayList<ArrayList<Integer>> result =new ArrayList<ArrayList<Integer>>();
	    		if(pRoot==null)
	    			return result;
	    		//将对应节点保存起来，依次完成层次遍历
	    		Queue<TreeNode> layer=new LinkedList<TreeNode>();
	    		ArrayList<Integer> layerList=new ArrayList<Integer>();
	    		layer.add(pRoot);
	    		int start=0,end=1;
	    		while(!layer.isEmpty())
	    		{
	    			//边将每一层的值和节点取出
	    			//同时对应把下一层的节点输入进去
	    			TreeNode cur=layer.remove();
	    			layerList.add(cur.val);
	    			start++;
	    			//将该节点对应的加入下一层，其实已是下一层的东西
	    			if(cur.left!=null)
	    			{
	    				layer.add(cur.left);
	    			}
	    			if(cur.right!=null)
	    			{
	    				layer.add(cur.right);
	    			}
	    			//表示该层已经遍历结束
	    			if(start==end)
	    			{
	    				//第二次赋值为第二层的长度
	    				//end为每次的长度
	    				end=layer.size();
	    				start=0;
	    				result.add(layerList);
	    				layerList=new ArrayList<Integer>();
	    			}
	    		}
	    	
				return result;
	    			
	    }
	    
	}
	
	
	//二维数组查找
	  public boolean Find(int [][] array,int target) {
		  		int left=0;
		  		int right=0;
		  		int mid=0;
				for(int []row : array)
				{
					if(row[row.length-1]<target && row[0]>target)
						continue;
					else
					{
						//内部可以变换成二分查找
						//设定对应的边界
						left=0;
						right=row.length-1;
						mid=right/2+1;
						while(left<=right)
						{
							//如果是在左边
							if(row[mid]==target)
							{
								return true;
							}
							else if(row[mid]>target)
							{
								right=mid;
								mid=(right-left)/2+1+left;
								
							}
							else
							{
								left=mid+1;
								mid=(right-left)/2+1+left;
							}
						}
					}
				}
				return false;
	
	  }
	
	
//	  public String replaceSpace(StringBuffer str) {
//	    	
//	    }
	
	  //矩形查找
	  public int RectCover(int target) {
		  	//其本质与斐波那契额数列相同
		  	//排除前项
		   if(target==0)
			   return 0;
		   else if(target==1)
			   return 1;
		   else if(target==2)
			   return 2;
		   else
			   return RectCover(target-1)+RectCover(target-2);
			   
		  
	    }
	
class StackTest {

		    
		    Stack<Integer> stest=new Stack<Integer>();
		    int min=0;
		    public void push(int node) {
		    	if(node<=min)
		    	{
		    		min=node;
		    	}
		        stest.push(node);
		    }
		    
		    public void pop() {
		        if(stest.pop()==min)
		        {
		        	min=stest.peek();
		        	 for(int x : stest)
				        {
				        	if(x<=min)
				        		min=x;
				        }
		        }
		       
		    }
		    
		    public int top() {
		    	//peek 不会移除元素
		        return stest.peek();
		    }
		    
		    public int min() {
		        return min;
		    }
		}
	  
//	替换空格
		public String replaceSpace(StringBuffer str) {
//			int i=0;
//			int len=str.length();
//			for(i=0;i<len;i++)
//			{
//				if(str.charAt(i)==' ')
//				{
//					str.deleteCharAt(i);
//					str.
//				}
//			}
			//return str.toString().replaceAll("\\s", "%20");
			//分成两种，重新遍历数组后赋值
			char [] before=str.toString().toCharArray();
			StringBuffer after=new StringBuffer();
			for(int i=0;i<before.length;i++)
			{
				if(before[i]==' ')
				{
					after.append("%20");
				}
				else
				{
					after.append(before[i]);
				}
			}
			return after.toString();
			
			
		}
		
		//连续子数组的最大和
		public int FindGreatestSumOfSubArray(int[] array) {
	        int len=array.length;
	        if(len==0)
	        	return 0;
	        int bef=array[0];
	        int temp=bef;
	        int max=bef;
//	        for(int i=0;i<len;i++)
//	        {
//	        	temp=array[i];
//	        	bef=array[i];
//	        	for(int j=i+1;j<len;j++)
//	        	{
//	        		temp+=array[j];
//	        		//temp+=i;
//		        	if(temp>bef)
//		        		bef=temp;
//	        	}
//	        	if(bef>max)
//	        	{
//	        		max=bef;
//	        	}
//	        	
//	        }
//	        return max;
	        
	        //采用动态规划思想来分析
	        //首先如果前面的和已经得到小于0肯定舍掉不用
	        int sum=array[0],tempsum=array[0];
	        for(int i=1;i<array.length;i++)
	        {
	        	//如果当前值小于0，表明从前面得到的结果或延续下去是没有意义的
	        	//因为此时不会给总和带来成长，所以要重新开始计数
	        	//故此时应该从array[i] 开始
	        	tempsum=(tempsum<0) ?array[i] :tempsum+array[i];
	        	sum=(tempsum>sum) ?tempsum :sum;
	        }
	        return 1;
	        
	    }

		//统计数字在排序数组中出现的次数
		public int GetNumberOfK(int [] array , int k) {
			//重新写，二分查找
//			//书上的例子
//			int left=0,right=array.length-1;
//			int last=-1;
//			while(left<=right)
//			{
//				int mid=(left+right)/2;
//				if(array[mid]<k)
//				{
//					left=mid+1;
//				}
//				else if(array[mid]>k)
//				{
//					right=mid-1;
//				}
//				else
//				{
//					last=mid;
//					
//				}
//			}
			

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//		       int len=array.length;
//		       if(len==0)
//		    	   return 0;
//		       int sum=0;
//		       int flag=0;
//		       for(int i=0;i<len;i++)
//		       {
//		    	   if(array[i]==k)
//		    	   {
//		    		   sum++;
//		    		   flag=1;
//		    	   }
//		    		  
//		    	   if(array[i]!=k && flag==1)
//		    		   break;
//		       }
//		       return sum;
		       
		       
		       
		       
		       
		       
		       
		       //情况考虑不全
		       //先用最简单的来实现
//		       for(int i=0;i<len;i++)
//		       {
//		    	   if(array[i]==k)
//		    	   {
//		    		   
//		    		   first=i;
//		    		   break;
//		    	   }
//		    	   
//		       }
//		       for(int i=first;i<len;i++)
//		       {
//		    	   if(array[i]==k)
//		    	   {
//		    		   last=i;
//		    		   
//		    	   }
//		       }
//		       return last-first;
			if(array==null || array.length==0)
				return 0;
			int t=getFirst(array,0,array.length-1,k);
			if(t!=-1)
				return getLast(array,0,array.length-1,k)-t+1;
			return 0;

	    }
	  
	int getFirst(int [] array, int s,int e,int k)
	{
			if(s>=e)
				return array[s]==k ?s:-1;
			int m=(s+e)/2;
			if(array[m]<k)
				return getFirst(array,m+1,e,k);
			else
				return getFirst(array,s,m,k);
			
	}
	
	int getLast(int [] array,int s,int e,int k){
		if(s>=e){
			if(array[s]==k)
				return s;
			return array[s-1]==k? s-1:-1;
			
		}
		int  m=(s+e)/2;
		if(array[m] <=k)
			return getLast(array,m+1,e,k);
		else
			return getLast(array,s,m,k);
	}
	//判断二叉树对称
	boolean isSymmetrical(TreeNode pRoot)
    {
		//其实为判断翻转二叉树与对应的二叉树相同的变种
		//首先实现函数翻转二叉树
//		TreeNode tempRoot=pRoot;
//		TreeNode RRoot=ReverseBinaryTree(tempRoot);
//		//翻转二叉树后由于原来为树结构，所以把原有的树也翻转了
//		//再多加一个即可
//		
//		System.out.println(pRoot.val+","+pRoot.left.val+","+pRoot.right.val);
//		System.out.println(RRoot.val+","+RRoot.left.val+","+RRoot.right.val);
//		//实现函数判断二叉树是否相同
//		return IsSameTree(pRoot,RRoot);
		
//        if(pRoot==null)
//        	return true;
//        else if(pRoot.left.val!=pRoot.right.val)
//        	return false;
//        else
//        	return isSymmetrical(pRoot.left) && isSymmetrical(pRoot.right);
		
		
		
		//同之前想的一样，为比较同一棵树的左和右，不做修改，递归
		if(pRoot==null)
			return true;
		else
			return comRoot(pRoot.left,pRoot.right);
		
    }
		boolean comRoot(TreeNode left,TreeNode right)
		{
			if(left==null && right==null)
				return true ;
			else if(left==null || right==null)
				return false;
			else if(left.val!=right.val)
				return false;
			else 
				return (comRoot(left.right,right.left) && comRoot(left.left,right.right));
			
		}
	
	
	TreeNode ReverseBinaryTree(TreeNode pRoot)
	{
		TreeNode temp;
		if(pRoot==null)
			return null;
		else
		{
//			temp=pRoot.left;
//			pRoot.left=pRoot.right;
//			pRoot.right=temp;
			
			temp=ReverseBinaryTree(pRoot.left);
			pRoot.left=ReverseBinaryTree(pRoot.right);
			pRoot.right=temp;
			return pRoot;
		}
		
	}
	
//	boolean IsSameTree(TreeNode Root1,TreeNode Root2)
//	{
//		if(Root1==null && Root2==null)
//			return true;
//		else if(Root1==null || Root2==null)
//			return false;
//		else
//		{
//			if(Root1.val!=Root2.val)
//				return false;
//			else
//				return (IsSameTree(Root1.left,Root2.left) && IsSameTree(Root1.right,Root2.right));
//		}
//		
//	}
	
	//输入一个链表，从尾部到头打印
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> temp=new Stack<Integer>();
        ArrayList<Integer> result =new ArrayList<Integer> ();
        //判断空值
        if(listNode==null)
        	return result;
        //判断是否为空
        while(listNode!=null)
        {
        	temp.push(listNode.val);
        	listNode=listNode.next;
        }
        while(!temp.isEmpty())
        {
        	result.add(temp.pop());
        }
		return result;
    }
	
	//查找两个数，使其和正好为S
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        HashMap <Integer,Integer> temp=new HashMap<Integer,Integer>();
        ArrayList<Integer> result=new ArrayList<Integer>();
        int multi=0;
		if(array==null)
        	return null;
		//判断其中的数
		for(int x: array)
		{
			//超过sum，退出
			if(x>sum)
				break;
			//System.out.println(x+" ");
			//System.out.println(temp.containsValue(x));
			if(temp.containsValue(x))
			{
				//肯定后面发现的x更大
				//发现和相同且乘积小的，存入，并释放更新元素
				
				if(multi!=0 && multi>x*(sum-x))
				{
					multi=x*(sum-x);
					result.clear();
					
					result.add(sum-x);
					result.add(x);
					//System.out.println(x+" ");
				}
				else
				{
					multi=x*(sum-x);
					result.add(sum-x);
					result.add(x);
				}
			}
			//每次都存值，判断
			temp.put(x, sum-x);
			
		}
		for (Map.Entry<Integer,Integer> pair:temp.entrySet())
		{
			System.out.println(pair.getKey()+":"+pair.getValue());
		}
		if(temp.isEmpty())
			return null;
		return result;
		
//		//自己写
//		int i=0,j=array.length-1,flag=-1;
//		ArrayList<Integer> a1=new ArrayList<Integer>();
//		if(a==null || a.length==0) return a1;
//		while(i!=j)
//		{
//			if(a[i]+a[j]==sum)
//			{
//				a1.add(a[i]);
//				a1.add(a[j]);
//				return a1;
//			}
//			else if(flag==-1) i++;
//			else if(flag==1) j--;
//			flag=flag*-1;
//			
//		}
//		 while(i < j && a[i] + a[j] > sum) --j;
//         while(i < j && a[i] + a[j] < sum) ++i;
//		return a1;
//		交替缩进寻找

		
	}
	
	//算法复杂对过大
//	//寻找数组中的逆序对
//	public int InversePairs(int [] array) {
//		//会有跨越的情况发生
//		int sum=0;
//		
//		if(array==null || array.length==0)
//			return sum;
//        for(int i=0;i<array.length-1;i++)
//        {
//        	for(int j=i+1;j<array.length;j++)
//        	{
//        		if(array[j]<array[i])
//        			sum++;
//        	}
//        }
//        return sum;
//        
//    }
	
	
	class Test
	{
		HashMap<Character,Integer> temp=new HashMap<Character,Integer>();
		
		//输出字符流中第一个只出现一次的ch
		//Insert one char from stringstream
		ArrayList <Character> result=new ArrayList<Character>();
	    public void Insert(char ch)
	    {
	        if(temp.containsKey(ch))
	        {
	        	temp.put(ch, temp.get(ch)+1);
	        	//result.remove(ch);
	        }  	
	        else
	        {
	        	temp.put(ch, 1);
	        	//result.add(ch);
	        }
	        result.add(ch);
	        	
	    }
	  //return the first appearence once char in current stringstream
	    public char FirstAppearingOnce()
	    {
	    	char ch='#';
	    	for(char key : result)
	    	{
	    		if(temp.get(key)==1)
	    		{
	    			ch=key;
	    			break;
	    		}	    			
	    	}
	    	return ch;
	    }
		
	}
	//从上到下打印二叉树节点
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		 //Queue需要使用LinkedList来实现
	        Queue<TreeNode> tree=new LinkedList<TreeNode>();
	        ArrayList<Integer> result=new ArrayList<Integer>();
	        TreeNode cur;
	        int start=0;
	        int end=1;
	        if(root==null)
	        	return result;
	        tree.add(root);
	        
	        while(!tree.isEmpty())
	        {        	
	        	//System.out.println(root.val+",");
	        	cur=tree.remove();
	        	result.add(cur.val);
	        	if(cur.left!=null)
	        		tree.add(cur.left);
	        	if(cur.right!=null)
	        		tree.add(cur.right);
	        	
	        	start++;
	        	if(start==end)
	        	{	        		
	        		end=tree.size();
	        		start=0;
	        	}
	        }
	        return result;		 
	    }
	
	 //两个单调链表进行合并
	 public ListNode Merge(ListNode list1,ListNode list2) {
//	     ListNode temp=new ListNode(1);
//	     ListNode head;
//	     head=temp;
//	     while(list1!=null && list2!=null)
//	     {
//	    	 if(list1.val<=list2.val)
//	    	 {
//	    		 //这里错了，因为错在交换顺序和指针上
//	    		 //对应会把链表变成循环的，不再是指针形式的东西。
//	    		 //所以会错误，输出不正确
//	    		 //此外错误在于引用上，顺序赋值有错，导致对应关系错误
//	    		 //重新修改
//	    		 temp.next=list1;
//	    		 list1=list1.next;
//	    		 temp=temp.next;
//	    	 }
//	    	 else
//	    	 {
//	    		 temp.next=list2;
//	    		 list2=list2.next;
//	    		 temp=temp.next;	    		
//	    	 }
//	     }
//	     if(list1!=null)
//	     {
//	    	 temp.next=list1;
//	     }
//	     if(list2!=null)
//	     {
//	    	 temp.next=list2;
//	     }
//	     
//	     return head.next;
//	     
		 
		 //再写一个递归实现的函数
		 ListNode head=null;
		 if(list1==null)
			 return list2;
		 if(list2==null)
			 return list1;
		 if(list1.val<=list2.val)
		 {
			 head=list1;
			 list1=list1.next;
			 head.next=Merge(list1, list2);
		 }
		 else
		 {
			 head=list2;
			 list2=list2.next;
			 head.next=Merge(list1,list2);
		 }
		 return head;
	}
	
	
	
	public void test(ListNode list1)
	{
		list1=list1.next;
		System.out.println("t:"+list1.val);
		//System.out.println("t:"+list1.next.val);
	}
	
	//输出旋转数组的最小元素
	public int minNumberInRotateArray(int [] array) {
	    if(array==null || array.length==0)
	    	return 0;
		Arrays.sort(array);
	    return array[0];
    }
	
	//输出链表的翻转
	public ListNode ReverseList(ListNode head) {
		ListNode end=null;
//		if(head==null)
//			return end;
//		else
//		{
//			end=head;
//			head=head.next;
//			end.next=ReverseList(head);
//		}
//		return end;
		//上面的是复制链表 不太对
//		Stack<ListNode> result=new Stack<ListNode>();
//		ListNode end=new ListNode(1);
//		ListNode cur=null;
//		cur=end;
//		if(head==null)
//			return end.next;
//		while(head!=null)
//		{
//			result.add(head);
//			head=head.next;
//		}
//		while(!result.isEmpty())
//		{
//			cur.next=result.pop();
//			cur=cur.next;
//		}
//		cur.next=null;//末尾节点赋值为空，否则会成为循环
		return end.next;
		//其实更简单的是直接加一个前驱和后继，再赋值
//		ListNode pre=null;
//		ListNode next=null;
//		while(head!=null)
//		{
//			//先获取当前节点下一个节点保存
//			next=head.next;
//			//令当前节点指向前一个节点
//			head.next=pre;
//			//令当前节点成为下一个的前节点
//			pre=head;
//			//换成下一个节点
//			head=next;
//			
//		}
		
		
		
		
		
    }
	
	//调整数组中奇数和偶数的位置
	public void reOrderArray(int [] array) {
        ArrayList<Integer> odd=new ArrayList<Integer>();
        ArrayList<Integer> even=new ArrayList<Integer>();
        if(array==null || array.length==0)
        	return;
        for(int i=0;i<array.length;i++)
        {
        	if(array[i]%2==0)
        		even.add(array[i]);
        	else
        		odd.add(array[i]);
        }
        odd.addAll(even);
        for(int i=0;i<array.length;i++)
        {
        	array[i]=odd.get(i);
        	
        }
		
    }
	
	//输出链表中倒数第k个节点
	//此处可以用双指针法
	//通过第一个指针与第二个指针之间相差为k
	//当第二个指针到尾部时，第一个指针指向的是为对应倒数第k个
	//然后也可以判断大小和越界
	public ListNode FindKthToTail(ListNode head,int k) {
		//用堆栈实现
		ArrayList<ListNode> end=new ArrayList<ListNode>();
		ListNode result=null;
		if(head==null)
			return null;
		//边界问题
	
		while(head!=null)
		{
			end.add(head);
			head=head.next;
		}
		if(k>end.size() || k<=0)
			return result;
		else
			return end.get(end.size()-k);
    }

	//数值的乘方
	public double Power(double base, int exponent) {
		double result=1;
        if(exponent==0)
        	return 1;
        else if(exponent>0)
        {
        	while(exponent>0)
        	{
        		result=result*base;
        		exponent--;
        	}
        }
        else//exponent<0
        {
        	while(exponent<0)
        	{
        		result=result/base;
        		exponent++;
        	}
        }
        return exponent;
	  }
	
	//顺时针打印矩阵
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> result=new ArrayList<Integer>();
	    if(matrix==null || matrix.length==0)
	    	return result;
	    //else if
		int height=matrix.length;
	    int width=matrix[0].length;//length取第0个
	    int i=0;//作为初始的指针值变量
	    //边界条件肯定是对应的最短长度的一半，上取整
	    double end=Math.ceil((double)Math.min(height, width)/2);
	    //System.out.println("end"+end);
	    //结束条件是小于
	    //对应要判断是否相同
	    //四条边分别为
	    //i,width-1-i,height-1-i,i
	    while(i<end)
	    {
	    	//共分为上下左右四层，四个循环,在这里我们取每次打印宽或高的长度减1
	    	//起点总是左上角的点i,i
	    	//打印从左到右
	    	//容易发现其中的对称结构，用于检查
	    	//第一次输出整行，后面调整，防止出错
	    	//System.out.println("end"+i);
	    	//尽量保证都不会有+-1的情况，只是进行单纯的操作，防止越界
	    	for(int j=i;j<width-i;j++)
	    	{
	    		result.add(matrix[i][j]);//对应添加的是第i行，第j列
	    		//System.out.println("e1:"+matrix[i][j]);
	    	}
	    	//对应第二个少输出一个元素，少输出一次
	    	//不能多加1.因为可能会出错，越界
	    	//System.out.println("i:"+i);
	    	//if()
	    	//下面所有都加判断是为了保证由于新的循环赋值操作越界
	    	for(int j=i+1;j<height-i;j++)
	    	{
	    		//仅这里可能出现越界
	    		if(j<height-i)
	    		{
	    			result.add(matrix[j][width-1-i]);
//	    			System.out.println("e2:"+matrix[j][width-1-i]);
	    		}
	    		else
	    			break;
	    		//System.out.println("e2"+matrix[i][j]);
	    	}
	    	for(int j=width-2-i;(j>=i)&&(height-1-i)!=i;j--)
	    	{
	    		result.add(matrix[height-1-i][j]);
//	    		System.out.println("e3:"+matrix[height-1-i][j]);
	    		//System.out.println("e3"+matrix[i][j]);
	    	}
	    	for(int j=height-2-i;(j>i)&& (width-1-i)!=i;j--)
	    	{
	    		result.add(matrix[j][i]);
//	    		System.out.println("e4:"+matrix[j][i]);
	    		//System.out.println("e4"+matrix[i][j]);
	    	}
	    	//判断是否重复
	    	i++;
	    }
	    return result;
    }
	
	//重建二叉树
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		TreeNode root=reConstrcutBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
		return root;
    }
	
	private TreeNode reConstrcutBinaryTree(int [] pre,int starPre,int endPre,int [] in,int starIn,int endIn) {
		// TODO Auto-generated method stub
		//TreeNode root=null;
		//因为后面有递增，防止越界
        if(pre==null || starPre>endPre)
        	return null;
        if(in==null || starIn>endIn)
        	return null;
        TreeNode root=new TreeNode(pre[starPre]);
        int index=-1;
        for(int i=starIn;i<=endIn;i++)
        {
        	if(in[i]==pre[starPre])
        	{
        		index=i;
        		break;
        	}
        }
        // 用数组实现后面的序号就不一样了
        if(index>starIn)//表明此时有左孩子
        {
        	root.left=reConstrcutBinaryTree(pre,starPre+1,index-starIn+starPre,in,starIn,index-1);
        	
        }
        if(index<endIn)
        {
        	root.right=reConstrcutBinaryTree(pre, index+starPre-starIn+1, endPre, in, index+1, endIn);
        	
        }
        return root;
	}

	
	
	// Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
	//返回数组中重复的元素
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	//duplication[0]=0;
    	if(length==0 || numbers==null || numbers.length==0)
    		return false;
    	int[] temp =new int[length];
    	int flag=0;
    	int n=0;
    	for(int i=0;i<length;i++)
    	{
    		//空间换时间
    		temp[numbers[i]]++;
    		if(temp[numbers[i]]>1)
    		{
    			flag=1;
    			n=numbers[i];
    			break;
    		}
    	}
    	if(flag==1)
    	{
    		duplication[0]=n;
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
	
	
//    一、1的数目
//
//    编程之美上给出的规律：
//
//    1. 如果第i位（自右至左，从1开始标号）上的数字为0，则第i位可能出现1的次数由更高位决定（若没有高位，视高位为0），等于更高位数字X当前位数的权重10i-1。
//
//    2. 如果第i位上的数字为1，则第i位上可能出现1的次数不仅受更高位影响，还受低位影响（若没有低位，视低位为0），等于更高位数字X当前位数的权重10i-1+（低位数字+1）。
//
//    3. 如果第i位上的数字大于1，则第i位上可能出现1的次数仅由更高位决定（若没有高位，视高位为0），等于（更高位数字+1）X当前位数的权重10i-1。
//
//    二、X的数目
//
//    这里的 X∈[1,9]，因为 X=0 不符合下列规律，需要单独计算。
//
//    首先要知道以下的规律：
//
//    从 1 至 10，在它们的个位数中，任意的 X 都出现了 1 次。
//    从 1 至 100，在它们的十位数中，任意的 X 都出现了 10 次。
//    从 1 至 1000，在它们的百位数中，任意的 X 都出现了 100 次。
//    依此类推，从 1 至 10i，在它们的左数第二位（右数第 i 位）中，任意的 X 都出现了 10i−1 次。
//
//    这个规律很容易验证，这里不再多做说明。
//
//    接下来以 n=2593,X=5 为例来解释如何得到数学公式。从 1 至 2593 中，数字 5 总计出现了 813 次，其中有 259 次出现在个位，260 次出现在十位，294 次出现在百位，0 次出现在千位。
//
//    现在依次分析这些数据，首先是个位。从 1 至 2590 中，包含了 259 个 10，因此任意的 X 都出现了 259 次。最后剩余的三个数 2591, 2592 和 2593，因为它们最大的个位数字 3 < X，因此不会包含任何 5。（也可以这么看，3<X，则个位上可能出现的X的次数仅由更高位决定，等于更高位数字（259）X101-1=259）。
//
//    然后是十位。从 1 至 2500 中，包含了 25 个 100，因此任意的 X 都出现了 25×10=250 次。剩下的数字是从 2501 至 2593，它们最大的十位数字 9 > X，因此会包含全部 10 个 5。最后总计 250 + 10 = 260。（也可以这么看，9>X，则十位上可能出现的X的次数仅由更高位决定，等于更高位数字（25+1）X102-1=260）。
//
//    接下来是百位。从 1 至 2000 中，包含了 2 个 1000，因此任意的 X 都出现了 2×100=200 次。剩下的数字是从 2001 至 2593，它们最大的百位数字 5 == X，这时情况就略微复杂，它们的百位肯定是包含 5 的，但不会包含全部 100 个。如果把百位是 5 的数字列出来，是从 2500 至 2593，数字的个数与百位和十位数字相关，是 93+1 = 94。最后总计 200 + 94 = 294。（也可以这么看，5==X，则百位上可能出现X的次数不仅受更高位影响，还受低位影响，等于更高位数字（2）X103-1+（93+1）=294）。
//
//    最后是千位。现在已经没有更高位，因此直接看最大的千位数字 2 < X，所以不会包含任何 5。（也可以这么看，2<X，则千位上可能出现的X的次数仅由更高位决定，等于更高位数字（0）X104-1=0）。
//
//    到此为止，已经计算出全部数字 5 的出现次数。
//
//    总结一下以上的算法，可以看到，当计算右数第 i 位包含的 X 的个数时：
//
//    取第 i 位左边（高位）的数字，乘以 10i−1，得到基础值 a。
//    取第 i 位数字，计算修正值：
//    如果大于 X，则结果为 a+10i−1。
//    如果小于 X，则结果为 a。
//    如果等 X，则取第 i 位右边（低位）数字，设为 b，最后结果为 a+b+1。
//    相应的代码非常简单，效率也非常高，时间复杂度只有 O(log10n)。
	//求1出现的次数
    //可以求所有数字出现的次数
    
    public int NumberOf1Between1AndN_Solution(int n) {
//    	int sum=0;
//    	//明显采用递归来做
////    	s
////        for(int i=0;i<=n;i++)
////        {
////        	if(i%10==1)
////        	{
////        		sum++;
////        		//System.out.println(i+","+(i/10)%10);
////        	}
////        	if((i/10)%10==1)
////        		sum++;
////        		
////        }
//    	if(n==0)
//    		return 0;
//    	else if(n/10>1)
//    	{
//    		
//    	}
//    	else
//    	{
//    		if(n%10==1)
//    			return 1;
//    	}
//        return sum;
    	
    	if(n<0)
    		return 0;
    	int high,low,curr,tmp,i=1;
    	high=n;
    	int total=0;
    	while(high!=0)
    	{
    		high=n/(int)Math.pow(10, i);//取第i位的高位
    		tmp=n%(int)Math.pow(10, i);//取余数
    		curr=tmp/(int)Math.pow(10, i-1);//取第i位
    		low=tmp%(int)Math.pow(10, i-1);//取第i位的低位
    		if(curr==1)
    			total+=high*(int)Math.pow(10, i-1)+low+1;
    		else if(curr<1)
    		{
    			total+=high*(int)Math.pow(10, i-1);
    		}
    		else
    		{
    			total+=(high+1)*(int)Math.pow(10, i-1);
    		}
    		i++;
    	}
    	return total;
    }
	
    //判断是否为子树
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)
        	return true;
        if(root1==null && root2!=null)
        	return false;
        boolean flag=false;
        if(root1.val==root2.val)
        {
        	flag=IsSubTree(root1,root2);
        	if(!flag)
        	{
        		flag=IsSubTree(root1.left,root2);
        		if(!flag)
        		{
        			flag=IsSubTree(root1.right,root2);
//        			if(!flag)
//        				return false;
        		}
        	}
        }
        return flag;
    }
    
    public boolean IsSubTree(TreeNode root1,TreeNode root2){
    	//SubTree 与SameTree 不同，可以包括
    	if(root2==null) 
    		return true;
    	if(root1==null && root2!=null) 
    		return false;
    	if(root1.val==root2.val)
    		return IsSubTree(root1.left,root2.left) && IsSubTree(root1.right,root2.right);
    	else
    		return false;
    		
    	
    }
    
    //找到第一个只出现一次的字符的位置
    public int FirstNotRepeatingChar(String str) {
    	char[] data=str.toCharArray();
    	if(data.length==0)
    		return -1;
    	HashMap<Character,Integer> result=new HashMap<Character,Integer>();
    	for(int i=0;i<data.length;i++)
    	{
    		if(result.containsKey(data[i]))
    		{
    			result.put(data[i], data.length);
    		}
    		else
    		{
    			result.put(data[i], i);
    		}
    	}
    	int index=data.length;
    	for(Map.Entry<Character, Integer> pair : result.entrySet())
    	{
    		if(pair.getValue()<index)
    		{
    			index=pair.getValue();
    		}
    	}
    	if(index<data.length)
    		return index;
    	else
    		return -1;
    }
    
    //数组中超过次数一半的元素
    public int MoreThanHalfNum_Solution(int [] array) {
        int len=array.length;
        if(len==0)
        	return 0;
        Arrays.sort(array);
        int temp=array[len/2];
        int sum=0;
        for(int i=0;i<len;i++)
        {
        	if(array[i]==temp)
        		sum++;
        }
        if(sum>len/2)
        	return temp;
        else
        	return 0;
    }
    
    
    //输出所有和为S的连续正数序列
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<Integer> temp=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(sum<0)
        	return result;
        if(sum==0)
        {
        	temp.add(0);
        	result.add(temp);
        }
        //double S=(double)sum;
        int t1=0;
        int t2=0;
        int i=1;
        
        //抽象由一元二次方程得结果
        for(int n=2;n<sum;n++)
        {
        	t1=2*n;
        	t2=2*sum+n-n*n;
        	if(t2<t1)
        		break;
        	//System.out.println(t2+","+t1);
        	if(t2%t1==0)//表明起始值存在
        	{
        		i=t2/t1;//起始的第一个值
        		//清空当前值
        		temp=new ArrayList<Integer>();
        		//依次将对应值放入
        		for(int j=0;j<n;j++)
        		{
        			temp.add(i);
        			//System.out.println(i);
        			i++;
        		}
        		//System.out.println(temp);
        		result.add(0, temp);
        		//System.out.println(result);
        	}
        	
        }
        return result;
    }
    
    
    //给出栈的压入顺序，判断是否为栈的弹出顺序
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	//每次push和pop时依次判断对应是否当前堆栈可以pop
    	//如果可以pop则pop
    	//判断最后是否原堆栈为空
        Stack<Integer> temp=new Stack<Integer>();
        if(pushA.length==0 || pushA==null)
        	return false;
        if(popA.length==0 || popA==null)
        	return false;
        int j=0;
        //重点在于判断和轮询
        for(int i=0;i<pushA.length;i++)
        {
        	temp.add(pushA[i]);
        	while(!temp.isEmpty() && temp.peek()==popA[j])
        	{
        		temp.pop();
        		j++;
        	}
        }
        return temp.isEmpty();
    }
    
    
    //判断是否为二叉搜索树后序遍历
//    BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：
//    T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
    public boolean VerifySquenceOfBST(int [] sequence) {
        //采用递归来实现，其中分解最后一个数肯定是根，位于中间节点上，然后再分解递归前面的
    	if(sequence==null || sequence.length==0)
    		return false;
    	//最后一个是根节点
    	int len=sequence.length;
    	int root=sequence[len-1];
    	int index=0;
    	for(int i=0;i<len-1;i++)
    	{
    		//中间节点，必须保证前面的都比root小
    		//后面的都比root大
    		if(sequence[i]>root)
    		{
    			index=i;//获取划分的中间节点位置
    			for(int j=i;j<len-1;j++)
    			{
    				if(sequence[j]<root)
    					return false;
    			}
    			break;
    		}
    	}
    	boolean left=true;
    	boolean right=true;
    	if(index>0)
    		left=VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, index));
    	if(index<len-1)
    		right=VerifySquenceOfBST(Arrays.copyOfRange(sequence, index, len-1));
    	return left&&right;
    	
    }
    
    
  //非递归 
  //非递归也是一个基于递归的思想：
  //左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
  //最后一个数字是右子树的根他也比左子树所有值大，因此我们可以每次只看有子树是否符合条件
  //即可，即使到达了左子树左子树也可以看出由左右子树组成的树还想右子树那样处理
   
  //对于左子树回到了原问题，对于右子树，左子树的所有值都比右子树的根小可以暂时把他看出右子树的左子树
  //只需看看右子树的右子树是否符合要求即可
//  class Solution {
//  public:
//      bool VerifySquenceOfBST(vector<int> sequence) {
//          int size = sequence.size();
//          if(0==size)return false;
//   
//          int i = 0;
//          while(--size)
//          {
//              while(sequence[i++]<sequence[size]);
//              while(sequence[i++]>sequence[size]);
//   
//              if(i<size)return false;
//              i=0;
//          }
//          return true;
//      }
//  };
    
    //二叉树中和为某一值的路径
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //基础方法，遍历所有路径，求解
    	ArrayList<Integer> temp=new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> left=new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> right=new ArrayList<ArrayList<Integer>>();
    	if(root==null)
    		return result;
    	//递归即可，否则需迭代
//    	TreeNode 
//    	while()
//    	{
//    		
//    	}
    	//递归实现
    	//System.out.println("right"+root.right!=null);
    	//System.out.println(root.val+"=="+target);
    	if(root.val==target && root.left==null && root.right==null)
    	{
    		temp=new ArrayList<Integer>();
    		temp.add(root.val);
    		result.add(temp);
//    		System.out.println("result"+result);
    	}
    	//else if 互斥！！！！！！！！！！！！！！！！！！！！！！
    	//所以不行！！！！！！！！！！！！！！！！！！！！！！！！！！！
    	if(root.left!=null)
    	{
    		//递归再次调用
//    		System.out.println("left"+":");
    		left=FindPath(root.left, target-root.val);
//    		System.out.println(left);
    		if(left!=null)
    		{
    			//如果有遍历下一层中所有节点，再汇总数据
    			for(ArrayList<Integer> pair : left)
    			{
    				temp=new ArrayList<Integer>();
    	    		temp.add(root.val);
    				for(int x : pair)
    				{
    					temp.add(x);
    				}
    				result.add(temp);
    				//System.out.println("left"+":"+root.left.val);
    			}
    		}
    	}
    	//else if 互斥 所以不行
    	if(root.right!=null)
    	{
    		//递归再次调用
//    		System.out.println("right"+":");
    		right=FindPath(root.right, target-root.val);
//    		System.out.println(right);
    		if(right!=null)
    		{
    			//如果有遍历下一层中所有节点，再汇总数据
    			for(ArrayList<Integer> pair : right)
    			{
    				temp=new ArrayList<Integer>();
    	    		temp.add(root.val);
    				for(int x : pair)
    				{
    					temp.add(x);
    				}
    				result.add(temp);
    			}
    		}
    	}
    	return result;
    }
    
    
    
    
    //输出最小的n个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //解决法
    	ArrayList<Integer> result=new ArrayList<Integer>();
    	if(input==null || input.length==0)
    		return result;
    	Arrays.sort(input);
    	if(k>input.length)
    		return result;
    	for(int i=0;i<k;i++)
    	{
    		result.add(input[i]);
    	}
    	return result;
    	
    	//使用简单选择排序或者对应冒泡排序也可以
    }
    
    //桶排序对应生成一个新的堆，无穷大数组，然后将下标值付给对应数组值，然后为默认值的不输出，即可得所有的k个
    //循环左移字符串
    public String LeftRotateString(String str,int n) {
    	String result=str;
        if(str==null)
        	return result;
        char[] temp=new char[str.length()];
        for(int i=0;i<temp.length;i++)
        {
        	temp[i]=str.charAt((i+n)%str.length());
        	System.out.println(temp[i]);
        }
        //char转string
        //copyValueOf
        result=String.copyValueOf(temp);
        return result;
        //直接substring
//        int len = str.length();
//        if(len == 0) return "";
//        n = n % len;
//        str += str;
//        return str.substr(n, len);
        
    }
    
    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    
    //复杂链表的复制
    public RandomListNode Clone(RandomListNode pHead)
    {
//        RandomListNode temp=pHead;
//        //System.out.println("pHead:"+pHead.label);
//        if(pHead==null)
//        	return temp;
//        RandomListNode cur;
//        cur=pHead.next;
//        RandomListNode Rnd;
//        Rnd=pHead.random;
//        //System.out.println(cur.label+" "+Rnd.label);
//        //System.out.println(cur.label+" "+Rnd.label);
//        temp.random=Rnd;
//        Rnd=pHead;
//        while(cur!=null)
//        {
//        	temp.next=cur; 	
//        	temp=cur;
//        	cur=cur.next;
//        }
//        return Rnd;
        //空指针，不太懂
        //
//    	HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
//    	RandomListNode
    	//链表复制表明的是重新生成一个新链表，不再管其他的
    	//重写
    	
    	//复杂链表的复制问题在于重复性
    	//即我通过.next生成的一个新的节点，可能已经在前面的某个节点，通过random方法生成过
    	//所以其实不好做关联
    	//方法1通过Map方法实现，然后将对应.next更新一遍后再更新.random
    	//方法2是先复制，每个节点后面是自己新节点的复制，然后将对应的random都找好
    	//然后再进行拆分
//    	RandomListNode rHead=null;
//    	//System.out.println("pHead:"+pHead.label);
//    	if(pHead==null)
//    		return rHead;
//    	else
//    	{
//    		rHead=new RandomListNode(pHead.label);
//        	if(pHead.random!=null)
//        		rHead.next=new RandomListNode(pHead.random.label);
//        	if(pHead.next!=null)
//        		rHead.next=Clone(pHead.next.next);
//            return rHead;
//    	}
//    	
    	//递归复制试一试
    	//该方法并未实现真正的复制！！！！！！！！！！！！
//    	RandomListNode copyHead=new RandomListNode(-1);
//    	if(pHead==null)
//    		return pHead;
//    	copyHead.label=pHead.label;
//    	copyHead.next=pHead.next;
//    	copyHead.random=pHead.random;
//    	copyHead.next=Clone(pHead.next);
//    	return copyHead;
    	/*
        1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
        2、遍历链表，A1->random = A->random->next;
        3、将链表拆分成原链表和复制后的链表
    */
    	if(pHead==null)
    		return null;
    	RandomListNode curNode=pHead;
    	//复制A-A*-B-B*
    	while(curNode!=null)
    	{
    		RandomListNode node=new RandomListNode(curNode.label);
    		node.next=curNode.next;
    		//只做next，后期的random要是新的才可以
    		//node.random=pHead.random;
    		curNode.next=node;
    		curNode=node.next;
    	}
    	curNode=pHead;
    	//复制对应的random节点
    	while(curNode!=null)
    	{
    		RandomListNode node=curNode.next;
    		if(curNode.random!=null) //当前值有random
    		{
    			node.random=curNode.random.next;
    		}
    		curNode=node.next;
    	}
    	//拆分
    	RandomListNode CloneHead=pHead.next;
    	RandomListNode temp;
    	curNode=pHead;
    	//下面这个是跨一个节点，跨节点复制
    	while(curNode.next!=null)
    	{
    		temp=curNode.next;
    		curNode.next=temp.next;
    		curNode=temp;
    	}
    	return CloneHead;
    	
        
    }
    
    //二叉树双向链表指针指向
    //其实类似于二叉树的中序遍历
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
        	return null;
        if(pRootOfTree.left==null && pRootOfTree.right==null)
        {
        	return pRootOfTree;
        }
       //对二叉树进行中序遍历
//        方法二：递归版
//        解题思路：
//        1.将左子树构造成双链表，并返回链表头节点。
//        2.定位至左子树双链表最后一个节点。
//        3.如果左子树链表不为空的话，将当前root追加到左子树链表。
//        4.将右子树构造成双链表，并返回链表头节点。
//        5.如果右子树链表不为空的话，将该链表追加到root节点之后。
//        6.根据左子树链表是否为空确定返回的节点。
        TreeNode left=null;
        TreeNode temp=null;
        TreeNode right=null;
        if(pRootOfTree.left!=null)
        {
        	left=Convert(pRootOfTree.left);
        	temp=left;
        	while(temp.right!=null)
        	{
        		temp=temp.right;
        	}
        	temp.right=pRootOfTree;
        	pRootOfTree.left=temp;
        }
        right=Convert(pRootOfTree.right);
        if(pRootOfTree.right!=null)
        {
        	right.left=pRootOfTree;
        	pRootOfTree.right=right;
        }
        if(left!=null)
        	return left;
        else
        	return pRootOfTree;
        //如果两个孩子都为空，则直接返回自身
        //return pRootOfTree;
    }
    
    
    //确定字符串互异
//    遍历那么只能用两层for循环遍历，时间复杂度为O(n*n)，
//    但是根据抽屉原理，没必要遍历到N，只需要遍历到前257就够了，
//    如果N<257就遍历到N，所以时间复杂度其实为O(1)!!!
//    排序既然题目要求不能使用额外空间，而参数列表没有const或引用，
//    那么就可以对字符串排序，然后再判断，需要O（nlogn)排序，然后再遍历一遍O(n)。
//    其实也没必要全都排序，只需前257个，同抽屉原理。
    public boolean checkDifferent(String iniString) {
        // write code here
    	if(iniString==null)
    		return true;
    	int len=iniString.length();
    	if(len==1)
    		return true;
    	char c;
    	boolean flag=true;
    	int r;
    	int t;
    	for(int i=0;i<len;i++){
    		r=iniString.charAt(i);
    		for(int j=i+1;j<len;j++)
    		{
    			c=iniString.charAt(j);
    			t=r^c;
        		if(t==0)
        		{
        			flag=false;
        			return flag;
        		}
    		}	
    	}
    	return flag;
    }
    
    
    
    //在不使用额外数据的情况下，翻转字符串
    public String reverseString(String iniString) {
    	if(iniString==null || iniString.length()==0)
    		return iniString;
        // write code here
    	int len=iniString.length();
    	char[] c=iniString.toCharArray();
    	char t;
    	for(int i=0;i<c.length/2;i++)
    	{
    		t=c[i];
    		c[i]=c[len-i-1];
    		c[len-i-1]=t;
    	}
    	//对应的String 生成方式
    	return new String(c);
    }
    
    
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    //计算数组中的不一样元素，一共两个
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp=0;
        if(array==null || array.length==0)
        {
        	return ;
        }
        if(array.length==1)
        {
        	num1[0]=0;
        	num2[0]=0;
        	return;
        }
        for(int i=0;i<array.length;i++)
        {
        	temp=array[i]^temp;
        }
        //可以让对应的temp仅与1按位与，可得对应的是！！！
        //或者x&（-（x-1））
        int s1=temp;
        int bit=0;
        int n1=0,n2=0;
        while((s1&1)==0)
        {
        	s1=s1>>1;
        	bit++;
        }
        for(int i=0;i<array.length;i++)
        {
        	if(((array[i]>>bit)&1)!=0)
        	{
        		n1=n1^array[i];
        	}
        	else
        	{
        		n2=n2^array[i];
        	}
        }
        num1[0]=n1;
        num2[0]=n2;
    }
    
    //按字典顺序打印出字符的所有排列
//    public ArrayList<String> Permutation(String str) {
//        ArrayList<String> result=new ArrayList<String>();
//        if(str==null || str.length()==0)
//        	return result;
//        char[]t=str.toCharArray();
//        Arrays.sort(t);
//        for(int i=0;i<t.length;i++)
//        {
//        	char f=t[i];
//        	//String b=new String()
//        }
//    }
     
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> re=new ArrayList<String>();
        if(str==null || str.length()==0)
        	return re;
        HashSet<String> set=new HashSet<String>();
        //调用函数初始化
        fun(set,str.toCharArray(),0);
        re.addAll(set);
        //最后再sort，前面直接全排列即可
        Collections.sort(re);
        return re;
     }
    
     void fun(HashSet<String> re,char[] str,int k){
    	 if(k==str.length){
    		 re.add(new String(str));
    		 return;
    	 }
    	 //假设从第0步开始，
    	 //首先是0，然后调用递归，是1，
    	 //最先加入的是第一个，全的
    	 //然后后面的回溯到上一步，
    	 //上一步为len-1,变为len,则交换后面两个的位置，再换回来
    	 //然后是len-2,变为len-1，交换（最后-1）两个的位置，进入len-1，交换了最后两个的位置即ab，ba都有
    	 //设置对应为....abc时，就是，先交换得到bac,然后交换得到...bca,再交换得到cba,cab,
    	 for(int i=k;i<str.length;i++){
    		 //对应实现交换和函数递归
    		 //两次交换的目的是将其换成原来的样子
    		 swap(str,i,k);
    		 fun(re,str,k+1);
    		 swap(str,i,k);
    	 }
     }
     
     void swap(char[] str,int i,int j){
    	 if(i!=j){
    		 char t=str[i];
    		 str[i]=str[j];
    		 str[j]=t;
    	 }
     }
    
     //字符串全排列，第二种
     private char [] seqs;
     private Integer[] book;
     //用于结果去重
     private HashSet<String> result=new HashSet<String>();
     /**
      * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
      * 例如输入字符串abc,则打印出由字符a,b,c
      * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
        输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。\
      * @param str
      * @return
      */
     public ArrayList<String> Permutation2(String str){
    	 ArrayList<String> arrange=new ArrayList<String>();
    	 if(str==null || str.isEmpty())
    		 return arrange;
    	 char[] strs=str.toCharArray();
    	 seqs=new char[strs.length];
    	 book=new Integer[strs.length];
    	 for(int i=0;i<book.length;i++){
    		 book[i]=0;
    	 }
    	 //传入的是对应原始的字符集合
    	 dfs(strs,0);
    	 arrange.addAll(result);
    	 Collections.sort(arrange);
    	 return arrange;
     }
     
     //手写一个深度遍历法
     private void dfs(char[] arrs,int step){
    	 //走完所有可能，记录排列
    	 if(arrs.length==step){
    		 String str="";
    		 for(int i=0;i<seqs.length;i++){
    			 str+=seqs[i];
    		 }
    	     result.add(str);
    	     return;//返回上一步
    	 }
    	 //遍历整个序列，尝试每一种可能
    	 //dfs标记表明对应状态，实现顺序
    	 //不同顺序用标记来实现！！！！
    	 for(int i=0;i<arrs.length;i++)
    	 {
    		 //是否走过
    		 if(book[i]==0)
    		 {
    			 seqs[step]=arrs[i];
    			 //两个标记做标记，重新清零
    			 book[i]=1;
    			 //下一步
    			 dfs(arrs,step+1);
    			 book[i]=0;
    		 }
    			 
    	 }
     }
     
     
     
     //丑数，求按从小到大的第n个丑数
     //最简单的方法是遍历
     public int GetUglyNumber_Solution(int index) {
    	int x=0;
    	if(index==1)
    		return 1;
    	else if(index<=0)
    		return 0;
    	// 此处组合情况不宜讨论，重新做！
// 		for(int i=2;i<0xffff;i++)
// 		{
// 			//第一个全为2
// 			//判断其是否是整数
// 			if((Math.log(i)/Math.log(2*3*5))==(int)(Math.log(i)/Math.log(2*3*5)))
// 				index--;
// 			else if((Math.log(i)/Math.log(2))==(int)(Math.log(i)/Math.log(2)))
// 				index--;
// 			else if((Math.log(i)/Math.log(3))==(int)(Math.log(i)/Math.log(3)))
// 				index--;
// 			else if((Math.log(i)/Math.log(5))==(int)(Math.log(i)/Math.log(5)))
// 				index--;
// 			else if((Math.log(i)/Math.log(2*3))==(int)(Math.log(i)/Math.log(2*3)))
// 				index--;
// 			else if((Math.log(i)/Math.log(2*5))==(int)(Math.log(i)/Math.log(2*5)))
// 				index--;
// 			else if((Math.log(i)/Math.log(3*5))==(int)(Math.log(i)/Math.log(3*5)))
// 				index--;
// 			if(index==1)
// 				return i;
// 	   
// 		}
//    	return 0;
    	
//    	//java解法1
//    	int res[] =new int[index];
//    	ArrayList<Integer> u2=new ArrayList<Integer>();
//    	ArrayList<Integer> u3=new ArrayList<Integer>();
//    	ArrayList<Integer> u5=new ArrayList<Integer>();
//    	
//    	int temp=1;
//    	u2.add(temp);
//    	int num=0;
//    	
//    	while(num<index){
//    		if(!u2.contains(2*temp))
//    			u2.add(2*temp);
//    		if(!u3.contains(3*temp))
//    			u3.add(3*temp);
//    		if(!u5.contains(5*temp))
//    			u5.add(5*temp);
//    		temp=findMin(u2.get(0),u3.get(0),u5.get(0));
//    		if(num==0){
//    			res[num]=temp;
//    			num++;
//    		}
//    		if(num>=1 && res[num-1]!=temp){
//    			//此时肯定是从前面过来的，2，3, 5 对应的新下标
//    			//防止可能存在相同，如2*3
//    			res[num]=temp;
//    			num++;
//    		}
//    		//每次取的都是最开始的地方
//    		//如果其中一个数取到了，相互乘过，那么就把这个数移除，不再取
//    		//相当于每次保留的方法
//    		if(temp==u2.get(0)){
//    			u2.remove(0);
//    		}
//    		else if(temp==u3.get(0)){
//    			u3.remove(0);
//    		}
//    		else
//    		{
//    			u5.remove(0);
//    		}
//    	}
    	
    	//方法不好，不易写
    	//
    	
    	//java 解法2
    	/*
    	说下思路，如果p是丑数，那么p=2^x * 3^y * 5^z
    	那么只要赋予x,y,z不同的值就能得到不同的丑数。
    	如果要顺序找出丑数，要知道下面几个特（fei）点（hua）。
    	对于任何丑数p：
    	（一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
    	（二）如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q
    	现在说说算法思想：
    	    由于1是最小的丑数，那么从1开始，把2*1，3*1，5*1，进行比较，得出最小的就是1
    	的下一个丑数，也就是2*1，
    	    这个时候，多了一个丑数‘2’，也就又多了3个可以比较的丑数，2*2，3*2，5*2，
    	这个时候就把之前‘1’生成的丑数和‘2’生成的丑数加进来也就是
    	(3*1,5*1,2*2，3*2，5*2)进行比较，找出最小的。。。。如此循环下去就会发现，
    	每次选进来一个丑数，该丑数又会生成3个新的丑数进行比较。
    	    上面的暴力方法也应该能解决，但是如果在面试官用这种方法，估计面试官只会摇头吧
    	。下面说一个O（n）的算法。
    	    在上面的特（fei）点（hua）中，既然有p<q, 那么2*p<2*q，那么
    	“我”在前面比你小的数都没被选上，你后面生成新的丑数一定比“我”大吧，那么你乘2
    	生成的丑数一定比我乘2的大吧，那么在我选上之后你才有机会选上。
    	其实每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
    	数。也就是比较(2*x , 3*y, 5*z) ，x>=y>=z的，
    	重点说说下面代码中p的作用：int p[] = new int[] { 0, 0, 0 }; p[0]表示最小用于
    	乘2比较数在数组a中的【位置】。 */
    	
    	final int d[]={2,3,5};
    	int a[]=new int[index];
    	a[0]=1;
    	int p[]=new int[]{0,0,0};
    	int num[]=new int[]{2,3,5};
    	int cur=1;
    	
    	//序号表明顺序
    	while(cur<index){
    		int m=findMin(num[0],num[1],num[2]);
    		//这个数要比前面的大，否则只是单纯的更新下标而已，防止相等
    		if(a[cur-1]<num[m])
    			a[cur++]=num[m];
    		//此处更新丑数的下标值
    		p[m]+=1;
    		//此处更新对应的待选丑数的值，前面已经把丑数放到最终的丑数集合里面，如果需要有的话
    		num[m]=a[p[m]]*d[m];
    	}
    	return a[index-1];
    	
    	
     }
     
     private int findMin(int num2,int num3,int num5)
     {
    	 int min=Math.min(num2, Math.min(num3, num5));
    	 return min==num2?0:min==num3?1:2;
     }
     
 
     //输入数组的最小数
     //巧妙使用comparable接口以及自定义的sort与排序
     public String PrintMinNumber(int [] numbers) {
    	 
    	 if(numbers==null || numbers.length==0)
    		 return null;
    	 int n;
    	 String s="";
    	 ArrayList<Integer> list=new ArrayList<Integer>();
    	 n=numbers.length;
    	 //现将对应所有字符输入到Arraylist中
    	 for(int i=0;i<n;i++){
    		 list.add(numbers[i]);
    	 }
    	 //实现Compare方法，对应完成实现比较
    	 Collections.sort(list,new Comparator<Integer>(){
    		 
    		 public int compare(Integer str1,Integer str2){
    			 String s1=str1+""+str2;
    			 String s2=str2+""+str1;
    			 return s1.compareTo(s2);
    		 }
    	 });
    	 
    	 for(int j:list){
    		 s+=j;
    	 }
    	 return s;
    	 
     }
     
     
     //
     /*归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
     合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
     数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
     参考剑指Offer，但是感觉剑指Offer归并过程少了一步拷贝过程。
     还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余
     */
     //求数组中的逆序对，采用递归方法实现，出现对应的i>j;表明其实i
     public int InversePairs(int [] array) {
         if(array==null || array.length==0)
         {
        	 return 0;
         }
         int[] copy=new int[array.length];
         for(int i=0;i<array.length;i++)
         {
        	 copy[i]=array[i];
         }
         int count=InversePairsCore(array,copy,0,array.length-1)%1000000007;//数值过大求余
         return count;
     }
     
     private int InversePairsCore(int[] array,int[] copy,int low,int high)
     {
    	 if(low==high)
    	 {
    		 return 0;
    	 }
    	 //其实对应有两个数组，另外有一个数组表明当前节点值前面的逆序对或顺序对的个数
    	 int mid=(low+high)>>1;
         int leftCount=InversePairsCore(array,copy,low,mid)%1000000007;
         int rightCount=InversePairsCore(array,copy,mid+1,high)%1000000007;
         int count=0;
         int i=mid;
         int j=high;
         int locCopy=high;
         while(i>=low&&j>mid)
         {
        	 //如果前面的数比后面的大，逆序对
        	 //在进行内部过程中，大的放到了右边，小的放到了左边，完成了排序
        	 if(array[i]>array[j])
        	 {
        		 count+=j-mid;//其实对应为j+1-(mid+1)
        		 copy[locCopy--]=array[i--];
        		 if(count>1000000007)//数组过大求余数
        		 {
        			 count%=1000000007;
        		 }
        	 }
        	 else
        	 {
        		 copy[locCopy--]=array[j--];
        	 }
         }
         //如果有一方排序完，即其中一组数比另一组都大或小，那么将另一组（此时有序的值复制进去）
         //如果左边一个数大于右边最大的，那么右边所有的数都比左边小
         
         for(;i>=low;i--)
         {
        	 copy[locCopy--]=array[i];
         }
         for(;j>mid;j--)
         {
        	 copy[locCopy--]=array[j];
         }
         //此时在小的组内，对应是有序的
         for(int s=low;s<=high;s++)
         {
        	 array[s]=copy[s];
         }
         return (leftCount+rightCount+count)%1000000007;
     }
    
    
    
     //返回大写字母和空格
     public void GetUpperString()
     {
    	 Scanner s=new Scanner(System.in);
    	 char c;
    	 String in="";
    	 String res="";
    	 while(s.hasNext())
    	 {
    		in=s.nextLine();
    		for(int i=0;i<in.length();i++)
    		{
    			c=in.charAt(i);
    			if((c>='A' && c<='Z') || c==' ')
    				res+=c;
    		}
    		
    	 }
    	 System.out.print(res);
    	 
     }
     
     //字符串转整数
     //parse 从语法上分析解析
     //parse Int 转int
     public int StrToInt(String str) {
    	if(str==null || str.equals(""))
    		return 0;
    	char[] a=str.toCharArray();
    	int flag=0;
    	if(a[0]=='-')
    		flag=1;
    	int sum=0;
    	for(int i=flag;i<a.length;i++){
    		if(a[i]=='+')
    			continue;
    		if(a[i]<'0' || a[i]>'9')
    			return 0;
    		else
    			sum=sum*10+(a[i]-'0');
    	}
    	return flag==0 ? sum:sum*(-1);
     }
     
     //删除重复的节点，排序节点
     public ListNode deleteDuplication(ListNode pHead)
     {
//    	 if(pHead==null)
//    		 return pHead;
//    	 ListNode h=null;
//    	 ListNode next;
//    	 ListNode t;
//    	 ListNode pre;
//    	 while(pHead.next!=null && pHead!=null){
//    		 next=pHead.next;
//    		 if(pHead.val==next.val)
//    		 {
//    			 t=next.next;
//    			 pHead=t;
//    		 }
//    		 else
//    		 {
//    			 if(h==null)
//    				 h=pHead;
//    			 else
//    				 h.next=pHead;
//    			 pHead=next;
//    		 }
//    	 }
//    	 return h;
    	 
    	 
    	 ListNode first=new ListNode(-1);
    	 first.next=pHead;
    	 ListNode p=pHead;
    	 ListNode last=first;
    	 
    	 //一次性把所有值全判断一遍
    	 //这里的设计是为了判断重复和空值
    	 //若一开始就是有重复1111122
    	 //first=last,一直到最后的null或非null的值，头是first.next
    	 //否则,last=p,并不改变,此时第一个不重复，不做改变
    	 //下一个
    	 while(p!=null && p.next!=null){
    		 if(p.val==p.next.val){
    			 int val=p.val;
    			 while(p!=null && p.val==val)
    				 p=p.next;
    			 last.next=p;//此时p是没有重复的第一个//有错就在里面
    		 }
    		 else{
    			 //若后面都没有重复依次进行，因为此时first.next 就是pHead的第一个
    			 //后面如果有重复，那么因为前面的last里都是没有重复的，所以里面的不改变
    			 //每次更新后last.next都是新的，原因在于没有重复不用更新对原来序列做修改
    			 //当且仅当重复时才做修改和更新，last.next=p;
    			 last=p;
    			 p=p.next;
    		 }
    	 }
    	 return first.next;
    	 
    	 
    		 
     }
     
     
     
     
     
     //链表中环的入口节点
     public ListNode EntryNodeOfLoop(ListNode pHead)
     {
         //设对应的值，首先是快慢指针法
    	 //a,2a 然后相遇点肯定是在环中，所以，是 l+b=a, l+b+c=2*a
    	 //所以环长度是a,然后从头往前头结点到达肯定是a-b,然后另一个环中节点肯定也是
    	 //得到环中节点
    	 ListNode N1=pHead;
    	 ListNode N2=pHead;
    	 ListNode N3=pHead;
    	 
    	 int circlecount=1;
    	 int linecount=1;
    	 int flag=0;
    	 if(pHead==null)
    		 return N1;
    	 //第一次找到环长度和环内节点
    	 //边界条件不同
    	 while(N1!=null && N2.next!=null){
    		 N1=N1.next;
    		 N2=N2.next.next;
    		 if(N1==N2){
    			//得到环长度是circlecount;
    	    	 //第二次找到环的入口节点和对应到入口节点的长度
    	    	 while(N1!=N3){
    	    		 N3=N3.next;
    	    		 N1=N1.next;
    	    		 linecount++;
    	    	 }
    	    	 if(N1==N3)
    	    		 return N3;
    		 }
    		 circlecount++;
    	 }
    	 return null;
    	 
    	
    	 
     }
     
     
     //删除开始和结尾的空格并将中间的空格合成一个
     public static void FormatString(char str[], int len){
//    	 //设两个指针，一个用于找，一个用于查
//    	 int begin=0;
//    	 int end=len-1;
//         //删除开始的空格
//    	 while(str[begin]==' ' && begin<len){
//    		 begin++;
//    	 }
//    	 
//    	//删除末尾的空格
//    	 while(str[end]==' ' && end>0){
//    		 end--;
//    	 }
//    	 
//         //找中间的空格
//    	 for(int i=begin;i<end;i++){
//    		 //第一个不是空格
//    		 while(str[i]!=' ')
//    			 i++;
//    		//记录第一个空格位置为 i
//    	
//    		
//    	 }
    	 int i=0,j=0;
    	 while(str[i]==' '){
    		 i++;
    	 }
    	 while(i<len-1){
    		 //表明对应的str[i]是“ ” 但是str[i+1] 不是 “ ”
    		 //复制是在i中开始复制的
    		 if(str[i]==' ' && (i==len-1  || str[i+1]==' ')){
    			 i++;
    			 continue;
    		 }
    		 str[j++]=str[i++];
    	 }
    	 
    	 for(int k=0;k<j;k++){
    		 System.out.print(str[k]);
    	 }
     }
     
     //求两个二叉树的公共父节点！！！！
//     //思路一：我们首先找到两个节点的高度差，然后从较靠近根结点的一层开始向上找，
//     //若父节点为同一节点则该节点为解。
//     
//     public static int getHeight(TreeNode node){
//    	 int height=0;
//    	 while(node!=null){
//    		 height++;
//    		 node=node.father;
//    	 }
//    	 return height;
//     }
//     
//     public static TreeNode LowestCommonAncestor(TreeNode first,TreeNode second) {
//    	 int height1=getHeight(first), height=getHeight(second),diff=height1-height2;
//    	 if(diff<0){
//    		 diff=-diff;
//    		 while(diff!=0){
//    			 diff--;
//    			 second=second.father;
//    		 }
//    	 }
//    	 else{
//    		 while(diff!=0){
//    			 diff--;
//    			 first=first.father;
//    		 }
//    	 }
//    	 //这是为了保证first与second都在同一层里，
//    	 //然后依次向上遍历得到最后的值
//    	 while(first!=second){
//    		 first=first.father;
//    		 second=second.father;
//    	 }
//     }
//     
     
     //动态规划问题 取最大获取的值！
//     用自底向上的动态规划解决，几行代码就足够了。
//     r[i][j]记录硬币序列是i到j的子问题，s[i][j]记录i到j的总额 .则有
//     r[i][j] = max{v[i] + s[i][j] - v[i]  -  r[i + 1][j],  v[j] + s[i][j] - v[j] -  r[i][j - 1]}.
//     = max{s[i][j]  -  r[i + 1][j],  s[i][j] - r[i][j - 1]}.
      
     //返回二叉树的下一个节点 中序遍历，递归实现
     //TreeNode 有next
     class TreeLinkNode {
    	    int val;
    	    TreeLinkNode left = null;
    	    TreeLinkNode right = null;
    	    TreeLinkNode next = null;

    	    TreeLinkNode(int val) {
    	        this.val = val;
    	    }
    	}
     
     public TreeLinkNode GetNext(TreeLinkNode pNode)
     {
    	 if(pNode==null)
    		 return null;
    	 //区分情况现节点位置
    	 //是根节点时,判断是否有右孩子返回
    	 if(pNode.next==null){
    		 if(pNode.right==null)
    			 return null;
    		 else 
    			 return GetBefore(pNode.right);   	  
    	 }
    	 //是左节点时，同理判断返回
    	 else if(pNode.next.left==pNode){
    		 if(pNode.right==null)
        		 return pNode.next;
        	 else{
        		 return GetBefore(pNode.right);
        	 }
    	 }
    	 //是右节点时
    	 else{
    		 if(pNode.right!=null){
    			 return GetBefore(pNode.right);
    		 }
    		 //返回最近的父节点的根节点
    		 else{
    			 //判断父节点在树中的位置，判断左右边不同
    			 //当前节点在上层树的左边返回上层-上层节点（即父节点的父节点）
    			 //当前节点在上层树的右边就继续向上找父节点，且对应父节点不是父节点父节点的左节点
    			 //同时考虑空值可能
    			 ////没右子树，则找第一个当前节点是父节点左孩子的节点
    			 while(pNode.next!=null){
    				 if(pNode.next.next.left==pNode.next)
    					 return pNode.next;
    				 pNode=pNode.next;
    			 }
    			 return null;
    		 }
    			 
    	 }
     }
      
     public TreeLinkNode GetBefore(TreeLinkNode pNode)
     {
    	 if(pNode.left==null)
    		 return pNode;
    	 else
    		 return GetBefore(pNode.left);
     }
     
     
     
     
     //走台阶问题
     //此处不同在于不应用递归 算法复杂度过大！！！ 所以要用正向推导的方式！
//     public int countWays(int n) {
//         // write code here
//    	 int sum=0;
//    	 if(n<=1)
//    		 return 0;
//    	 sum=countWays2(n);
//    	 return sum%1000000007;
//     }
//     
//     public int countWays2(int n){
//    	 if(n==2)
//    		 return 1;
//         else if(n==3)
//             return 2;
//    	 else
//    		 return (countWays2(n-1)+countWays2(n-2))%1000000007;
//     }
     public int countWays(int n) {
         // write code here
    	 int[] sum=new int[n+1];
    	 if(n<=1)
    		 return 0;
    	 else if(n==2)
    		 return 1;
    	 else if(n==3)
    		 return 2;
    	 else{
    		 sum[2]=1;
    		 sum[3]=2;
    		 for(int i=4;i<n;i++){
    			 sum[n]=(sum[n-1]+sum[n-2]);
    		 }
    	 }

    	 return sum[n]%1000000007;
     }
     
     
     
     //小球落到地面不跳！每次只跳一半
     public int calcDistance(int A, int B, int C, int D) {
         // write code here
    	 //数学中的极限思维
    	 return 3*(A+B+C+D);
//    	 int sum=0;
//    	
//    	 boolean down=true;
//    	 while(A>0){
//    		 sum=sum+A;
//    		 if(!down){
//    			 down=true;
//    		 }
//    		 else{
//    			 down=false;
//    			 A=A/2;
//    		 }
//    	 }
//    	 
//    	 down=true;
//    	 while(B>0){
//    		 sum=sum+B;
//    		 if(!down){
//    			 down=true;
//    		 }
//    		 else{
//    			 down=false;
//    			 B=B/2;
//    		 }
//    	 }
//    	 
//    	 down=true;
//    	 while(C>0){
//    		 sum=sum+C;
//    		 if(!down){
//    			 down=true;
//    		 }
//    		 else{
//    			 down=false;
//    			 C=C/2;
//    		 }
//    	 }
//    	 System.out.println(C);
//    	 down=true;
//    	 while(D>0){
//    		 sum=sum+D;
//    		 if(!down){
//    			 down=true;
//    		 }
//    		 else{
//    			 down=false;
//    			 D=D/2;
//    		 }
//    	 }
//         return sum;
     }
     
     //价值最高的礼物 京东笔试题
     public int getMost(int[][] board) {
//         // write code here
//    	 int max=0;
//    	 int maxright=0;
//    	 int maxdown=0;
//    	 //求向右走的解
//    	 maxright=getMost()
    	 //动态规划思想
    	 //每一次每个点取对应到达该点的最大值，要么是从上面过来的，要么是从下面过来的
    	 //那么从最左边开始依次加值遍历得到最右下角的点就是最大值！
    	 for(int i=0;i<board.length;i++)
    		 for(int j=0;j<board[0].length;j++){
    			 if(i==0&&j==0){
    				 //如果是起点坐标，不做任何处理。
    			 }else if(i==0){
    				 //如果走在行的临界边，也就是第一行，那么他只能向右走
                     //向右走的时候该点就要将后面的值加起来。
    				 board[i][j]+=board[i][j-1];
    			 }else if(j==0){
    				 board[i][j]+=board[i-1][j];
    			 }else{
    				//核心点在这，除去两个临界边，剩下的就是既能向右走，也能向下走，
                     //那么这时候就要考虑走到当前点的所有可能得情况，也就是走到当前点
                     //各自路径的和是不是这些所有到达该点路径当中最大的了。
                     //temup用来存储从该点上面走下来的最大路径和。
                     //templeft用来存储从该点左边走过来的最大路径的和，
    				 int temup=board[i-1][j];
    				 int templeft=board[i][j-1];
    				//这两者肯定只能选其一，进行比较，那个大，就把这个值加给当前点，
                     //因为从一开始我们就进行了大小的比较，每一个点存储的都是到达当前点
                     //的最大值。所以直到最后一个点为止，她的值就是当前最大值的和。只要返回
                     //最后一个点的内容就可以了。
    				 if(temup>templeft){
    					 board[i][j]+=temup;
    				 }
    				 else{
    					 board[i][j]+=templeft;
    				 }
    					 
    			 }
    			 
    			 
    		 }
    	 	return board[board.length-1][board[0].length-1];
     }
     
     
     public int getInitial(int n) {
         // write code here
    	 int sum=0;
    	 int left=0;
    	 for(int i=0;i<n;i++){
    		 //System.out.println(i+"; left:"+left);
    		 //结束条件可以省略！！！！！！！！！！！！！！！！
//    		 if(left>20)
//    			 break;
    		 if(sum==left)
    			 sum=sum*n;
    		 else{
    			 if((sum*n)%(n-1)==0)
    			 {
    				 sum=(sum*n)/(n-1);
    			 }
    			 else{
    				 left++;
    				 sum=left;
    				 i=-1;
    				 continue;
    			 }
    		 }
    		 sum+=1;
    		 //System.out.println(i+"; sum:"+sum);
    	 }
    	return sum;
    	 
     }
     
     
     //最小生成树
     /*
      * 最小生成树prim算法，加入最小邻接边生成最小生成树。
      * 首先构造一个零图，选择一个初始点加入到集合中，
      * 然后分别从原来顶点的集合中抽取一个顶点，
      * 选择的标准是构造成的树的权值最小，
      * 循序渐进最终生成一棵最小生成树
      */
     /**
      * @author 刘雁冰
      * @date 2015-02-13 20:23
      */
     
     /*
      * m:定义为无法到达的距离
      * weight:邻接矩阵表,weight表示权值
      * verNum:顶点的个数
      * lowerW:到新集合的最小权值
      * edge:存储到新集合的边
      * checked:判定顶点是否被抽取的集合
      */
     
     static int m=Integer.MAX_VALUE;
     static int[][] weight={
       {0, 0, 0, 0, 0, 0},  
       {0, m, 6, 9, 5, 13},  
       {0, 6, m, 6,7,8},  
       {0, 9,6,m,9,3},  
       {0, 5,7,9,m,3},  
       {0,13,8,3,3,m}};
     static int verNum=weight.length;
     static int []lowerW=new int[verNum];
     static int []edge=new int[verNum];
     static boolean []checked=new boolean[verNum];
     
     public void prim(int n,int [][]w){
    	 checked[1]=true;
    	 
    	 for(int i=1;i<=n;i++){//初始化顶点集合
    		 lowerW[i]=w[1][i];
    		 edge[i]=1;
    		 checked[i]=false;
    	 }
    	 
    	 //取当前树中最小的节点 和对应最小的带权路径
    	 for(int i=1;i<=n;i++){
    		 int min=Integer.MAX_VALUE;
    		 int j=1;
    		 for(int k=2;k<=n;k++){
    			 if(lowerW[k]<min&&(!checked[k])){
    				 min=lowerW[k];
    				 j=k;
    			 }
    		 }
    		 
    		 //将最小的带权路径输入，并做标记
    		 if(i<n)
        		 System.out.println(j+"-->"+edge[j]);
    		 checked[j]=true;
    		 
    		 for(int k=2;k<=n;k++){//根据新得到的节点求出最小的权值
    			 if((w[j][k]<lowerW[k])&&(!checked[k])){
    				 lowerW[k]=weight[j][k];
    				 edge[k]=j;
    			 }
    		 }
    		 
    	 }
    	 
    	   
    	 
     }
     
     
     
   //按之字型打印二叉树！
 	/*按层序遍历分层打印的代码，添加一段判断用以倒序输出即可*/
 	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
 		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
 		if(pRoot==null){
 			return result;
 		}
 		boolean leftToRight=true;
 		//在java中队列的实现采用Linkedlist
 		//Queue<TreeNode> layer=new LinkedList<TreeNode>()
 		Queue<TreeNode> layer=new LinkedList<TreeNode>();
 		ArrayList<Integer> layerList=new ArrayList<Integer>();
 		layer.add(pRoot);
 		int start=0,end=1;
 		//layer.isEmpty()
 		while(!layer.isEmpty()){
 			TreeNode cur=layer.remove();
 			layerList.add(cur.val);
 			start++;
 			if(cur.left!=null){
 				layer.add(cur.left);
 			}
 			if(cur.right!=null){
 				layer.add(cur.right);
 			}
 			if(start==end){
 				//每次动态更新layer Queue中的长度！此时已经将上一层的释放出来
 				end=layer.size();
 				start=0;
 				//不是从左到右那么就翻转链表
 				if(!leftToRight){
 					result.add(reverse(layerList));
 				}
 				else{
 					result.add(layerList);
 				}
 				leftToRight=!leftToRight;
 				layerList=new ArrayList<Integer>();
 			}
 		}
 		return result;
     }
 	
     private ArrayList reverse(ArrayList<Integer> layerList){
    	 int length=layerList.size();
    	 ArrayList<Integer> reverseList=new ArrayList<Integer>();
    	 for(int i=length-1;i>=0;i--){
    		 reverseList.add(layerList.get(i));
    	 }
    	 return reverseList;
     }
     
     
     //机器人走过的路径！！！！！！请问该机器人能够达到多少个格子？
     public int movingCount(int threshold, int rows, int cols)
     {
         int flag[][]=new int[rows][cols];//记录是否走过！
         return helper(0,0,rows,cols,flag,threshold);
     }
     
     //很明显返回值为1或0
     private int helper(int i,int j,int rows,int cols,int [][]flag,int threshold){
    	 if(i<0 || i>=rows || j<0 || j>=cols || flag[i][j]==1 || numSum(i)+numSum(j)>threshold)
    		 return 0;
    	 flag[i][j]=1;
    	 //如果满足条件继续从这里走，深度搜索！
    	 return helper(i+1,j,rows,cols,flag,threshold)+
    			helper(i-1,j,rows,cols,flag,threshold)+
    	 		helper(i,j+1,rows,cols,flag,threshold)+
    	 		helper(i,j-1,rows,cols,flag,threshold)+
    	 		1;
     }
     
     private int numSum(int i){
    	 int sum=0;
    	 do{
    		 sum+=i%10;
    	 }while((i=i/10)>0);
    	 return sum;
     }
     
     
     
     //关于子序列问题
     //1、最大子序列
     //比较前面连续几项的值是不是小于0，如果不是小于0那么可以继续延伸扩展
     //如果小于0表明当前的值是负数（在前一过程中会动态更新保留max用做比较）
     //那么从当前的值下一个开始新的探索 i+1
     
     //2、最长递增子序列
     //采用动态规划思想动态规划的思想，考虑{arr[0],...,arr[i]}的最长递增子序列时需要找到所有比arr[i]小的arr[j]，且j<i，结果应该是所有{arr[0],...,arr[j]}的最长递增子序列中最长的那一个再加1。即我们需要一个辅助的数组aid_arr，
     //aid_arr[i]的值是{arr[0],...,arr[i]}的最长递增子序列的长度，aid_arr[0]=1。
     //此时生成2个新数组，一个保留在对应i位置上的最大递增子序列长度
     //vector<int> monoseqlen(len,1);
     //vector<int> preindex(len,-1);
     //另外1个保留该序列前一个下标，对应可以通过stack将序列打印出来
     
     //3、最长公共子串
     //同样采用动态规划的思想
     //我们采用一个二维矩阵来记录中间的结果。
//     b　　a　　b
//
//     c　　0　　0　　0
//
//     a　　0　　1　　0
//
//     b　　1　　0　　1
//
//     a　　0　　1　　0
//
//     我们看矩阵的斜对角线最长的那个就能找出最长公共子串。
//
//     不过在二维矩阵上找最长的由1组成的斜对角线也是件麻烦费时的事，下面改进：当要在矩阵是填1时让它等于其左上角元素加1。
//
//     　　 b　　a　　b
//
//     c　　0　　0　　0
//
//     a　　0　　1　　0
//
//     b　　1　　0　　2
//
//     a　　0　　2　　0
//
//     这样矩阵中的最大元素就是 最长公共子串的长度。
//
//     在构造这个二维矩阵的过程中由于得出矩阵的某一行后其上一行就没用了，所以实际上在程序中可以用一维数组来代替这个矩阵。
//     每次构造的过程中会动态更新max长度值以及对应最后一个字符串的列位置
     //然后通过 string res=str1.substr(pos-maxele+1,maxele);截取即可
//     3、最长公共子序列
//
//     最长公共子序列与最长公共子串的区别在于最长公共子序列不要求在原字符串中是连续的，比如ADE和ABCDE的最长公共子序列是ADE。
//
//     我们用动态规划的方法来思考这个问题如是求解。首先要找到状态转移方程：
//
//     符号约定，C1是S1的最右侧字符，C2是S2的最右侧字符，S1‘是从S1中去除C1的部分，S2'是从S2中去除C2的部分。
//
//     LCS(S1,S2)等于下列3项的最大者：
//
//     （1）LCS（S1，S2’）
//
//     （2）LCS（S1’，S2）
//
//     （3）LCS（S1’，S2’）--如果C1不等于C2； LCS（S1'，S2'）+C1--如果C1等于C2；
//
//     边界终止条件：如果S1和S2都是空串，则结果也是空串。
//
//     下面我们同样要构建一个矩阵来存储动态规划过程中子问题的解。这个矩阵中的每个数字代表了该行和该列之前的LCS的长度。与上面刚刚分析出的状态转移议程相对应，矩阵中每个格子里的数字应该这么填，它等于以下3项的最大值：
//
//     （1）上面一个格子里的数字
//
//     （2）左边一个格子里的数字
//
//     （3）左上角那个格子里的数字（如果 C1不等于C2）； 左上角那个格子里的数字+1（ 如果C1等于C2）
//
//     举个例子：
//
//      　　　　  G　　C　　T　　A
//
//     　　 0　　0　　0　　0　　0
//
//     G　 0　　1　　1　　1　　1
//
//     B　 0　　1　　1　　1　　1
//
//     T　 0　　1　　1　　2　　2
//
//     A    0　　1　　1　　2　　3
//
//     填写最后一个数字时，它应该是下面三个的最大者：
//
//     （1）上边的数字2
//
//     （2）左边的数字2
//
//     （3）左上角的数字2+1=3,因为此时C1==C2
//
//     所以最终结果是3。
//
//     在填写过程中我们还是记录下当前单元格的数字来自于哪个单元格，以方便最后我们回溯找出最长公共子串。有时候左上、左、上三者中有多个同时达到最大，那么任取其中之一，但是在整个过程中你必须遵循固定的优先标准。在我的代码中优先级别是左上>左>上。
//     
//     
//     
//     
     
     
     
     
     
     
     
     
     
     
     
     
     //美团笔试题 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
     public int getDis(int[] A, int n) {
    	 //此时必须是有序的，即后面的比前面的大 所以不能简单排序
//         // write code here
//    	 //返回最大差值，排序后即可
//    	 if(A.length==0 || A==null || n<=0)
//    		 return 0;
//    	 Arrays.sort(A);
//    	 return A[A.length-1]-A[0];
    	 //其实我感觉就是最大递增子序列！哈哈哈哈单其实并不是。。。。。
    	 //最长递增子序列比的是长度这里比的是大小
    	 int max=0;
    	 if(A.length==0 || A==null || n<=0)
    		 return 0;
    	 for(int i=0;i<n;i++){
    		 for(int j=i;j<n;j++){
    			 if(A[j]>A[i]){
    				 if(max<A[j]-A[i]){
    					 max=A[j]-A[i];
    				 }
    			 }
    		 }
    	 }
    	 return max;
     }
     
     //翻转棋子
     public int[][] flipChess(int[][] A, int[][] f) {
         // write code here
    	 //int [][]res=new int[A.length][A[0].length];
    	 int x=1;
    	 int y=1;
    	 //肯定只有行与列，2
    	 for(int i=0;i<f.length;i++){
    		 x=f[i][0];
    		 y=f[i][1];
    		 //基础判断与筛选.考虑临界情况
    		 //注意两次下标起始位置不一样
    		 flip(A,x-1,y-1);
    	 }
    	 return A;
     }
     
     public void flip(int[][] A,int x,int y){
//    	 if(x>0 && x<A.length-1 && y>0 && y<A[0].length-1){
//    		 A[x][y-1]=1-A[x][y-1];
//    		 A[x][y+1]=1-A[x][y+1];
//    		 A[x-1][y]=1-A[x-1][y];
//    		 A[x+1][y]=1-A[x+1][y];
//    	 }
//    	 else if(x==0 && y==0){
//    		 A[x][y+1]=1-A[x][y+1];
//    		 A[x+1][y]=1-A[x+1][y];
//    	 }
//    	 else if(x==0){
//    		 A[x][y-1]=1-A[x][y-1];
//    		 A[x][y+1]=1-A[x][y+1];
//    		 A[x+1][y]=1-A[x+1][y];
//    	 }
//    	 else if(y==0){
//    		 A[x][y+1]=1-A[x][y+1];
//    		 A[x-1][y]=1-A[x-1][y];
//    		 A[x+1][y]=1-A[x+1][y];
//    	 }
//    	 else if(x==A.length-1 && y==A[0].length-1){
//    		 A[x][y-1]=1-A[x][y-1];
//    		 A[x-1][y]=1-A[x-1][y];
//    	 }
//    	 else if(x==A.length-1){
//    		 A[x][y-1]=1-A[x][y-1];
//    		 A[x][y+1]=1-A[x][y+1];
//    		 A[x-1][y]=1-A[x-1][y];
//    	 }
//    	 else if(y==A[0].length-1){
//    		 A[x][y-1]=1-A[x][y-1];
//    		 A[x-1][y]=1-A[x-1][y];
//    		 A[x+1][y]=1-A[x+1][y];
//    	 }
    	 //上面写的太烂了 直接判断即可
    	 if(x>=0 && x<=A.length-1 && y-1>=0 && y-1<=A[0].length-1)
    		 A[x][y-1]=1-A[x][y-1];
    	 if(x>=0 && x<=A.length-1 && y+1>=0 && y+1<=A[0].length-1)
    		 A[x][y+1]=1-A[x][y+1];
    	 if(x-1>=0 && x-1<=A.length-1 && y>=0 && y<=A[0].length-1)
    		 A[x-1][y]=1-A[x-1][y];
    	 if(x+1>=0 && x+1<=A.length-1 && y>=0 && y<=A[0].length-1)
    		 A[x+1][y]=1-A[x+1][y];
     }
     
     
     /**生产者消费者问题，涉及到几个类 
      * 第一，这个问题本身就是一个类，即主类 
      * 第二，既然是生产者、消费者，那么生产者类和消费者类就是必须的 
      * 第三，生产什么，消费什么，所以物品类是必须的，这里是馒头类 
      * 第四，既然是线程，那么就不是一对一的，也就是说不是生产一个消费一个，既然这样，多生产的往哪里放， 
      *      现实中就是筐了，在计算机中也就是数据结构，筐在数据结构中最形象的就是栈了，因此还要一个栈类 
      */  
     
     class ProduceConsume{
    	 
     }
     
     
     //单例模式敲一敲
     //懒汉式等需要时再进行实例化
//     class Singleton{
//    	 private Singleton(){}
//    	 private static Singleton single=null;
//    	 //静态工厂方法
//    	 //加一个对象锁
//    	 //再加一个类锁
//    	 public static synchronized Singleton getInstance(){
//    			 synchronized(Singleton.class){
//    				 if(single==null){
//    					 single=new Singleton();
//    			 }
//    		 }
//    		 return single;
//    	 } 
//     }
     
     
       //饿汉式.饿汉式提前实例化，不会出现线程同步问题
       static class Singleton1{
    	   private Singleton1(){}
    	   private static final Singleton1 single=new Singleton1();
    	   //静态工厂方法
    	   public static Singleton1 getInstance(){
    		   return single;
    	   }
       }
       
       
       public static void testall(){
    	  Map<String,Integer> staff=new HashMap<String,Integer>();
    	  staff.put("Hello0", 1);
    	  for(int i=0;i<5;i++){
    		  if(staff.containsKey("Hello"+i)){
    			  staff.put("Hello"+i, staff.get("Hello"+i));
    		  }else{
    			  staff.put("Hello"+i, 1);
    		  }
    	  }
    	  staff.remove("HAHAH");
    	  for(Map.Entry<String, Integer> entry : staff.entrySet()){
    		  String key=entry.getKey();
    		  Integer value=entry.getValue();
    		  System.out.println("Key:"+key+",Value:"+value);
    	  }
    	  Set<String> keys=staff.keySet();
    	  Collection<Integer> values=staff.values();
       }
     
       
      //构造回文序列
       public static void WY1(){
    	   Scanner sc=new Scanner(System.in);
    	   while(sc.hasNext()){
    		   int times=0;
    		   //int n
    	   }
       }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     /**
      * 拜访问题 美团
      * @param args
      * @throws Exception
      */
     public int countPath(int[][] map, int n, int m) {
         // write code here
    	 //首先找出1和2的位置
    	 int i,j;
    	 int x1=0,x2=0,y1=0,y2=0;
    	 for(i=0;i<n;i++){
    		 for(j=0;j<m;j++){
    			 if(map[i][j]==1){
    				 x1=i;y1=j;
    			 }else if(map[i][j]==2){
    				 x2=i;y2=j;
    			 }
    		 }
    	 }
    	 if(x1==x2 && y1==y2){
    		 //两点重合
    		 return 1;
    	 }
    	 
    	 if(x1>x2){//由于正反方向相同统一实现x1,y1用于存小坐标的值
    		 x1=x1^x2^(x2=x1);
    		 y1=y1^y2^(y2=y1);
    	 }
    	 
    	 //数组使用动态规划实现值的递增
    	 int dp[][]=new int[n][m];
    	 if(y1<y2){//两点处在主对角线上
    		 dp[x1][y1]=1;
    		 //首先初始化边界线
    		 for(i=x1+1;i<=x2;i++){
    			 dp[i][y1]=map[i][y1]==-1?0:dp[i-1][y1];
    		 }
    		 for(j=y1+1;j<=y2;j++){
    			 dp[x1][j]=map[x1][j]==-1?0:dp[x1][j-1];
    		 }
    		 for(i=x1+1;i<=x2;i++){
    			 for(j=y1+1;j<=y2;j++){
    				 dp[i][j]=map[i][j]==-1?0:dp[i-1][j]+dp[i][j-1];
    			 }
    		 }
    	 }
    	 else{
    		 //如果处在副对角线上
    		 dp[x1][y1]=1;
    		 for(i=x1+1;i<=x2;i++){
    			 dp[i][y1]=map[i][y1]==-1?0:dp[i-1][y1];
    		 }
    		 for(j=y1-1;j>=y2;j--){
    			 dp[x1][j]=map[x1][j]==-1?0:dp[x1][j+1];
    		 }
    		 for(i=x1+1;i<=x2;i++){
    			 for(j=y1-1;j>=y2;j--){
    				 dp[i][j]=map[i][j]==-1?0:dp[i-1][j]+dp[i][j+1];
    			 }
    		 }
    	 }	
    	 return dp[x2][y2];
    	 
    	 
     }
     
     
     
     //直方图内的最大矩形
     //直接遍历即可
     public int countArea(int[] A, int n) {
         // write code here
    	 int max=0;
    	 int area=0;
    	 int i,j,Lleft,Lright;
    	 for(i=0;i<n;i++){
    		 Lleft=0;
    		 Lright=0;
    		 //向右能延伸的长度
    		 //可以等于
    		 for(j=i;j<n;j++){
    			 //System.out.println("test1:"+A[j]+","+A[i]+","+(A[j]>A[i]));
    			 if(A[j]>=A[i])
    				 Lright++;
    			 else 
    				 break;
    		 }
    		 //向左能延伸的长度
    		 for(j=i-1;j>=0;j--){
    			 if(A[j]>=A[i])
    				 Lleft++;
    			 else
    				 break;
    		 }
    		 area=(Lleft+Lright)*A[i];
    		 //System.out.println("A:"+area);
    		 if(area>max)
    			 max=area;
    	 }
    	 return max;
     }
     
     
     //字符串排序字典序
     public void StringOrder(){
    	 Scanner sc=new Scanner(System.in);
    	 while(sc.hasNext()){
    		 long result=0;//注意要用long
    		 String begin=sc.next();
    		 String end=sc.next();
    		 int len1=sc.nextInt();
    		 int len2=sc.nextInt();
    		 int maxlen=begin.length()>end.length()?begin.length():end.length();
    		 int minlen=begin.length()<end.length()?begin.length():end.length();
    		 for(int i=0;i<maxlen;i++){
    			 int distance;
    			 //前面的只是比较字符长度
    			 //距离 一个为abcde,一个为hij
    			 //minlen=3; maxlen=5;
    			 //使用排列组合递归求
    			 if(i<minlen){
    				 distance=end.charAt(i)-begin.charAt(i);
    			 }
    			 //类似进制递归计算 最后一位不存在默认为‘a’-1
    			 else{
    				 if(begin.length()>end.length()){
    					 distance='a'-begin.charAt(i)-1;
    				 }
    				 else{
    					 distance=end.charAt(i)-'a'+1;
    				 }
    					 
    			 }
    			 long now=0;
    			 //计算字典序的进制
    			 //后面的只计算到len2
    			 //因为在len2后面的都是比len2长的，所以只计算到len2
    			 for(int j=len1;j<=len2;j++){
    				 //要去掉本身
    				 //每一位有26个其实是倍数的关系
    				 //从对应的递归位开始减为每一位代表的会有的长度值
    				 //即对应的字符串值，对应的所有字符串递增值
    				 if(j-i-1>=0){
    					 //这里说明字典树只有在比他大一位的地方有变动
    					 //下面才会覆盖掉小的len1和len2
    					 //所以判断条件是j-i-1 而不是j-i
    					 //所以是下面的情况
    					 now=now+(long)Math.pow(26, j-i-1);
    				 }
    				 now=(now*distance)%1000007;
    				 result+=now;
    			 }
    			 //最后返回减去自身
    			 System.out.println(result-1);
    		 }
    	 }
     }
     
     
     //平均年龄
     public void averOld(){
    	 Scanner sc=new Scanner(System.in);
    	 while(sc.hasNext()){
    		 double w=sc.nextDouble();
    		 double y=sc.nextDouble();
    		 double x=sc.nextDouble();
    		 int n=sc.nextInt();
    		 while(n>0){
    			 y=(y+1)*(1-x)+x*21;
    			 n--;
    		 }
    		 System.out.println((int)Math.ceil(y));
    	 }
    	 
     }
     
     
     
     //用stack实现队列操作
     class StackToQueue{
    	 Stack<Integer> stack1=new Stack<Integer>();
    	 Stack<Integer> stack2=new Stack<Integer>();
    	 
    	 public void add(int node){
    		 stack1.push(node);
    	 }
    	 
    	 //如果有新加入的暂存在stack1内也是有顺序的不用怕
    	 public int remove(){
    		 if(stack2.isEmpty()){
    			 //如果stack2为空则stack1
    			 while(!stack1.isEmpty()){
    				 stack2.push(stack1.pop());
    			 }
    		 }
    		 return stack2.pop();
    	 }
     }
     
     
//     //霍夫曼编码
//     1.将字符串转为字符数组，遍历统计每个字符出现的次数，放入hash表中
//     2.创建节点TreeNode，放入一个优先队列
//     3.构建哈夫曼树合并两个权重最小的节点，直到只剩下根节点root
//     4.带着深度遍历树，计算长度和
//     
//     
       public void HuffmanCode(){
    	   Scanner input=new Scanner(System.in);
    	   while(input.hasNext()){
    		   String s=input.nextLine();
    		   int result=hafuman(s);
    		   System.out.println(result);
    	   }
    	   
       }
       
       public static int hafuman(String s){
    	   char[] chars=s.toCharArray();
    	   //构件hash表存放每个字符串及出现次数
    	   Map<Character,Integer> hash=new HashMap<>();
    	   for(int i=0;i<chars.length;i++){
    		   if(hash.containsKey(chars[i])){
    			   hash.put(chars[i], hash.get(chars[i])+1);
    		   }
    		   else
    		   {
    			   hash.put(chars[i], 1);
    		   }
    	   }
    	 //优先队列（最小推），每次能得到weigh最小的node
    	   //优先队列可以主动设置权值
    	   Queue<CodeNode> q=new PriorityQueue<>(hash.size(),new Comparator<CodeNode>(){
    		   @Override
    		   public int compare(CodeNode o1,CodeNode o2){
    			   return Integer.compare(o1.weight, o2.weight);
    		   }
    		   
    		   
    	   });
    	   
    	   for(Map.Entry<Character, Integer> entry : hash.entrySet()){
    		   q.offer(new CodeNode(entry.getValue(),entry.getKey()));
    	   }
    	   
    	   while(q.size()>1){
    		   //弹出两个最小的合并成1个node
    		   CodeNode left=q.poll();
    		   CodeNode right=q.poll();
    		   CodeNode father=new CodeNode(left.weight+right.weight);
    		   father.left=left;
    		   father.right=right;
    		   q.offer(father);
    	   }
    	   CodeNode root=q.poll();
    	   return valLength(root,0);	   
       }
     
       
       public static int valLength(CodeNode node,int depth){
    	   if(node==null)
    		   return 0;
    	   return (node.ch==null ? 0:node.weight)*depth+valLength(node.left,depth+1)+valLength(node.right,depth+1);
       }
       
      static class CodeNode{
    	  int weight;//权重
    	  Character ch;//如果是初始字符，则ch为字符，如果是合并的，则为null
    	  CodeNode left;
    	  CodeNode right;
    	  
    	  public CodeNode(int weight){
    		  this.weight=weight;
    	  }
    	  
    	  public CodeNode(int weight,Character ch){
    		  this.weight=weight;
    		  this.ch=ch;
    	  }
    	  
      }
     
     
     //求取第奇位的数字
      public void getOddNum(){
    	  Scanner sc=new Scanner(System.in);
    	  while(sc.hasNext()){
    		  int n=sc.nextInt();
    		  System.out.println(FindOdd(n,new LinkedList<Integer>(),true));
    	  }
    	  
      }
     
     
      public static int FindOdd(int n,LinkedList<Integer> init,boolean first){
    	  LinkedList<Integer> li=new LinkedList<>();
    	  if(n<=0)
    		  return 0;
    	  if(first==true){
    		  for(int i=1;i<n;i+=2){
        		  li.add(i);
        	  }
    	  }
    	  else{
    		  for(int i=1;i<init.size();i+=2){
    			  li.add(init.get(i));
    		  }
    	  }
    	  
    	  if(li.size()==1){
    		  return li.get(0);
    	  }
    	  else
    		  return FindOdd(n,li,false);
    	  
    	  
      }
     
      //打印二维数组
      /**
       *  题意很简单，主要是边界的处理：
       *   1. 沿着主对角线打印，所以每次打印之后x与y都要加1，直到x或y超出边界。
       *   2. 每轮遍历的起始点，是遵循(0,n-1)...（0,0）...（n-1,0）。
        *           也就是y先减小到0，然后x增加到n-1。所以遍历的终止条件是startX>=n。 *
       **/
      public int[] arrayPrint(int[][] arr,int n){
//    	  int[] A=new int[n*n];
//    	  int p=0;
//    	  //连续对称放置
//    	  for(int p1=n-1;p1>-1;p1--){
//    		  for(int p2=0;p2<n-p1;p2++){
//    			  A[p]=arr[p2][p1+p2];
//    			  A[n*n-1-p]=arr[]
//    		      p++;
//    		  }
//    	  }
    	  int[] res=new int[n*n];
    	  int index=0;
    	  int startX=0;
    	  int startY=n-1;
    	  while(startX<n){
    		  int x=startX;
    		  int y=startY;
    		  while(x<n&&y<n){
    			  res[index++]=arr[x++][y++];
    		  }
    		  //两个方向的依次递减，取每一层的起点然后层次遍历
    		  if(startY>0){
    			  startY--;
    		  }
    		  else
    			  startX++;
    	  }
    	  return res;
    	  
      }
      
      
      //股票交易日
    //简单说一下我的做题思路，
      //其实我的原始思路是用二分法做，先把数组从中间分开，
      //然后在两部分中分别找最大差值，然后保存最大差值进行相加
      //完事之后，将中间的指针，也就是进行二分的指针向右移或者向左移
      //又划分成了两部分，依次找最大差值，
      //直到最后两个差值之和为最大值，返回最大值。
      public int maxProfit(int[] prices, int n) {
    	  int temp1=0,temp2=0,temp3=0,l=0;
    	  //既然从中间划分两部分，之后又要在往前划分和往后划分，
          //所以直接一开始就从最前面开始划分，将数组划分两部分
    	  while(l<n){
    		  //l变量用来划分数组
              //第一个for循环寻找的最大差值，仅限于l变量之前。
    		  for(int i=0;i<l+1;i++){
    			  for(int j=i+1;j<l+1;j++){
    				  if(prices[j]-prices[i]>temp1){
    					  temp1=prices[j]-prices[i];
    				  }
    			  }
    		  }
    		  ////第二个for循环寻找的最大差值，仅限于l变量之后。
    		  for(int i=l+1;i<n;i++){
    			  for(int j=i+1;j<n;j++){
    				  if(prices[j]-prices[i]>temp2){
    					  temp2=prices[j]-prices[i];
    				  }
    			  }
    		  }
    		  //取前后两者差值最大之和
    		  if(temp2+temp1>temp3){
    			  temp3=temp2+temp1;
    		  }
    		  temp2=0;
    		  temp1=0;
    		  l++;
    	  }
    	  return temp3;
      }
      
      
      //钓鱼比赛
      public static void fish(){
    	  Scanner sc=new Scanner(System.in);
    	  while(sc.hasNext()){
    		  String[] s1=sc.nextLine().split(" ");
    		  int n=Integer.parseInt(s1[0]);
    		  int m=Integer.parseInt(s1[1]);
    		  int x=Integer.parseInt(s1[2]);
    		  int y=Integer.parseInt(s1[3]);
    		  int t=Integer.parseInt(s1[4]);
    		  double ccp=0.00;
    		  double ssp=0.00;
    		  for(int i=1;i<=n;i++){
    			  String[] s=sc.nextLine().split(" ");
    			  for(int j=1;j<=m;j++){
    				  double p=1-Double.parseDouble(s[j-1]);
    				  if(i==x&&j==y){
    					  ccp=p;
    				  }
    				  ssp+=p;
    			  }
    		  }
    		  ssp/=(n*m);
    		  if(ccp<ssp){
    			  System.out.println("cc");
    			  System.out.printf("%.2f\n",1-Math.pow(ccp, t));
    		  }else if(ccp>ssp){
                  System.out.println("ss");
                  System.out.printf("%.2f\n", 1-Math.pow(ssp,t));
              }else{
                  System.out.println("equal");
                  System.out.printf("%.2f\n", 1-Math.pow(ccp,t));
              }
    		  
    	  }
      }
      
      
      //蘑菇阵，路径计算到达概率
      public static void mushroom(){
    	  Scanner sc=new Scanner(System.in);
    	  while(sc.hasNext()){
    		  int n=sc.nextInt();
    		  int m=sc.nextInt();
    		  int k=sc.nextInt();
    		  boolean[][] map=new boolean[n][m];
    		  //put mushroom
    		  for(int i=0;i<k;i++){
    			  int x=sc.nextInt()-1;
    			  int y=sc.nextInt()-1;
    			  map[x][y]=true;
    		  }
    		  //动态更新到达某一点的概率
    		  double[][] cw=new double[n][m];
    		  //所以一般有很多会动态初始化首行和首列
    		  cw[0][0]=1;
    		  for(int i=0;i<n;i++){
    			  for(int j=0;j<m;j++){
    				  if(map[i][j])
        				  cw[i][j]=0;
    				  else if(i==0 && j==0){
    				  }
    				  else{
    					  	//考虑从左边和上边过来的情况
    					  	//同时考虑边界，如果到了临界边只有一条路可走，概率为1
    					   cw[i][j]=(j-1<0?0:(i+1<n?cw[i][j-1]*0.5:cw[i][j-1]))+(i-1<0?0:(j+1<m?cw[i-1][j]*0.5:cw[i-1][j])); 
    				  }	  
    			  }
    			 
    		  }
    		  double res=cw[n-1][m-1];
			  System.out.println(String.format("%.2f", res));
    	  }
      }
      
      
      
      
      
      
      public static void Bags(){
    	  Scanner scanner=new Scanner(System.in);
    	  //考虑0值情况
    	  while(scanner.hasNext()){
        		  int messCount=scanner.nextInt();
        		  Meal meal=new Meal(messCount,scanner.nextInt(),scanner.nextInt());
        		  for(int j=0;j<messCount;j++){
        			  int foodCount=scanner.nextInt();
        			  Mess mess=new Mess(foodCount);
        			  for(int t=0;t<foodCount;t++){
        				  mess.allFood[t]=new Food(scanner.nextInt(),scanner.nextInt());
        				  
        			  }
        			  meal.messes[j]=mess;
        		  }  
        		  System.out.println(meal.eat());
    	  }
      }
      
      
      static class Food{
    	  int price;
    	  int joy;
    	  public Food(int price,int joy){
    		  this.price=price;
    		  this.joy=joy;
    	  }
      }
      
     static class Mess{
    	  int foodCount;
    	  Food[] allFood;
    	  public Mess(int count){
    		  this.foodCount=count;
    		  allFood=new Food[count];
    	  }
    	  
    	  //背包问题递归算法
    	  //动态规划
    	  public int eat(int bot,int top){
    		  //扩展桶，设置数组下标同桶的大小，直接用i表示对应重量不做其他，因为有0的可能
    		  int[][] r=new int[foodCount][top+1];
    		  for(int i=0;i<=top;i++){
    			  if(i>=allFood[0].price){
    				  r[0][i]=allFood[0].joy;
    			  }
    			  else
    				  r[0][i]=0;
    		  }
    		  
    		  for(int i=1;i<foodCount;i++){
    			  for(int j=0;j<=top;j++){
    				  //如果小于不便同上一行
    				  if(j<allFood[i].price){
    					  r[i][j]=r[i-1][j];
    				  }else{
    					  r[i][j]=Math.max(r[i-1][j], r[i-1][j-allFood[i].price]+allFood[i].joy);
    				  }
    				  
    			  }
    		  }
    		  
    		  return r[foodCount-1][bot-1]==r[foodCount-1][top]? 0:r[foodCount-1][top];
    		  
    	  }
    	  
    	  
      }
      
      
      static class Meal{
    	  Mess[] messes;
    	  int bot;
    	  int top;
    	  
    	  public Meal(int count,int bot,int top){
    		  this.bot=bot;
    		  this.top=top;
    		  messes=new Mess[count];
    	  }
    	  
    	  //Mess为对应食堂个数
    	  public int eat(){
    		  int enjoy=0;
    		  for(int i=0;i<messes.length;i++){
    			  int tmp=messes[i].eat(bot, top);
    			  if(tmp>enjoy)
    				  enjoy=tmp;
    		  }
    		  return enjoy;
    	  }
    	  
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      //深度搜索实现
      static int n;
      static int [][]adj;
      static boolean vis[];
      static int ans=Integer.MAX_VALUE;
      public static void citypath(){
    	  Scanner in=new Scanner(System.in);
    	  while(in.hasNext()){
    		  n=in.nextInt();
    		  adj=new int[n][n];
    		  vis=new boolean[n];
    		  String rub=in.nextLine();
    		  for(int i=0;i<n;i++){
    			  String str=in.nextLine();
    			  String[] line=str.split(",");
    			  for(int j=0;j<n;j++){
    				  adj[i][j]=Integer.parseInt(line[j]);
    			  }
    		  }
    		  //把四个点都进行一遍深度搜索，然后暴力求解
    		  for(int i=0;i<n;i++){
    			  pathdfs(i,1,0);
    		  }
    		  System.out.println(ans);
    	  }
    	  
      }
      
      static void pathdfs(int i,int len,int cost){
    	  //每次内部的深度搜索都是通过第一个i来进行计数比较
    	  if(len==n){
    		  ans=Math.min(ans, cost);
    		  return;
    	  }
    	  if(cost>=ans)
    		  return;
    	  vis[i]=true;//vis用于计数表明是否访问过
    	  //这里的暴力破解会进行遍历所有的情况
    	  //即使是里面的单次遍历也是会进行所有情况的比较
    	  //包括对应所有的点和实现，从某点出发，接着下一个到完全不同的另一个点
    	  //然后遍历所有情况实现
    	  for(int j=0;j<n;j++){
    		  if(j!=i && !vis[j]){
    			  pathdfs(j,len+1,cost+adj[i][j]);
    		  }
    	  }
    	  vis[i]=false;
      }
      
      
      
      //转移连续入狱的n名犯人
      public static void GetPrison(){
    	  Scanner sc=new Scanner(System.in);
    	  while(sc.hasNext()){
    		  int n=sc.nextInt();
    		  int t=sc.nextInt();
    		  int c=sc.nextInt();
    		  int[] a=new int[n];
    		  for(int i=0;i<n;i++){
    			  a[i]=sc.nextInt();
    		  }
    		  //这里表明对应应该是连续的；
    		  //其实也好做，每次递增差值即可
    		  int count=0;
    		  int tempt=0;
    		  //获得初始值
    		  for(int i=0;i<c;i++){
    			  tempt+=a[i];
    		  }
    		  if(tempt<=t){
    			  count++;
    		  }
    		  for(int i=c;i<a.length;i++){
    			  tempt=tempt+a[i]-a[i-c];//依次加入一个新的，然后去掉最开始的
    			  if(tempt<=t)
    				  count++;
    		  }
    		  System.out.println(count);
    		  
    	  }
    	  
      }
      
//      如果一个类继承了一个接口，那它就要实现接口里面的所有方法。
      //围城方格的面积
      public static void Cirtangle(){
    	  Scanner sc=new Scanner(System.in);
    	  while(sc.hasNext()){
    		  int n=sc.nextInt();
    		  //因为要做取值和筛选，所以是反的
    		  int maxX=Integer.MIN_VALUE;
    		  int maxY=Integer.MIN_VALUE;
    		  int minX=Integer.MAX_VALUE;
    		  int minY=Integer.MAX_VALUE;
    		  for(int i=0;i<n;i++){
    			  int x=sc.nextInt();
    			  int y=sc.nextInt();
    			  maxX=(int)Math.max(maxX, x);
    			  maxY=(int)Math.max(maxY, y);
    			  minX=(int)Math.min(minX, x);
    			  minY=(int)Math.min(minY, y);
    		  }
    		  int side=Math.max((maxX-minX), (maxY-minY));
    		  System.out.println(side*side);
    	  }
      }
      
      
      
      
      //水仙花数
      public static void waterflower(){
    	  int x=0;
    	  for(int i=100;i<=999;i++){
    		  int b=i/10;
    		  int s=(i-100*b)/10;
    		  int g=(i-s*10-b*100);
    		  
    		  if(i==g*g*g+s*s*s+b*b*b){
    			  x++;
    			  System.out.print(i+" ");
    		  }
    	  }
    	  
      }
      
      
      
      
      
      
      
      
      
      
      
      //有向图中有无环
      
      
      
      
      
      
     
     
     
    
    
    //This is for real check here ! 
	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		Main mtest=new Main();
//		String file="E:\\RFID项目\\Algorithm\\test.txt";
//		int num=0;
//		num=mtest.ReverseString(file);		
//		TreeNode temp=new TreeNode(8);
//		temp.left=new TreeNode(6);
//		temp.right=new TreeNode(9);
////		boolean flag=mtest.isSymmetrical(temp);
////		System.out.println(flag);
//		Main mtest =new Main();
//		ArrayList <Integer> t;
//		//int [] a={1,2,4,7,11,15};
//		t=mtest.PrintFromTopToBottom(temp);
//		for(int x: t)
//		{
//			System.out.println(x+" ");
//		}
		Main mtest=new Main();
//		ListNode head=mtest.new ListNode(3);
//		ListNode next=mtest.new ListNode(4);
//		ListNode snext=mtest.new ListNode(5);
//		head.next=next;
//		head.next.next=snext;
//		ListNode temp;
//		temp=mtest.ReverseList(head);
//		//System.out.println(temp.val);
//		while(temp!=null)
//		{
//			System.out.println(temp.val);
//			temp=temp.next;
//		}
		//多维数组的定义
//		int [][]a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		int [][]a={{1},{2},{3}};
////		int [][]a={{1}};
//		ArrayList <Integer>temp=new ArrayList<Integer>();
//		temp=mtest.printMatrix(a);
//		for(int x: temp)
//		{
//			System.out.print(x+" ");
//		}
		//System.out.println(a.length+","+a[1].length);
//		int sum=mtest.NumberOf1Between1AndN_Solution(13);
//		System.out.println(sum);
//		int []a={1,2,3,2,2,2,5,4,2};
//		int m=mtest.MoreThanHalfNum_Solution(a);
//		System.out.println(m);
		//Proxy.newProxyInstance(arg0, arg1, arg2)
//		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
//		result=mtest.FindContinuousSequence(9);
//		System.out.println(result);
//		int[]a={1,2,3};
//		System.out.println(mtest.VerifySquenceOfBST(a));
//		Main.Solution s=mtest.new Solution();
//		//Main.Solution s=new Main().new Solution();
//		TreeNode root=new TreeNode(10);
//		root.left=new TreeNode(5);
//		root.left.left=new TreeNode(4);
//		root.left.right=new TreeNode(7);
//		root.right=new TreeNode(12);
//		System.out.println(mtest.PrintFromTopToBottom(root));
//		System.out.println(mtest.FindPath(root, 22));
//		String test="hellooo";
//		System.out.println(test);
//		System.out.println(mtest.LeftRotateString(test, 3));
//		RandomListNode test=mtest.new RandomListNode(1);
//		test.next=mtest.new RandomListNode(2);
//		test.random=mtest.new RandomListNode(3);
//		test.next.next=test.random;
//		test.next.random=test;
//		test.next.next.next=null;
//		test.next.next.random=test.next;
//		RandomListNode head=test;
//		while(test!=null)
//		{
//			System.out.println("test:"+test.label);
//			if(test.next!=null)
//				System.out.println("test.next:"+test.next.label);
//			if(test.random!=null)
//				System.out.println("test.random:"+test.random.label);
//			System.out.println();
//			test=test.next;
//		}
//		RandomListNode result;
//		
//		System.out.println("after:::");
//		System.out.println("head:"+head.label);
//		result=mtest.Clone(head);
//		while(head!=null)
//		{
//			System.out.println("test:"+head.label);
//			if(head.next!=null)
//				System.out.println("test.next:"+head.next.label);
//			if(head.random!=null)
//				System.out.println("test.random:"+head.random.label);
//			head=head.next;
//		}
//		int x=0;
//		for(int i=0;i<100;i++)
//		{
//			//第一个全为2
//			//判断其是否是整数
//			if((Math.log(i)/Math.log(2*3*5))==(int)(Math.log(i)/Math.log(2*3*5)))
//				System.out.println(i);
//			else if((Math.log(i)/Math.log(2))==(int)(Math.log(i)/Math.log(2)))
//				System.out.println(i);
//			else if((Math.log(i)/Math.log(3))==(int)(Math.log(i)/Math.log(3)))
//				System.out.println(i);
//			else if((Math.log(i)/Math.log(5))==(int)(Math.log(i)/Math.log(5)))
//				System.out.println(i);
//			else if((Math.log(i)/Math.log(2*3))==(int)(Math.log(i)/Math.log(2*3)))
//				System.out.println(i);
//			else if((Math.log(i)/Math.log(2*5))==(int)(Math.log(i)/Math.log(2*5)))
//				System.out.println(i);
//			else if((Math.log(i)/Math.log(3*5))==(int)(Math.log(i)/Math.log(3*5)))
//				System.out.println(i);
//	   
//		}
		//int x=mtest.StrToInt("");
		
		//System.out.println(x);
//		ListNode h1=mtest.new ListNode(1);
//		ListNode h2=mtest.EntryNodeOfLoop(h1);
	
		//System.out.println(mtest.calcDistance(100, 90, 80, 70));
		//System.out.println(mtest.getInitial(3));
		//mtest.prim(verNum-1, weight);
//		int[][] A={{0,1,0,0},{1,0,1,0},{1,1,0,0},{1,0,0,1}};
//		int[][] f={{3,1},{3,1},{1,4}};
//		mtest.flipChess(A, f);
//		for(int i=0;i<A.length;i++){
//			for(int j=0;j<A[0].length;j++){
//				System.out.print(A[i][j]+" ");
//			}
//			System.out.println();
//		}
//		Queue<Integer> q = new LinkedList<>();
//		LinkedList<Integer> li=new LinkedList<>();
//		ArrayList<Integer> ali=new ArrayList<>();
//		
//		int[] A={2,7,9,4,1};
//		System.out.println(mtest.countArea(A, 5));
		//Main.mushroom();
		Main.Bags();
		
	}
	
}