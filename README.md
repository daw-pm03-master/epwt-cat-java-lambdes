# Type: Exercici Pràctic Amb Teoria (With Theory)
# Language: Catalan
# Programming Language: Java
# Tools: IntelliJ, git
# Contents: behavior parametrization, lambda expressions 

Segona part de l'exercici pràctic 2 de la UF2.

Aquesta part **sí és avaluable**. Per a poder fer aquesta part, és necessari haver estudiat i fet la primera part d'aquest exercici pràctica, que també teniu publicada.

## PROGRAMACIÓ MODULAR - FUNCIONS AMB EXPRESSIONS LAMBDA

**Les funcions són la unitat més petita de modulorització de tota aplicació**. 

En aquesta segona part d'aquesta activitat aprendrem com les expressions lambda ens ajuden a fer un ús més simple, clar, net, mantenible i escalable de les funcions en els nostres programes.

Seguint amb l'exemple de les pomes de la primera part d'aquesta activitat, veurem com **les expressions lambda en ajuden a trobar la millor solució a la parametrització del comportament**.

### Introducció a les expressions lambda

Les expressions lambda existeixen en la gran majoria de llenguatges de programació moderns. **No són una altra cosa que una manera diferent d'escriure funcions**. Vegem-ho amb exemples:

Exemple 1:

Volem escriure una funció que ens retorni la longitud d'una cadena de text. Aprofitarem que la classe String té un mètode, anomenat `lenght()` que retorna el número de lletres (chars) que conté l'String. Podem anomenar la nostra funció, per exemple, `getLenght` :

```java
int getLenght(String s) {
  return s.lenght();
}
```

L'expressió lambda equivalent és:

```java
(String s) -> s.lenght()
```

Notem que **abans** de la fletxa hi ha **els paràmetres de la funció**, i **després** de la fletxa hi ha **allò que la funció retorna**. _No es posa el `return` doncs ja està implícit_.

Exemple 2:

