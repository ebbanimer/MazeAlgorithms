package controllers;

import models.MainModel;
import support.Constants;
import views.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

/**
 * The program's main controller. Responsible for the communication between views and models,
 * responding to user input.
 */
public class MainController {

    private final MainModel mainModel = new MainModel();
    private final MainView mainView = new MainView(new SelectButtonListener(), new SolveButtonListener(), new RestartButtonListener());

    /**
     *  Inner class responsible for listening to the select maze button.
     */
    class SelectButtonListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Objects.equals(mainView.getFileName(), "")) { // Ensure that the user has entered a file name.
                try {
                    // Get values before calling show-maze.
                    String file = mainView.getFileName();

                    JPanel img = mainModel.getMaze(file);
                    mainView.showMaze(img);

                } catch (IOException ex) {
                    mainView.displayErrorMsg(Constants.ERR_NO_VALID_FILE);
                }
            } else {
                mainView.displayErrorMsg(Constants.ERR_NO_FILE_NAME);
            }
        }
    }

    /**
     * Inner class responsible for listening to the solve button.
     */
    class SolveButtonListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            // Display the loading panel in the view
            SwingUtilities.invokeLater(mainView::displayLoadingPanel);

            // Call the algorithms in a separate thread
            Thread algorithmsThread = new Thread(() -> {
                mainModel.showPoints(); // Make sure that the start and finish points are showing.
                Point start = mainView.getStartCoords();
                Point end = mainView.getFinishCoords();

                JPanel path1 = mainModel.displayPath(start, end, Constants.DIJK_HEAP);
                JPanel path2 = mainModel.displayPath(start, end, Constants.DIJK_DEQ);
                JPanel path3 = mainModel.displayPath(start, end, Constants.ASTAR);

                // Display the results in the view
                SwingUtilities.invokeLater(() -> {
                    mainView.displayResults(path1, path2, path3);

                    // Close the loading dialog after displaying the results
                    mainView.closeLoadingPanel();
                });
            });


            algorithmsThread.start();
        }

    }

    /**
     * Inner class responsible for listening to the restart button.
     */
    class RestartButtonListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            mainModel.clearPoints();
            mainView.init();
        }
    }
}
