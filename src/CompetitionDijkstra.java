import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {

	public String filename;
	public int speedA;
	public int speedB;
	public int speedC;
	public double distanceToNextIntersection [][];
	public int edgeToIntersection [][];
	public int totalEdges;
	public int totalNumberOfIntersections;
	public int totalNumberOfStreets;
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
    */
    CompetitionDijkstra (String filename, int sA, int sB, int sC){
    	this.speedA = sA;
    	this.speedB = sB;
    	this.speedC = sC;
    	
    	try
    	{
    		File file = new File(filename);
    		Scanner s = new Scanner(file);
    		int i = 0;
    		while(s.hasNextLine())
    		{
    			String [] currentLine = s.nextLine().trim().split("\\s+");
    			if ( i ==1);
    			{
    				totalEdges = Integer.parseInt(currentLine[i-1]);
    			}
    			if (i ==0)
    			{
    				distanceToNextIntersection = new double[Integer.parseInt(currentLine[i])][Integer.parseInt(currentLine[i])];
    				edgeToIntersection = new int[Integer.parseInt(currentLine[i])][Integer.parseInt(currentLine[i])];
    				for(int j = 0; j < distanceToNextIntersection.length; j++)
    				{
    					for(int h = 0; h < distanceToNextIntersection[j].length; h ++)
    					{
    						distanceToNextIntersection[j][h] = Integer.MAX_VALUE;
    						if(j ==h)
    						{
    							distanceToNextIntersection[j][h] = 0;
    						}
    					}
    				}
    			}
    			
    			else 
    			{
    				distanceToNextIntersection[Integer.parseInt(currentLine[0])][Integer.parseInt(currentLine[1])] = Double.parseDouble(currentLine[2]);
    				edgeToIntersection[Integer.parseInt(currentLine[0])][Integer.parseInt(currentLine[1])] = Integer.parseInt(currentLine[0]);
    			}
    			i++;
    			
    			
    		}
    		for(int k = 0; k <distanceToNextIntersection.length; k++)
    		{
    			findShortestPath(k);
    		}
    		s.close();	
    	}
    	catch (Exception x) {
    		distanceToNextIntersection = new double[0][0];
    		edgeToIntersection = new int[0][0];
    		return;
    		}
    }


    /**
    * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){

        //TO DO
        return -1;
    }
    public void findShortestPath(int i)
    {
    	
    }

}