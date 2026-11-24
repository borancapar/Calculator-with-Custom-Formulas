# Java Swing Calculator with Custom Formula Support

Unlike a basic calculator, this app lets you create your own formulas for everyday life or work and use them for quick calculations. You can save as many different formulas as you like and use them whenever you need.

This was my first Java project, built while learning Swing, event handling and object-oriented programming.

## Features

* Basic calculator: addition, subtraction, multiplication, division
* Chained operations: keep calculating without pressing `=` every time (e.g. `5 + 3 * 2 =`)
* Decimal numbers: only one decimal point per number is allowed
* Clear button (`C`) to reset
* Custom formulas: build a formula step by step (number, operator, number, ...), for example `((x + 5) * 2)`
* Formula list: up to 32 formulas, each one shown as a numbered button
* Apply a formula: pick a saved formula, enter a number and press `OK` to get the result
* Left-to-right evaluation: a formula applies its steps in the order you entered them, without operator precedence (`x + 5 * 2` is calculated as `(x + 5) * 2`)
* Multiple screens: calculator, formula list, new formula, formula usage

<img width="550" height="700" alt="Bildschirmfoto vom 2026-11-24 17-36-52" src="https://github.com/user-attachments/assets/f8ffaab9-70c6-42cd-9b3d-4e79351f699a" />
<img width="550" height="700" alt="Bildschirmfoto vom 2026-11-24 17-36-42" src="https://github.com/user-attachments/assets/9ea89a22-51de-4855-94c5-cab6876d6f50" />
<img width="550" height="700" alt="Bildschirmfoto vom 2026-11-24 17-35-59" src="https://github.com/user-attachments/assets/39f93e05-68a2-4f16-803d-75dc1fe67e02" />

## Challenges and What I Learned

While building this project, I paid extra attention to a few details that helped me understand Java and Swing much better:

* Allowing only one decimal point per number
* Supporting chained operations
* Making sure that typing a new number after a result starts a fresh input instead of appending to the previous result

Along the way, I learned and reinforced a lot about Java in general, as well as `JFrame`, object-oriented programming and `ArrayList`.

## Author

Boran Capar, [GitHub profile](https://github.com/borancapar)
