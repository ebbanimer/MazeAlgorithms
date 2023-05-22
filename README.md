
1. A maze generator from the given maze image. The maze images can be downloaded from here . The suggestion is to use a medium rectangle maze such as Maze 7.
2. Find the shortest path with Dijkstra's algorithm. The solution shall be implemented in two versions, i.e., using two different data structures. For example, one implementation uses a heap as a data structure.
3. Find the shortest path with the A* algorithm.
4. Display the maze and the shortest path found for all implementations.
5. Calculate the run time complexity of all solutions and compare them.


- Download maze-image and render a maze using e.g. BufferedImage or Tesseract. Should be generic to be able
  render any type of maze.
- Find the shortest path using Dijkstra's
  - Two implementations with different datastructures 
    - Heap
    - ???
- Shortest path using A*
- Display maze with the shortest paths for all algorithms. 
- Time complexity??? 




# TODO'S:

- Verkar som att 2d boolean array är mest efficient i vårt allt, eftersom alla pixels har samma weights. en graph är
  bättre om man har olika graph strukturer och mer flexibel, men i vårt fall är det mög. dessutom så fick vi ner tiden
  när vi bara genererar maze 1 gång. 



Buggar:
- Kolla så att exekveringen av programmet är rätt - har det något att göra med JPanels?
- Kirra så att error-messages dyker upp (antagligen något fel med JPanel och exekveringen?).
- När man väljer koordinater utanför så skickar den ingen error och den gör pathen, men printas inte. varför true???
- När det kommer till fel koordinater: jag har testat samma logik som i restart med då kan den inte välja nya koordinater.
  Testat även med att showMaze(maze) igen men då blir det typ dubbelt? Så nu resettar jag bara koordinaterna och clickcount,
  men då blir det ju inte rätt med labels med "choose start blabla"
 
Features & annat:
- Finslipa time-complexity.
- Städa upp kod + kommentarer.
- MVG-grejer ???
  


fixa så man kan go back till start från pickingen


arv för att minska redundans i algoritmklasserna och mazepoint?


Emma imorgon: kolla igenom all kod + readme