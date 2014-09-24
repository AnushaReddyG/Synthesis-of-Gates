package synthesisoftreegates;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFiles {

	ArrayList<Tree> optArr = new ArrayList<Tree>();
	ArrayList<Float> gateLib= new ArrayList<Float>();
	public void GateSynthesis(String PinFile,String GateLibFile){
		try
		{

			File file1 = new File(PinFile);
			Scanner scanline1 = new Scanner(file1);
			scanline1.nextLine();//Read File using Scanner
			while (scanline1.hasNextLine()) { //check for existence of new line on the file
				String line = scanline1.nextLine();//read file line by line
				Scanner scanArrival = new Scanner(line);//reading line
				float arrivaltimes = scanArrival.nextFloat();
				Tree node=new Tree(arrivaltimes);
				optArr.add(node);
				
			/*	for (Tree s: optArr)
					System.out.println(s.getValue());
			*/	
				scanArrival.close();
			}
			scanline1.close();
			int gatecost=1;
			
	
			
			//reading GateLibFile
			File file2 = new File(GateLibFile);
			Scanner scanline2 = new Scanner(file2);
			scanline2.nextLine();//Read File using Scanner
			while (scanline2.hasNextLine()) { //check for existence of new line on the file
				String line1 = scanline2.nextLine();//read file line by line
				Scanner scanArrival1 = new Scanner(line1);//reading line
				float gateDelay = scanArrival1.nextFloat();
				gatecost=scanArrival1.nextInt();
				gateLib.add(gateDelay);
				
			
				scanArrival1.close();
			}
			scanline2.close();

			/*for (Float s: gateLib)
				System.out.println(s.floatValue());*/
			
			float minDelay;
			if(gateLib.size()==0){
				
			minDelay=1;
			}
			else{
				minDelay=gateLib.get(gateLib.size()-1);
			}
			
			int cost=0;
			
			while(optArr.size()!=1){
				// finding minimum element
				float min=optArr.get(0).getValue();
				int minIndex=0;
				for(int i=1;i<optArr.size();i++){
					if(min>optArr.get(i).getValue()){
						min=optArr.get(i).getValue();
						minIndex=i;
					}
				}
				//calculating optimized delay and postfix order printing
				if(minIndex==optArr.size()-1){
					Tree tmp = new Tree(optArr.get(minIndex-1).getValue()+minDelay);
					tmp.setLeft(optArr.remove(minIndex-1));
					tmp.setRight(optArr.remove(minIndex-1));
					optArr.add(minIndex-1, tmp);
					cost=cost+gatecost;

				}
				else if(minIndex==0){
					Tree tmp = new Tree(optArr.get(minIndex+1).getValue()+minDelay);
					tmp.setLeft(optArr.remove(minIndex));
					tmp.setRight(optArr.remove(minIndex));
					optArr.add(minIndex, tmp);
					cost=cost+gatecost;
				}
				else{
					if (optArr.get(minIndex+1).getValue() < optArr.get(minIndex-1).getValue())
					{
						Tree tmp = new Tree(optArr.get(minIndex+1).getValue()+minDelay);
						tmp.setLeft(optArr.remove(minIndex));
						tmp.setRight(optArr.remove(minIndex));
						optArr.add(minIndex, tmp);
						cost=cost+gatecost;

						
					}
					else
					{
						Tree tmp = new Tree(optArr.get(minIndex-1).getValue()+minDelay);
						tmp.setLeft(optArr.remove(minIndex-1));
						tmp.setRight(optArr.remove(minIndex-1));
						optArr.add(minIndex-1, tmp);
						cost=cost+gatecost;
					}
				}
				//optArr.remove(minIndex);	
			}
			System.out.println("optimized arrival time is:"+ optArr.get(0).getValue());
			System.out.println("Cost is:" +cost);
			System.out.println("The Topolgy in Postfix Notation :");
			this.PostOrder(optArr.get(0));
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}

	public void PostOrder(Tree node ){


		if(node!=null){
			PostOrder(node.getLeft());
			PostOrder(node.getRight());
			System.out.println((node.getValue()));
		}
		
	}
}

