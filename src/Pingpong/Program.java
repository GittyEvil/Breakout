package Pingpong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Program extends JFrame {
	GameBoard board;
	Game game;
	private static String namn;
	private States status = States.running;
	HighScores<String> highscore;
	LatestRuns<Integer> runs;
	private JList<String> highscoreGlista;
	private JList<Integer> latestRGlista;
	
	public Program() {
		highscore = new HighScores<String>();
		runs = new LatestRuns<Integer>();
		highscoreGlista = new JList<>(highscore.getList());
		latestRGlista = new JList<>(runs.getList());
		board = new GameBoard(highscore, runs,status);
		
		highscoreGlista.setBackground(Color.gray);
		latestRGlista.setBackground(Color.gray);
		highscoreGlista.setFocusable(false);
		latestRGlista.setFocusable(false);
		board.setFocusable(true);
		
		BorderLayout border = new BorderLayout();
		board.setLayout(border);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		add(board, BorderLayout.CENTER);
		add(highscoreGlista, BorderLayout.EAST);
		add(latestRGlista, BorderLayout.WEST);
		
		highscoreGlista.setVisible(true);
		latestRGlista.setVisible(true);
		latestRGlista.setPreferredSize(getPreferredSize(200,100));
		highscoreGlista.setPreferredSize(getPreferredSize(200,300));
		setResizable(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}
	
	private Dimension getPreferredSize(int i, int j) {
		// TODO Auto-generated method stub
		return new Dimension(i, j);
	}
	public static String getText() {
		return namn;
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