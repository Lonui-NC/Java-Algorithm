import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AliTest {
	//邮费减免的优惠券
		Map <Float,Float> post=new HashMap<Float,Float>();
		//存放对应的减免总额
		List <Float> postSum=new ArrayList<Float>();
		//红包减免的优惠券
		Map <Float,Float> red=new HashMap<Float,Float>();
		//存放对应的减免总额
		List <Float> redSum=new ArrayList<Float>();
		AliTest()
		{
			//实现构造函数
			//包括对应的post与red的初始化等
			//篇幅有限不再写	
			InitPost();
			InitRed();
		}
		//邮费减免初始化
		public void InitPost()
		{
			//第一个对应为达到的总金额，第二个为对应达到的减免金额
			post.put(100.0f,10.0f);
			postSum.add(100.0f);
			post.put(200.0f,20.0f);
			postSum.add(200.0f);
		}
		//红包减免初始化
		public void InitRed()
		{
			red.put(200.0f, 30.0f);
			redSum.add(100.0f);
			red.put(300.0f, 40.0f);
			redSum.add(100.0f);
		}
		
		//推荐系统，返回对应的红包和免邮优惠券的Map队列
		//对应的项目包括String,优惠券名称，红包或者邮费
		//后面跟对应在该项目下所有推荐的优惠券Map
		//float中对应为购物车中的金额sum
		public Map <String,Map<Float,Float>> Recommand(float sum)
		{
			//返回的变量
			Map <String,Map<Float,Float>> result =new HashMap<String,Map<Float,Float>>();
			//对于输入的sum为和的float 类型进行分类和判断，与现有数值比较
			Float [] redCho=new Float[redSum.size()];
			redSum.toArray(redCho);
			Float [] postCho=postSum.toArray(new Float[postSum.size()]);
			Arrays.sort(redCho);
			Arrays.sort(postCho);
			int i=0;
			int j=0;
			Map<Float,Float> redtemp=new HashMap<Float,Float>();
			Map<Float,Float> postemp=new HashMap<Float,Float>();
			//对邮费进行分类和判断
			if(sum>redCho[0])
			{
				redtemp.put(redCho[0], red.get(redCho[0]));
				//for循环依次实现将对应的东西都存入其中，表明优惠券的力度
				for(j=0;j<redCho.length;j++)
				{
					if(sum>redCho[j])
						redtemp.put(redCho[j], red.get(redCho[j]));
					else//若对应已经达不到优惠额，退出
						break;
				}
				//若所有优惠券都推荐完，则对应不做处理
				if(j==redCho.length)
				{
					
				}
				else//若对应未推荐完所有推荐，则将离当前购物额最近的购物券也推荐给用户
				{
					redtemp.put(redCho[j+1], red.get(redCho[j+1]));
					result.put("red",redtemp);
				}
				
				
			}
			else
			{
				redtemp.put(redCho[0], red.get(redCho[0]));
				result.put("red",redtemp);
			}
			
			
//			//对应进行邮费的判断，下一步
//			if(sum>postCho[0])
//			{
//				postemp
//				result.put("post", new Map<postCho[0],red.get(postCho[0])>);
//				//for循环依次实现将对应的东西都存入其中，表明优惠券的力度
//				for(j=0;j<postCho.length;j++)
//				{
//					if(sum>postCho[j])
//						result.put("post", new Map<postCho[j],red.get(postCho[j])>);
//					else//若对应已经达不到优惠额，退出
//						break;
//				}
//				//若所有优惠券都推荐完，则对应不做处理
//				if(j==postCho.length)
//				{
//					
//				}
//				else//若对应未推荐完所有推荐，则将离当前购物额最近的购物券也推荐给用户
//				{
//					result.put("post", new Map<postCho[j+1],red.get(postCho[j+1])>);
//				}
//			}
//			else
//			{
//				result.put("post", new Map<postCho[0],red.get(postCho[0])>);
//			}
//			
//			//此时综上所述，对应所有的优惠劵待组合的已经全都输入到了result里
//			//result中的结果为所有符合条件的优惠券
			return result;
//			
		}
		
		
		//choose函数中对第一步处理的结果，temp为上一函数的result结果，包含所有适合推荐的优惠券
		//在choose函数中对其做进一步处理，用于选择在相同条件情况下选取对用户减免金额最大的处理
		//
		public  Map <String,Map<Float,Float>>  Choose(Map <String,Map<Float,Float>> temp,float sum)
		{
			Map <String,Map<Float,Float>> afResult =new HashMap<String,Map<Float,Float>>();
			//在下列函数体中进行优惠的筛选和比较
			return afResult;
		}
}
