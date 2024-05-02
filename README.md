# Bouncing Squares
By Sebastian Stefanowicz (sstefano@macalester.edu), Zander Leong (zleong@macalester.edu), and Harold Ponce Saldivar (hponcesa@macalester.edu)

## Description
Our project is a simulation of square graphics objects on a canvas course or map. The squares will bounce around the map and each other until all of them reach a designated zone or zones. In "race" mode, the designated zone will be a 
finish line and placements/winners will be determined by the order in which the squares cross the line. Whereas in 
"deathmatch" mode, placements/winners will be determined by the reverse order in which the squares enter the zones. 

## Requirements
The program requires Java version 17 and uses the java.awt, java.util, and edu.macalester.graphics packages.

## How To Run
To run the game: open the project code in your external editor of choice, run the SquareGame.java file, and select a map to see the simulation.

## Limitations
The only major bug in the code occurs when a square hits the corner of a wall and gets caught midway through the wall. Most of the time this is not game-breakings, as the square frees itself after a second or two. This can, however, cause the ball to gain abnormal velocity, which can interfere with the logic that causes the balls to bounce off of each other.

## Inspiration
The inspiration for this project comes from @project_jdm on YouTube, who makes short-form videos of this variety like: https://youtube.com/shorts/2D_7zhpqHMI?si=tgFZFDU4D_dLvf2K and https://youtube.com/shorts/-00rjsVTPYc?si=8e_N__7eljRYTYVO

## Demo Video


## What it looks like

<img width="598" alt="Screen Shot 2024-05-02 at 4 17 39 PM" src="https://github.com/mac-comp127-s24-alhashim/project-02_harold_sebastian_project/assets/156940876/99cbe49d-ae8b-4367-92e5-4706af7ac4e4">

<img width="598" alt="Screen Shot 2024-05-02 at 4 19 06 PM" src="https://github.com/mac-comp127-s24-alhashim/project-02_harold_sebastian_project/assets/156940876/d6794390-2e09-49b0-b580-d416e7d72370">

<img width="598" alt="Screen Shot 2024-05-02 at 4 20 59 PM" src="https://github.com/mac-comp127-s24-alhashim/project-02_harold_sebastian_project/assets/156940876/042a9b4c-e4ee-4674-969f-9a6461cfd492">

<img width="599" alt="Screen Shot 2024-05-02 at 4 20 43 PM" src="https://github.com/mac-comp127-s24-alhashim/project-02_harold_sebastian_project/assets/156940876/06eb3466-b1a1-4a9d-a5e0-ea2c777c0ba8">
