package com.game;

import com.battlechess.BattleChess;
import com.entity.Player;

public class RoomHandler implements Runnable{
	public RoomHandler() {
		if(Board.isFirstRoom) {
			Space[][] boardMaker = new Space[16][16];
			for(int r = 0;r<boardMaker.length;r++)
				for(int c = 0;c<boardMaker[r].length;c++) {
					if(r<2 || r > 13 || c < 2)
						boardMaker[r][c] = new Space(null,Space.State.CLEAR);
					else if(r == 2 || r == 13 || c == 2)
						boardMaker[r][c] = new Space(null,Space.State.WALL);
					else if(r == 4 && c == 0) {
						Player.getPlayer().setPos(r,c);
						boardMaker[r][c] = new Space(Player.getPlayer(),Space.State.WALL);
					}
					else
						boardMaker[r][c] = new Space(null,Space.State.USED);
				}
			Board.getBoard().newBoard(boardMaker);
			
		}
			
	}
	
	
	@Override
	public void run() {
		while(!Board.exit) {
			//System.out.println("Checking for new Board!");
		}
		Board.exit = true;
		(new Thread(new RoomHandler())).start();
	}

}
