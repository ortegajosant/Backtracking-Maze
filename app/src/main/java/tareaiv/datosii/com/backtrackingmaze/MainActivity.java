package tareaiv.datosii.com.backtrackingmaze;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private GameView gameView;
    private Button mazeButton;
    private Button fixButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mazeButton = (Button) findViewById(R.id.mazeButton);
        fixButton = (Button) findViewById(R.id.fixButton);

        mazeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView = GameView.getInstance();
                gameView.makeMaze();
                gameView.setMazeON(true);
            }
        });

        fixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView = GameView.getInstance();
                gameView.fixMaze();
            }
        });
    }
}
