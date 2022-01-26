import java.util.*;

public class ReadyQueue {

	static LinkedList toCrawl = new LinkedList();
	 static int totalNode=0;
	 
	public static void  addNode(int val){
		totalNode++;
		if(totalNode<1000)
		{
			toCrawl.add(val);
			
		}
	}
	
	public static void  removeNode(){
		
		if(totalNode==0)
		{
			System.out.println("The list is already empty");
		}
		else{
		//	totalNode--;
			System.out.println("Node Removed is "+toCrawl.getFirst());
			toCrawl.removeFirst();
				
		}
		//if(totalNode==10)
	//	{	FriendSearch.getMatrix();
			FriendSearch.getFriendList();
			FriendSearch.getMatrix();
			//FriendSearch.writeAdjList();
		//	FriendSearch.writeAdjMatrix();
			
		//}
		
	}
	
	public static void showToCrawl(){
		
		System.out.println(toCrawl);
	}
	
	public static Object getNodeValue(){
		//int n;
		//n=(int) toCrawl.getFirst();
	//	System.out.println(toCrawl.getFirst());
		return toCrawl.getFirst();
	}
	
	
}
