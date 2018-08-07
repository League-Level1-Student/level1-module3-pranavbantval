import java.awt.Color;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class GridWorld {
	public static void main(String[] args) {
		World w = new World();
		w.show();
		Bug b = new Bug();
		Bug b2 = new Bug();
		Location l = new Location(0, 1);
		//w.add( l, b);
		Flower f = new Flower();
		Flower f2 = new Flower();
		b2.setColor(Color.BLUE);
		Location l2 = w.getRandomEmptyLocation();
		//w.add(l2, b2);
		b.turn();
		b.turn();
		Location l3 = new Location(0,2);
	//	w.add(l3, f);
	l3= new Location (0,0);
		
		//w.add(l3, f2);
		
	/*	for (int i = 0; i < 100; i++) {
			Flower f3 = new Flower();
			l3 = w.getRandomEmptyLocation();
			int x = l3.getRow();
			if(x%2==1) {
				f3.setColor(Color.WHITE);
			}
			else {
				f3.setColor(Color.RED);
			}
			w.add(l3, f3);
		}*/
	
	Location l4 = new Location(0,0);
	for (int i = 1; i < 6; i++) {
		Bug b3 = new Bug();
		
		w.add(l4, b3);
		l4 = new Location(i,i);
	}
	
		for (int j = 0; j < 5; j++) {
			Bug b3 = new Bug();
			
			w.add(l4, b3);
			l4 = new Location(j,-j+4);
		
	}
		l = new Location(4,0);
	w.add(l, b);
	}
}



  