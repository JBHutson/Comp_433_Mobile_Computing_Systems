package com.example.hutsonj.eight_queens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int[][] chessBoard = new int[8][8];
    int[][] queenLocations = new int[8][2];
    int queens = 0;


    public void placeQueen(View v) {
        String place = v.getTag().toString();

        int row = Character.getNumericValue(place.charAt(0));
        int column = Character.getNumericValue(place.charAt(2));
        char color = place.charAt(4);

        if (checkSpace(row, column) == true) {
            chessBoard[row][column] = 0;
            if (color == 'B') {
                v.setBackgroundColor(0xff000000);
            } else {
                v.setBackgroundColor(0xffcc0000);
            }
            for (int i = 0; i <= queens; i++) {
                if (queenLocations[i][0] == row && queenLocations[i][1] == column) {
                    queenLocations[i][0] = 0;
                    queenLocations[i][1] = 0;
                }
            }
            for (int i = 0; i <= queens; i++) {
                if (queenLocations[i][0] == 0 && queenLocations[i][1] == 0) {
                    if (queenLocations[i + 1][0] != 0 && queenLocations[i + 1][1] != 0) {
                        queenLocations[i][0] = queenLocations[i + 1][0];
                        queenLocations[i][1] = queenLocations[i + 1][1];
                        queenLocations[i + 1][0] = 0;
                        queenLocations[i + 1][1] = 0;
                    }
                }
            }
            queens--;
        } else {

            boolean columnTaken = false;
            boolean rowTaken = false;
            boolean diagTaken = false;


            // check row
            for (int i = 0; i < 8; i++) {
                if (chessBoard[row][i] == 1) {
                    rowTaken = true;
                }
            }
            // check column
            for (int i = 0; i < 8; i++) {
                if (chessBoard[i][column] == 1) {
                    columnTaken = true;
                }
            }
            if (queens > 0) {
                for (int i = 0; i <= queens; i++) {
                    int deltaRow = abs(row - queenLocations[i][0]);
                    int deltaColumn = abs(column - queenLocations[i][1]);
                    if (deltaColumn == deltaRow) {
                        diagTaken = true;
                    }
                }
            }
            if (rowTaken == true || columnTaken == true || diagTaken == true) {
                Toast.makeText(getApplicationContext(), "Invalid Move", Toast.LENGTH_SHORT).show();
            } else {
                chessBoard[row][column] = 1;
                v.setBackgroundResource(R.drawable.queen);
                queenLocations[queens][0] = row;
                queenLocations[queens][1] = column;
                queens++;

            }
            if (queens == 8) {
                Toast.makeText(getApplicationContext(), "Game Won", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void resetBoard(View view){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++) {
                chessBoard[i][j] = 0;
            }
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 2; j++){
                queenLocations[i][j] = 0;
            }
        }
        queens = 0;
        setContentView(R.layout.activity_main);
    }
    public boolean checkSpace(int x, int y) {
        if(chessBoard[x][y] == 1){
            return true;
        } else {
            return false;
        }
    }
}
