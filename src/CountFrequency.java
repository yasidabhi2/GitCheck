import java.util.HashMap;

public class CountFrequency {
	public static void main(String[] args) {
		String a="#aa#ac#ac#aa#aw";
		
		HashMap<String,Integer> hm=new HashMap<>();
		String x[]=a.split("#");
		for(String c:x)
		{
			System.out.println(c);
			if(c.isEmpty())
			{
				
			}
			else if(hm.containsKey(c))
			{
				hm.put(c,hm.get(c)+1);
			}
			else
			{
				hm.put(c,1);
			}
		}
		System.out.println(hm);
	}
}