Donada una poma (recordeu les Apple que vam veure a la part 1 d'aquesta activitat), volem saber si la poma és verda. Podem crear una funció que s'anomeni `isGreenApple`:

```java
boolean isGreenApple(Apple apple){
  return apple.color.equals("green");
}
```
Abans de mirar quina és la corresponent expressió lambda, **escriu-la** i després clica a _comprova_ per a comprovar si és correcte.

<details><summary>Comprova (exemple 2)</summary>
<p>

```java
(Apple a) -> a.color.equals("green")
```

</p>
</details>

Igual que en l'exemple 1, abans de `->`hi ha els paràmetres de la funció, i després de `->` hi ha allò que la funció retorna. 

Fixeu-vos que el nom de la variable usada per al paràmetre de tipus `Apple` en la signatura de la funció (paràmetre de nom `apple`) és diferent que el nom de la mateixa variable usada en l'expressió lambda (nom `a`). Com ja sabeu de la UF1, es pot posar el nom que es vulgui a les variables, i això no altera la nostra aplicació ni tampoc el fet que l'expressió lambda sigui equivalent. Emperò, com ja sabeu també de la UF1, és una bona pràctica de programació usar sempre noms per a les variables que siguin explicatius d'allò que representen.

Exemple 3:

Volem crear una funció que, donats dos enters, imprimeixi per pantalla la seva suma. Per exemple, podem crear la següent funció amb el nom `printSum`:

```java
void printSum(int x, int y) {
  System.out.println("Sum: ");
  System.out.println(x + y);
}
```

Aquesta funció no retorna res (`void`) i conté més d'una instrucció. Així doncs, quina és la corresponent expressió lambda? 

Pensa-hi una mica abans de comprovar la solució.

<details><summary>Comprova (exemple 3)</summary>
<p>

```java
(int x, int y) -> {   System.out.println("Sum: ");
                      System.out.println(x + y);
                  }
```

</p>
</details>

> Quan una funció no retorna res, en l'expressió lambda cal posar el codi de la funció, que va després de la fletxa, entre `{ }`.

Exemple 4:

Volem una funció que retorni simplement un String de salutació en anglès. Per exemple:

```java
String getHello() {
   return "Hello";
}
```
Abans de comprovar l'expressió lambda equivalent
, pensa-hi una mica i escriu-la.

<details><summary>Comprova (exemple 4)</summary>
<p>

```java
() -> "Hello"
```

Així de simple és. No té paràmetres d'entrada, i sempre retorna la cadena de text "Hello".
</p>
</details>


#### Sintaxis general de les expressions lambda

Amb els exemples vistos, podem entendre quina és la sintaxis general de les expressions lambda. Hi ha 2 formes:

```java
//Primera forma
//El return està implícit

(parameters) -> expression
```

```java
//Segona forma
//Múltiples instruccions

(parameters) -> { statements; }
```

## Exercici 0

_(Aquest exercic no és avaluable. Teniu la solució a continuació)_

Quines de les següents expresions lambda són invàlides?

1. `() -> "lambda expression"`
2. `() -> { return 33; }`
3. `() -> { }`
4. `(int n) -> return 2*n;`
5. `(String s) -> { "Programming"; }`


<details><summary>Solució</summary>
<p>

4 i 5 són expressions lambda invàlides.

1. Aquesta expressió representa una funció que no té paràmetres i retorna un String.
2. Equival a una funció que no té paràmetres i retorna un int. En aquest cas s'escriu explícitament el `return` perquè la instrucció està dins de `{ }`.
3. Representa una funció sense paràmetres i que retorna `void`, essent el cos de la funció buit.
4. Invàlida perquè si no hi ha `{ }` el return és implícit i no s'ha d'escriure.
5. Invàlida perquè la instrucció `"Programming";` no és una instrucció vàlida (penseu què faria aquesta instrucció si l'escriviu dins del cos d'una funció).

</p>
</details>


#### Més exemples d'expressions lambda

```java
//Exemple 1
(double x, double y) -> x > y
(Apple a) -> a.weight >= 150
(Apple a) -> a.color.equals("green")
```
Aquests tres exemples (exemple 1) són **predicats**, doncs representen funcions que retornen un **boolean**.

```java
//Exemple 2
() -> new Apple()
```
Aquest exemple (exemple 2) representa una funció sense paràmetres que retorna una nova instància de tipus Apple.

```
//Exemple 3
(Apple a) -> { System.out.println("Apple color is: " + a.color); }
```
Aquesta expressió lambda (exemple 3) representa una funció que té un únic paràmetre de tipus Apple, que imprimeix per pantalla el color de la poma, i que no retorna res (`void`).

### Com s'utilitzen les expressions lambda?

Ja hem vist quina forma tenen les expressions lambda, però encara no sabem com les podem usar en el nostre programa.

Recordem com s'usen les funcions: 

* D'una funció en definim tres coses, que són la seva signatura (nom de la funció i paràmetres), el seu valor de retorn, i la seva implementació (codi dins del bloc de codi de la funció). _Recordeu que les funcions abstractes no tenen implementació!_
* Un cop definida la funció, la podem usar cridant-la en qualsevol punt del nostre programa escrivint el nom de la funció (i passant valors per a cada paràmetre si és el cas).

Exemple d'ús d'una funció:

```java
//Definim i implementem la funció test
boolean test(Apple a) {
   return a.color.equals("green");
}

Apple a = new Apple();
a.color = "red";

//Cridem la funció test usant el seu nom
boolean isGreen = test(a);
System.out.println("Apple is green? " + isGreen); //false
```

Fixeu-vos, però, que **les expressions lambda no tenen nom !**. Per tant, **com podem usar les expressions lambda**?

> En Java, les expressions lambda només es poden usar allà on hi hagi una **interfície funcional**. D'aquesta manera, l'expressió lambda **proveirà una implementació per al mètode abstracte** de la interfície funcional. La única condició que cal complir és que l'expressió lambda **sigui compatible** amb la signatura del mètode abstracte de la interfície funcional, és a dir, que tinguin els mateixos paràmetres i tipus de dada de retorn.

Vegem-ho amb els següents exemples:

Primer exemple:

```java
//Exemple 1

public interface MyFunctionalInterface {
    public void execute();
}

//Sense expressions lambda:

//Hem de crear una classe que implementi la interfície
public class MyFunctionalClass implements MyFunctionalInterface {
    public void execute() {
       System.out.println("Execute method is run");
    }
}

//Hem d'instanciar la classe,
//que podem assignar a una variable 
//de tipus de dada MyFunctionalInterface
//gràcies al polimorfisme
MyFunctionalInterface my = new MyFunctionalClass();

//Executem el mètode execute, que ens imprimirà
//per pantalla el missatge "Execute method is run"
my.execute();

//Amb expressions lambda:

//No cal crear cap classe que implementi la interfície
//Directament podem fer:
MyFunctionalInterface my = () -> { System.out.println("Execute method is run"); }
my.execute();

//L'expressió lambda determina la implementació (comportament)
//del mètode abstracte de la interfície funcional
```

I si volem que el mètode `execute()`, d'aquest exemple 1, imprimeixi un missatge diferent o faci altres coses que no siguin imprimir missatges? Sense expressions lambda, caldria crear una classe que implementi la interfície per a cada nou comportament (recordeu que cada implementació determina un comportament) del mètode `execute()`. Amb expressions lambda no cal crear cap classe, simplement podem determinar la implementació (és a dir, el comportament) del mètode abstracte directament amb l'expressió lambda:

```java
//Exemple 1 (continuació)

my = () -> { System.out.println("Run from a lambda"); }
my.execute();

my = () -> { System.out.println("I love programming"); }
my.execute();

my = () -> { Arrays.bubbleSort(new int[]{4, 6, 1, 0, -2}); }
my.execute();

//Amb les expressions lambda anem assignant diferents implementacions
//al mètode execute() abans de cridar-lo.
//El mètode execute() cada vegada executarà instruccions diferents
//és a dir, es comportarà de manera diferent.

//L'expressió lambda ha de ser compatible amb
//la signatura del mètode execute():

my = (String message) -> { System.out.println(message); } //Error
//Error perquè el mètode execute() no té cap paràmetre
//i aquesta lambda té un paràmetre de tipus String
```

Segon exemple:

```java
//Exemple 2

//Recordem la classe Apple
//que teníem a la primera part
//d'aquesta activitat
publi class Apple {
   public String color = ""; //valor és ""
   public int weight; //valor per defecte, que és 0
}

//(El valor per defecte de l'String color és null)
//(Per evitar errors de tipus NullPointerException
//hem donat a l'String color un nou valor per defecte:
//la cadena buida "". Aquest valor podrà ser
//canviat per "green", "red", etc. en el nostre
//programa)

//Volem un mètode que ens retorni
//noves instàncies d'Apple
//Encapsulem aquest mètode
//dins d'una interfície funcional
public interface AppleFactory {
    public Apple getInstance();
}

//Amb expressions lambda:
//(No cal crear classes que implementin
//la interfície AppleFactory)
AppleFactory af = () -> new Apple();
Apple apple = af.getInstance();
```

Si volem un mètode que ens retorni una poma (Apple) d'un determinat color, podem modificar la interfície funcional de la següent manera (o crear una nova interfície funcional `AppleFactoryWithColor`):

```java
//Exemple 2 (continuació)

public interface AppleFactoryWithColor {
    public Apple getInstance(String color);
}

AppleFactoryWithColor afc = 
        (String color) -> { Apple a = new Apple();
                            a.color = color;
                            return a;
                          }

Apple greenApple = afc.getInstance("green");
```

Tornem a la interfície funcional `AppleFactory` que s'encarrega de crear pomes amb valors per defecte `""` i `0` per a les propietats `color` i `weight` d'Apple. Ara volem comprovar si una poma creada amb el mètode `getInstance` de `AppleFactory` és  una poma de color verd. Podem utilitzar el següent mètode `isAppleGreen`:

```java
boolean isAppleGreen(AppleFactory factory) {
   Apple apple = factory.getInstance();
   return apple.color.equals("green");
}
```

Com utilitzem aquest mètode `isAppleGreen`? Doncs bé, de la mateixa manera que l'expressió lambda la podem assignar a la variable `af` (exemple 2) que és de tipus de dada `AppleFactory`, també **la podem passar com a argument** a qualsevol funció que tingui un paràmetre de tipus de dada `AppleFactory`. Així, tindrem:

```java
//Exemple 2 (continuació)
boolean isGreen = isGreenApple(() -> new Apple());
//retorna false, perquè el valor per defecte
//de la propietat color d'Apple és ""
```

> En resum, les expressions lambda en Java es poden usar només **en el contexte d'interfícies funcionals**. Això vol dir que podem assignar una lambda a una variable que sigui de tipus de dada d'una interfície funcional, o podem passar una lambda com a argument a una funció que tingui un paràmetre de tipus de dada d'una interfície funcional.


### Parametrització del comportament amb expressions lambda

Volem un programa que ens faci les 4 operacions matemàtiques bàsiques sobre números decimals (suma, resta, multiplicació i divisió). Una solució innocent seria crear un mètode per a cada operació:

```java
//Solució innocent
double sum(double x, double y){
   return x + y;
}
double substract(double x, double y){
   return x - y;
}
double multiply(double x, double y){
   return x * y;
}
double divide(double x, double y){
   return x / y;
}
```

Una altra solució, més elegant, és la de parametritzar el comportament, com hem fet a la primera part d'aquest exercici pràctic amb les pomes. Per a parametritzar el comportament, hem de crear una interfície funcional:

```java
interface OperationSelector{
   double calculate(double x, double y);
}
```

I crear quatre classes, cadascuna de les quals implementarà el mètode `calculate` de manera diferent per a poder fer cadascuna de les quatre operacions:

```java
public class Sum implements OperationSelector{
   double calculate(double x, double y) {
      return x + y;
   }
}

public class Substraction implements OperationSelector{
   double calculate(double x, double y) {
      return x - y;
   }
}

public class Multiplication implements OperationSelector{
   double calculate(double x, double y) {
      return x * y;
   }
}

public class Division implements OperationSelector{
   double calculate(double x, double y) {
      return x / y;
   }
}
```

D'aquesta manera, podem calcular les diferents operacions sobre qualssevol parella de `double`, així:

```java
//Funció que usarem per a obtenir els resultats
double getMathResult(double a, double b, OperationSelector operation) {
      return operation.calculate(a,b);
}

//Sense lambdes
double a = 6.0, b = 3.0;

OperationSelector sum = new Sum();
OperationSelector substraction = new Substraction();
OperationSelector multiplication = new Multiplication();
OperationSelector division = new Division();

System.out.println(getMathResult(a,b,sum)); //imprimeix 9.0
System.out.println(getMathResult(a,b,substraction)); //imprimeix 3.0
System.out.println(getMathResult(a,b,multiplication)); //imprimeix 18.0
System.out.println(getMathResult(a,b,division)); //imprimeix 2.0
```

Però fent ús de les lambdes, no cal crear les quatre classes `Sum`, `Substraction`, `Multiplication` i `Division`. Podem passar directament les lambdes a la funció `getMathResult`:

```java
double sumResult = getMathResult(a,b,(a,b)-> a + b);
double substractionResult = getMathResult(a,b,(a,b)-> a - b);
double multiplicationResult = getMathResult(a,b,(a,b)-> a * b);
double divisionResult = getMathResult(a,b,(a,b)-> a / b);

System.out.println(sumResult); //imprimeix 9.0
System.out.println(substractionResult); //imprimeix 3.0
System.out.println(multiplicationResult); //imprimeix 18.0
System.out.println(divisionResult); //imprimeix 2.0
```

Fixeu-vos que en aquest darrer exemple hem escrit `(a,b) -> a + b` enlloc de `(double a, double b) -> a + b`. És correcte i està permès. El compilador de Java és capaç d'inferir els tipus de dades dels paràmetres a la lambda (si no els escrivim) a partir de la signatura del mètode abstracte de la interfície funcional. Això és el que s'anomena _**type inference**_.


## Exercici 1 (30%)

En aquest primer exercici partireu del codi final de la primera part d'aquesta activitat, que podeu trobar en la carpeta _part1-final_ d'aquest enunciat.

Heu d'eliminar les 5 classes que implementen la interfície `ApplePredicate` i refactoritzar el codi de la classe `App` utilitzant expressions lambda.

**Lliurament**: Tots els fitxers amb el codi final (la vostra solució) d'aquest exercici 1, consistent amb **totes** les classes (inclosa la interfície) que estan ubicades dins de la carpeta _src_ en el vostre projecte IntelliJ IDEA, s'han de copiar a la carpeta _exc1-lliurament_ d'aquest enunciat.


## Exercici 2 (40%)

En aquest exercici se us donen una llista (en forma d'array) de 10 estudiants, i els heu d'imprimir per pantalla ordenats per nom (primera llista), per edat (segona llista) i per quantitat d'assignatures matriculades (tercera llista).

Teniu el codi inicial a la carpeta _exc2-innocent_ amb una solució innocent de com aconseguir ordenar i imprimir les tres llistes. 

Se us dóna fet l'algorisme _quickSort_ que es troba a la classe utilitaria `Arrays`. No cal entendre aquest algorisme per a poder resoldre aquest exercici, només cal saber en quina línia de codi es fa la comparació que determina l'ordre. Aquesta línia de codi ja està indicada amb el corresponent comentari al codi que se us dóna.

La solució que se us dóna és una solució innocent, perquè existeix un mètode _quickSort_ diferent per a generar cada llista:

* `quickSortByName` ordena un array d'estudiants segons l'ordre alfabètic del seu nom
* `quickSortByAge` ordena un array d'estudiants segons la seva edat
* `quickSortByAmountOfEnrolledSubjects` ordena un array d'estudiants segons el número d'assignatures matriculades

Si us fixeu amb el codi de la classe `Arrays` veureu com l'algorisme _quicksort_ està dividit en dos mètodes ja que des del mètode principal es crida un mètode auxiliar anomenat _partition_:

* Des de `quickSortByName` es crida el mètode `partitionByName`
* Des de `quickSortByAge` es crida el mètode `partitionByAge`
* Des de `quickSortByAmountOfEnrolledSubjects` es crida el mètode `partitionByAmountOfEnrolledSubjects`

Cadascun dels mètodes _quicksort_ que hi ha a la classe Arrays són cridats des de la classe principal App, en concret són cridats pels mètodes següents:

* El mètode `App.sortByName` crida el mètode `Arrays.quickSortByName`
* El mètode `App.sortByAge` crida el mètode `Arrays.quickSortByAge`
* El mètode `App.sortByAmountOfEnrolledSubjects` crida el mètode `Arrays.quickSortByAmountOfEnrolledSubjects`

Les tres llistes ordenades d'estudiants es generen i imprimeixen des del psvm (public static void main). És a dir, des de psvm cridem els mètodes `sortByName`, `sortByAge` i `sortByAmountOfEnrolledSubjects` de la mateixa classe App, abans d'imprimir la llista d'estudiants.

Comproveu que la solució innocent funciona.

**Què heu de fer?** Heu de completar el codi que hi ha a la carpeta _exc2-behavior_ (el codi completat s'ha de lliurar a la carpeta _exc2-lliurament_). Es tracta d'una evolució de la solució innocent **implementant la parametrització del comportament**. Passes a fer:

1. Heu de completar la implementació de cadascuna de les tres classes que implementen la interfície, substituint on posa `//TODO` pel codi corresponent. _Pista_: mireu el petit troç de codi (**la condició de comparació**) en què es diferencien els tres mètodes `partitionByName`, `partitionByAge` i `partitionByAmountOfEnrolledSubjects` de la classe Arrays.
2. Substituïu el `true`, indicat amb `//TODO`, al mètode `partition` per la condició de comparació adequada usant la interfície funcional passada com a paràmetre.
3. A la classe principal App, implementeu el cos del nou mètode `static void sort(Student[] students, StudentComparator comp);`, indicat amb `//TODO`. Fixeu-vos amb els altres mètodes `sort` per saber què heu de fer i tingueu en compte que a la classe Arrays ara teniu un nou mètode anomenat `quickSort`.
4. Al mètode psvm (public static void main) de la classe App, elimineu les tres crides `sortByName(students);`, `sortByAge(students);` i `sortByAmountOfEnrolledSubjects(students);` i substituïu-les per les corresponents crides al nou mètode `sort` que heu implementat al pas anterior.
5. Comproveu que funciona i s'imprimeixen totes les llistes ordenades d'estudiants.
6. Elimineu tots els mètodes que ja no fem servir, tant de la classe App, com de la classe Arrays.

**Lliurament**: Tots els fitxers amb el codi final (la vostra solució) d'aquest exercici 2, consistent amb **totes** les classes (inclosa la interfície) que estan ubicades dins de la carpeta _src_ en el vostre projecte IntelliJ IDEA, s'han de copiar a la carpeta _exc2-lliurament_ d'aquest enunciat.


## Exercici 3 (30%)

En aquest exercici heu de refactoritzar el codi final obtingut a l'exercici anterior (exercici 2) usant expressions lambda. Per tant, haureu d'eliminar les tres classes que implementen la interfície funcional i fer els canvis necessaris en el codi de la classe App escrivint lambdes allà on sigui adequat.

**Lliurament**: Tots els fitxers amb el codi final (la vostra solució) d'aquest exercici 3, consistent amb **totes** les classes (inclosa la interfície) que estan ubicades dins de la carpeta _src_ en el vostre projecte IntelliJ IDEA, s'han de copiar a la carpeta _exc3-lliurament_ d'aquest enunciat. Heu de fer una còpia del codi lliurat a l'exercici anterior (és a dir, del codi que heu lliurat a la carpeta _exc2-lliurament_), refactoritzar el codi i lliurar-lo a la carpeta _exc3-lliurament_.

**LLIURAMENT FINAL**: el lliurament s'ha de fer a github. Heu de fer el darrer `git commit` i el darrer `git push` abans de les 24:00 h de la data límit de lliurament, que està publicada a l'aula (Moodle ...).
