osztály tudja használni az interfészt (kb őstípusként lehet rá hivatkozni)
Az intrfészben absztrak metódusok vannak (eleve nem kell megadni), de ha az osztály használja, akkor meg kell adnia, hogy mit csináljon
Az interfészek is tudnak öröklődni
Az interfész metódusfejeke definiál a későbi implementációhoz (képességek gyűjteménye)
ez a metódus vár egy paramétert -> aki az interfészt megvalósítja, az az interfészben deklarált változókat implementálja
this: az osztály egy példánya
Pl: az osztály implementálja az ActionListener interfészt
amikor a gombra kattintunk, akkor meg tudja hívni pl az actionListener(this)
gomb.addActionListener(ActionListener) <--- figyelő
innentől a gomb tudja, hogy a figylőjének van actionPerform metódusa
