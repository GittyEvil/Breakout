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
		Glista = new JList<>(highscore.getList());
		board = new GameBoard(highscore, runs);
		
		Glista.setSize(100, 100);
		Glista.setBackground(Color.white);
		Glista.setFocusable(false);
		
		BorderLayout border = new BorderLayout();
		board.setLayout(border);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		add(board, BorderLayout.CENTER);
		add(Glista, BorderLayout.EAST);
		
		setResizable(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
		//Program program1 = new Program();
	}

}
