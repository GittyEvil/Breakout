package Pingpong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Program extends JFrame {
	GameBoard board;
	HighScores<Integer> highscore;
	LatestRuns<Integer> runs;
	private JList<Integer> Glista;
	
	public Program() {
		highscore = new HighScores<Integer>();
		runs = new LatestRuns<Integer>();
		board = new GameBoard(highscore, runs);
		Glista = new JList<>(highscore.getList());
		setLayout(new GridLayout(1,3));
		
		add(highscore);
		add(runs);
		add(board);
		//add(Glista);
		setResizable(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}
	
	private void add(LatestRuns<Integer> runs2) {
		
	}

	private void add(HighScores<Integer> highscore2) {
		
	}

	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	}

}
