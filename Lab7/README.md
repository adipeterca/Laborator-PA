<h1>Laboratory 7</h1>

For the compulsory part, I have done the following:
<ul>
    <li>three main classes: the GameManager class, the Player class and the Token class. Each one does a different thing:
        <ul>
            <li>the GameManager class : it handles the whole game, adding players, running them and printing the scores when the game ended. Also it prints the game table.</li>
            <li>the Player class : it has a name and a list of tokens. It also handles the interaction between the game board and its list of tokens. It uses a lock to access the game board (with <em>synchonized</em>).</li>
            <li>the Token class : it describes a token from the game, having all the attributes described in the laboratory description.</li>
        </ul>
    </li>
    <li>added a simple console interface for setting up the game (number of players, number of tokens, the minimum and maximum score for a token, etc)</li>
    <li>in the Main class, there are two static functions: <em>setupGame</em> and <em>startGame</em>, each doing a specific task.</li>
</ul>