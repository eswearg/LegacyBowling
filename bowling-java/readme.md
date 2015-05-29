     _____________________________________________________________
    |__1__|__2__|__3__|__4__|__5__|__6__|__7__|__8__|__9__|__10___|
    |  1|4|  4|5|  6|/|  5|/|   |X|  0|1|  7|/|  6|/|   |X|  2|/|6|
    |  5  |  14 |  29 |  49 |  60 |  61 |  77 |  97 | 117 |  133  |
    '-----'-----'-----'-----'-----'-----'-----'-----'-----'-------'
The game consists of 10 frames as shown above. In each frame the player has two opportunities to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two tries. The bonus for that frame is the number of pins knocked down by the next roll. So in frame 3 above, the score is 10 (the total number knocked down) plus a bonus of 5 (the number of pins knocked down on the next roll).

A strike is when the player knocks down all 10 pins on his first try. The bonus for that frame is the value of the next two balls rolled.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in the tenth frame.

source: http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata

New functionality:

Get the list of frames for the current game with scores. In the cases where the frame score is not yet calculable, return an empty string.

     _____________________________________________________________
    |__1__|__2__|__3__|__4__|__5__|__6__|__7__|__8__|__9__|__10___|
    |  1|4|  4|5|  6|/|  5|/|   | |   | |   | |   | |   | |   | | |
    |  5  |  14 |  29 |     |     |     |     |     |     |       |
    '-----'-----'-----'-----'-----'-----'-----'-----'-----'-------'